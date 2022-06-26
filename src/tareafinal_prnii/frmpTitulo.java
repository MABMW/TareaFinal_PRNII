package tareafinal_prnii;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.beans.BeanProperty;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class frmpTitulo extends javax.swing.JPanel {
    
    private String titulo = "";
    private int alineacion = SwingConstants.CENTER;
    private boolean visible = true;
    private boolean frmPrincipal = false;

    public frmpTitulo() {
        initComponents();
        //configura el color y la alineacion por defecto
        this.lblTitulo.setHorizontalAlignment(alineacion);
        this.btnCerrar.setFondo(this.getBackground());
        this.btnMaximizar.setFondo(this.getBackground());
        this.btnMinimizar.setFondo(this.getBackground());
    }

    @BeanProperty(preferred = true, visualUpdate = true, description = "Configura la fuente del texto")
    public void setFuente(Font fuente) {
        lblTitulo.setFont(fuente);
    }

    @BeanProperty(preferred = true, visualUpdate = true, description = "Oculta el boton maximizar")
    public void setVisibleMaximizar(boolean visible) {
        this.visible = visible;
        this.btnMaximizar.setVisible(visible);
    }

    public boolean getVisibleMaximizar() {
        return visible;
    }

    @BeanProperty(preferred = true, visualUpdate = true, description = "Define el Texto que se mostrara en la barra de titulo")
    public void setTitulo(String titulo) {
        this.titulo = titulo;
        this.lblTitulo.setText(titulo);
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        if(frame!=null)
            frame.setTitle(titulo);
    }

    public String getTitulo() {
        return titulo;
    }

    @BeanProperty(preferred = true, visualUpdate = true, description = "La alineacion de texto titulo.")
    public void setAlineacionHorizontal(int alineacion) {
        this.alineacion = alineacion;
        this.lblTitulo.setHorizontalAlignment(alineacion);
    }

    public int getAlineacionHorizontal() {
        return this.alineacion;
    }

    @BeanProperty(preferred = true, visualUpdate = true, description = "Configura el color de fondo del boton cerrar")
    public void setColorBotonCerrar(Color color) {
        this.btnCerrar.setFondo(color);
    }

    public Color getColorBotonCerrar() {
        return this.btnCerrar.getBackground();
    }

    @BeanProperty(preferred = true, visualUpdate = true, description = "Configura el icono del formulario")
    public void setIcono(String ruta) {
        String icopath = ruta;
        ImageIcon myicons = new ImageIcon(getClass().getClassLoader().getResource(icopath));
        this.lblIcono.setIcon(myicons);
    }

    /**
     * Configura el color del boton Mostrar
     *
     * @param color 
     *
     */
    @BeanProperty(preferred = true, visualUpdate = true, description = "Configura el color de fondo del boton maximizar")
    public void setColorBotonMaximizar(Color color) {
        this.btnMaximizar.setFondo(color);
    }

    @BeanProperty(preferred = true, visualUpdate = true, description = "Configura el color de fondo del boton minizar")
    public void setColorBotonMinimizar(Color color) {
        this.btnMinimizar.setFondo(color);
    }

    @BeanProperty(preferred = true, visualUpdate = true, description = "Configura los bordes de los botones")
    public void setBordesBotones(javax.swing.border.Border border) {
        this.btnCerrar.setBorder(border);
        this.btnMaximizar.setBorder(border);
        this.btnMinimizar.setBorder(border);
    }
    @BeanProperty(preferred = true, visualUpdate = true, description = "Si es el formulario principal")
    public void setFrmPrincipal(boolean frmPrincipal){
        this.frmPrincipal = frmPrincipal;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblIcono = new javax.swing.JLabel();
        btnCerrar = new tareafinal_prnii.JButtonNew();
        btnMaximizar = new tareafinal_prnii.JButtonNew();
        btnMinimizar = new tareafinal_prnii.JButtonNew();

        lblTitulo.setText("Titulo");
        lblTitulo.setPreferredSize(new java.awt.Dimension(32, 32));
        lblTitulo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                lblTituloMouseDragged(evt);
            }
        });
        lblTitulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblTituloMousePressed(evt);
            }
        });

        lblIcono.setPreferredSize(new java.awt.Dimension(32, 32));

        btnCerrar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCerrar.setFondo(new java.awt.Color(255, 255, 255));
        btnCerrar.setTexto("X");
        btnCerrar.setPreferredSize(new java.awt.Dimension(32, 32));
        btnCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCerrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCerrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCerrarMouseExited(evt);
            }
        });

        btnMaximizar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnMaximizar.setFondo(java.awt.Color.white);
        btnMaximizar.setTexto("M");
        btnMaximizar.setPreferredSize(new java.awt.Dimension(32, 32));
        btnMaximizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMaximizarMouseClicked(evt);
            }
        });

        btnMinimizar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnMinimizar.setFondo(java.awt.Color.white);
        btnMinimizar.setTexto("-");
        btnMinimizar.setPreferredSize(new java.awt.Dimension(32, 32));
        btnMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMinimizarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblIcono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMaximizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblIcono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnMaximizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseClicked
        if (this.frmPrincipal == false) {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            frame.dispose();
        } else {
            System.exit(0);
        }
    }//GEN-LAST:event_btnCerrarMouseClicked

    
    private void btnCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseEntered
        this.btnCerrar.setFondo(Color.RED);
        this.btnCerrar.setTextoColor(Color.WHITE);
    }//GEN-LAST:event_btnCerrarMouseEntered

    private void btnCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseExited
        this.btnCerrar.setFondo(this.btnMinimizar.getBackground());
        this.btnCerrar.setTextoColor(Color.BLACK);
    }//GEN-LAST:event_btnCerrarMouseExited

    private void btnMaximizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMaximizarMouseClicked
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        if (frame.getExtendedState() == Frame.MAXIMIZED_BOTH) {//Si esta maximizado
            frame.setMaximizedBounds(env.getMaximumWindowBounds());
            frame.setExtendedState(Frame.NORMAL);
        } else {//si no esta maximizado
            frame.setMaximizedBounds(env.getMaximumWindowBounds());
            frame.setExtendedState(frame.getExtendedState() | Frame.MAXIMIZED_BOTH);
        }
    }//GEN-LAST:event_btnMaximizarMouseClicked

    private void btnMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizarMouseClicked
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        frame.setMaximizedBounds(env.getMaximumWindowBounds());
        frame.setExtendedState(frame.getExtendedState() | Frame.ICONIFIED);
    }//GEN-LAST:event_btnMinimizarMouseClicked

    private void lblTituloMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTituloMouseDragged
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        FiveCodMover.FiveCodMoverJFrame.MouseDraggedFrame(evt, frame);
    }//GEN-LAST:event_lblTituloMouseDragged

    private void lblTituloMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTituloMousePressed
        FiveCodMover.FiveCodMoverJFrame.MousePressed(evt);
    }//GEN-LAST:event_lblTituloMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private tareafinal_prnii.JButtonNew btnCerrar;
    private tareafinal_prnii.JButtonNew btnMaximizar;
    private tareafinal_prnii.JButtonNew btnMinimizar;
    private javax.swing.JLabel lblIcono;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
