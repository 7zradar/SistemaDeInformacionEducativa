/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import control.DatoRecolectado;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author chave
 */
public class DatoRecolectadoBase implements DatoRecolectado {
    protected int idEstudiante;//id estudiante
    protected String tipoDato;//examen
    protected String valor;//resultado 90%
    protected Map<String, String> metadatos = new HashMap<>();
    
    public DatoRecolectadoBase(){
        
    }
    public DatoRecolectadoBase(int idEstudiante, String tipoDato, String valor) {
        if (idEstudiante <= 0 || tipoDato == null || tipoDato.isEmpty() || valor == null) {
            throw new IllegalArgumentException("Datos inválidos para la creación del objeto.");
        }
        this.idEstudiante = idEstudiante;
        this.tipoDato = tipoDato;
        this.valor = valor;
        this.metadatos = new HashMap<>();
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public void setTipoDato(String tipoDato) {
        this.tipoDato = tipoDato;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
    @Override
    public int getIdEstudiante() {
        return idEstudiante;
    }

    @Override
    public String getTipoDato() {
        return tipoDato;
    }

    @Override
    public String getValor() {
        return valor;
    }

    @Override
    public Map<String, String> getMetadatos() {
        return new HashMap<>(metadatos); // Retorna una copia para evitar modificaciones externas
    }

    // Métodos para gestionar metadatos
    public void agregarMetadato(String clave, String valor) {
        if (clave == null || clave.isEmpty() || valor == null) {
            throw new IllegalArgumentException("Clave o valor del metadato no puede ser nulo o vacío.");
        }
        metadatos.put(clave, valor);
    }

    public String obtenerMetadato(String clave) {
        return metadatos.get(clave);
    }

}
