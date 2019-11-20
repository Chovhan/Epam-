import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {

    public final String URL = "jdbc:mysql://localhost:3306/problemshopping?useSSL=false&serverTimezone=UTC";
    public final String USERNAME = "root";
    public final String PASSWORD = "8855";

    public Connection connection;

    public Connection connectDb(){
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }catch (SQLException e) {
            System.out.println("Can`t connect...");
        }
        return connection;
    }
}
