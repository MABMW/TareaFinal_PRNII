package tareafinal_prnii;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.BeanProperty;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static javax.swing.BorderFactory.createBevelBorder;
import javax.swing.GroupLayout;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
/**
 *
 * @author Adalberto
 * Este es un control que simula un boton para una mayor personalizacion
 */
public class JButtonNew extends JPanel {

    private final JLabel Label = new JLabel();
    private Color Background, colorMouseEntered, colorMouseExited, colorMousePressed;
    
    //Constructor
    public JButtonNew() {
        //configura el tamanio por defecto del control
        Dimension tamanio =new Dimension(73,28);
        this.setSize(tamanio);
        this.setPreferredSize(tamanio);
        //Configurar el color
        //this.setBackground(Color.WHITE);
        Background = this.getBackground();
        colorMouseEntered = Background.darker();
        colorMouseExited = Background;
        colorMousePressed = Background.darker().darker();
        //Configura el borde
        this.setBorder(createBevelBorder(BevelBorder.RAISED, Color.lightGray, Color.darkGray, Color.darkGray, Color.lightGray));
        //Configura el cursor cuando este pasa sobre el control
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //Configura el Label para que este sea siempre del mismo tamanio del control padre
        GroupLayout jPanel1Layout = new GroupLayout(this);
        this.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(Label, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(Label, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        //Configura el LABEL 
        Label.setText("JButtonNew");
        Label.setForeground(Color.black);
        Label.setHorizontalAlignment(SwingConstants.CENTER);
        //Eventos de mouse para darle un efecto de cambio de color
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {//Cuando el mouse entra en el Control
                colorMouseEventos(0);
            }

            @Override
            public void mouseExited(MouseEvent evt) {//Cuando el mouse sale del control
                colorMouseEventos(1);
            }

            @Override
            public void mousePressed(MouseEvent evt) {//Cuando se hace click en el control
                if (evt.getButton() == MouseEvent.BUTTON1) {
                    colorMouseEventos(2);
                }
            }

            @Override
            public void mouseReleased(MouseEvent evt) {//Cuando se suelta el click del mouse
                colorMouseEventos(0);
            }
        });
    }
    
    /**
     * Hace los cambios de color de este control correspodiente del evento
     *
     * @param estado el valor corresponde al evento correspondiente 0 ==
     * mouseEntered 1 == mouseExited 2 == mousePressed mouseRealeased es el
     * mismo estado con el de mouseEntered
     *
     */
    private void colorMouseEventos(int estado) {
        switch (estado) {
            case 0 ->
                this.setBackground(colorMouseEntered);
            case 1 ->
                this.setBackground(colorMouseExited);
            case 2 ->
                this.setBackground(colorMousePressed);
            default -> {
            }
        }
    }

    /**
     * Establece la alineacion del texto en el control
     *
     * @param alineacion Una de las siguientes constantes definido en
     * <code>SwingConstants</code>:
     * <code>LEFT</code>,
     * <code>CENTER</code> (el valor predeterminado para las etiquetas de solo
     * imagen),
     * <code>RIGHT</code>,
     * <code>LEADING</code> (el valor predeterminado para las etiquetas de solo
     * texto) o
     * <code>TRAILING</code>.
     *
     */
    public void setAlineacionHorizontal(int alineacion) {
        Label.setHorizontalAlignment(alineacion);
    }

    /**
     * Configura el texto del control
     *
     * @param texto es la cadena a mostrar en el control
     *
     */
    @BeanProperty(preferred = true, visualUpdate = true, description = "Texto del control")
    public void setTexto(String texto) {
        Label.setText(texto);
    }
    
    /**
     * Retorna el texto del control
     **/
    public String getTexto(){
        return Label.getText();
    }
    public void setTextoColor(Color fg){
        Label.setForeground(fg);
    }

    /**
     * Configura la fuente del texto del control
     *
     * @param fuente (java.awt.Font) Especifca el estilo del texto 
     *
     */
    public void setFuente(Font fuente) {
        Label.setFont(fuente);
    }

    /**
     * Configura el fondo del control
     *
     * @param color es el color que se aplicara el fondo
     *
     */
    @BeanProperty(preferred = true, visualUpdate = true, description = "Define el color del fondo")
    public void setFondo(Color color) {
        this.setBackground(color);
        this.Background = color;
        //Background = backg;
        colorMouseEntered = Background.darker();
        colorMouseExited = Background;
        colorMousePressed = Background.darker().darker();
    }
}
