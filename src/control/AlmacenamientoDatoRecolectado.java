/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import control.Almacenamiento;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import control.DatoRecolectado;
import control.DatoRecolectadoBase;
import modelo.ConexionSingleton;

/**
 *
 * @author chave
 */
public class AlmacenamientoDatoRecolectado implements Almacenamiento {
    
    public AlmacenamientoDatoRecolectado(){
        
    }
    
     @Override
    public void guardarDato(DatoRecolectado dato) {
        String spInsertarDato = "{CALL sp_insertar_dato_recolectado(?, ?, ?)}";
        String spInsertarMetadato = "INSERT INTO metadatos_recoleccion (id_dato, clave, valor) VALUES (?, ?, ?)";

        try (Connection connection = ConexionSingleton.getInstancia().getConexion();
             CallableStatement csDato = connection.prepareCall(spInsertarDato)) {

            // Insertar el dato recolectado
            csDato.setInt(1, dato.getIdEstudiante());
            csDato.setString(2, dato.getTipoDato());
            csDato.setString(3, dato.getValor());
            ResultSet rs = csDato.executeQuery();

            // Obtener el ID del dato insertado
            int idDato = -1;
            if (rs.next()) {
                idDato = rs.getInt("id_dato");
            }

            // Insertar los metadatos asociados
            try (PreparedStatement psMetadato = connection.prepareStatement(spInsertarMetadato)) {
                for (var entry : dato.getMetadatos().entrySet()) {
                    psMetadato.setInt(1, idDato);
                    psMetadato.setString(2, entry.getKey());
                    psMetadato.setString(3, entry.getValue());
                    psMetadato.executeUpdate();
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al guardar el dato en la base de datos: " + e.getMessage());
        }
    }

    @Override
    public List<DatoRecolectado> obtenerDatos(int idEstudiante) {
        String spObtenerDatos = "{CALL sp_obtener_datos_estudiante(?)}";

        List<DatoRecolectado> datos = new ArrayList<>();

        try (Connection connection = ConexionSingleton.getInstancia().getConexion();
             CallableStatement cs = connection.prepareCall(spObtenerDatos)) {

            // Llamar al procedimiento almacenado
            cs.setInt(1, idEstudiante);
            ResultSet rs = cs.executeQuery();

            // Procesar los resultados
            while (rs.next()) {
                int idDato = rs.getInt("id_dato");
                String tipoDato = rs.getString("tipo_dato");
                String valor = rs.getString("valor");

                DatoRecolectadoBase dato = new DatoRecolectadoBase(idEstudiante, tipoDato, valor);

                // Añadir metadatos al dato recolectado
                String clave = rs.getString("metadata_clave");
                String valorMetadato = rs.getString("metadata_valor");
                if (clave != null && valorMetadato != null) {
                    dato.agregarMetadato(clave, valorMetadato);
                }

                datos.add(dato);
            }
        } catch (SQLException e) {
            System.err.println("Error al recuperar datos de la base de datos: " + e.getMessage());
        }

        return datos;
    }
    
}