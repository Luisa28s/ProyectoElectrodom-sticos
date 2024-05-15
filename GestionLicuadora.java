import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Comparator;

public class GestionLicuadora extends Licuadora {
    private List<Licuadora> listaLicuadoras;
    private double precioMinimo;
    private String colorFiltrado;

    public GestionLicuadora(String marca, double precioBase, String color, String modelo, double consumoEnergia,
            String eficienciaEnergia, double precioEnergia, float potencia, float tiempoFuncionamiento,
            double precioKwHora, double precioConsumo, String fuenteAlimentacion, int numAspas, int numVelocidades,
            String materialVaso, double voltaje, double porcMantenimientoL, double costoMantLic,
            double precioFinalLicuadora, List<Licuadora> listaLicuadoras, double precioMinimo, String colorFiltrado) {
        super(marca, precioBase, color, modelo, consumoEnergia, eficienciaEnergia, precioEnergia, potencia,
                tiempoFuncionamiento, precioKwHora, precioConsumo, fuenteAlimentacion, numAspas, numVelocidades,
                materialVaso, voltaje, porcMantenimientoL, costoMantLic, precioFinalLicuadora);
        this.listaLicuadoras = listaLicuadoras;
        this.listaLicuadoras = new ArrayList<>();
        this.precioMinimo = precioMinimo;
        this.colorFiltrado = colorFiltrado;
    }

    public List<Licuadora> getListaLicuadoras() {
        return listaLicuadoras;
    }

    public double getPrecioMinimo() {
        return precioMinimo;
    }

    public void setPrecioMinimo(double precioMinimo) {
        this.precioMinimo = precioMinimo;
    }

    public String getColorFiltrado() {
        return colorFiltrado;
    }

    public void setColorFiltrado(String colorFiltrado) {
        this.colorFiltrado = colorFiltrado;
    }

    // ----Inicio de métodos de la colección------
    public void anadirLicuadora(Licuadora licuadora) {
        listaLicuadoras.add(licuadora);
        System.out.println("¡Licuadora agregada correctamente!");
    }

    public Licuadora obtenerLicuadora(String modelo) {
        for (Licuadora licuadora : listaLicuadoras) {
            if (licuadora.getModelo().equals(modelo)) {
                return licuadora;
            }
        }
        System.out.println("La licuadora con modelo " + modelo + " no se encuentra");
        return null; // Retorna null si no se encuentra la licuadora con el modelo dado
    }

    public void modificarLicuadora(String modelo, Licuadora datos) {
        for (int i = 0; i < listaLicuadoras.size(); i++) {
            Licuadora licuadora = listaLicuadoras.get(i);
            if (licuadora.getModelo().equals(modelo)) {
                listaLicuadoras.set(i, datos);
                System.out.println("La licuadora con modelo ->" + modelo + "<- ha sido modificada.");
                return;
            }
        }
        System.out.println("La licuadora con modelo ->" + modelo + "<- no se encuentra");
    }

    public void eliminarLicuadora(String modelo) {
        for (int i = 0; i < listaLicuadoras.size(); i++) {
            Licuadora licuadora = listaLicuadoras.get(i);
            if (licuadora.getModelo().equals(modelo)) {
                listaLicuadoras.remove(i);
                System.out.println("La licuadora con modelo ->" + modelo + "<- ha sido eliminada.");
                return;
            }
        }
        System.out.println("La licuadora con modelo ->" + modelo + "<- no se encuentra en la lista.");
    }

    public void mostrarLicuadoras() {
        if (listaLicuadoras.isEmpty()) {
            System.out.println("No hay licuadoras en la lista.");
        } else {
            System.out.println("Lista de licuadoras:");
            for (Licuadora licuadora : listaLicuadoras) {
                System.out.println(licuadora);
            }
        }
    }
    // ----Fin métodos de la colección----

    // ------Inicio filtros por Stream----------
    public List<Licuadora> filtrarPorMarca() {
        // Verificar si listaLicuadoras no es nula antes de crear el Stream
        if (listaLicuadoras != null) {
            // Convertir la lista a Stream
            Stream<Licuadora> streamLicuadoras = listaLicuadoras.stream();

            // Ordenar el Stream por marcas
            return streamLicuadoras.sorted(Comparator.comparing(Licuadora::getMarca)).collect(Collectors.toList());
        } else {
            throw new IllegalStateException("La lista de licuadoras está vacía");

        }
    }

    public List<String> filtrarLicPorPrecio(double precioMinimoo) {
        // Verificar si listaLicuadoras no es nula antes de crear el Stream
        if (listaLicuadoras != null) {
            // Convertir la lista a Stream
            Stream<Licuadora> streamLicuadoras = listaLicuadoras.stream();

            // Aplicar filtro por el precio que el usuario ingrese
            return streamLicuadoras.filter(e -> e.getPrecioFinalLicuadora() > precioMinimoo)
                    .map(e -> String.format("Marca: %s, Modelo: %s, Precio: %.2f", e.getMarca(),
                            e.getModelo(), e.getPrecioFinalLicuadora()))
                    .collect(Collectors.toList());
        } else {
            throw new IllegalStateException("La lista de licuadoras está vacía");
        }
    }

    public List<String> filtrarPorColor(String colorDeseado) {
        // Verificar si listaLicuadoras no es nula antes de crear el Stream
        if (listaLicuadoras != null) {
            // Convertir la lista a Stream
            Stream<Licuadora> streamLicuadoras = listaLicuadoras.stream();

            // Aplicar filtro por el color deseado y luego mapear a una lista de cadenas
            // formateadas
            return streamLicuadoras.filter(e -> e.getColor().equalsIgnoreCase(colorDeseado))
                    .map(e -> String.format("Marca: %s, Modelo: %s, Color: %s", e.getMarca(), e.getModelo(),
                            e.getColor()))
                    .collect(Collectors.toList());
        } else {
            throw new IllegalStateException("La lista de licuadoras está vacía");
        }
    }

}
