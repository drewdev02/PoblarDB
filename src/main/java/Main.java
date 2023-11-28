import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    private static final String URL = "jdbc:postgresql://ep-late-rain-12834272.us-east-2.aws.neon.fl0.io:5432/database";
    private static final String USER = "fl0user";
    private static final String PASSWORD = "elWFdSb9Dzt1";
    private static Connection connection;


    public static void main(String[] args) {
        try (var connection = DriverManager.getConnection(URL, USER, PASSWORD)) {

            System.out.println("Conexión exitosa.");

            System.out.println("Datos insertados correctamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void poblarDb(Connection connection) {

        var role1 = "admin";
        var role2 = "user";

        var queryRoles = "INSERT INTO Roles (rol_Name) VALUES (?, ?)";

        try (var statement = connection.prepareStatement(queryRoles)) {
            statement.setString(1, role1);
            statement.executeUpdate();

            statement.setString(2, role2);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        var name = "Andrey";
        var password = "password";
        var email = name.toLowerCase() + "@example.com";

        var queryUsuarios = "INSERT INTO Usuario (password, nombre, email) VALUES (?, ?, ?)";

        try (var statement = connection.prepareStatement(queryUsuarios)) {
            statement.setString(1, password);
            statement.setString(2, name);
            statement.setString(3, email);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        var idRol = 1;
        var idUsuario = 1;

        var queryUserRoles = "INSERT INTO User_Roles (rol_ID, user_ID) VALUES (?, ?)";
        try (var statement = connection.prepareStatement(queryUserRoles)) {
            statement.setInt(1, idRol);
            statement.setInt(2, idUsuario);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        var queryjefes = "INSERT INTO Jefes DEFAULT VALUES";
        try (var statement = connection.prepareStatement(queryjefes)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        var cargo = "Administrador";
        var nombre = "Andrey";
        var jefe = 1;

        var queryEmpleados = "INSERT INTO Empleados (cargo, nombre,jefe) VALUES (?, ?, ?)";
        try (var statement = connection.prepareStatement(queryEmpleados)) {
            statement.setString(1, cargo);
            statement.setString(2, nombre);
            statement.setInt(3, jefe);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        var nombreProveedor = "Proveedor 1";
        var direccion = "Calle 1";
        var queryProveedor = "INSERT INTO Proveedor (nombre, direccion) VALUES (?, ?)";

        try (var statement = connection.prepareStatement(queryProveedor)) {
            statement.setString(1, nombreProveedor);
            statement.setString(2, direccion);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        var nombreCategoria = "producto 1";
        var descripcion = "descripcion 1";
        var precio = 100;
        var cantidad = 100;
        var proveedor = "Proveedor 1";
        var categoria = "Categoria 1";

        var queryProducto = "INSERT INTO Producto (nombre,descripcion ,precio, cantidad, proveedor,categoria) VALUES " +
                "(?, ?, ?, ?, ?, ?)";
        try (var statement = connection.prepareStatement(queryProducto)) {
            statement.setString(1, nombreCategoria);
            statement.setString(2, descripcion);
            statement.setInt(3, precio);
            statement.setInt(4, cantidad);
            statement.setString(5, proveedor);
            statement.setString(6, categoria);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        var userID = 1;
        var productoID = 1;
        var queryPredido = "INSERT INTO Pedido (userID, producto_ID) VALUES (?,?) ";

        try (var statement = connection.prepareStatement(queryPredido)) {
            statement.setInt(1, userID);
            statement.setInt(2, productoID);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



        var queryPedidoEmpleado = "INSERT INTO Producto (nombre, descripcion, precio, proveedor, categoria) VALUES (?, ?, ?, ?, ?)";




    }


    private static void insertRoles(Connection connection) throws SQLException {
        var query = "INSERT INTO Roles (rol_Name) VALUES (?)";
        try (var statement = connection.prepareStatement(query)) {
            statement.setString(1, "Administrador");
            statement.executeUpdate();

            statement.setString(1, "Usuario Regular");
            statement.executeUpdate();
        }
    }

    private static void insertUsuarios(Connection connection) throws SQLException {
        String query = "INSERT INTO Usuario (password, nombre, email) VALUES (?, ?, ?)";
        try (var statement = connection.prepareStatement(query)) {
            statement.setString(1, "contrasena123");
            statement.setString(2, "Andrey");
            statement.setString(3, "andrey@example.com");
            statement.executeUpdate();
        }
    }

    private static void insertUserRoles(Connection connection) throws SQLException {
        var query = "INSERT INTO User_Roles (rol_ID, user_ID) VALUES (?, ?)";
        try (var statement = connection.prepareStatement(query)) {
            statement.setInt(1, 1);
            statement.setInt(2, 1);
            statement.executeUpdate();
        }
    }
}
