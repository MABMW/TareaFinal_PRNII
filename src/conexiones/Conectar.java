/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ListIterator;

/**
 *
 * @author Adalberto
 */
public class Conectar {

    private final String urldataBase = "jdbc:mysql://localhost:3306/baseDeDatos?characterEncoding=utf8";
    private String NombreUsuario = "rooter";
    private String Contrasenia = "12345678";
    private Connection conectar = null;
    private Statement declaraciones = null;
    private ResultSet resultados = null;
    private static ArrayList listasEventos;
    CambioEventos fd;

    public void addEventListener(CambioEventos listener) {
        listasEventos.add(listener);
    }

    private void correctaConexion() {
        ListIterator li = listasEventos.listIterator();
        while (li.hasNext()) {
            CambioEventos listener = (CambioEventos) li.next();
            Eventos readerEvObj = new Eventos(this, this);
            (listener).onCorrectaConexion(readerEvObj);
        }
    }
    private void erroneaConexion(String MensajeError){
        ListIterator li = listasEventos.listIterator();
        while (li.hasNext()) {
            CambioEventos listener = (CambioEventos) li.next();
            Eventos readerEvObj = new Eventos(this, this);
            (listener).onErroneaConexion(readerEvObj, MensajeError);
        }
    }
    private void ClaseNoEncontrada(String MensajeError){
        ListIterator li = listasEventos.listIterator();
        while (li.hasNext()) {
            CambioEventos listener = (CambioEventos) li.next();
            Eventos readerEvObj = new Eventos(this, this);
            (listener).onClassNoEncontrada(readerEvObj, MensajeError);
        }
    }

    public Conectar() {
        listasEventos = new ArrayList();
    }

    public Conectar(String NombreUsuario, String Contrasenia) {
        this.NombreUsuario = NombreUsuario;
        this.Contrasenia = Contrasenia;
        listasEventos = new ArrayList();
    }

    /**
     * Conecta a la base de datos de mysql
     * @return true si se ha conectado con exito, false si la conexion fue fallida
     **/
    public boolean conectarBase() {
        boolean conecto = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection(urldataBase, NombreUsuario, Contrasenia);
            correctaConexion();
            conecto = true;
        } catch (ClassNotFoundException c) {
            ClaseNoEncontrada(c.getMessage());
            conecto = false;
        } catch (SQLException e) {
            this.erroneaConexion(e.getMessage());
            conecto = false;
        }
        return conecto;
    }
    /**
     * Configura las credenciales para acceder a la base de datos
     * @param NombreUsuario el nombre de usuario para conectar con mysql
     * @param Contrasenia la contraseña para mysql
     * */
    public void setCredenciales(String NombreUsuario, String Contrasenia){
        this.NombreUsuario = NombreUsuario;
        this.Contrasenia = Contrasenia;
    }
}
