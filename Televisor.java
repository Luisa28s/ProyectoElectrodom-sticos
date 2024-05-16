public class Televisor extends Electrodomesticos {
    private String resolucionPantalla;
    private int pulgadas;
    private int numPuertosHDMI;
    private int numPuertosUSB;
    private int numPuertosVGA;
    private double porcMantTv = 0.05;
    private double costoMantTv;
    private double precioFinalTV = super.CalcprecioBase();

    public Televisor() {

    }

    public Televisor(String marca, double precioBase, String color, String modelo, double consumoEnergia,
            String eficienciaEnergia, double precioEnergia, float potencia, float tiempoFuncionamiento,
            double precioKwHora, double precioConsumo, String fuenteAlimentacion, String resolucionPantalla,
            int pulgadas, int numPuertosHDMI, int numPuertosUSB,
            int numPuertosVGA, double porcMantTv, double costoMantTv, double precioFinalTV) {
        super(marca, precioBase, color, modelo, consumoEnergia, eficienciaEnergia, precioEnergia, potencia,
                tiempoFuncionamiento, precioKwHora, precioConsumo, fuenteAlimentacion);
        this.resolucionPantalla = resolucionPantalla;
        this.pulgadas = pulgadas;
        this.numPuertosHDMI = numPuertosHDMI;
        this.numPuertosUSB = numPuertosUSB;
        this.numPuertosVGA = numPuertosVGA;
        this.porcMantTv = porcMantTv;
        this.costoMantTv = costoMantTv;
        this.precioFinalTV = precioFinalTV;
    }

    public String getResolucionPantalla() {
        return resolucionPantalla;
    }

    public void setResolucionPantalla(String resolucionPantalla) {
        this.resolucionPantalla = resolucionPantalla;
    }

    public int getPulgadas() {
        return pulgadas;
    }

    public void setPulgadas(int pulgadas) {
        this.pulgadas = pulgadas;
    }

    public int getNumPuertosHDMI() {
        return numPuertosHDMI;
    }

    public void setNumPuertosHDMI(int numPuertosHDMI) {
        this.numPuertosHDMI = numPuertosHDMI;
    }

    public int getNumPuertosUSB() {
        return numPuertosUSB;
    }

    public void setNumPuertosUSB(int numPuertosUSB) {
        this.numPuertosUSB = numPuertosUSB;
    }

    public int getNumPuertosVGA() {
        return numPuertosVGA;
    }

    public void setNumPuertosVGA(int numPuertosVGA) {
        this.numPuertosVGA = numPuertosVGA;
    }

    public double getPorcMantTv() {
        return porcMantTv;
    }

    public void setPorcMantTv(double porcMantTv) {
        this.porcMantTv = porcMantTv;
    }

    public double getCostoMantTv() {
        return costoMantTv;
    }

    public void setCostoMantTv(double costoMantTv) {
        this.costoMantTv = costoMantTv;
    }

    public double getPrecioFinalTV() {
        return precioFinalTV;
    }

    public void setPrecioFinalTV(double precioFinalTV) {
        this.precioFinalTV = precioFinalTV;
    }

    // ---- Inicio Métodos----
    public void CalccostoMantenimiento() {
        costoMantTv = precioBase * 0.05;
    }

    public void CalcprecioFinal() {
        precioFinalTV = super.CalcprecioBase();
        if (pulgadas > 40) {
            precioFinalTV = precioBase + 10000;
        } else {
            precioFinalTV += 5000;
        }
    }

    // ---Fin métodos

}
