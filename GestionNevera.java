import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Gestion nevera con Hashset
public class GestionNevera extends Nevera {
    private HashSet<Nevera> neveras;
    private String eficiencia;

    public GestionNevera(String marca, double precioBase, String color, String modelo, double consumoEnergia,
            String eficienciaEnergia, double precioEnergia, float potencia, float tiempoFuncionamiento,
            double precioKwHora, double precioConsumo, String fuenteAlimentacion, String funcionDual,
            double capacidadLitros, float consumoMinimoEnergetico, String tecnoDeFrio, String tipoPaneldeControl,
            double porcMantNev, double costoMantNev, double precioFinalNevera, HashSet<Nevera> neveras,
            String eficiencia) {
        super(marca, precioBase, color, modelo, consumoEnergia, eficienciaEnergia, precioEnergia, potencia,
                tiempoFuncionamiento, precioKwHora, precioConsumo, fuenteAlimentacion, funcionDual, capacidadLitros,
                consumoMinimoEnergetico, tecnoDeFrio, tipoPaneldeControl, porcMantNev, costoMantNev, precioFinalNevera);
        this.neveras = neveras;
        this.eficiencia = eficiencia;
        this.neveras = new HashSet<>();
    }

    public HashSet<Nevera> getNeveras() {
        return neveras;
    }

    public String getEficiencia() {
        return eficiencia;
    }

    public void setEficiencia(String eficiencia) {
        this.eficiencia = eficiencia;
    }

    // INICIO CRUDL
    public void agregarNevera(Nevera nevera) {
        neveras.add(nevera);
        System.out.println("¡Nevera agregada correctamente!");
    }

    public void eliminarNevera(String modelo) {
        Nevera neveraAEliminar = buscarNevera(modelo);
        if (neveraAEliminar != null) {
            neveras.remove(neveraAEliminar);
            System.out.println("Nevera eliminada correctamente.");
        } else {
            System.out.println("La nevera con el modelo " + modelo + " no se encuentra");
        }
    }

    public Nevera buscarNevera(String modelo) {
        for (Nevera nevera : neveras) {
            if (nevera.getModelo().equals(modelo)) {
                return nevera;
            }
        }
        System.out.println("La nevera con modelo " + modelo + " no se encuentra");
        return null; // Si no se encuentra la nevera
    }

    public void modificarNevera(String modelo, Nevera nuevaNevera) {
        Nevera neveraExistente = buscarNevera(modelo);
        if (neveraExistente != null) {
            neveras.remove(neveraExistente);
            System.out.println("Nevera modificada correctamente");
        } else {
            System.out.println("La nevera con modelo " + modelo + " no se encuentra");
        }
    }

    public void mostrarNeveras() {
        if (neveras.isEmpty()) {
            System.out.println("No hay neveras registradas.");
        } else {
            System.out.println("Lista de Neveras:");
            for (Nevera nevera : neveras) {
                System.out.println(nevera);
            }
        }
    }
    // FIN CRUDL

    // INICIO FILTROS
    public List<String> filtradoEficienciaEnergetica(String eficiencia) {
        if (neveras != null) {
            Stream<Nevera> streamNeveras = neveras.stream();

            return streamNeveras.filter(e -> e.getEficienciaEnergia().equalsIgnoreCase(eficiencia))
                    .map(e -> String.format("Modelo: %s, Marca: %s, Eficiencia: %s", e.getModelo(), e.getMarca(),
                            e.getEficienciaEnergia()))
                    .collect(Collectors.toList());
        } else {
            System.out.println("Error");
            return new ArrayList<>();
        }
    }

    public List<Nevera> filtrarPorFunciionDual() {
        if (neveras != null) {
            Stream<Nevera> streamNeveras = neveras.stream();

            return streamNeveras.sorted(Comparator.comparing(Nevera::getFuncionDual))
                    .collect(Collectors.toList());
        } else {
            System.out.println("Error: La lista de neveras es nula");
            return new ArrayList<>();
        }
    }
    // FIN FILTROS
}