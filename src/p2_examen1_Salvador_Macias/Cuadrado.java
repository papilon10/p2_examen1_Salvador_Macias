/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p2_examen1_Salvador_Macias;

/**
 *
 * @author claudiacortes
 */
class Cuadrado extends Figura{

    private double lado;

    public Cuadrado(double lado) {
        this.lado = lado;
    }

    //@override
    double calcularArea() {
        return lado * lado;
    }

    @Override
    public String toString() {
        return "(L=" + lado + ")";
    }
}
