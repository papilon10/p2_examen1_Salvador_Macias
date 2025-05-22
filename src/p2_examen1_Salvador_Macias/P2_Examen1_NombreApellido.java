/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package p2_examen1_Salvador_Macias;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author claudiacortes
 */
public class P2_Examen1_NombreApellido {

    /**
     * @param args the command line arguments
     */
    private static ArrayList<Figura> figuras = new ArrayList<>();

    public static void main(String[] args) {
        /*NOTA: todos los metodos de este archivo estan correctos y no es necesario cambiarlos.*/
        menu();
    }

    public static void menu() {
        boolean bandera = true;
        while (bandera) {
            //NOTA: No olvide reemplazar su nombre
            String menu = "PRIMER EXAMEN PARCIAL, PROGRAMACIÓN 2\n"
                    + "Salvador Macias\n"
                    + "1. Agregar Figura\n"
                    + "2. Calcular área de una figura\n"
                    + "3. Listar figuras\n"
                    + "4. ¿Por qué es posible tener dos métodos con el mismo nombre? ¿Cómo se llama esta característica en Java?\n"
                    + "5. Salir\n"
                    + "-> ingrese la opción deseada";

            bandera = menu(leerEntrada(menu, 5));
        }

    }

    public static int leerEntrada(String mensaje, int limite) {
        Scanner entrada = new Scanner(System.in);
        int resp;
        do {
            System.out.println(mensaje);
            resp = entrada.nextInt();
        } while (resp < 0 || resp > limite);
        return resp;
    }

    public static double leerEntrada(String mensaje, double limite) {
        Scanner entrada = new Scanner(System.in);
        double resp;
        do {
            System.out.println(mensaje);
            resp = entrada.nextDouble();
        } while (resp < 0 || resp > limite);
        return resp;
    }

    public static boolean menu(int op) {
        switch (op) {
            case 1 ->
                agregarFigura();
            case 2 ->
                calcularArea();
            case 3 ->
                listarFiguras();
            case 4 -> {
                System.out.println("A esta caracteristica se llama sobrecarga de metodos, la sobrecarga de metodos permite "
                        + "\nque existan metodos con el mismo nombre pero con diferentes parametros.");
            }
            case 5 -> {
                System.out.println("\nSaliendo del programa....");
                return false;
            }
            default -> {
                System.out.println("\nOpción no válida, inténtelo de nuevo.");
            }
        }
        return true;
        
         /*
        ¿Cuál es la diferencia entre polimorfismo por sobreescritura, interfaces y clases abstractas?
        
         La diferencia entre estos 3 terminos es que el polimorfismo por sobreescritura utiliza las clases hijas de la clase abstacta principal
            y en estos metodos se puede modificar de diferentes formas en las diferentes subclases, las interfaces permiten que las subclases 
            puedan implementar un metodo polimorfico,se le puede conocer como polimorfismo obligatorio, y las clases abstractas contienen
            metodos polimorficos que pueden o no ser implementados en sus subclases.
      
        ¿Qué es la sobrecarga de metodos? 
        
            La sobrecarga de metodos es una caracteristica que permite que un metodo exista multiples veces en un mismo codigo y 
            haga la misma tarea cuando sus parametros son diferentes.
         */
    }

    public static void agregarFigura() {
        int limite = 2;
        String mensaje = "\nIngrese el tipo de figura que desea crear: \n 1.circulo \n 2.cuadrado";
        if (figuras.size() >= 2) {
            mensaje += " \n 3.Figura compuesta";
            limite = 3;
        }

        int tipo = leerEntrada(mensaje, limite);

        switch (tipo) {
            case 1 -> {

                double radio = leerEntrada("\nIngrese el radio del círculo: ", 20.0);
                figuras.add(new Circulo(radio));
                System.out.println("Círculo agregado.\n");
            }
            case 2 -> {
                double lado = leerEntrada("\nIngrese el lado del cuadrado: ", 20.0);
                figuras.add(new Cuadrado(lado));
                System.out.println("Cuadrado agregado.\n");
            }
            case 3 -> {
                figuras.add(crearFiguraCompuesta());
                System.out.println("Figura compuesta creada.\n");
            }
        }
    }

    public static void calcularArea() {
        if (figuras.isEmpty()) {
            System.out.println("No hay figuras para calcular el área.");
            return;
        }

        listarFiguras();
        int opcion = leerEntrada("Seleccione la figura para calcular el área:", figuras.size() - 1);
        double area = figuras.get(opcion).calcularArea();
        System.out.println("\nEl área de la figura seleccionada es: " + area);
    }

    public static void listarFiguras() {
        if (figuras.isEmpty()) {
            System.out.println("No hay figuras en la lista.");
        } else {
            System.out.println("Figuras en la lista:");
            for (int i = 0; i < figuras.size(); i++) {
                System.out.println((i) + ") " + figuras.get(i));
            }
        }
    }

    public static FiguraCompuesta crearFiguraCompuesta() {
        FiguraCompuesta figura = new FiguraCompuesta();
        boolean continuar = true;
        while (continuar) {
            listarFiguras();
            int pos = leerEntrada("\nIngrese el tipo de figura que desea crear:", figuras.size() - 1);
            int opSubMenu = leerEntrada("\nDesea continuar agregando figuras? 1.si, 2.No", 2);

            figura.agregarFigura(figuras.get(pos));
            if (opSubMenu == 2) {
                break;
            }
        }
        return figura;
    }
}
