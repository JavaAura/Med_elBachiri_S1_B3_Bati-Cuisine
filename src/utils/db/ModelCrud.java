package utils.db;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.sql.*;
import java.util.*;

public class ModelCrud {
    private static final Logger logger = LoggerFactory.getLogger(ModelCrud.class);
    private final Connection cn = DbConnection.connect();

    public enum Table { CLIENTS, PROJECTS, MATERIALS, LABORS, QUOTATIONS, PROJECT_COMPONENTS }
    private final Table table;
    private boolean throughMsg = true;
    private boolean activeWhere = false;
    public void activateWhere(boolean activeWhere) { this.activeWhere = activeWhere; }
    private String where;
    private Object equalsTo;

    public void where(String where) { this.where = where; }
    public void equalsTo(Object equalsTo) { this.equalsTo = equalsTo; }

    private Object[] values;
    private Object[] columns;

    public void setThroughMsg(boolean throughMsg) { this.throughMsg = throughMsg; }

    public void setValues(Object... values) { this.values = values; }
    public void setColumns(Object... columns) { this.columns = columns; }

    public ModelCrud(Table table) { this.table = table; }

    private String singleName(String n) {return n.substring(0, (table.name().length() - 1));}

    // get all records of a table
    public HashMap<Integer, List<Object>> getAll() {
        HashMap<Integer, List<Object>> data = new HashMap<>();
        String query = "SELECT * FROM " + table;

        if (activeWhere) query += " WHERE " + where + " = ?";

        try {
            PreparedStatement st = cn.prepareStatement(query);
            if (activeWhere) st.setObject(1, equalsTo);
            ResultSet rs = st.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            while (rs.next()) {
                int id = rs.getInt("id");
                List<Object> rowData = new ArrayList<>();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    rowData.add(rs.getObject(i));
                }
                data.put(id, rowData);
            }
        } catch (SQLException e) {
            logger.error("SQL ERROR: ", e);
        }
        return data;
    }


    // Insert a new record into the table
    public Integer create() {
        String query = "INSERT INTO " + table + buildColumns() + " VALUES " + buildPlaceholders() + "RETURNING id";

        try (PreparedStatement st = cn.prepareStatement(query)) {
            for (int i = 0; i < values.length; i++) {
                st.setObject(i + 1, values[i]);
            }

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                if (throughMsg) System.out.println("[+] " + singleName(table.name()) + " added successfully.");
                return rs.getInt(1);
            } else {
                if (throughMsg) logger.warn("[-] Failed adding " + singleName(table.name()) + ".");
                return null;
            }
        } catch (SQLException e) {
            logger.error("[-] Failed adding " + singleName(table.name()) + ".", e);
        }
        return null;
    }


    // get string of columns like (id, name, phone .... )
    private String buildColumns() {
        return " (" + String.join(", ", Arrays.stream(columns).map(Object::toString).toArray(String[]::new)) + ") ";
    }

    // get string of values placeholders, ex: (?, ?, ?, ?)
    private String buildPlaceholders() {
        return " (" + String.join(", ", Collections.nCopies(values.length, "?")) + ") ";
    }
}
