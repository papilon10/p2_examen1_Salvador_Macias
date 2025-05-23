/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p2_examen1_Salvador_Macias;

import java.util.ArrayList;

/**
 *
 * @author claudiacortes
 */
class FiguraCompuesta extends Figura {

    private ArrayList<Figura> figuras = new ArrayList<>();

    double calcularArea() {
        for (int i = 0; i < figuras.size(); i++) {
            double suma;
            figuras.get(i).calcularArea();
            suma = +figuras.get(i).calcularArea();
            return suma;
        }
        return 0;
    }

    public void listar_f() {
        for (Figura figura : figuras) {
            if (figura instanceof FiguraCompuesta) {
                System.out.println("figura compuesta:\n" + figura);
            }

        }
    }

    @Override
    public String toString() {
        return "figuras compuesta: " + figuras;
    }
}
