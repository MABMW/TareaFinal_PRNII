/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexiones;

import java.util.EventObject;

/**
 *
 * @author Adalberto
 */
public class Eventos extends EventObject{
    
    Conectar cn;
    public Eventos(Object source, Conectar _cn) {
        super(source);
        cn = _cn;
    }
}
