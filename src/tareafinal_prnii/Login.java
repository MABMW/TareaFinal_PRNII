package tareafinal_prnii;

import conexiones.*;
import java.awt.Font;
import javax.swing.JOptionPane;
import java.sql.SQLException;

public class Login extends javax.swing.JFrame {

    Conectar conectar;
    //eventos para mostrar los mensajes de exito y error de conexion
    CambioEventos CE = new CambioEventos() {
        @Override
        public void onCorrectaConexion(Eventos ev) {
            // JOptionPane.showMessageDialog(null, "Conexion Exitosa");
        }

        @Override
        public void onErroneaConexion(Eventos ev, SQLException MensajeError) {
            switch (MensajeError.getErrorCode()) {
                case 1251:
                    JOptionPane.showMessageDialog(null, "El usuario es incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
                case 1045:
                    JOptionPane.showMessageDialog(null, "La Constraseña es incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
                case 1146:
                    JOptionPane.showMessageDialog(null, "La tabla no existe", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
                case 1007:
                    JOptionPane.showMessageDialog(null, "La base de datos que se quiere crear, ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
                case 1049:
                    JOptionPane.showMessageDialog(null, "La base de datos no se encuentra.", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
                default:
                    break;
            }
        }

        @Override
        public void onClassNoEncontrada(Eventos ev, ClassNotFoundException MensajeError) {
            JOptionPane.showMessageDialog(rootPane, "Error: " + MensajeError + "\n La libreria requerida no se encuentra");
        }
    };

    public Login() {
        initComponents();
        this.setIconImage(new MetodosG().getImage("IMG/Icono.png"));
        setLocationRelativeTo(null);
        this.barraTitulo.setFuente(new java.awt.Font(Font.SANS_SERIF, Font.BOLD, 16));
        this.btnIniciarSesion.setFuente(new java.awt.Font(Font.DIALOG, Font.BOLD, 26));
        MetodosG.setplaceHolder(this.txtUsuario, "Nombre de usuario", java.awt.Font.ITALIC, 0.70f);
        MetodosG.setplaceHolder(this.jptxtPassword, "Ingrese la contraseña", java.awt.Font.ITALIC, 0.70f);
        conectar = new Conectar();
        conectar.addEventListener(CE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        barraTitulo = new tareafinal_prnii.frmpTitulo();
        jLabel1 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jptxtPassword = new javax.swing.JPasswordField();
        jchkShowContrasenia = new javax.swing.JCheckBox();
        btnIniciarSesion = new tareafinal_prnii.JButtonNew();
        jchkModoAvanzado = new javax.swing.JCheckBox();
        txtNombreBaseDeDatos = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        barraTitulo.setBackground(new java.awt.Color(255, 255, 255));
        barraTitulo.setBordesBotones(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        barraTitulo.setColorBotonCerrar(new java.awt.Color(255, 255, 255));
        barraTitulo.setColorBotonMinimizar(java.awt.Color.white);
        barraTitulo.setIcono("IMG\\Icono.png");
        barraTitulo.setTitulo("Login");
        barraTitulo.setVisibleMaximizar(false);

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LOGIN");

        txtUsuario.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        txtUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsuario.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(51, 51, 255)));

        jptxtPassword.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jptxtPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jptxtPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 0, 255)));
        jptxtPassword.setEchoChar('*');

        jchkShowContrasenia.setText("Mostrar Contraseña");
        jchkShowContrasenia.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jchkShowContraseniaStateChanged(evt);
            }
        });

        btnIniciarSesion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnIniciarSesion.setTexto("Ingresar");
        btnIniciarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnIniciarSesionMouseClicked(evt);
            }
        });

        jchkModoAvanzado.setText("ModoAvanzado");
        jchkModoAvanzado.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jchkModoAvanzadoStateChanged(evt);
            }
        });

        txtNombreBaseDeDatos.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        txtNombreBaseDeDatos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombreBaseDeDatos.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(51, 51, 255)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(barraTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(txtUsuario)
            .addComponent(jptxtPassword)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jchkModoAvanzado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addComponent(jchkShowContrasenia))
            .addComponent(btnIniciarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtNombreBaseDeDatos)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(barraTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jptxtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jchkShowContrasenia)
                    .addComponent(jchkModoAvanzado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreBaseDeDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnIniciarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jchkShowContraseniaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jchkShowContraseniaStateChanged
        if (this.jchkShowContrasenia.isSelected()) {
            this.jptxtPassword.setEchoChar((char) 0);
        } else {
            this.jptxtPassword.setEchoChar('*');
        }
    }//GEN-LAST:event_jchkShowContraseniaStateChanged

    private void btnIniciarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIniciarSesionMouseClicked
        
        if (!this.txtNombreBaseDeDatos.getText().equals("")) {
            conectar.setCredenciales(this.txtUsuario.getText(), MetodosG.charsToString(this.jptxtPassword.getPassword()), this.txtNombreBaseDeDatos.getText());
        } else {
            conectar.setCredenciales(this.txtUsuario.getText(), MetodosG.charsToString(this.jptxtPassword.getPassword()));
        }
        
        if (conectar.conectarBase()) {
            TablaEditor est = new TablaEditor(conectar, "clientes");
            JOptionPane.showMessageDialog(rootPane, est.getCount());
        } else {
            this.txtUsuario.setText("");
            this.jptxtPassword.setText("");
        }
    }//GEN-LAST:event_btnIniciarSesionMouseClicked

    private void jchkModoAvanzadoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jchkModoAvanzadoStateChanged
        if (this.jchkModoAvanzado.isSelected()) {
            this.txtNombreBaseDeDatos.setText("");
            this.txtNombreBaseDeDatos.setVisible(true);
        } else {
            this.txtNombreBaseDeDatos.setText("");
            this.txtNombreBaseDeDatos.setVisible(false);
        }
    }//GEN-LAST:event_jchkModoAvanzadoStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private tareafinal_prnii.frmpTitulo barraTitulo;
    private tareafinal_prnii.JButtonNew btnIniciarSesion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JCheckBox jchkModoAvanzado;
    private javax.swing.JCheckBox jchkShowContrasenia;
    private javax.swing.JPasswordField jptxtPassword;
    private javax.swing.JTextField txtNombreBaseDeDatos;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
