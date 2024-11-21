/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author chave
 */


public class EstudianteBuilder {
    private String nombre;
    private int edad;
    private String curso;

    public EstudianteBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public EstudianteBuilder conEdad(int edad) {
        this.edad = edad;
        return this;
    }

    public EstudianteBuilder conCurso(String curso) {
        this.curso = curso;
        return this;
    }

    public EstudianteDTO construir() {
        return new EstudianteDTO(nombre, edad, curso);
    }
}


