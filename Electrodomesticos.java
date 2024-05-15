public abstract class Electrodomesticos {
    protected String marca;
    protected double precioBase;
    protected String color;
    protected String modelo;
    protected double consumoEnergia;
    protected String eficienciaEnergia;
    protected double precioEnergia = 550;
    protected float potencia;
    protected float tiempoFuncionamiento;
    protected double precioKwHora = 0.15;
    protected double precioConsumo;
    protected String fuenteAlimentacion;

    public Electrodomesticos() {

    }

    public Electrodomesticos(String marca, double precioBase, String color, String modelo, double consumoEnergia,
            String eficienciaEnergia, double precioEnergia, float potencia, float tiempoFuncionamiento,
            double precioKwHora, double precioConsumo, String fuenteAlimentacion) {
        this.marca = marca;
        this.precioBase = precioBase;
        this.color = color;
        this.modelo = modelo;
        this.consumoEnergia = consumoEnergia;
        this.eficienciaEnergia = eficienciaEnergia;
        this.precioEnergia = precioEnergia;
        this.potencia = potencia;
        this.tiempoFuncionamiento = tiempoFuncionamiento;
        this.precioKwHora = precioKwHora;
        this.precioConsumo = precioConsumo;
        this.fuenteAlimentacion = fuenteAlimentacion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getConsumoEnergia() {
        return consumoEnergia;
    }

    public void setConsumoEnergia(double consumoEnergia) {
        this.consumoEnergia = consumoEnergia;
    }

    public String getEficienciaEnergia() {
        return eficienciaEnergia;
    }

    public void setEficienciaEnergia(String eficienciaEnergia) {
        this.eficienciaEnergia = eficienciaEnergia;
    }

    public double getPrecioEnergia() {
        return precioEnergia;
    }

    public void setPrecioEnergia(double precioEnergia) {
        this.precioEnergia = precioEnergia;
    }

    public float getPotencia() {
        return potencia;
    }

    public void setPotencia(float potencia) {
        this.potencia = potencia;
    }

    public float getTiempoFuncionamiento() {
        return tiempoFuncionamiento;
    }

    public void setTiempoFuncionamiento(float tiempoFuncionamiento) {
        this.tiempoFuncionamiento = tiempoFuncionamiento;
    }

    public double getPrecioKwHora() {
        return precioKwHora;
    }

    public void setPrecioKwHora(double precioKwHora) {
        this.precioKwHora = precioKwHora;
    }

    public double getPrecioConsumo() {
        return precioConsumo;
    }

    public void setPrecioConsumo(double precioConsumo) {
        this.precioConsumo = precioConsumo;
    }

    public String getFuenteAlimentacion() {
        return fuenteAlimentacion;
    }

    public void setFuenteAlimentacion(String fuenteAlimentacion) {
        this.fuenteAlimentacion = fuenteAlimentacion;
    }

    // ---------Métodos----------------

    // Método para calcular la eficiencia energetica del producto
    public double CalcEficienciaEnergia() {
        switch (eficienciaEnergia) {
            case "A+++":
                precioBase *= 0.35; // Recibe un descuento de 65%
                break;

            case "A++":
                precioBase *= 0.35; // Recibe un descuento de 65%
                break;

            case "A+":
                precioBase *= 0.40; // Recibe un descuento de 60%
                break;

            case "A":
                precioBase *= 0.45; // Recibe un descuento de 55%
                break;

            case "B":
                precioBase *= 0.50; // Recibe un descuento de 50%
                break;

            case "C":
                precioBase *= 0.60; // Recibe un descuento de 40%
                break;

            case "D":
                precioBase *= 0.75; // Recibe un descuento de 25%
                break;

            case "E":
                precioBase *= 0.85; // Recibe un descuento de 15%
                break;

            case "F":
                precioBase *= 0.90; // Recibe un descuento de 10%
                break;

            case "G":
                precioBase *= 0.97; // Recibe un descuento de 3%
                break;

            case "No aplica":
                precioBase *= 1; // En caso de que el producto no cuente con eficiencia energetica
            default:
                break;
        }
        return precioBase;
    }

    // Método para calcular el precio final del producto
    public double CalcprecioBase() {
        return precioBase;
    }

    // Método para calcular el consumo de energía (si el usuario lo requiere) del
    public double CalcconsumoEnergia() {
        consumoEnergia = potencia * tiempoFuncionamiento;
        return consumoEnergia;
    }

    // Método para calcular el precio del consumo de energia
    public double CalcprecioConsumoEnergia() {
        this.consumoEnergia = this.CalcconsumoEnergia();
        precioConsumo = consumoEnergia * 0.15;
        return precioConsumo;
    }

    abstract void CalccostoMantenimiento();

    abstract void CalcprecioFinal();

    @Override
    public String toString() {
        return "Electrodomesticos [marca=" + marca + ", precio base=" + precioBase + ", color=" + color + ", modelo="
                + modelo + ", consumo de energia=" + consumoEnergia + ", eficiencia energética=" + eficienciaEnergia
                + ", precioEnergia=" + precioEnergia + ", potencia=" + potencia + ", tiempoFuncionamiento="
                + tiempoFuncionamiento + ", precio Kw/Hora=" + precioKwHora + ", precio de consumo=" + precioConsumo
                + ", fuente de alimentacion=" + fuenteAlimentacion + "]";
    }

}