public class Vehiculo {

    private String placa;
    private String marca;
    private int modelo;
    private float precioDiario;
    private String estado;

    public Vehiculo(String placa, String marca,int modelo,float precioDiario,String estado) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.precioDiario = precioDiario;
        this.estado = estado;
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public int getModelo() {
        return modelo;
    }

    public float getPrecioDiario() {
        return precioDiario;
    }

    public String getEstado() {
        return estado;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public void setPrecioDiario(float precioDiario) {
        this.precioDiario = precioDiario;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    public String mostrarInformacion() {

        return "Placa: " + placa +
                "\nMarca: " + marca +
                "\nModelo: " + modelo +
                "\nPrecio Diario: " + precioDiario +
                "\nEstado: " + estado;
    }

    @Override
    public String toString() {
        return mostrarInformacion();
    }
}