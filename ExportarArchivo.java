import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ExportarArchivo {

    public void exportarArchivo(ArrayList<Vehiculo> lista) {

        if (lista.isEmpty()) {
            System.out.println("No hay vehiculos para exportar.");
            return;
        }

        try (FileWriter fw = new FileWriter("Vehiculos.txt")) {

            for (Vehiculo v : lista) {

                fw.write("Marca: " + v.getMarca() + "\n");
                fw.write("Modelo: " + v.getModelo() + "\n");
                fw.write("Precio: " + v.getPrecioDiario() + "\n");
                fw.write("Estado: " + v.getEstado() + "\n");

                if (v instanceof CarroSedan) {
                    CarroSedan c = (CarroSedan) v;
                    fw.write("Combustible: " + c.gettipoCombustible() + "\n");
                    fw.write("Transmision: " + c.gettransmision() + "\n");
                }

                if (v instanceof CamionetaSUV) {
                    CamionetaSUV c = (CamionetaSUV) v;
                    fw.write("Traccion: " + c.gettraccion() + "\n");
                    fw.write("Capacidad: " + c.getcapacidadMaletero() + "\n");
                }

                fw.write("---------------------------------------\n");
            }

            System.out.println("Exportacion exitosa.");

        } catch (IOException e) {
            System.out.println("Error al exportar.");
        }
    }
}
