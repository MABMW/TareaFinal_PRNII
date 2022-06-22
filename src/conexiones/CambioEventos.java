package conexiones;

import java.sql.SQLException;
import java.util.EventListener;
 
public interface CambioEventos extends EventListener {
 
    public abstract void onCorrectaConexion(Eventos ev);
    
    public abstract void onErroneaConexion(Eventos ev, SQLException Exception);
    
    public abstract void onClassNoEncontrada(Eventos ev, ClassNotFoundException Exception);
}