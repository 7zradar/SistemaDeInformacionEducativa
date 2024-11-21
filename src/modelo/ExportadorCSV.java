/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author chave
 */



public class ExportadorCSV implements FormatoExportacion {
    @Override
    public String exportar(Object datos) {
        // Lógica para exportar a CSV
        return "Datos exportados en CSV";
    }
}
