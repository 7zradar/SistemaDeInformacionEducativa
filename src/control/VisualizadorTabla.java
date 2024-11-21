/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import control.Visualizador;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import modelo.ConexionSingleton;

/**
 * Visualizador que genera un modelo de tabla para mostrar datos combinados de las tablas relacionadas.
 */
public class VisualizadorTabla implements Visualizador {

    
    public DefaultTableModel generarVisualizacion(int idEstudiante) {
        // Definir las columnas de la tabla
        String[] columnas = {
            "ID Estudiante", "Nombre", "Edad", "Curso", "Fecha Registro",
            "ID Dato", "Tipo de Dato", "Valor Dato", "Fecha Dato",
            "Clave Metadata", "Valor Metadata"
        };

        // Crear el modelo de la tabla con las columnas
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        // Conexión a la base de datos
        String procedimiento = "{CALL sp_obtener_datos_completos(?)}";
        try (Connection conexion = ConexionSingleton.getInstancia().getConexion();
             CallableStatement cs = conexion.prepareCall(procedimiento)) {

            // Establecer el parámetro del procedimiento
            cs.setInt(1, idEstudiante);

            // Ejecutar el procedimiento y procesar los resultados
            try (ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    // Crear una fila con los datos del ResultSet
                    Object[] fila = {
                        rs.getInt("estudiante_id"),
                        rs.getString("estudiante_nombre"),
                        rs.getInt("estudiante_edad"),
                        rs.getString("estudiante_curso"),
                        rs.getTimestamp("estudiante_fecha_registro"),
                        rs.getInt("dato_id"),
                        rs.getString("dato_tipo"),
                        rs.getString("dato_valor"),
                        rs.getTimestamp("dato_timestamp"),
                        rs.getString("metadata_clave"),
                        rs.getString("metadata_valor")
                    };
                    // Agregar la fila al modelo
                    modelo.addRow(fila);
                }
            }

        } catch (SQLException e) {
            System.err.println("Código de error SQL: " + e.getErrorCode());
            System.err.println("Estado SQL: " + e.getSQLState());
            System.err.println("Mensaje: " + e.getMessage());
            throw new RuntimeException("Error al obtener los datos del estudiante: " + e.getMessage(), e);
        }


        return modelo;
    }
}
