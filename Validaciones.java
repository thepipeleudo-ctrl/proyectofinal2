import java.util.Scanner;

public class Validaciones {

    private static Scanner sc = new Scanner(System.in);

    
    public static String validarNombre(String mensaje) {

        System.out.print(mensaje);
        String texto = sc.nextLine().trim();

        if (texto.isEmpty()) {
            System.out.println("Campo vacio");
            return validarNombre(mensaje);
        }

        if (!texto.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
            System.out.println("Solo letras");
            return validarNombre(mensaje);
        }

        if (texto.length() > 15) {
            System.out.println("Maximo 15 caracteres");
            return validarNombre(mensaje);
        }

        return texto;
    }

    public static String validarApellido(String mensaje) {

        System.out.print(mensaje);
        String texto = sc.nextLine().trim();

        if (texto.isEmpty()) {
            System.out.println("Campo vacio");
            return validarApellido(mensaje);
        }

        if (!texto.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
            System.out.println("Solo letras");
            return validarApellido(mensaje);
        }

        if (texto.length() > 20) {
            System.out.println("Maximo 20 caracteres");
            return validarApellido(mensaje);
        }

        return texto;
    }

    public static String validarCedulaUnica(String mensaje) {

        System.out.print(mensaje);
        String cedula = sc.nextLine().trim();

        if (!cedula.matches("[0-9]+")) {
            System.out.println("Solo numeros");
            return validarCedulaUnica(mensaje);
        }

        if (cedula.length() != 10) {
            System.out.println("Debe tener 10 digitos");
            return validarCedulaUnica(mensaje);
        }

        if (SistemaRenting.buscarCliente(cedula) != null) {
            System.out.println("Cedula ya registrada");
            return validarCedulaUnica(mensaje);
        }

        return cedula;
    }

    public static String validarTelefono(String mensaje) {

        System.out.print(mensaje);
        String tel = sc.nextLine().trim();

        if (!tel.matches("[0-9]+")) {
            System.out.println("Solo numeros");
            return validarTelefono(mensaje);
        }

        if (tel.length() != 10) {
            System.out.println("Debe tener 10 digitos");
            return validarTelefono(mensaje);
        }

        return tel;
    }

    
    public static String validarPlacaUnica(String mensaje) {

        System.out.print(mensaje);
        String placa = sc.nextLine().trim().toUpperCase();

        if (!placa.matches("[A-Z0-9]+")) {
            System.out.println("Placa invalida");
            return validarPlacaUnica(mensaje);
        }

        if (SistemaRenting.buscarVehiculo(placa) != null) {
            System.out.println("Placa ya existe");
            return validarPlacaUnica(mensaje);
        }

        return placa;
    }

   
    public static int validarEntero(String mensaje) {

        try {
            System.out.print(mensaje);
            int n = Integer.parseInt(sc.nextLine());

            if (n < 0) {
                System.out.println("Debe ser positivo");
                return validarEntero(mensaje);
            }

            return n;

        } catch (Exception e) {
            System.out.println("Error numero entero");
            return validarEntero(mensaje);
        }
    }

    
    public static float validarFloat(String mensaje) {

        try {
            System.out.print(mensaje);
            float n = Float.parseFloat(sc.nextLine());

            if (n < 0) {
                System.out.println("Debe ser positivo");
                return validarFloat(mensaje);
            }

            return n;

        } catch (Exception e) {
            System.out.println("Error decimal");
            return validarFloat(mensaje);
        }
    }
}