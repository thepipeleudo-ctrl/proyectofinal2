public class Menu {

    public static void mostrarMenuPrincipal() {

        int op;

        do {

            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1. Clientes");
            System.out.println("2. Vehiculos");
            System.out.println("3. Contratos");
            System.out.println("4. Informe");
            System.out.println("5. Salir");

            op = Validaciones.validarEntero("Opcion: ");

            switch (op) {

                case 1:
                    menuClientes();
                    break;

                case 2:
                    menuVehiculos();
                    break;

                case 3:
                    menuContratos();
                    break;

                case 4:
                    SistemaRenting.imprimirInforme();
                    break;

                case 5:

             ExportarArchivo exp = new ExportarArchivo();
             exp.exportarArchivo(SistemaRenting.vehiculos);

            System.out.println("Datos guardados.");
             break;
            }

        } while (op != 5);
    }

    
    public static void menuClientes() {

        int op;

        do {

            System.out.println("\n--- CLIENTES ---");
            System.out.println("1. Registrar");
            System.out.println("2. Modificar");
            System.out.println("3. Eliminar");
            System.out.println("4. Listar");
            System.out.println("5. Volver");

            op = Validaciones.validarEntero("Opcion: ");

            switch (op) {

                case 1:
                    SistemaRenting.registrarCliente();
                    break;

                case 2: {
                    String ced = Validaciones.validarCedulaUnica("Cedula: ");
                    SistemaRenting.modificarCliente(ced);
                    break;
                }

                case 3: {
                    String ced2 = Validaciones.validarCedulaUnica("Cedula: ");
                    SistemaRenting.eliminarCliente(ced2);
                    break;
                }

                case 4:
                    SistemaRenting.listarClientes();
                    break;
            }

        } while (op != 5);
    }

    
    public static void menuVehiculos() {

        int op;

        do {

            System.out.println("\n--- VEHICULOS ---");
            System.out.println("1. Registrar");
            System.out.println("2. Modificar");
            System.out.println("3. Eliminar");
            System.out.println("4. Listar");
            System.out.println("5. Volver");

            op = Validaciones.validarEntero("Opcion: ");

            switch (op) {

                case 1:
                    SistemaRenting.registrarVehiculo();
                    break;

                case 2: {
                    String placa = Validaciones.validarPlacaUnica("Placa: ");
                    SistemaRenting.modificarVehiculo(placa);
                    break;
                }

                case 3: {
                    String placa2 = Validaciones.validarPlacaUnica("Placa: ");
                    SistemaRenting.eliminarVehiculo(placa2);
                    break;
                }

                case 4:
                    SistemaRenting.listarVehiculos();
                    break;
            }

        } while (op != 5);
    }

    public static void menuContratos() {

        int op;

        do {

            System.out.println("\n--- CONTRATOS ---");
            System.out.println("1. Registrar");
            System.out.println("2. Modificar");
            System.out.println("3. Finalizar");
            System.out.println("4. Listar");
            System.out.println("5. Volver");

            op = Validaciones.validarEntero("Opcion: ");

            switch (op) {

                case 1:
                    SistemaRenting.registrarContrato();
                    break;

                case 2: {
                    String id = Validaciones.validarEntero("ID: ") + "";
                    SistemaRenting.modificarContrato(id);
                    break;
                }

                case 3: {
                    String id2 = Validaciones.validarEntero("ID: ") + "";
                    SistemaRenting.finalizarContrato(id2);
                    break;
                }

                case 4:
                    SistemaRenting.listarContratos();
                    break;
            }

        } while (op != 5);
    }
}