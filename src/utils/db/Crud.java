package utils.db;


import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.sql.*;
import java.util.*;


public class Crud {
    public enum Table {users, clients, projects}
    private Table table;
    public void setTable(Table table){ this.table = table; }
    private ArrayList<?> values;

    public void setValues(ArrayList<?> values) { this.values = values; }

    private Logger logger = LoggerFactory.getLogger(Crud.class);
    private Connection cn = DbConnection.connect();

    public HashMap<Integer, List<Object>> getAll() {
        HashMap<Integer, List<Object>> data = new HashMap<>();
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM " + table);
            ResultSetMetaData rsmd = rs.getMetaData();

            while (rs.next()) {
                int id = rs.getInt("id");
                data.putIfAbsent(id, new ArrayList<>());
                List<Object> rowData = data.get(id);
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    rowData.add(rs.getObject(i));
                }
            }
        } catch (SQLException e) {
            logger.error("SQL ERROR : " + e);
        }
        return data;
    }

    public void create(Object ...objects) {
        try {
            String query = "INSERT INTO " + table + " (name, address, phone, is_professional) VALUES (";
            loopStr s = (int x) -> {
                StringBuilder n = new StringBuilder();
                for (int i = 1; i <= x; i++) {
                    n.append("?");
                    if (i < x) {
                        n.append(", ");
                    }
                }
                return n + ")";
            };
            query += s.doLoop(values.size());

            PreparedStatement st = cn.prepareStatement(query);

            for (int i = 0; i < values.size(); i++) {
                st.setObject(i + 1, values.get(i));
            }

            int affectedRows = st.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Insert successful. Rows affected: " + affectedRows);
            } else {
                logger.warn("Insert failed. No rows affected.");
            }

        } catch (SQLException e) {
            logger.error("CREATION FAILED : " + e);
        }
    }



}
@FunctionalInterface
interface loopStr {
    String doLoop(int x);
}
