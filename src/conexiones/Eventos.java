package conexiones;

import java.util.EventObject;

public class Eventos extends EventObject{
    
    Conectar cn;
    public Eventos(Object source, Conectar _cn) {
        super(source);
        cn = _cn;
    }
}
