public class CamionetaSUV extends Vehiculo {

    private String traccion;
    private float capacidadMaletero;

    public CamionetaSUV(String placa, String marca,  int modelo, float precioDiario,String estado,String traccion,float capacidadMaletero) {

        super(placa, marca, modelo, precioDiario, estado);

        this.traccion = traccion;
        this.capacidadMaletero = capacidadMaletero;
    }

    @Override
    public String mostrarInformacion() {

        return "SUV" +
                "\nPlaca: " + getPlaca() +
                "\nMarca: " + getMarca() +
                "\nModelo: " + getModelo() +
                "\nPrecio Diario: " + getPrecioDiario() +
                "\nEstado: " + getEstado() +
                "\nTraccion: " + traccion +
                "\nCapacidad Maletero: " + capacidadMaletero;
    }

    public String gettraccion() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'gettraccion'");
    }

    public String getcapacidadMaletero() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getcapacidadMaletero'");
    }
}