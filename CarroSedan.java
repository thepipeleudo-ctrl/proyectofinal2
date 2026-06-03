public class CarroSedan extends Vehiculo {

    private String tipoCombustible;
    private String transmision;

    public CarroSedan(String placa, String marca, int modelo, float precioDiario,String estado,String tipoCombustible, String transmision) {

        super(placa, marca, modelo, precioDiario, estado);

        this.tipoCombustible = tipoCombustible;
        this.transmision = transmision;
    }

    @Override
    public String mostrarInformacion() {

        return "SEDAN" +
                "\nPlaca: " + getPlaca() +
                "\nMarca: " + getMarca() +
                "\nModelo: " + getModelo() +
                "\nPrecio Diario: " + getPrecioDiario() +
                "\nEstado: " + getEstado() +
                "\nCombustible: " + tipoCombustible +
                "\nTransmision: " + transmision;
    }

    public String gettipoCombustible() {
       
        throw new UnsupportedOperationException("Unimplemented method 'gettipoCombustible'");
    }

    public String gettransmision() {
   
        throw new UnsupportedOperationException("Unimplemented method 'gettransmision'");
    }
}