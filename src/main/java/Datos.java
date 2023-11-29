import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import lombok.Data;

import java.sql.Date;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

@Data
public class Datos {
    private static Random random = new Random();
    public static List<String> categorias = List.of("Abarrotes", "Bebidas", "Carnes", "Lacteos", "Frutas y Verduras", "Panaderia", "Dulces", "Farmacia", "Limpieza", "Hogar", "Mascotas", "Ropa", "Juguetes", "Electronica", "Papeleria", "Ferreteria", "Jardineria", "Automotriz", "Deportes", "Belleza");

    private static List<List<String>> productos = List.of(
            List.of("Leche", "Huevo", "Cereal", "Galletas", "Cafe", "Azucar", "Sal", "Aceite"),
            List.of("Coca Cola", "Pepsi", "Fanta", "Sprite", "Cerveza", "Vino"),
            List.of("Jamon"),
            List.of("Queso", "Mantequilla", "Yogurt"),
            List.of("Papas"),
            List.of("Pan"),
            List.of("Gelatina", "Gel"),
            List.of("Papel Higienico", "Shampoo", "Jabon", "Desodorante", "Crema"),
            List.of("Detergente", "Suavizante"),
            List.of("Cepillo", "Cepillo", "Cera", "Cera para pisos"),
            List.of("Juguete para mascotas", "Comida para mascotas", "Collar para mascotas", "Cama para mascotas", "Rascador para mascotas", "Correa para mascotas", "Transportadora para mascotas", "Plato para mascotas", "Arena para mascotas", "Ropa para mascotas", "Hueso para mascotas", "Peine para mascotas", "Snacks para mascotas", "Jaula para mascotas", "Acuario para mascotas"),
            List.of("Camiseta", "Pantalones", "Sudadera", "Vestido", "Abrigo", "Chaqueta", "Calcetines", "Zapatos", "Gorra", "Bufanda", "Pijama", "Falda", "Ropa interior", "Traje", "Sombrero"),
            List.of("Rompecabezas", "Muñeca", "Pelota", "Rompecabezas 3D", "Puzzle", "Lego", "Juego de mesa", "Carro de juguete", "Avión de juguete", "Tren de juguete", "Cocinita de juguete", "Bloques de construcción", "Figuras de acción", "Muñeco de peluche", "Barbie"),
            List.of("Teléfono", "Computadora portátil", "Tableta", "Televisor", "Auriculares", "Altavoz inteligente", "Cámara", "Videojuego", "Cargador portátil", "Reloj inteligente", "Impresora", "Router", "Teclado", "Ratón", "Disco duro externo"),
            List.of("Cuaderno", "Pluma", "Lápiz", "Bolígrafo", "Libreta", "Resaltador", "Papel", "Tijeras", "Regla", "Goma de borrar", "Corrector", "Cinta adhesiva", "Carpeta", "Pegamento", "Marcadores"),
            List.of("Maceta", "Herramientas de jardinería", "Semillas", "Tierra para plantas", "Regadera", "Fertilizante", "Podadora", "Manguera de jardín", "Césped artificial", "Invernadero", "Alicate de podar", "Sustrato para plantas", "Cortasetos", "Carretilla de jardín", "Tijeras de podar"),
            List.of("Aceite para motor", "Llantas", "Limpiaparabrisas", "Batería de coche", "Filtro de aceite", "Anticongelante", "Espejo retrovisor", "Cargador de batería", "Cera para coche", "Cepillo para coche", "Tapetes para coche", "Limpia tapicería", "Martillo de emergencia", "Kit de herramientas para coche", "GPS para coche"),
            List.of("Balón de fútbol", "Raqueta de tenis", "Pelota de baloncesto", "Guantes de boxeo", "Bicicleta", "Pesas", "Patineta", "Casco para deportes", "Red de voleibol", "Balón de rugby", "Gafas de natación", "Cuerda para saltar", "Colchoneta de yoga", "Palo de golf", "Tablero de ajedrez"),
            List.of("Maquillaje", "Perfume", "Cremas faciales", "Esmalte de uñas", "Cepillo para cabello", "Plancha para cabello", "Secadora de cabello", "Mascarilla facial", "Exfoliante corporal", "Aceite corporal", "Bálsamo labial", "Desmaquillante", "Tinte para cabello", "Depiladora", "Serum facial")

    );
    private static Lorem lorem = LoremIpsum.getInstance();
    private static String[] cargos = {"Gerente", "Supervisor", "Empleado"};
    private static String[] direcciones = generarDirecciones();
    private static String[] metodoEnvio = {"Envío estándar", "Envío express", "Recogida en tienda", "Envío urgente",
            "Envío internacional"};

    public static String getCategoria() {
        var i = categorias.size() < 2 ? 1 : categorias.size() - 1;
        var index = random.nextInt(i);
        return categorias.get(index < 0 ? 0 : index);
    }

    public static String getProducto(String categoria) {
        var productosCategoria = productos.get(categorias.indexOf(categoria));
        var i = productosCategoria.size() < 2 ? 1 : productosCategoria.size() - 1;
        var index = random.nextInt(i);
        return productosCategoria.get(index < 0 ? 0 : index);
    }

    public static String getDireccion() {
        var i = direcciones.length < 2 ? 1 : direcciones.length - 1;
        var index = random.nextInt(i);
        return direcciones[index < 0 ? 0 : index];
    }

    public static String getCargo() {
        var index = random.nextInt(cargos.length - 1);
        return cargos[index < 0 ? 0 : index];
    }

    public static String getName() {
        return lorem.getName();
    }

    public static String getWords(int words) {
        return lorem.getWords(words);
    }

    public static Date fecha() {
        var fecha = lorem.getFutureDate(java.time.Duration.ofHours(random.nextInt(100)))
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).split("-");
        return new Date(Integer.parseInt(fecha[0]), Integer.parseInt(fecha[1]), Integer.parseInt(fecha[2]));
    }

    public static String[] generarDirecciones() {
        String[] direcciones = new String[100];
        for (int i = 0; i < 100; i++) {
            direcciones[i] = "Calle " + lorem.getName() + (i + 1) + ", Ciudad" + lorem.getCity() + ", País " + lorem.getCountry();
        }
        return direcciones;
    }

    public static String getMetodoEnvio() {
        var i = metodoEnvio.length < 2 ? 1 : metodoEnvio.length - 1;
        var index = random.nextInt(i);
        return metodoEnvio[index < 0 ? 0 : index];
    }
}
