import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ImportarArchivoTxt {

    public ArrayList<Vehiculo> leerArchivo(String archivo, ArrayList<Vehiculo> lista) {

        String ruta = archivo + ".txt";

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {

            String linea;

            String marca = "";
            int modelo = 0;
            float precioDiario  = 0;
            String estado = "Disponible";
            String placa = "";
            String tipoCombustible = "";
            String transmision = "";
            String traccion = "";
            float capacidad = 0;

            boolean esSedan = false;
            boolean esSUV = false;

            while ((linea = br.readLine()) != null) {

                if (linea.startsWith("Marca: ")) {
                    marca = linea.substring(7).trim();
                }

                else if (linea.startsWith("Modelo: ")) {
                    modelo = Integer.parseInt(linea.substring(8).trim());
                }

                else if (linea.startsWith("Precio: ")) {
                    precioDiario = Float.parseFloat(linea.substring(8).trim());
                }

                else if (linea.startsWith("Estado: ")) {
                    estado = linea.substring(8).trim();
                }

                else if (linea.startsWith("Combustible: ")) {
                    tipoCombustible = linea.substring(13).trim();
                    esSedan = true;
                }

                else if (linea.startsWith("Transmision: ")) {
                    transmision = linea.substring(13).trim();
                }

                else if (linea.startsWith("Traccion: ")) {
                    traccion = linea.substring(10).trim();
                    esSUV = true;
                }

                else if (linea.startsWith("Capacidad: ")) {
                    capacidad = Float.parseFloat(linea.substring(11).trim());
                }

                else if (linea.startsWith("--------------------------------")) {

                    if (!marca.isEmpty()) {

                        if (esSedan) {
                     lista.add(new CarroSedan(placa, marca, modelo, precioDiario, estado, tipoCombustible, transmision));
                        }

                        else if (esSUV) {
                            lista.add(new CamionetaSUV(
                                    placa, marca, modelo, precioDiario, estado, traccion, capacidad
                            ));
                        }
                    }

                    // reset
                    marca = "";
                    modelo = 0;
                   precioDiario= 0;
                    estado = "Disponible";

                    tipoCombustible = "";
                    transmision = "";
                    traccion = "";
                    capacidad = 0;

                    esSedan = false;
                    esSUV = false;
                }
            }

            System.out.println("Importacion exitosa.");

        } catch (IOException e) {
            System.out.println("Error al leer archivo.");
        }

        return lista;
    }
}