import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
    private static final String URL = "jdbc:postgresql://ep-late-rain-12834272.us-east-2.aws.neon.fl0.io:5432/database";
    private static final String USER = "fl0user";
    private static final String PASSWORD = "elWFdSb9Dzt1";
    private static Connection connection;

    private DataBase() {
    }

    public static void getInstancia() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        System.out.println("Conexión exitosa.");
    }


    public static void setRoles(String role1) {
        var queryRoles = "INSERT INTO roles (nombre) VALUES (?)";
        try (var statement = connection.prepareStatement(queryRoles)) {
            statement.setString(1, role1);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void insertUser(String password, String name, String email) {
        var queryUsuarios = "INSERT INTO Usuario (password, nombre, email) VALUES (?, ?, ?)";

        try (var statement = connection.prepareStatement(queryUsuarios)) {
            statement.setString(1, password);
            statement.setString(2, name);
            statement.setString(3, email);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertRoles(int idRol, int idUsuario) {
        var queryUserRoles = "INSERT INTO User_Roles (rol_ID, user_ID) VALUES (?, ?)";

        try (var statement = connection.prepareStatement(queryUserRoles)) {
            statement.setInt(1, idRol);
            statement.setInt(2, idUsuario);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertJefes() {
        var queryjefes = "INSERT INTO Jefes DEFAULT VALUES";

        try (var statement = connection.prepareStatement(queryjefes)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertEmpleado(String cargo, String nombre, int jefe) {
        var queryEmpleados = "INSERT INTO Empleados (cargo, nombre,jefe) VALUES (?, ?, ?)";

        try (var statement = connection.prepareStatement(queryEmpleados)) {
            statement.setString(1, cargo);
            statement.setString(2, nombre);
            statement.setInt(3, jefe);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertProveedor(String nombreProveedor, String direccion) {
        var queryProveedor = "INSERT INTO Proveedor (nombre, direccion) VALUES (?, ?)";

        try (var statement = connection.prepareStatement(queryProveedor)) {
            statement.setString(1, nombreProveedor);
            statement.setString(2, direccion);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void insertProducto(String nombreCategoria, String descripcion, int precio, int cantidad, String proveedor, String categoria) {
        var queryProducto = "INSERT INTO Producto (nombre,descripcion ,precio, cantidad, proveedor,categoria) VALUES " + "(?, ?, ?, ?, ?, ?)";

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
    }

    public void insertPedido(int userID, int productoID) {
        var queryPedido = "INSERT INTO Pedido (userID, producto_ID) VALUES (?,?) ";

        try (var statement = connection.prepareStatement(queryPedido)) {
            statement.setInt(1, userID);
            statement.setInt(2, productoID);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertarPedidoEmpleado(int empID, int pedidoID) {
        var queryPedidoEmpleado = "INSERT INTO Producto (emp_ID, pedido_ID) VALUES (?, ?)";

        try (var statement = connection.prepareStatement(queryPedidoEmpleado)) {
            statement.setInt(1, empID);
            statement.setInt(2, pedidoID);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertarAlmacen(int capacidad) {
        var queryAlmacen = "INSERT INTO Almacen (capacidad) VALUES (?)";
        try (var statement = connection.prepareStatement(queryAlmacen)) {
            statement.setInt(1, capacidad);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void insertarIventario(int productID, int almacenID, int stock) {
        var queryInventario = "INSERT INTO Inventario (product_ID, almacen_ID, stock) VALUES (?, ?, ?)";

        try (var statement = connection.prepareStatement(queryInventario)) {
            statement.setInt(1, productID);
            statement.setInt(2, almacenID);
            statement.setInt(3, stock);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertarCompra(int user_ID, String fecha, int ganancia, int pedidos) {
        var queryCompra = "INSERT INTO Compra (user_ID, fecha, ganancia, pedidos)VALUES (?, ?,?, ?)";
        try (var statement = connection.prepareStatement(queryCompra)) {
            statement.setInt(1, user_ID);
            statement.setString(2, fecha);
            statement.setInt(3, ganancia);
            statement.setInt(4, pedidos);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertarHistorialComprar(int producto_ID, int cantidadCompra, int coste, String proveedorCompra) {
        var queryHistorialCompra = "INSERT INTO Historial_Compra (producto_ID, cantidad, coste, proveedor) VALUES (?," + " ?,?, ?)";
        try (var statement = connection.prepareStatement(queryHistorialCompra)) {
            statement.setInt(1, producto_ID);
            statement.setInt(2, cantidadCompra);
            statement.setInt(3, coste);
            statement.setString(4, proveedorCompra);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
