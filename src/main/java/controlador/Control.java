/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import java.sql.SQLException;
import vista.Visualizacion;

/**
 *
 * @author moniq
 */
public class Control {
    public static void main(String[] args){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Visualizacion().setVisible(true);
            }
        });
    }
}
