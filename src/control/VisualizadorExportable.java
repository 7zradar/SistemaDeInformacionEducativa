/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

public class VisualizadorExportable implements Visualizador<String> {

    private final Visualizador<String> base;

    public VisualizadorExportable(Visualizador<String> base) {
        this.base = base;
    }

    @Override
    public String generarVisualizacion(int idEstudiante) {
        // Llamar al método de la clase base
        String visualizacion = base.generarVisualizacion(idEstudiante);
        
        // Agregar las opciones de exportación
        return visualizacion + "\n[Opciones de Exportación: PDF, Excel]";
    }
}


