/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.TDA.grafos.exeption;

/**
 *
 * @author romer
 */
public class VerticeExepction extends Exception{

    public VerticeExepction(String msg) {
        super(msg);
    }

    public VerticeExepction() {
        super("Vetice fuera de rango");
    }
    
    
}
