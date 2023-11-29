import java.sql.SQLException;
import java.util.Random;

public class Main {
    public static Random random = new Random();

    public static void main(String[] args) {
        try {
            DataBase.getInstancia();
            var role1 = "User";
            DataBase.setRoles(role1);
            var role2 = "Admin";

            for (int i = 1; i <= 20; i++) {
                DataBase.insertJefes();
            }
            DataBase.setRoles(role2);
            var cont = 3;
            for (int i = 1; i <= 100; i++) {
                var userID = i;
                var password = "123456";
                var name = Datos.getName();
                var email = name + "@gmail.com";
                DataBase.insertUser(password, name, email);
                var randomRole = random.nextInt(2) + 1;
                DataBase.insertRoles(randomRole, userID);

                var cargo = Datos.getCargo();
                var nombre = Datos.getName();
                var jefe = random.nextInt(20) + 1;
                var idEmpleado = i;
                DataBase.insertEmpleado(cargo, nombre, jefe);

                var nameProveedor = Datos.getName();
                var address = Datos.getDireccion();
                DataBase.insertProveedor(nameProveedor, address);

                var categoria = Datos.getCategoria();
                var producto = Datos.getProducto(categoria);
                var descripcion = Datos.getWords(25);

                var precio = random.nextInt(1000) + 1;
                var cantidad = random.nextInt(100) + 1;
                var proveedor = i;
                var productoID = i;
                DataBase.insertProducto(producto, descripcion, precio, proveedor, categoria);

                var pedidoId = i;
                DataBase.insertPedido(userID, productoID);

                DataBase.insertarPedidoEmpleado(idEmpleado, pedidoId);

                if (cont > 0) {
                    cont--;
                    DataBase.insertarAlmacen(random.nextInt(5000) + 1);
                }

                DataBase.insertarIventario(productoID, random.nextInt(3) + 1, random.nextInt(4000) + 1);

                var fecha = Datos.fecha();
                DataBase.insertarCompra(userID, fecha, random.nextInt(2131), random.nextInt(2131));

                DataBase.insertarHistorialComprar(productoID, random.nextInt(12321), random.nextInt(12321), proveedor);


                System.out.println("Usuario " + i + " insertado.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
