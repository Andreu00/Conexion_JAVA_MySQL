/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.jdbc;

import java.sql.*;

public class JDBC {
    static final String DB_URL = "jdbc:mysql://localhost:3306/jcvd";
    static final String USER = "andreu";
    static final String PASS = "1234";
    static final String QUERY = "SELECT * FROM videojuegos";
    public static void main(String[] args) {
       
        try(
            Connection conn=DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt =conn.createStatement();
            ResultSet rs =stmt.executeQuery(QUERY);)
        {
            while(rs.next()){
                System.out.println("ID: "+rs.getInt("id"));
                System.out.println("Nombre: "+rs.getString("nombre"));
                System.out.println("Gemero: "+rs.getString("genero"));
                System.out.println("Fecha de lanzamiento: "+rs.getDate("fechalanzamiento"));
                System.out.println("Compañia: "+rs.getString("compañia"));
                System.out.println("Precio: "+rs.getFloat("precio"));
                System.out.println("\n");
                              
            }
            //Insertar aqui nuevo juego
                //String query="INSERT INTO `videojuegos` (`id`, `nombre`, `genero`, `fechalanzamiento`, `compañia`, `precio`) VALUES (NULL, 'Call Of Duty Black Ops 2', 'Gerra', '2023-11-11', 'Activision', '70')";
                //stmt.executeUpdate(query);
                //System.out.println("Videjuego añadido");
            //Eliminar libro
                //String query="DELETE FROM `videojuegos` WHERE `nombre` = 'Call Of Duty Black Ops 2'";
                //stmt.executeUpdate(query);
                //System.out.println("Libro eliminado");
            stmt.close();                
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
