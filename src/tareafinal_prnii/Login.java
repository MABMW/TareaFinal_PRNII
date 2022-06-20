package tareafinal_prnii;

import conexiones.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Adalberto
 */
public class Login extends javax.swing.JFrame {

    Conectar conectar;
    //eventos para mostrar los mensajes de exito y error de conexion
    CambioEventos CE = new CambioEventos() {
        @Override
        public void onCorrectaConexion(Eventos ev) {
            JOptionPane.showMessageDialog(null, "Conexion Exitosa");
        }

        @Override
        public void onErroneaConexion(Eventos ev, String MensajeError) {
            JOptionPane.showMessageDialog(rootPane, "Error: " + MensajeError + "\nEs posible que sus credenciales este mal escritas.");
        }

        @Override
        public void onClassNoEncontrada(Eventos ev, String MensajeError) {
            JOptionPane.showMessageDialog(rootPane, "Error: " + MensajeError + "\n La libreria requerida no se encuentra");
        }
    };

    public Login() {
        initComponents();
        this.setIconImage(new MetodosG().getImage("IMG/Icono.png"));
        setLocationRelativeTo(null);
        MetodosG.setplaceHolder(this.txtUsuario, "Nombre de usuario", java.awt.Font.ITALIC, 0.70f);
        MetodosG.setplaceHolder(this.jptxtPassword, "Ingrese la contraseña", java.awt.Font.ITALIC, 0.70f);
        conectar = new Conectar();
        conectar.addEventListener(CE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtUsuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jptxtPassword = new javax.swing.JPasswordField();
        btnIngresar = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        frmpTitulo1 = new tareafinal_prnii.frmpTitulo();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        txtUsuario.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        txtUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsuario.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(51, 51, 255)));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LOGIN");

        jptxtPassword.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jptxtPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jptxtPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 0, 255)));
        jptxtPassword.setEchoChar('*');

        btnIngresar.setFont(new java.awt.Font("Myanmar Text", 3, 16)); // NOI18N
        btnIngresar.setText("Ingresar");
        btnIngresar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        jCheckBox1.setText("Mostrar Contraseña");
        jCheckBox1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jCheckBox1StateChanged(evt);
            }
        });

        frmpTitulo1.setBordesBotones(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        frmpTitulo1.setIcono("IMG\\Icono.png");
        frmpTitulo1.setVisibleMaximizar(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(frmpTitulo1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jptxtPassword, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(267, 267, 267)
                        .addComponent(jCheckBox1))
                    .addComponent(btnIngresar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(frmpTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jptxtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jCheckBox1)
                .addGap(7, 7, 7)
                .addComponent(btnIngresar))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        conectar.setCredenciales(this.txtUsuario.getText(), MetodosG.charsToString(this.jptxtPassword.getPassword()));
        if (conectar.conector()) {
            frmCliente frmC = new frmCliente();
            frmC.setVisible(true);
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Se cerrara la aplicacion ");
            System.exit(0);
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void jCheckBox1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCheckBox1StateChanged
        if(this.jCheckBox1.isSelected()){
            this.jptxtPassword.setEchoChar((char)0);
        }else{
            this.jptxtPassword.setEchoChar('*'); 
        }
    }//GEN-LAST:event_jCheckBox1StateChanged

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
    private javax.swing.JButton btnIngresar;
    private tareafinal_prnii.frmpTitulo frmpTitulo1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField jptxtPassword;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
