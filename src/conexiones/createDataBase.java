package conexiones;

public class createDataBase {
    
    Conectar conectar;
    
    public createDataBase(Conectar conectar){
        this.conectar = conectar;
    }
    
    public void crearbase(){
        conectar.AMB("create database Prueba");
    }
}
