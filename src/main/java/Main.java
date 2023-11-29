import java.sql.SQLException;
import java.util.Random;

public class Main {
    public static Random random = new Random();

    public static void main(String[] args) {
        try {
            DataBase.getInstancia();
            for (int i = 0; i < 10; i++) {
                var role = "user";
                DataBase.setRoles(role);
                DataBase.insertUser()
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
