import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;

import java.sql.SQLException;
import java.util.Random;

public class Main {
    public static Random random = new Random();
    public static Lorem lorem = LoremIpsum.getInstance();

    public static void main(String[] args) {
        try {
            DataBase.getInstancia();
            for (int i = 0; i < 10; i++) {

                var password = "123456";
                var name = lorem.getName();
                DataBase.insertUser(password, name, "email" + i);
                var role = "user";
                DataBase.setRoles(role);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
