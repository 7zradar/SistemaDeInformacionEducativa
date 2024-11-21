/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.List;


public class RegistroEventos implements Observador {
    @Override
    public void actualizar(String evento) {
        // Implementar registro de eventos
        System.out.println("Evento registrado: " + evento);
    }
}
