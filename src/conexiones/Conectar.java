package conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ListIterator;

public class Conectar {
    private String NombreUsuario = "root";
    private String Contrasenia = "12345678";
    private Connection conectar = null;
    private Statement declaraciones = null;
    private ResultSet resultados = null;
    private static ArrayList listasEventos;
    private String nombrebasedeDatos="baseDeDatos";
    private String urldataBase;
    
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
    
    private void erroneaConexion(SQLException MensajeError){
        ListIterator li = listasEventos.listIterator();
        while (li.hasNext()) {
            CambioEventos listener = (CambioEventos) li.next();
            Eventos readerEvObj = new Eventos(this, this);
            (listener).onErroneaConexion(readerEvObj, MensajeError);
        }
    }
    
    private void claseNoEncontrada(ClassNotFoundException MensajeError){
        ListIterator li = listasEventos.listIterator();
        while (li.hasNext()) {
            CambioEventos listener = (CambioEventos) li.next();
            Eventos readerEvObj = new Eventos(this, this);
            (listener).onClassNoEncontrada(readerEvObj, MensajeError);
        }
    }

    public Conectar() {
        this.urldataBase = String.format("jdbc:mysql://localhost:3306/%s?characterEncoding=utf8", nombrebasedeDatos);
        listasEventos = new ArrayList();
    }

    public Conectar(String NombreUsuario, String Contrasenia) {
        this.urldataBase = String.format("jdbc:mysql://localhost:3306/%s?characterEncoding=utf8", nombrebasedeDatos);
        this.NombreUsuario = NombreUsuario;
        this.Contrasenia = Contrasenia;
        listasEventos = new ArrayList();
    }

    public Conectar(String NombreUsuario, String Contrasenia,String nombrebasedeDatos) {
        this.nombrebasedeDatos = nombrebasedeDatos;
        this.urldataBase = String.format("jdbc:mysql://localhost:3306/%s?characterEncoding=utf8", this.nombrebasedeDatos);
        this.NombreUsuario = NombreUsuario;
        this.Contrasenia = Contrasenia;
        listasEventos = new ArrayList();
    }
    
    /**
     * Conecta a la base de datos de mysql
     * @return true si se ha conectado con exito, false si la conexion fue fallida
     **/
    public boolean conectarBase() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection(urldataBase, NombreUsuario, Contrasenia);
            correctaConexion();
            return true;
        } catch (ClassNotFoundException c) {
            claseNoEncontrada(c);
            return false;
        } catch (SQLException e) {
            this.erroneaConexion(e);
            return false;
        }
    }
    
    /**
     * Agrega, Modifica, Borra registros de la base de datos
     * @param cmdSql el comando de para la consola mysql
     * @return true: Si se ha realizado la operacion correctamente. false: si hubo alguna excepcion
     **/
    public boolean AMB(String cmdSql) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection(urldataBase, NombreUsuario, Contrasenia);
            declaraciones = conectar.createStatement();
            declaraciones.executeUpdate(cmdSql); //statement
            return true;
        } catch (ClassNotFoundException c) {
            claseNoEncontrada(c);
            return false;
        } catch (SQLException e) {
            erroneaConexion(e);
            return false;
        }
    }
    
     //Método para Consultar datos
    public ResultSet getValores(String cmdSql) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection(urldataBase, NombreUsuario, Contrasenia);
            declaraciones = conectar.createStatement();
            resultados = declaraciones.executeQuery(cmdSql);  //resultset
        } catch (ClassNotFoundException c) {
            claseNoEncontrada(c);
        } catch (SQLException e) {
            this.erroneaConexion(e);
        }
        return resultados;
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
    
    public void setCredenciales(String NombreUsuario, String Contrasenia, String nombrebasedeDatos){
        this.NombreUsuario = NombreUsuario;
        this.Contrasenia = Contrasenia;
        this.nombrebasedeDatos = nombrebasedeDatos;
        this.urldataBase = String.format("jdbc:mysql://localhost:3306/%s?characterEncoding=utf8", this.nombrebasedeDatos);
    }
}
