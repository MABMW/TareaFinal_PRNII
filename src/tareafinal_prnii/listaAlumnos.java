package tareafinal_prnii;


import conexiones.Conectar;
import conexiones.TablaEditor;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class listaAlumnos extends javax.swing.JFrame {

    Conectar conectar;
    TablaEditor tablaEditor;
    DefaultTableModel modeloTabla = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    String[] encabezados = {"Codigo", "Apellido1", "Apellido2", "Nombres", "Sexo", "Fecha Nacimiento"};

    public listaAlumnos() {
        initComponents();
        this.setIconImage(new MetodosG().getImage("IMG/icono.png"));
        setLocationRelativeTo(null);
        this.frmpTitulo1.setFrmPrincipal(true);
    }

    public listaAlumnos(Conectar conectar) {
        initComponents();
        this.setIconImage(new MetodosG().getImage("IMG/icono.png"));
        setLocationRelativeTo(null);
        this.frmpTitulo1.setFrmPrincipal(true);
        this.conectar = conectar;
        tablaEditor = new TablaEditor(conectar, "alumno");//alumno es el nombre de la tabla
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        frmpTitulo1 = new tareafinal_prnii.frmpTitulo();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnGenerarPdf = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lista Alumnos");
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        frmpTitulo1.setFuente(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        frmpTitulo1.setIcono("IMG\\icono.png");
        frmpTitulo1.setTitulo("Listado de Alumnos");
        frmpTitulo1.setToolTipText("");
        frmpTitulo1.setVisibleMaximizar(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Apellido1", "Apellido2", "Nombres", "Sexo", "FechaNacimiento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(20);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(200);
        }

        btnGenerarPdf.setText("Generar Reporte");
        btnGenerarPdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarPdfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(frmpTitulo1, javax.swing.GroupLayout.DEFAULT_SIZE, 848, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnGenerarPdf)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(frmpTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGenerarPdf)
                .addContainerGap())
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

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        //para ejecutar el formulario donde se podran editar las notas de los alumnos
        if (evt.getClickCount() == 2 && evt.getButton() == MouseEvent.BUTTON1) {//para dar doble click izquierdo
            int selectRow = jTable1.getSelectedRow();
            if (selectRow > -1) {
                String id = String.valueOf(this.jTable1.getModel().getValueAt(selectRow, 0));
                String apellido1 = String.valueOf(this.jTable1.getModel().getValueAt(selectRow, 1));
                String apellido2 = String.valueOf(this.jTable1.getModel().getValueAt(selectRow, 2));
                String nombre = String.valueOf(this.jTable1.getModel().getValueAt(selectRow, 3));
                String sexo = String.valueOf(this.jTable1.getModel().getValueAt(selectRow, 4));
                String fechaNacimiento = String.valueOf(this.jTable1.getModel().getValueAt(selectRow, 5));
                frmNotas notasform = new frmNotas(conectar);
                notasform.setVisible(true);
                notasform.setDatos(id, apellido1, apellido2, nombre, sexo, fechaNacimiento);
                notasform.setListaAlumnos(this);
                this.setVisible(false);
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked
//Cuando se carga el formulario se agregan los datos de la base de datos en la tabla alumno
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        if (conectar != null) {
            String apellido1 = "";
            String codigo = "";
            String apellido2 = "";
            String nombres = "";
            String fechaNacimiento = "";
            String sexo = "";
            int ultimo = tablaEditor.getUltimoResgistro();

            for (int i = 1; i < ultimo + 1; i++) {
                int cuantos = this.jTable1.getModel().getRowCount();
                ResultSet rs = tablaEditor.buscardato("Idalumno", i + "");
                try {
                    while (rs.next()) {
                        codigo = rs.getString(1);
                        apellido1 = rs.getString(2);
                        apellido2 = rs.getString(3);
                        nombres = rs.getString(4);
                        if (!"M".equals(rs.getString(5))) {
                            sexo = "Femenino";
                        } else {
                            sexo = "Masculino";
                        }
                        fechaNacimiento = rs.getString(6);
                    }
                    this.modeloTabla.setColumnCount(6);
                    modeloTabla.setRowCount(cuantos + 1);
                    modeloTabla.setColumnIdentifiers(encabezados);
                    modeloTabla.setValueAt(codigo, cuantos, 0);
                    modeloTabla.setValueAt(apellido1, cuantos, 1);
                    modeloTabla.setValueAt(apellido2, cuantos, 2);
                    modeloTabla.setValueAt(nombres, cuantos, 3);
                    modeloTabla.setValueAt(sexo, cuantos, 4);
                    modeloTabla.setValueAt(fechaNacimiento, cuantos, 5);
                    this.jTable1.setModel(modeloTabla);
                    this.jTable1.getColumnModel().getColumn(0).setResizable(false);
                    this.jTable1.getColumnModel().getColumn(1).setResizable(false);
                    this.jTable1.getColumnModel().getColumn(2).setResizable(false);
                    this.jTable1.getColumnModel().getColumn(3).setResizable(false);
                    this.jTable1.getColumnModel().getColumn(4).setResizable(false);
                    this.jTable1.getColumnModel().getColumn(5).setResizable(false);
                } catch (SQLException ex) {
                }
            }
        }
    }//GEN-LAST:event_formWindowOpened

    private void btnGenerarPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarPdfActionPerformed
        plantillaPdf pPdf = new plantillaPdf("C:\\UsersLocal\\Escritorio"+"\\reportePrueba.pdf",this.modeloTabla);
        pPdf.platillaAlumno();
    }//GEN-LAST:event_btnGenerarPdfActionPerformed

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
            java.util.logging.Logger.getLogger(listaAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(listaAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(listaAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(listaAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new listaAlumnos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerarPdf;
    private tareafinal_prnii.frmpTitulo frmpTitulo1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
