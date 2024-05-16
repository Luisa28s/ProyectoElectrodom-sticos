public class Nevera extends Electrodomesticos {
    private String funcionDual; // Quiere decir que si la nevera refrigera o congela
    private double capacidadLitros;
    private float consumoMinimoEnergetico;
    private String tecnoDeFrio;
    private String tipoPaneldeControl;
    private double porcMantNev = 0.09;
    private double costoMantNev;
    private double precioFinalNevera = super.CalcprecioBase();

    public Nevera() {

    }

    public Nevera(String marca, double precioBase, String color, String modelo, double consumoEnergia,
            String eficienciaEnergia, double precioEnergia, float potencia, float tiempoFuncionamiento,
            double precioKwHora, double precioConsumo, String fuenteAlimentacion, String funcionDual,
            double capacidadLitros, float consumoMinimoEnergetico, String tecnoDeFrio, String tipoPaneldeControl,
            double porcMantNev, double costoMantNev, double precioFinalNevera) {
        super(marca, precioBase, color, modelo, consumoEnergia, eficienciaEnergia, precioEnergia, potencia,
                tiempoFuncionamiento, precioKwHora, precioConsumo, fuenteAlimentacion);
        this.funcionDual = funcionDual;
        this.capacidadLitros = capacidadLitros;
        this.consumoMinimoEnergetico = consumoMinimoEnergetico;
        this.tecnoDeFrio = tecnoDeFrio;
        this.tipoPaneldeControl = tipoPaneldeControl;
        this.porcMantNev = porcMantNev;
        this.costoMantNev = costoMantNev;
        this.precioFinalNevera = precioFinalNevera;

    }

    public String getFuncionDual() {
        return funcionDual;
    }

    public void setFuncionDual(String funcionDual) {
        this.funcionDual = funcionDual;
    }

    public double getCapacidadLitros() {
        return capacidadLitros;
    }

    public void setCapacidadLitros(double capacidadLitros) {
        this.capacidadLitros = capacidadLitros;
    }

    public float getConsumoMinimoEnergetico() {
        return consumoMinimoEnergetico;
    }

    public void setConsumoMinimoEnergetico(float consumoMinimoEnergetico) {
        this.consumoMinimoEnergetico = consumoMinimoEnergetico;
    }

    public String getTecnoDeFrio() {
        return tecnoDeFrio;
    }

    public void setTecnoDeFrio(String tecnoDeFrio) {
        this.tecnoDeFrio = tecnoDeFrio;
    }

    public String getTipoPaneldeControl() {
        return tipoPaneldeControl;
    }

    public void setTipoPaneldeControl(String tipoPaneldeControl) {
        this.tipoPaneldeControl = tipoPaneldeControl;
    }

    public double getPorcMantNev() {
        return porcMantNev;
    }

    public void setPorcMantNev(double porcMantNev) {
        this.porcMantNev = porcMantNev;
    }

    public double getCostoMantNev() {
        return costoMantNev;
    }

    public void setCostoMantNev(double costoMantNev) {
        this.costoMantNev = costoMantNev;
    }

    public double getPrecioFinalNevera() {
        return precioFinalNevera;
    }

    public void setPrecioFinalNevera(double precioFinalNevera) {
        this.precioFinalNevera = precioFinalNevera;
    }

    // ----Inicio Métodos----
    public void CalccostoMantenimiento() {
        costoMantNev = super.CalcprecioBase() * 0.09;
    }

    public void CalcprecioFinal() {
        precioFinalNevera = super.CalcprecioBase();
        if (capacidadLitros > 300) {
            precioFinalNevera += 3000;
        }
        if (tecnoDeFrio.equalsIgnoreCase("noFrost")) {
            precioFinalNevera += 10000;
        }
    }
    // ---Fin métodos----

    @Override
    public String toString() {
        return "Nevera [funcion dual=" + funcionDual + ", marca =" + marca + ", capacidad x litros=" + capacidadLitros
                + ", tecnología de frio=" + tecnoDeFrio + ", tipo panel de control="
                + tipoPaneldeControl + ", precio final=" + precioFinalNevera + "]";
    }

}
