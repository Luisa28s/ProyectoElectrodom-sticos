public class AireAcondicionado<T, U, V> extends Electrodomesticos {
    private T capacidadEnfriamiento;
    private U voltaje;
    private V tipoMotor;
    private String materialTuberia;
    private double porcentajeCostoMantenimiento = 0.7;
    private double totalMantenimiento;
    private double precioFinalAire = super.CalcprecioBase();

    // ----Constructor--------

    public AireAcondicionado() {

    }

    public AireAcondicionado(String marca, double precioBase, String color, String modelo, double consumoEnergia,
            String eficienciaEnergia, double precioEnergia, float potencia, float tiempoFuncionamiento,
            double precioKwHora, double precioConsumo, String fuenteAlimentacion, T capacidadEnfriamiento, U voltaje,
            V tipoMotor, String materialTuberia, double porcentajeCostoMantenimiento, double totalMantenimiento,
            double precioFinalAire) {
        super(marca, precioBase, color, modelo, consumoEnergia, eficienciaEnergia, precioEnergia, potencia,
                tiempoFuncionamiento, precioKwHora, precioConsumo, fuenteAlimentacion);
        this.capacidadEnfriamiento = capacidadEnfriamiento;
        this.voltaje = voltaje;
        this.tipoMotor = tipoMotor;
        this.materialTuberia = materialTuberia;
        this.porcentajeCostoMantenimiento = porcentajeCostoMantenimiento;
        this.totalMantenimiento = totalMantenimiento;
        this.precioFinalAire = precioFinalAire;
    }

    // -----Getters y Setters------

    public T getCapacidadEnfriamiento() {
        return capacidadEnfriamiento;
    }

    public void setCapacidadEnfriamiento(T capacidadEnfriamiento) {
        this.capacidadEnfriamiento = capacidadEnfriamiento;
    }

    public U getVoltaje() {
        return voltaje;
    }

    public void setVoltaje(U voltaje) {
        this.voltaje = voltaje;
    }

    public V getTipoMotor() {
        return tipoMotor;
    }

    public void setTipoMotor(V tipoMotor) {
        this.tipoMotor = tipoMotor;
    }

    public String getMaterialTuberia() {
        return materialTuberia;
    }

    public void setMaterialTuberia(String materialTuberia) {
        this.materialTuberia = materialTuberia;
    }

    public double getPorcentajeCostoMantenimiento() {
        return porcentajeCostoMantenimiento;
    }

    public void setPorcentajeCostoMantenimiento(double porcentajeCostoMantenimiento) {
        this.porcentajeCostoMantenimiento = porcentajeCostoMantenimiento;
    }

    public double getTotalMantenimiento() {
        return totalMantenimiento;
    }

    public void setTotalMantenimiento(double totalMantenimiento) {
        this.totalMantenimiento = totalMantenimiento;
    }

    public double getPrecioFinalAire() {
        return precioFinalAire;
    }

    public void setPrecioFinalAire(double precioFinalAire) {
        this.precioFinalAire = precioFinalAire;
    }

    public void CalccostoMantenimiento() {
        totalMantenimiento = super.CalcprecioBase() * 0.07;
    }

    public void CalcprecioFinal() {
        precioFinalAire = super.CalcprecioBase();
        if (marca.equalsIgnoreCase("HACEB")) {
            precioFinalAire += 5000;
        } else if (marca.equalsIgnoreCase("MABE")) {
            precioFinalAire += 10000;
        } else if (marca.equalsIgnoreCase("LG")) {
            precioFinalAire += 15000;
        } else {
            precioFinalAire += 500;
        }
    }

}