public class Licuadora extends Electrodomesticos {
    private int numAspas;
    private int numVelocidades;
    private String materialVaso;
    private double voltaje;
    private double porcMantenimientoL = 0.04;
    private double costoMantLic;
    private double precioFinalLicuadora = super.CalcprecioBase();

    public Licuadora() {

    }

    public Licuadora(String marca, double precioBase, String color, String modelo, double consumoEnergia,
            String eficienciaEnergia, double precioEnergia, float potencia, float tiempoFuncionamiento,
            double precioKwHora, double precioConsumo, String fuenteAlimentacion, int numAspas, int numVelocidades,
            String materialVaso, double voltaje, double porcMantenimientoL, double costoMantLic,
            double precioFinalLicuadora) {
        super(marca, precioBase, color, modelo, consumoEnergia, eficienciaEnergia, precioEnergia, potencia,
                tiempoFuncionamiento, precioKwHora, precioConsumo, fuenteAlimentacion);
        this.numAspas = numAspas;
        this.numVelocidades = numVelocidades;
        this.materialVaso = materialVaso;
        this.voltaje = voltaje;
        this.porcMantenimientoL = porcMantenimientoL;
        this.costoMantLic = costoMantLic;
        this.precioFinalLicuadora = precioFinalLicuadora;
    }

    public int getNumAspas() {
        return numAspas;
    }

    public void setNumAspas(int numAspas) {
        this.numAspas = numAspas;
    }

    public int getNumVelocidades() {
        return numVelocidades;
    }

    public void setNumVelocidades(int numVelocidades) {
        this.numVelocidades = numVelocidades;
    }

    public String getMaterialVaso() {
        return materialVaso;
    }

    public void setMaterialVaso(String materialVaso) {
        this.materialVaso = materialVaso;
    }

    public double getVoltaje() {
        return voltaje;
    }

    public void setVoltaje(double voltaje) {
        this.voltaje = voltaje;
    }

    public double getPorcMantenimientoL() {
        return porcMantenimientoL;
    }

    public void setPorcMantenimientoL(double porcMantenimientoL) {
        this.porcMantenimientoL = porcMantenimientoL;
    }

    public double getCostoMantLic() {
        return costoMantLic;
    }

    public void setCostoMantLic(double costoMantLic) {
        this.costoMantLic = costoMantLic;
    }

    public double getPrecioFinalLicuadora() {
        return precioFinalLicuadora;
    }

    public void setPrecioFinalLicuadora(double precioFinalLicuadora) {
        this.precioFinalLicuadora = precioFinalLicuadora;
    }

    // ----Inicio Métodos----
    public void CalccostoMantenimiento() {
        costoMantLic = super.CalcprecioBase() * 0.04;
    }

    public void CalcprecioFinal() {
        precioFinalLicuadora = super.CalcprecioBase();
        if (numVelocidades > 3) {
            precioFinalLicuadora += 10000;
        }
        if (materialVaso.equalsIgnoreCase("Vidrio")) {
            precioFinalLicuadora += 5000;
        }
        if (materialVaso.equalsIgnoreCase("Plástico")) {
            precioFinalLicuadora += 3000;
        }
    }
    // ---Fin métodos---

    @Override
    public String toString() {
        return "Licuadora [numero de aspas=" + numAspas + ", marca= " + marca + ", numero de velocidades="
                + numVelocidades
                + ", material de vaso=" + materialVaso + ", costo de mantenimiento=" + costoMantLic + ", precio final="
                + precioFinalLicuadora + "]";
    }

}
