package s35.ea1.database;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class DBConnection {

    private final String jdbcUrl;
    private final String user;
    private final String password;

    public DBConnection() {
        Dotenv dotenv = Dotenv.load();
        this.jdbcUrl = dotenv.get("DATABASE_JDBC_URL");
        this.user = dotenv.get("DATABASE_USER");
        this.password = dotenv.get("DATABASE_PASSWORD");
    }

    public List<Map<String, Object>> executeSelectQuery(String sqlQuery) {
        List<Map<String, Object>> results = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(jdbcUrl, user, password); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(sqlQuery)) {

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (resultSet.next()) {
                Map<String, Object> row = new HashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    Object value = resultSet.getObject(i);
                    row.put(columnName, value);
                }
                results.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    public boolean executeUpdateQuery(String sqlQuery) {
        try (Connection connection = DriverManager.getConnection(jdbcUrl, user, password); Statement statement = connection.createStatement()) {

            statement.executeUpdate(sqlQuery);

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
