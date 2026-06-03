
import java.util.ArrayList;

public class SistemaRenting {

    public static ArrayList<Cliente> clientes = new ArrayList<>();
    public static ArrayList<Vehiculo> vehiculos = new ArrayList<>();
    public static ArrayList<ContratoRenting> contratos = new ArrayList<>();

   
    public static Cliente buscarCliente(String cedula) {
        for (Cliente c : clientes) {
            if (c.getCedula().equals(cedula)) {
                return c;
            }
        }
        return null;
    }

    public static Cliente registrarCliente() {

        String cedula = Validaciones.validarCedulaUnica("Cedula: ");
        String nombre = Validaciones.validarNombre("Nombre: ");
        String apellido = Validaciones.validarApellido("Apellido: ");
        String telefono = Validaciones.validarTelefono("Telefono: ");

        System.out.print("Direccion: ");
        String direccion = new java.util.Scanner(System.in).nextLine();

        System.out.print("Licencia: ");
        String licencia = new java.util.Scanner(System.in).nextLine();

        Cliente c = new Cliente(cedula, nombre, apellido, telefono, direccion, licencia);
        clientes.add(c);

        return c;
    }

    public static boolean modificarCliente(String cedula) {

        Cliente c = buscarCliente(cedula);
        if (c == null) return false;

        c.setNombre(Validaciones.validarNombre("Nuevo nombre: "));
        c.setApellido(Validaciones.validarApellido("Nuevo apellido: "));
        c.setTelefono(Validaciones.validarTelefono("Nuevo telefono: "));

        return true;
    }

    public static boolean eliminarCliente(String cedula) {

        Cliente c = buscarCliente(cedula);
        if (c == null) return false;

        clientes.remove(c);
        return true;
    }

    public static void listarClientes() {
        for (Cliente c : clientes) {
            System.out.println(c);
        }
    }

    public static Vehiculo buscarVehiculo(String placa) {
        for (Vehiculo v : vehiculos) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                return v;
            }
        }
        return null;
    }

    public static Vehiculo registrarVehiculo() {

        String placa = Validaciones.validarPlacaUnica("Placa: ");
        String marca = Validaciones.validarNombre("Marca: ");
        int modelo = Validaciones.validarEntero("Modelo: ");
        float precio = Validaciones.validarFloat("Precio diario: ");

        Vehiculo v = new Vehiculo(placa, marca, modelo, precio, "Disponible");
        vehiculos.add(v);

        return v;
    }

    public static boolean modificarVehiculo(String placa) {

        Vehiculo v = buscarVehiculo(placa);
        if (v == null) return false;

        v.setMarca(Validaciones.validarNombre("Nueva marca: "));
        v.setModelo(Validaciones.validarEntero("Nuevo modelo: "));
        v.setPrecioDiario(Validaciones.validarFloat("Nuevo precio: "));

        return true;
    }

    public static boolean eliminarVehiculo(String placa) {

        Vehiculo v = buscarVehiculo(placa);
        if (v == null) return false;

        vehiculos.remove(v);
        return true;
    }

    public static void listarVehiculos() {
        for (Vehiculo v : vehiculos) {
            System.out.println(v);
        }
    }

 
    public static ContratoRenting buscarContrato(String id) {
        for (ContratoRenting c : contratos) {
            if (c.getIdContrato().equals(id)) {
                return c;
            }
        }
        return null;
    }

    public static ContratoRenting registrarContrato() {

        String id = String.valueOf(contratos.size() + 1);

        String cedula = Validaciones.validarCedulaUnica("Cedula cliente: ");
        Cliente cliente = buscarCliente(cedula);

        if (cliente == null) {
            System.out.println("Cliente no existe");
            return null;
        }

        String placa = Validaciones.validarPlacaUnica("Placa vehiculo: ");
        Vehiculo v = buscarVehiculo(placa);

        if (v == null) {
            System.out.println("Vehiculo no existe");
            return null;
        }

        if (v.getEstado().equalsIgnoreCase("Alquilado")) {
            System.out.println("Vehiculo ocupado");
            return null;
        }

        int dias = Validaciones.validarEntero("Dias: ");
        float total = dias * v.getPrecioDiario();

        ContratoRenting c = new ContratoRenting(
                id, cedula, placa,
                "inicio", "fin",
                dias, total, true
        );

        contratos.add(c);
        v.setEstado("Alquilado");

        return c;
    }

    public static boolean modificarContrato(String id) {

        ContratoRenting c = buscarContrato(id);
        if (c == null) return false;

        c.setFechaInicio("inicio");
        c.setFechaFin("fin");

        return true;
    }

    public static boolean finalizarContrato(String id) {

        ContratoRenting c = buscarContrato(id);
        if (c == null) return false;

        c.setActivo(false);

        Vehiculo v = buscarVehiculo(c.getPlacaVehiculo());
        if (v != null) {
            v.setEstado("Disponible");
        }

        return true;
    }

    public static void listarContratos() {
        for (ContratoRenting c : contratos) {
            System.out.println(c);
        }
    }

    public static void imprimirInforme() {

        System.out.println("=== CLIENTES ===");
        listarClientes();

        System.out.println("=== VEHICULOS ===");
        listarVehiculos();

        System.out.println("=== CONTRATOS ===");
        listarContratos();
    }
}