import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        GestionNevera gestionNevera = new GestionNevera(null, 0, null, null, 0, null, 0,
                0, 0, 0, 0, null, null, 0, 0, null, null, 0, 0, 0, null, null);

        GestionLicuadora gestionLicuadora = new GestionLicuadora(null, 0, null, null, 0,
                null, 0, 0, 0, 0, 0, null, 0, 0, null, 0, 0, 0, 0, null, 0, null);

        int opc = 0;
        char continuar = 'S';
        boolean volverMenuPrincipal = false;
        System.out.println();

        try {
            do {
                System.out.println("_______ B I E N V E N I D O ________");
                System.out.println("       1. Aire acondicionado        ");
                System.out.println("            2. Nevera               ");
                System.out.println("           3. Licuadora             ");
                System.out.println("           4. Lavadora");
                System.out.println("          5. Televisor              ");
                System.out.println("            6. Salir                ");
                System.out.println("________________________________________");
                System.out.println("Seleccione una opción: ");
                opc = teclado.nextInt();

                System.out.println();

                switch (opc) {
                    case 1:
                        char aggAire = 'S';
                        do {
                            System.out.println("____ AIRE ACONDICIONADO ____");
                            System.out.println("Marca: HACEB - MABE - LG - OTRA(Ingrese cuál)");
                            teclado.nextLine();
                            String marcaA = teclado.nextLine();
                            System.out.println("Precio base: ");
                            double pBaseA = teclado.nextDouble();
                            System.out.println("Color: ");
                            teclado.nextLine();
                            String colorA = teclado.nextLine();
                            System.out.println("Modelo: ");
                            String modeloA = "";
                            boolean entradaModelo = false;
                            // Validación de modelo
                            while (!entradaModelo) {
                                modeloA = teclado.nextLine();
                                if (!modeloA.matches("^[a-zA-Z]+$")) {
                                    System.out.println("Debe ingresar obligatoriamente letras sin espacios");
                                } else {

                                    entradaModelo = true;
                                    teclado.nextLine();
                                }
                            }
                            System.out.println(
                                    "Eficiencia energética: A+++ , A++ , A+ , A, B , C , D , E , F , G , NO APLICA ");
                            String eficienciaA = "";
                            boolean entradaEficiencia = false;
                            // Validacion eficiencia energética con expresión regular
                            while (!entradaEficiencia) {
                                eficienciaA = teclado.nextLine();
                                if (!eficienciaA.matches("^(A\\+{0,3}|B|C|D|F|G|No aplica)$")) {
                                    System.out.println("Error: Eficiencia de energía no válida");
                                } else {
                                    entradaEficiencia = true;
                                }
                            }
                            System.out.println("Capacidad de enfriamiento: ");
                            Double enfriamientoA = teclado.nextDouble();
                            System.out.println("Voltaje: ");
                            Double voltajeA = 0.0;
                            boolean entradaVoltaje = false;
                            // Validación de excepción para el voltaje
                            while (!entradaVoltaje) {
                                try {
                                    voltajeA = teclado.nextDouble();
                                    entradaVoltaje = true;
                                } catch (InputMismatchException e) {
                                    System.out.println("Debe ingresar un número válido");
                                    teclado.next();
                                }
                            }
                            System.out.println("Tipo de motor: ");
                            teclado.nextLine();
                            String motorA = teclado.nextLine();
                            System.out.println("Materia del tubería: ");
                            String tuberiaA = teclado.nextLine();
                            System.out.println();

                            // Instancia de la clase "Aire acondicionado"
                            AireAcondicionado<Double, Double, String> aireA = new AireAcondicionado<Double, Double, String>(
                                    marcaA, pBaseA, colorA, modeloA, 0, eficienciaA,
                                    0, 0, 0, 0, 0, null, enfriamientoA, voltajeA, motorA, tuberiaA, 0, 0, 0);

                            // Captura de datos
                            aireA.setMarca(marcaA);
                            aireA.setPrecioBase(pBaseA);
                            aireA.setColor(colorA);
                            aireA.setModelo(modeloA);
                            aireA.setEficienciaEnergia(eficienciaA);
                            aireA.setCapacidadEnfriamiento(enfriamientoA);
                            aireA.setVoltaje(voltajeA);
                            aireA.setTipoMotor(motorA);
                            aireA.setMaterialTuberia(tuberiaA);

                            // Llamada de métodos
                            aireA.CalcEficienciaEnergia();
                            aireA.CalcprecioBase();
                            aireA.CalcprecioFinal();
                            aireA.CalccostoMantenimiento();
                            System.out.println();

                            System.out.println("¡Aire agregado con éxito!");
                            System.out.println();

                            System.out.println("Precio base + eficiencia energética: " + aireA.getPrecioBase());
                            System.out.println("Costo de mantenimiento: " + aireA.getTotalMantenimiento());
                            System.out.println("Precion final en $COP: " + aireA.getPrecioFinalAire());

                            // Calcular consumo de energía y su precio si el usuario lo requiere
                            System.out.println("¿Desea saber el consumo de energía y su precio? (1.Sí o 2.No)");
                            int opcCalculo = teclado.nextInt();

                            if (opcCalculo != 2) {
                                System.out.println("Ingrese la potencia: ");
                                float potenciaA = teclado.nextFloat();
                                System.out.println("Tiempo aproximado de funcionamiento");
                                float tiempoFun = teclado.nextFloat();

                                // Captura de datos
                                aireA.setPotencia(potenciaA);
                                aireA.setTiempoFuncionamiento(tiempoFun);

                                // Llamada de métodos
                                aireA.CalcconsumoEnergia();
                                aireA.CalcprecioConsumoEnergia();

                                System.out.println("El consumo de energía en Kw/H es de: " + aireA.getConsumoEnergia());
                                System.out.println("Tiene un costo de: " + aireA.getPrecioConsumo());
                            } else {

                            }

                            System.out.println("¿Desea agregar otro aire acondicionado? (S/N)");
                            aggAire = teclado.next().charAt(0);

                        } while (aggAire == 'S' || aggAire == 's');
                        break;

                    case 2:
                        // Caso 2: Nevera
                        do {
                            System.out.println("------------ NEVERA --------------");
                            System.out.println("       ¿Qué desea hacer?          ");
                            System.out.println("           1. Agregar             ");
                            System.out.println("           2. Eliminar            ");
                            System.out.println("           3. Buscar              ");
                            System.out.println("          4. Modificar            ");
                            System.out.println("     5. Ver info de neveras        ");
                            System.out.println("6. Filtrar por eficiencia energética");
                            System.out.println("   7. Filtrar por función dual     ");
                            System.out.println("   8. Volver al menú principal      ");
                            System.out.println("-------------------------------------");
                            int opcNevera = teclado.nextInt();
                            teclado.nextLine();
                            System.out.println();

                            switch (opcNevera) {
                                case 1:
                                    // Caso 2.1: Agregar Nevera
                                    char aggNev = 'S';
                                    do {
                                        System.out.println("------- Agregar nevera --------");
                                        System.out
                                                .println("Por favor ingrese los siguientes datos para agregar nevera ");
                                        System.out.println("Marca: ");
                                        String marcaN = teclado.next();
                                        System.out.println("Precio Base: ");
                                        double precioN = teclado.nextDouble();
                                        System.out.println("Color: ");
                                        String colorN = teclado.next();
                                        System.out.println("Modelo: ");
                                        String modeloN = teclado.next();
                                        System.out.println("Fuente de alimentación: ");
                                        String fuenteA = teclado.next();
                                        System.out.println("Función dual (noFrost - No aplica)");
                                        String funDual = teclado.next();
                                        System.out.println("Capacidad x litros: ");
                                        teclado.nextLine();
                                        double capacidadL = teclado.nextDouble();
                                        System.out.println("Tipo de panel de control: ");
                                        String panelControl = teclado.next();
                                        System.out.println(
                                                "Eficiencia de energía: A+++ - A++ - A+ - A - B - C - D - C - F - G - No aplica");
                                        String eficienciaNev = teclado.next();

                                        Nevera nevera = new Nevera(marcaN, precioN, colorN, modeloN, 0, eficienciaNev,
                                                precioN, continuar, aggNev, precioN, precioN, fuenteA, funDual,
                                                capacidadL, opcNevera, panelControl, eficienciaNev, aggNev, capacidadL,
                                                precioN);

                                        nevera.setMarca(marcaN);
                                        nevera.setPrecioBase(precioN);
                                        nevera.setColor(colorN);
                                        nevera.setModelo(modeloN);
                                        nevera.setFuenteAlimentacion(fuenteA);
                                        nevera.setFuncionDual(funDual);
                                        nevera.setCapacidadLitros(capacidadL);
                                        nevera.setTipoPaneldeControl(panelControl);
                                        nevera.setEficienciaEnergia(eficienciaNev);

                                        gestionNevera.agregarNevera(nevera);
                                        System.out.println();

                                        System.out.println(
                                                "Precio base + eficiencia energética: " + nevera.getPrecioBase());
                                        System.out.println("Costo de mantenimiento: " + nevera.getCostoMantNev());
                                        System.out.println("Precion final en $COP: " + nevera.getPrecioFinalNevera());

                                        System.out.println();

                                        System.out.println(
                                                "¿Desea realizar el cálculo del consumo de energía del producto? (1.Sí o 2.No)");
                                        int opcCalculoN = teclado.nextInt();

                                        if (opcCalculoN != 2) {
                                            System.out.println("Ingrese la potencia: ");
                                            float potenciaNev = teclado.nextFloat();
                                            System.out.println("Tiempo aproximado de funcionamiento: ");
                                            float tiempoFuncNev = teclado.nextFloat();

                                            nevera.setPotencia(potenciaNev);
                                            nevera.setTiempoFuncionamiento(tiempoFuncNev);

                                            nevera.CalcconsumoEnergia();
                                            nevera.CalcprecioConsumoEnergia();

                                            System.out.println("El consumo de energía en Kw/H es de: "
                                                    + nevera.getConsumoEnergia());

                                            teclado.nextLine();

                                            System.out
                                                    .println("Tiene un costo en $COP de: " + nevera.getPrecioConsumo());
                                            System.out.println();
                                        }

                                        System.out.println("¿Desea agregar otra nevera? (S/N)");
                                        aggNev = teclado.next().charAt(0);
                                        System.out.println();
                                    } while (aggNev == 'S' || aggNev == 's');
                                    break;

                                case 2:
                                    // Caso 2.2: Eliminar Nevera
                                    char elimNev = 'S';
                                    do {
                                        System.out.println("-------- Eliminar nevera ---------");
                                        System.out.println("Ingrese el modelo de la nevera que desea eliminar");
                                        String modeloNevera = teclado.next();
                                        Nevera neveraAEliminar = gestionNevera.buscarNevera(modeloNevera);
                                        if (neveraAEliminar != null) {
                                            gestionNevera.eliminarNevera(modeloNevera);
                                        }
                                        System.out.println();

                                        System.out.println("¿Desea eliminar otra nevera? (S/N)");
                                        elimNev = teclado.next().charAt(0);
                                    } while (elimNev == 'S' || elimNev == 's');
                                    break;

                                case 3:
                                    // Caso 2.3: Buscar Nevera
                                    char buscNev = 'S';
                                    do {
                                        System.out.println("-------- Buscar nevera --------");
                                        System.out.println("Ingrese el modelo de la nevera que desea buscar:");
                                        String modeloBuscar = teclado.next();
                                        Nevera neveraEncontrada = gestionNevera.buscarNevera(modeloBuscar);
                                        if (neveraEncontrada != null) {
                                            System.out.println("Nevera encontrada:");
                                            System.out.println(neveraEncontrada);
                                        }
                                        System.out.println();

                                        System.out.println("¿Desea buscar otra nevera? (S/N)");
                                        buscNev = teclado.next().charAt(0);
                                    } while (buscNev == 'S' || buscNev == 's');
                                    break;

                                case 4:
                                    // Caso 2.4: Modificar Nevera
                                    char modifNev = 'S';
                                    do {
                                        System.out.println("-------- Modificar nevera --------");
                                        System.out.println("Ingrese el modelo de la nevera que desea modificar: ");
                                        String modeloModif = teclado.next();
                                        teclado.nextLine();

                                        Nevera nevExistente = gestionNevera.buscarNevera(modeloModif);

                                        if (nevExistente != null) {
                                            System.out.println("Por favor ingrese los nuevos datos de la nevera: ");
                                            System.out.println("Marca: ");
                                            String marcaNueva = teclado.nextLine();
                                            System.out.println("Precio Base: ");
                                            double precioNuevo = teclado.nextDouble();
                                            System.out.println("Color: ");
                                            String colorNuevo = teclado.next();
                                            System.out.println("Modelo: ");
                                            String modeloNuevo = teclado.next();
                                            System.out.println("Fuente de alimentación: ");
                                            String fuenteNueva = teclado.next();
                                            System.out.println("Función dual (noFrost - No aplica): ");
                                            String funDualNueva = teclado.next();
                                            System.out.println("Capacidad x litros: ");
                                            double capacidadLNueva = teclado.nextDouble();
                                            System.out.println("Tipo de panel de control: ");
                                            String panelControlNuevo = teclado.next();
                                            System.out.println(
                                                    "Eficiencia de energía: A+++ - A++ - A+ - A - B - C - D - C - F - G - No aplica");
                                            String eficienciaNev = teclado.next();

                                            Nevera nuevaNevera = new Nevera(marcaNueva, precioNuevo, colorNuevo,
                                                    modeloNuevo, 0, eficienciaNev, 0, 0, 0, 0, 0, fuenteNueva,
                                                    funDualNueva, capacidadLNueva, 0, panelControlNuevo, null, 0, 0, 0);

                                            nuevaNevera.setMarca(marcaNueva);
                                            nuevaNevera.setPrecioBase(precioNuevo);
                                            nuevaNevera.setColor(colorNuevo);
                                            nuevaNevera.setModelo(modeloNuevo);
                                            nuevaNevera.setFuenteAlimentacion(fuenteNueva);
                                            nuevaNevera.setFuncionDual(funDualNueva);
                                            nuevaNevera.setCapacidadLitros(capacidadLNueva);
                                            nuevaNevera.setTipoPaneldeControl(panelControlNuevo);
                                            nuevaNevera.setEficienciaEnergia(eficienciaNev);

                                            gestionNevera.modificarNevera(modeloModif, nuevaNevera);
                                            gestionNevera.agregarNevera(nuevaNevera);

                                            System.out.println();

                                            nuevaNevera.CalcEficienciaEnergia();
                                            nuevaNevera.CalcprecioBase();
                                            nuevaNevera.CalcprecioFinal();
                                            nuevaNevera.CalccostoMantenimiento();

                                            System.out.println("Precio base + eficiencia energética: "
                                                    + nuevaNevera.getPrecioBase());
                                            System.out.println(
                                                    "Costo de mantenimiento: " + nuevaNevera.getCostoMantNev());
                                            System.out.println(
                                                    "Precion final en $COP: " + nuevaNevera.getPrecioFinalNevera());

                                            System.out.println("¿Desea modificar otra nevera? (S/N)");
                                            modifNev = teclado.next().charAt(0);
                                        }
                                    } while (modifNev == 'S' || modifNev == 's');
                                    break;

                                case 5:
                                    // Caso 2.5: Ver info de Neveras
                                    System.out.println("Información sobre las neveras ");
                                    gestionNevera.mostrarNeveras();
                                    break;

                                case 6:
                                    // Caso 2.6: Filtrar por eficiencia energética
                                    List<Nevera> neverasFiltradas = gestionNevera.filtrarPorFunciionDual();
                                    if (!neverasFiltradas.isEmpty()) {
                                        System.out.println("Neveras filtradas por función dual:");
                                        for (Nevera neveraFuncion : neverasFiltradas) {
                                            System.out.println(neveraFuncion);
                                        }
                                    } else {
                                        System.out.println("No existen neveras con dicho filtro");
                                    }
                                    break;

                                case 7:
                                    // Caso 2.7: Filtrar por función dual
                                    System.out.println("Ingrese la función dual por la que quiere filtrar");
                                    System.out.println("A+++ - A++ - A+ - A - B - C - D - C - F - G - No aplica");
                                    teclado.nextLine();
                                    String eficiencia = teclado.nextLine();

                                    gestionNevera.setEficiencia(eficiencia);

                                    List<String> filtroEficiencia = gestionNevera
                                            .filtradoEficienciaEnergetica(eficiencia);

                                    if (!filtroEficiencia.isEmpty()) {
                                        System.out.println("Neveras filtradas por eficiencia:");
                                        filtroEficiencia.forEach(System.out::println);
                                    } else {
                                        System.out.println("No existen neveras con dicho filtro");
                                    }
                                    break;

                                case 8:
                                    // Caso 2.8: Volver al menú principal
                                    volverMenuPrincipal = true;
                                    break;

                                default:
                                    System.out.println("Por favor ingrese una opción válida");
                                    break;
                            }
                        } while (!volverMenuPrincipal);
                        break;

                    case 3:
                        do {
                            System.out.println("------------- LICUADORA --------------");
                            System.out.println("          ¿Qué desea hacer?           ");
                            System.out.println("        1. Agregar licuadora          ");
                            System.out.println("        2. Eliminar licuadora        ");
                            System.out.println("        3. Buscar licuadora           ");
                            System.out.println("        4. Modificar licuadora         ");
                            System.out.println("     5. Ver información de licuadoras");
                            System.out.println("     6. Filtrar licuadoras por marcas");
                            System.out.println("     7. Filtrar licuadoras por precio");
                            System.out.println("     8. Filtrar licuadoras por color         ");
                            System.out.println("      9. Volver al menú principal        ");
                            System.out.println("----------------------------------------");
                            int opcL = teclado.nextInt();
                            System.out.println();

                            switch (opcL) {
                                case 1:
                                    char aggLic = 'S';
                                    do {
                                        System.out.println("-----Agregar licuadora-------");
                                        System.out.println(
                                                "Por favor ingrese los siguientes datos para agregar licuadoras ");
                                        System.out.println("Marca: ");
                                        teclado.nextLine();
                                        String marcaL = teclado.nextLine();
                                        System.out.println("Precio base: ");
                                        double precioBase = teclado.nextDouble();
                                        System.out.println("Color: ");
                                        teclado.nextLine();
                                        String colorL = teclado.nextLine();
                                        System.out.println("Modelo: ");
                                        String modelo = teclado.nextLine();
                                        System.out.println(
                                                "Eficiencia de energía: A+++ - A++ - A+ - A - B - C - D - C - F - G - No aplica");
                                        String eficienciaE = teclado.nextLine();
                                        System.out.println("Número de aspas:");
                                        int aspas = teclado.nextInt();
                                        System.out.println("Número de velocidades: ");
                                        int velocidades = teclado.nextInt();
                                        System.out.println("Material de vaso (Vidrio / Plástico):");
                                        teclado.nextLine();
                                        String vaso = teclado.nextLine();

                                        // Instancia de la clase licuadora
                                        Licuadora licuadora = new Licuadora(marcaL, precioBase, colorL, modelo, 0,
                                                eficienciaE, 0,
                                                0, 0, 0, 0, null, aspas, velocidades, vaso, 0, 0, 0, 0);

                                        // Captura de los datos otorgados por el usuario
                                        licuadora.setMarca(marcaL);
                                        licuadora.setPrecioBase(precioBase);
                                        licuadora.setColor(colorL);
                                        licuadora.setModelo(modelo);
                                        licuadora.setEficienciaEnergia(eficienciaE);
                                        licuadora.setNumAspas(aspas);
                                        licuadora.setNumVelocidades(velocidades);
                                        licuadora.setMaterialVaso(vaso);

                                        // Llamada de métodos
                                        licuadora.CalcEficienciaEnergia();
                                        licuadora.CalcprecioBase();
                                        licuadora.CalcprecioFinal();
                                        licuadora.CalccostoMantenimiento();

                                        // Lllamada de método de colección para agregar licuadora
                                        gestionLicuadora.anadirLicuadora(licuadora);
                                        System.out.println();

                                        System.out.println(
                                                "Precio base + eficiencia energética: " + licuadora.getPrecioBase());
                                        System.out.println("Costo mantenimiento: " + licuadora.getCostoMantLic());
                                        System.out.println(
                                                "Precio final en $COP: " + licuadora.getPrecioFinalLicuadora());

                                        // Calcular consumo de energía y su precio si el usuario lo requiere
                                        System.out.println(
                                                "¿Desea saber el consumo de energía y su precio? (1.Sí o 2.No)");
                                        int opcCalculoLic = teclado.nextInt();

                                        if (opcCalculoLic != 2) {
                                            System.out.println("Ingrese la potencia: ");
                                            float potenciaL = teclado.nextFloat();
                                            System.out.println("Tiempo aproximado de funcionamiento");
                                            float tiempoFunL = teclado.nextFloat();

                                            // Captura de datos
                                            licuadora.setPotencia(potenciaL);
                                            licuadora.setTiempoFuncionamiento(tiempoFunL);

                                            // Llamada de métodos
                                            licuadora.CalcconsumoEnergia();
                                            licuadora.CalcprecioConsumoEnergia();

                                            System.out.println("El consumo de energía en Kw/H es de: "
                                                    + licuadora.getConsumoEnergia());
                                            System.out.println("Tiene un costo de: " + licuadora.getPrecioConsumo());
                                        } else {

                                        }

                                        System.out.println("¿Desea agregar otro aire acondicionado? (S/N)");
                                        aggLic = teclado.next().charAt(0);

                                    } while (aggLic == 'S' || aggLic == 's');
                                    break;

                                case 2:
                                    char elimLic = 'S';
                                    do {
                                        System.out.println("--------Eliminar licuadora--------");
                                        System.out
                                                .println("Por favor ingrese el modelo de la licuadora a eliminar -> ");
                                        teclado.nextLine();
                                        String modeloElim = teclado.nextLine();

                                        // Llamada de método de la colección para eliminar licuadora
                                        gestionLicuadora.eliminarLicuadora(modeloElim);

                                        System.out.println("¿Desea eliminar otra licuadora? (S/N)");
                                        elimLic = teclado.next().charAt(0);
                                        System.out.println();
                                    } while (elimLic == 'S' || elimLic == 's');
                                    break;

                                case 3:
                                    char buscarLic = 'S';
                                    do {
                                        System.out.println("-------Buscar licuadora-------");
                                        System.out.println(
                                                "Por favor ingrese el modelo de la licuadora que desea buscar: ");
                                        teclado.nextLine();
                                        String modeloBuscar = teclado.nextLine();

                                        // Se crea una nueva instancia de la licuadora para buscar con el método
                                        // "obtener" el modelo que el usuario desea buscar
                                        Licuadora licuadoraEncontrada = gestionLicuadora.obtenerLicuadora(modeloBuscar);

                                        if (licuadoraEncontrada != null) {
                                            // Si se encuentra el modelo, entonces se muestran los datos
                                            // correspondientes
                                            System.out.println("Detalles de la licuadora encontrada: ");
                                            System.out.println(licuadoraEncontrada);
                                        } else {
                                            System.out.println("La licuadora con modelo -> " + modeloBuscar
                                                    + " <- no se encontró");
                                        }
                                        System.out.println();
                                        System.out.println("¿Desea buscar otra licuadora? (S/N)");
                                        buscarLic = teclado.next().charAt(0);
                                        System.out.println();
                                    } while (buscarLic == 'S' || buscarLic == 's');
                                    break;

                                case 4:
                                    char modLic = 'S';
                                    do {
                                        System.out.println("-------Modificar licuadora-------");
                                        System.out.println(
                                                "Por favor ingrese el modelo de la licuadora que desea modificar -> ");
                                        teclado.nextLine();
                                        String modeloModif = teclado.nextLine();

                                        // Se crea una nueva instancia de la licuadora para buscar con el método
                                        // "obtener" el modelo que el usuario desea buscar
                                        Licuadora licuadoraExistente = gestionLicuadora.obtenerLicuadora(modeloModif);

                                        // Si se encuentra el modelo y es diferente de null, se piden los nuevos datos
                                        if (licuadoraExistente != null) {
                                            System.out.println("Por favor ingrese los nuevos datos ");
                                            System.out.println("Marca: ");
                                            String marcaNueva = teclado.nextLine();
                                            System.out.println("Precio base: ");
                                            double precioBaseNuevo = teclado.nextDouble();
                                            System.out.println("Color: ");
                                            String colorNuevo = teclado.nextLine();
                                            System.out.println("Modelo: ");
                                            String modeloNuevo = teclado.nextLine();
                                            System.out.println(
                                                    "Eficiencia de energía: A+++ - A++ - A+ - A - B - C - D - C - F - G - No aplica");
                                            String eficienciaENuevo = teclado.nextLine();
                                            System.out.println("Número de aspas: ");
                                            int aspasNuevo = teclado.nextInt();
                                            System.out.println("Número de velocidades: ");
                                            int velocidadesNuevo = teclado.nextInt();
                                            System.out.println("Material de vaso (Vidrio / Plástico): ");
                                            String vasoNuevo = teclado.nextLine();

                                            // Se crea otra instancia para los nuevos datos
                                            Licuadora nuevaLicuadora = new Licuadora(marcaNueva, precioBaseNuevo,
                                                    colorNuevo,
                                                    modeloNuevo, 0, eficienciaENuevo, 0, 0, 0, 0, 0, null, aspasNuevo,
                                                    velocidadesNuevo, vasoNuevo, 0, 0, 0, 0);

                                            // Captura de los datos otorgados
                                            nuevaLicuadora.setMarca(marcaNueva);
                                            nuevaLicuadora.setPrecioBase(precioBaseNuevo);
                                            nuevaLicuadora.setColor(colorNuevo);
                                            nuevaLicuadora.setModelo(modeloNuevo);
                                            nuevaLicuadora.setEficienciaEnergia(eficienciaENuevo);
                                            nuevaLicuadora.setNumAspas(aspasNuevo);
                                            nuevaLicuadora.setNumVelocidades(velocidadesNuevo);
                                            nuevaLicuadora.setMaterialVaso(vasoNuevo);

                                            // Primero se modifica y luego se agrega la info de la licuadora
                                            gestionLicuadora.modificarLicuadora(modeloModif, nuevaLicuadora);
                                            System.out.println("¡Licuadora agregada correctamente!");

                                            // Llamada de métodos
                                            nuevaLicuadora.CalcEficienciaEnergia();
                                            nuevaLicuadora.CalcprecioBase();
                                            nuevaLicuadora.CalcprecioFinal();
                                            nuevaLicuadora.CalccostoMantenimiento();
                                            System.out.println();

                                            System.out.println("Precio base + eficiencia energética: "
                                                    + nuevaLicuadora.getPrecioBase());

                                            System.out.println(
                                                    "Costo mantenimiento: " + nuevaLicuadora.getCostoMantLic());

                                            System.out.println("Precio final en $COP: "
                                                    + nuevaLicuadora.getPrecioFinalLicuadora());

                                        }
                                        System.out.println();
                                        System.out.println("¿Desea modificar otra licuadora? (S/N)");
                                        modLic = teclado.next().charAt(0);
                                        System.out.println();
                                    } while (modLic == 'S' || modLic == 's');
                                    break;

                                case 5:
                                    System.out.println("----Información sobre las licuadoras---- ");
                                    gestionLicuadora.mostrarLicuadoras();
                                    break;

                                case 6: // Filtrar por marca con el uso de Streams
                                    System.out.println("¿Desea filtrar por marca? (S/N)");
                                    teclado.nextLine();
                                    String filtrarPorMarcaStr = teclado.nextLine();
                                    boolean filtrarPorMarca = filtrarPorMarcaStr.equalsIgnoreCase("S");

                                    if (filtrarPorMarca) {
                                        System.out.println("Licuadoras ordenadas por marca:");
                                        List<Licuadora> licuadorasFiltradas = gestionLicuadora.filtrarPorMarca();

                                        // Se verifica que haya licuadoras filtradas por Marcas
                                        if (!licuadorasFiltradas.isEmpty()) {
                                            for (Licuadora licu : licuadorasFiltradas) {
                                                System.out.println(
                                                        licu);
                                            }
                                        } else {
                                            System.out.println("No se encontraron resultados");
                                        }
                                    }
                                    break;

                                case 7: // Filtrar por precio con el uso de Streams
                                    System.out.println("Ingrese el precio mínimo de las licuadoras a mostrar:");
                                    double precioMinimo = teclado.nextDouble();

                                    gestionLicuadora.setPrecioMinimo(precioMinimo);

                                    List<String> licuadorasFiltradasPrecio = gestionLicuadora
                                            .filtrarLicPorPrecio(precioMinimo);

                                    if (!licuadorasFiltradasPrecio.isEmpty()) {
                                        System.out.println("Licuadoras filtradas por precio:");
                                        licuadorasFiltradasPrecio.forEach(System.out::println);
                                    } else {
                                        System.out.println("No se encontraron resultados");
                                    }
                                    break;

                                case 8:
                                    System.out.println("Ingrese el color por el que quiere filtrar las licuadoras:");
                                    teclado.nextLine();
                                    String colorFiltrar = teclado.nextLine();

                                    gestionLicuadora.setColorFiltrado(colorFiltrar);

                                    List<String> licuadorasFiltradasColor = gestionLicuadora
                                            .filtrarPorColor(colorFiltrar);

                                    if (!licuadorasFiltradasColor.isEmpty()) {
                                        System.out.println("Licuadoras filtradas por color:");
                                        licuadorasFiltradasColor.forEach(System.out::println);
                                    } else {
                                        System.out.println("No se encontraron resultados");
                                    }
                                    break;

                                case 9:
                                    volverMenuPrincipal = true;
                                    break;

                                default:
                                    System.out.println("Por favor ingrese una opción válida");
                                    break;
                            }
                        } while (!volverMenuPrincipal);

                    case 4:
                        char aggLav = 'S';
                        do {
                            System.out.println("Marca: ");
                            teclado.nextLine();
                            String marcaLav = teclado.nextLine();
                            System.out.println("Precio Base: ");
                            double precioBasLav = teclado.nextDouble();
                            System.out.println("Color: ");
                            teclado.nextLine();
                            String colorLav = teclado.nextLine();
                            System.out.println("Modelo: ");
                            String modeloLav = teclado.nextLine();
                            System.out.println("Voltaje: ");
                            Number voltajeLav = teclado.nextDouble();
                            System.out.println("Programas de lavado: ");
                            int lavados = teclado.nextInt();
                            System.out.println("Material de tina: ");
                            String materialTina = teclado.nextLine();
                            System.out.println("Niveles de agua: ");
                            int nivelAgua = teclado.nextInt();
                            System.out.println("Tipo de panel de control: ");
                            String panelControlLav = teclado.nextLine();
                            System.out.println(
                                    "Eficiencia de energía: A+++ - A++ - A+ - A - B - C - D - C - F - G - No aplica");
                            String eficienciaLav = teclado.nextLine();

                            Lavadora<?, ?> lavadora = new Lavadora<>(marcaLav, precioBasLav, colorLav, modeloLav, 0,
                                    eficienciaLav, 0, 0, 0, 0, 0, null, voltajeLav,
                                    lavados, materialTina, nivelAgua, panelControlLav, 0, 0, 0);

                            // Captura de datos
                            lavadora.setMarca(marcaLav);
                            lavadora.setPrecioBase(precioBasLav);
                            lavadora.setColor(colorLav);
                            lavadora.setModelo(modeloLav);
                            // lavadora.setVoltaje(voltajeLav);
                            lavadora.setProgramasdeLavado(lavados);
                            lavadora.setMaterialdeTina(materialTina);
                            // lavadora.setNivelesdeAgua(nivelAgua);
                            lavadora.setTipoPaneldeControl(panelControlLav);
                            lavadora.setEficienciaEnergia(eficienciaLav);

                            // Llamada de métodos
                            lavadora.CalcEficienciaEnergia();
                            lavadora.CalcprecioBase();
                            lavadora.CalcprecioFinal();
                            lavadora.CalccostoMantenimiento();
                            System.out.println();

                            System.out.println("¡Lavadora agregada con éxito!");
                            System.out.println();

                            System.out.println("Precio base + eficiencia energética: " + lavadora.getPrecioBase());

                            System.out.println("Costo mantenimiento: " + lavadora.getTotalMantenimientoLav());

                            System.out.println("Precio final en $COP: " + lavadora.getPrecioFinalLavadora());
                            System.out.println();
                            System.out.print("¿Desea agregar otra lavadora? (S/N): ");
                            aggLav = teclado.next().charAt(0);
                        } while (aggLav == 'S' || aggLav == 's');
                        break;
                    default:
                        System.out.println("Por favor ingrese una opción válida");
                        break;

                }

            } while (continuar == 'S' || continuar == 's');

        } catch (InputMismatchException e) {
            System.out.println("Error: Entrada no válida. Por favor ingrese un valor numérico.");
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
