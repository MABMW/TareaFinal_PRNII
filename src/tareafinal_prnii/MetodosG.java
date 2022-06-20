/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareafinal_prnii;

import javax.swing.ImageIcon;

/**
 *
 * @author Adalberto
 */
public class MetodosG {

    /**
     * Convierte una coleccion de tipo char en una cadena
     *
     * @param chars colecion de tipo char
     *
     */
    public static String charsToString(char[] chars) {
        String retorno = "";
        for (int i = 0; i < chars.length; i++) {
            retorno += chars[i];
        }
        return retorno;
    }

    /**
     * Genera el efecto placeHolder en un cuadro de texto, al estilo web
     * TextPrompt es un codigo escrito por "Rob Camick"
     * https://tips4java.wordpress.com/2009/11/29/text-prompt/
     *
     * @param txtComponent es el cuadro de texto al que se le aplicara el efecto
     * @param Texto es el texto que se mostrara en el fondo
     * @param estiloFuente el estilo de la fuente de Texto (Italic, Bold Plain)
     * @param Alpha 
     *
     */
    public static void setplaceHolder(javax.swing.text.JTextComponent txtComponent, String Texto, int estiloFuente, float Alpha) {
        TextPrompt placeholder = new TextPrompt(Texto, txtComponent);
        if (0 <= Alpha || Alpha <= 1.0) {
            placeholder.changeAlpha(Alpha);
        } else {
            placeholder.changeAlpha(0.75f);
        }
        placeholder.changeStyle(estiloFuente);
    }
    
    public javax.swing.Icon getIcono(String ruta){
        String icopath = ruta;
        ImageIcon myicono = new ImageIcon(getClass().getClassLoader().getResource(icopath));
        //this.lblIcono.setIcon(myicons);
        return myicono;
    }
    public java.awt.Image getImage(String ruta){
        String icopath = ruta;
        ImageIcon myicono = new ImageIcon(getClass().getClassLoader().getResource(icopath));
        //this.lblIcono.setIcon(myicons);
        return myicono.getImage();
    }
}
