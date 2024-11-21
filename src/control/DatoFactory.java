/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

/**
 *
 * @author chave
 */
public class DatoFactory {
    public DatoFactory(){
        
    }
    public DatoRecolectado crearDato(String tipo, int idEstudiante, String valor) {
        if (tipo.equalsIgnoreCase("base")) {
            return new DatoRecolectadoBase(idEstudiante, tipo, valor);
        }
        // Puedes agregar más tipos en el futuro
        throw new IllegalArgumentException("Tipo de dato no soportado: " + tipo);
    }
}