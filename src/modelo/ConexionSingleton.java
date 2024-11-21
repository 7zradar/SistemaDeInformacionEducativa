/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexionSingleton {
    private static ConexionSingleton instancia;
    private Connection conexion;

    // Credenciales de conexión como cadenas
    private static final String URL = "jdbc:mysql://localhost:3306/sistema_recoleccion_datos";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "root";

    // Constructor privado
    private ConexionSingleton() {
        conectar();
    }

    // Método para obtener la única instancia
    public static ConexionSingleton getInstancia() {
        if (instancia == null) {
            instancia = new ConexionSingleton();
        }
        return instancia;
    }

    // Método para obtener la conexión
    public Connection getConexion() {
        try {
            // Verificar si la conexión sigue activa
            if (conexion == null || conexion.isClosed()) {
                conectar();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al verificar el estado de la conexión", e);
        }
        return conexion;
    }

    // Método privado para establecer la conexión
    private void conectar() {
        try {
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
        } catch (SQLException e) {
            throw new RuntimeException("Error al conectar con la base de datos", e);
        }
    }
}

