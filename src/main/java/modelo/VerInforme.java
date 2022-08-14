/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author moniq
 */
public class VerInforme {
    public DefaultTableModel informeLideres(DefaultTableModel model){
        try{
            Consulta cons = new Consulta();
            Connection conn = cons.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT ID_Lider as ID, Nombre as NOMBRE, Primer_Apellido as APELLIDO, Ciudad_Residencia as CIUDAD FROM Lider l ORDER BY Ciudad_Residencia");
            Object[] lideres = new Object[4];
            
                while(rs.next()){
                    lideres[0] = rs.getInt("ID");
                    lideres[1] = rs.getString("NOMBRE");
                    lideres[2] = rs.getString("APELLIDO");
                    lideres[3] = rs.getString("CIUDAD");
                    model.addRow(lideres);
                }
            rs.close();
        } catch(Exception e){
            System.out.println("Error: " + e);
        }
        return model;
    }
    
    public DefaultTableModel informeProyectos(DefaultTableModel model){
        try{
            Consulta cons = new Consulta();
            Connection conn = cons.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT ID_Proyecto as ID, Constructora as CONSTRUCTORA, Numero_Habitaciones as HABITACIONES, Ciudad as CIUDAD FROM Proyecto p WHERE Clasificacion = 'Casa Campestre' AND Ciudad IN ('Santa Marta', 'Cartagena', 'Barranquilla');");
            Object[] proyectos = new Object[4];
            
            while(rs.next()){
                proyectos[0] = rs.getInt("ID");
                proyectos[1] = rs.getString("CONSTRUCTORA");
                proyectos[2] = rs.getInt("HABITACIONES");
                proyectos[3] = rs.getString("CIUDAD");
                model.addRow(proyectos);
            }
            rs.close();
        } catch(Exception e){
            System.out.println("Error: " + e);
        }
        return model;
    }
    
    public DefaultTableModel informeCompras(DefaultTableModel model){
        try{
            Consulta cons = new Consulta();
            Connection conn = cons.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT ID_Compra as ID, p.Constructora as CONSTRUCTORA, p.Banco_Vinculado as BANCO FROM Compra c LEFT JOIN Proyecto p ON c.ID_Proyecto = p.ID_Proyecto WHERE Proveedor = 'Homecenter' AND p.Ciudad = 'Salento'");
            Object[] compras = new Object[3];

            while(rs.next()){
                compras[0] = rs.getInt("ID");
                compras[1] = rs.getString("CONSTRUCTORA");
                compras[2] = rs.getString("BANCO");
                model.addRow(compras);
            }
            rs.close();
        } catch(Exception e){
            System.out.println("Error: " + e);
        }
        return model;
    }
}
