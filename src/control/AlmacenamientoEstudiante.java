/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.sql.*;
import modelo.ConexionSingleton;

/**
 *
 * @author chave
 */
public class AlmacenamientoEstudiante{
    
    public AlmacenamientoEstudiante(){
        
    }
    
    public int guardarEstudiante(String nombre, int edad, String curso) {
        String spInsertarEstudiante = "{CALL sp_insertar_estudiante(?, ?, ?)}";

        try (Connection connection = ConexionSingleton.getInstancia().getConexion();
         CallableStatement cs = connection.prepareCall(spInsertarEstudiante)) {

        cs.setString(1, nombre);
        cs.setInt(2, edad);
        cs.setString(3, curso);

        try (ResultSet rs = cs.executeQuery()) {
            if (rs.next()) {
                return rs.getInt("id_estudiante");
            } else {
                throw new RuntimeException("Error al registrar estudiante: no se devolvió ID.");
            }
        }
    } catch (SQLException e) {
        throw new RuntimeException("Error en la base de datos al registrar estudiante", e);
    }
    }

           
}
