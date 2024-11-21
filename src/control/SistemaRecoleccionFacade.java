/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;


import modelo.ConexionSingleton;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class SistemaRecoleccionFacade {
    private final DatoRecolectadoBase datoRecolectado;
    private final Almacenamiento almacenamiento;
    private final Visualizador visualizador;
    private final Connection conexionBD;

    public SistemaRecoleccionFacade() {
        this.datoRecolectado = new DatoRecolectadoBase();

        // Crear almacenamiento con decorador de cifrado
        Almacenamiento almacenamientoBase = new AlmacenamientoDatoRecolectado();
        this.almacenamiento = new AlmacenamientoCifrado(almacenamientoBase);

        // Crear visualizador con decorador de exportación
        Visualizador visualizadorBase = new VisualizadorTabla();
        this.visualizador = new VisualizadorExportable(visualizadorBase);

        // Obtener la conexión desde el Singleton
        this.conexionBD = ConexionSingleton.getInstancia().getConexion();
    }

    public void recolectarDato(int idEstudiante, String tipoDato, String valor, String dificultad, String tiempo) {
        datoRecolectado.setIdEstudiante(idEstudiante);
        datoRecolectado.setTipoDato(tipoDato);
        datoRecolectado.setValor(valor);
        datoRecolectado.agregarMetadato(dificultad,tiempo);
        almacenamiento.guardarDato(datoRecolectado);
        
    }

    public DefaultTableModel visualizarDatos(int idEstudiante) {
        VisualizadorTabla visualizadorTabla = new VisualizadorTabla();
        return visualizadorTabla.generarVisualizacion(idEstudiante);
    }

    public int registrarEstudiante(String nombre, int edad, String curso) {
        AlmacenamientoEstudiante almacenamientoEstudiante = new AlmacenamientoEstudiante();
        return almacenamientoEstudiante.guardarEstudiante(nombre, edad, curso);
    }
}