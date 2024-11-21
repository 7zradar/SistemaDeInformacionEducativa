/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package control;

import control.DatoRecolectado;
import java.util.List;

public interface Almacenamiento {
    void guardarDato(DatoRecolectado dato);
    List<DatoRecolectado> obtenerDatos(int idEstudiante);
}



