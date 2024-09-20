package utils.db;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.sql.*;
import java.util.*;

public class ModelCrud {
    private static final Logger logger = LoggerFactory.getLogger(ModelCrud.class);
    private final Connection cn = DbConnection.connect();

    public enum Table { USERS, CLIENTS, PROJECTS, QUOTATIONS }
    private final Table table;

    private Object[] values;
    private Object[] columns;

    public void setValues(Object... values) { this.values = values; }
    public void setColumns(Object... columns) { this.columns = columns; }

    public ModelCrud(Table table) { this.table = table; }

    // get all records of a table
    public HashMap<Integer, List<Object>> getAll() {
        HashMap<Integer, List<Object>> data = new HashMap<>();
        String query = "SELECT * FROM " + table;

        try (Statement st = cn.createStatement();
             ResultSet rs = st.executeQuery(query)) {

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
    public void create() {
        String query = "INSERT INTO " + table + buildColumns() + " VALUES " + buildPlaceholders();

        try (PreparedStatement st = cn.prepareStatement(query)) {
            for (int i = 0; i < values.length; i++) {
                st.setObject(i + 1, values[i]);
            }

            int affectedRows = st.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("[+] Insert successful. Rows affected: " + affectedRows);
            } else {
                logger.warn("[-] Insert failed. No rows affected.");
            }
        } catch (SQLException e) {
            logger.error("[-] INSERTION FAILED: ", e);
        }
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
