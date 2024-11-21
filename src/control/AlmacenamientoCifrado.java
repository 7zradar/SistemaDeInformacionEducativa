/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import control.Almacenamiento;
import java.util.List;
import control.DatoRecolectado;

/**
 *
 * @author chave
 */
public class AlmacenamientoCifrado implements Almacenamiento {
    private final Almacenamiento base;

    public AlmacenamientoCifrado(Almacenamiento base) {
        this.base = base;
    }

    @Override
    public void guardarDato(DatoRecolectado dato) {
        System.out.println("Cifrando dato...");
        base.guardarDato(dato);
    }

    @Override
    public List<DatoRecolectado> obtenerDatos(int idEstudiante) {
        return base.obtenerDatos(idEstudiante);
    }
}
