import java.util.List;

public class Lavadora<T, U> extends Electrodomesticos {
    private T voltaje;
    private int programasdeLavado;
    private String materialdeTina;
    private U nivelesdeAgua;
    private String tipoPaneldeControl;
    private double porcMantenimiento = 0.08;
    private double totalMantenimientoLav;
    private double precioFinalLavadora = super.CalcprecioBase();

    public Lavadora() {

    }

    public Lavadora(String marca, double precioBase, String color, String modelo, double consumoEnergia,
            String eficienciaEnergia, double precioEnergia, float potencia, float tiempoFuncionamiento,
            double precioKwHora, double precioConsumo, String fuenteAlimentacion, T voltaje, int programasdeLavado,
            String materialdeTina, U nivelesdeAgua, String tipoPaneldeControl, double porcMantenimiento,
            double totalMantenimientoLav, double precioFinalLavadora) {
        super(marca, precioBase, color, modelo, consumoEnergia, eficienciaEnergia, precioEnergia, potencia,
                tiempoFuncionamiento, precioKwHora, precioConsumo, fuenteAlimentacion);
        this.voltaje = voltaje;
        this.programasdeLavado = programasdeLavado;
        this.materialdeTina = materialdeTina;
        this.nivelesdeAgua = nivelesdeAgua;
        this.tipoPaneldeControl = tipoPaneldeControl;
        this.porcMantenimiento = porcMantenimiento;
        this.totalMantenimientoLav = totalMantenimientoLav;
        this.precioFinalLavadora = precioFinalLavadora;
    }

    public T getVoltaje() {
        return voltaje;
    }

    public void setVoltaje(T voltaje) {
        this.voltaje = voltaje;
    }

    public int getProgramasdeLavado() {
        return programasdeLavado;
    }

    public void setProgramasdeLavado(int programasdeLavado) {
        this.programasdeLavado = programasdeLavado;
    }

    public String getMaterialdeTina() {
        return materialdeTina;
    }

    public void setMaterialdeTina(String materialdeTina) {
        this.materialdeTina = materialdeTina;
    }

    public U getNivelesdeAgua() {
        return nivelesdeAgua;
    }

    public void setNivelesdeAgua(U nivelesdeAgua) {
        this.nivelesdeAgua = nivelesdeAgua;
    }

    public String getTipoPaneldeControl() {
        return tipoPaneldeControl;
    }

    public void setTipoPaneldeControl(String tipoPaneldeControl) {
        this.tipoPaneldeControl = tipoPaneldeControl;
    }

    public double getPorcMantenimiento() {
        return porcMantenimiento;
    }

    public void setPorcMantenimiento(double porcMantenimiento) {
        this.porcMantenimiento = porcMantenimiento;
    }

    public double getTotalMantenimientoLav() {
        return totalMantenimientoLav;
    }

    public void setTotalMantenimientoLav(double totalMantenimientoLav) {
        this.totalMantenimientoLav = totalMantenimientoLav;
    }

    public double getPrecioFinalLavadora() {
        return precioFinalLavadora;
    }

    public void setPrecioFinalLavadora(double precioFinalLavadora) {
        this.precioFinalLavadora = precioFinalLavadora;
    }

    // ----Inicio Métodos----
    public void CalccostoMantenimiento() {
        totalMantenimientoLav = precioBase * 0.08;
    }

    public void CalcprecioFinal() {
        precioFinalLavadora = super.CalcprecioBase();
        if (programasdeLavado > 5) {
            precioFinalLavadora += 30000;
        } else {
            precioFinalLavadora += 20000;
        }
    }

    public static void imprimirDetallesLavadoras(List<? extends Lavadora<?, ?>> lavadoras) {
        for (Lavadora<?, ?> lavadora : lavadoras) {
            System.out.println("Marca: " + lavadora.marca);
            System.out.println("Voltaje: " + lavadora.getVoltaje());
            System.out.println("Programas de Lavado: " + lavadora.getProgramasdeLavado());
            System.out.println("Material de Tina: " + lavadora.getMaterialdeTina());
            System.out.println("Niveles de Agua: " + lavadora.getNivelesdeAgua());
            System.out.println("Tipo de Panel de Control: " + lavadora.getTipoPaneldeControl());
            System.out.println("Precio Final de la Lavadora: " + lavadora.getPrecioFinalLavadora());
            System.out.println("----------------------------------------");
        }
        // ---Fin métodos----
    }
}
