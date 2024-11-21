/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package control;

import java.util.Map;

public interface DatoRecolectado {
    int getIdEstudiante();
    String getTipoDato();
    String getValor();
    Map<String, String> getMetadatos();
}


