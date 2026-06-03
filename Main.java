public class Main {

    public static void main(String[] args) {

       
        ImportarArchivoTxt imp = new ImportarArchivoTxt();

        SistemaRenting.vehiculos =
                imp.leerArchivo("Vehiculos", SistemaRenting.vehiculos);

       
        Menu.mostrarMenuPrincipal();

        ExportarArchivo exp = new ExportarArchivo();

        exp.exportarArchivo(SistemaRenting.vehiculos);

        System.out.println("Datos guardados correctamente. Saliendo del sistema...");
    }
}