/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p2_examen1_Salvador_Macias;

/**
 *
 * @author claudiacortes
 */
abstract class Figura {
    /*NOTA: esta clase no necesita ningun atributo
    El método calcularArea DEBE ser abstracto*/
    abstract double calcularArea() { return 1*0.5};

    @Override
    public String toString() {
        return "Figura{" + '}';
    }
    
}