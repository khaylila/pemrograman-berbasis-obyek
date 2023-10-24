package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
    protected final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/perpustakaan";
    protected final String USER = "postgres";
    protected final String PASS = "postgres";
    protected String table;
    protected String pk;
    protected Connection conn;

    public Database(String[] config) {
        this.table = config[0];
        this.pk = config[1];
        try {
            this.conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getLastID() {
        try {
            String[] orderBy = { "id", "DESC" };
            ResultSet result = this.getData("id", 1, orderBy);
            if (result.next()) {
                return result.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public ResultSet getData(String select) {
        String query = "SELECT " + select + " FROM " + this.table;
        return this.get(query);
    }

    public ResultSet getData(String select, int limit, String[] orderBy) {
        String query = "SELECT " + select + " FROM " + this.table
                + " ORDER BY " + orderBy[0] + " " + orderBy[1]
                + " LIMIT " + limit;
        System.out.println(query);
        return this.get(query);
    }

    public ResultSet findId(int id) {
        String query = "SELECT * FROM " + this.table
                + " WHERE " + this.pk + "=" + id + ";";
        return this.get(query);
    }

    public boolean checkData(int id) {
        try {
            return this.findId(id).next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private ResultSet get(String sql) {
        try {
            ResultSet result = this.conn.createStatement().executeQuery(sql);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean insert(String[] data) {
        try {
            String query = "INSERT INTO " + this.table
                    + "(id, name, pengarang, jenis) VALUES (?, ?, ?, ?);";
            PreparedStatement preparedStatement = this.conn.prepareStatement(query);
            preparedStatement.setInt(1, (this.getLastID() + 1));
            preparedStatement.setString(2, data[0]);
            preparedStatement.setString(3, data[1]);
            preparedStatement.setString(4, data[2]);
            if (preparedStatement.executeUpdate() <= 0) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    private String[] beforeUpdate(String[] data, int id) {
        try {
            String query = "SELECT * FROM " + this.table + " WHERE " + this.pk + "=? LIMIT 1;";
            PreparedStatement preparedStatement = this.conn.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();
            if (result.next()) {
                for (int i = 0; i < data.length; i++) {
                    if (data[i].length() == 0) {
                        data[i] = result.getString(i + 2);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public boolean update(String[] data, int id) {
        data = this.beforeUpdate(data, id);
        try {
            String query = "UPDATE " + this.table + " SET name=?, pengarang=?, jenis=? WHERE " + this.pk + "=?;";
            PreparedStatement preparedStatement = this.conn.prepareStatement(query);
            preparedStatement.setString(1, data[0]);
            preparedStatement.setString(2, data[1]);
            preparedStatement.setString(3, data[2]);
            preparedStatement.setInt(4, id);
            return preparedStatement.executeUpdate() > 0 ? true : false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(int id) {
        try {
            String query = "DELETE FROM " + this.table + " WHERE " + this.pk + "=?;";
            PreparedStatement preparedStatement = this.conn.prepareStatement(query);
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0 ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
