/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author moniq
 */
public class Consulta {
    public static final String UBICACION_BD = "ProyectosConstruccion.db";
    Connection conn = null;
    public Connection getConnection() throws SQLException{
        try{
            String url = "jdbc:sqlite:" + UBICACION_BD;
            conn = DriverManager.getConnection(url);
        } catch(Exception e){
            System.out.println("Error: " + e);
        }
    return conn;    
    }
}
