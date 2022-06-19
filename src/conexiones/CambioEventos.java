/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexiones;

/**
 *
 * @author Adalberto
 */
import java.util.EventListener;
 
public interface CambioEventos extends EventListener {
 
    public abstract void onCorrectaConexion(Eventos ev);
    
    public abstract void onErroneaConexion(Eventos ev, String MensajeError);
    
    public abstract void onClassNoEncontrada(Eventos ev, String MensajeError);
}