package tareafinal_prnii;

import conexiones.Conectar;
import conexiones.TablaEditor;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class frmNotas extends javax.swing.JFrame {

    Conectar conectar;
    boolean celdaEditable = false;
    private listaAlumnos lstAlumnos = new listaAlumnos();
    TablaEditor tablaEditor;
    DefaultTableModel modeloTabla = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return celdaEditable;
        }
    };
    String[] encabezados = {"Nota1", "Nota2", "Nota3", "Nota4"};
    String[][] notas = new String[20][5];//Son 4 materia y 4 evaluaciones entonces serian 16 como maximo a guardar
    String[] idNota = new String[4];
    boolean modoEdicion = false;

    public frmNotas() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.barraTitulo.setFuente(new java.awt.Font(Font.MONOSPACED, Font.BOLD, 16));
    }

    public frmNotas(Conectar conectar) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.barraTitulo.setFuente(new java.awt.Font(Font.MONOSPACED, Font.BOLD, 16));
        this.conectar = conectar;
        tablaEditor = new TablaEditor(conectar, "notaAlumnos");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpContenedor = new javax.swing.JPanel();
        barraTitulo = new tareafinal_prnii.frmpTitulo();
        txtId = new javax.swing.JTextField();
        lblId = new javax.swing.JLabel();
        lblnombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblFechaNacimiento = new javax.swing.JLabel();
        txtFechaNacimiento = new javax.swing.JTextField();
        cmbxMaterias = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
        lblMateria = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        txtSexo = new javax.swing.JTextField();
        lblSexo = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        btnInforme = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        barraTitulo.setFrmPrincipal(true);
        barraTitulo.setTitulo("Ingreso Notas");
        barraTitulo.setVisibleMaximizar(false);

        txtId.setEditable(false);
        txtId.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtId.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtId.setEnabled(false);

        lblId.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblId.setText("ID:");

        lblnombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblnombre.setText("Nombre:");

        txtNombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNombre.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        lblFechaNacimiento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblFechaNacimiento.setText("Fecha de Nacimiento:");

        txtFechaNacimiento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtFechaNacimiento.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        cmbxMaterias.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbxMaterias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Matematica", "Lenguaje y Literatura", "Ciencia Salud y Medio Ambiente", "Estudio Sociales" }));
        cmbxMaterias.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbxMateriasItemStateChanged(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nota 1", "Nota 2", "Nota 3", "Nota 4"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        lblMateria.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblMateria.setText("Materia:");

        btnRegresar.setText("Regresar a Lista");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        txtSexo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtSexo.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        lblSexo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblSexo.setText("Sexo:");

        btnEditar.setText("Editar datos");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnInforme.setText("Generar Informe");
        btnInforme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInformeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpContenedorLayout = new javax.swing.GroupLayout(jpContenedor);
        jpContenedor.setLayout(jpContenedorLayout);
        jpContenedorLayout.setHorizontalGroup(
            jpContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(barraTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
            .addGroup(jpContenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpContenedorLayout.createSequentialGroup()
                        .addComponent(btnGuardar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar)
                        .addGap(36, 36, 36)
                        .addComponent(btnInforme)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegresar))
                    .addGroup(jpContenedorLayout.createSequentialGroup()
                        .addGroup(jpContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpContenedorLayout.createSequentialGroup()
                                .addComponent(lblMateria)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbxMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpContenedorLayout.createSequentialGroup()
                                .addGroup(jpContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpContenedorLayout.createSequentialGroup()
                                        .addComponent(lblId)
                                        .addGap(8, 8, 8)
                                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jpContenedorLayout.createSequentialGroup()
                                        .addComponent(lblnombre)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(8, 8, 8)
                                .addGroup(jpContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblSexo)
                                    .addComponent(lblFechaNacimiento))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                                    .addComponent(txtSexo))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpContenedorLayout.setVerticalGroup(
            jpContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpContenedorLayout.createSequentialGroup()
                .addComponent(barraTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jpContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblId)
                    .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFechaNacimiento))
                .addGap(18, 18, 18)
                .addGroup(jpContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblnombre)
                    .addComponent(txtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSexo))
                .addGap(18, 18, 18)
                .addGroup(jpContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbxMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMateria))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jpContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresar)
                    .addComponent(btnGuardar)
                    .addComponent(btnEditar)
                    .addComponent(btnInforme))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.lstAlumnos.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String[] columnas = {"nota"};//la columna a editar
        for (int i = 0; i < 4; i++) {
            String[] nuevoValor = {String.valueOf(this.jTable1.getModel().getValueAt(0, i))};
            tablaEditor.modificar(nuevoValor, columnas, "idnota", this.idNota[i]);
        }
        setModeloTabla();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void cmbxMateriasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbxMateriasItemStateChanged
        cambioMateria();
    }//GEN-LAST:event_cmbxMateriasItemStateChanged

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        modoEditar();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        modoEditar();
    }//GEN-LAST:event_formWindowOpened

    private void btnInformeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInformeActionPerformed
        
        plantillaPdf plantillaNota = new plantillaPdf("C:\\UsersLocal\\Escritorio"+"\\reportePruebaNotas.pdf",this.modeloTabla);
        infoAlumno info = new infoAlumno(this.txtId.getText(),this.txtNombre.getText(),this.txtSexo.getText(),this.txtFechaNacimiento.getText(),this.notas);
        plantillaNota.plantillaNotas(info);
    }//GEN-LAST:event_btnInformeActionPerformed

    //Define los datos que se mostraran en el frm
    public void setDatos(String id, String apellido1, String apellido2, String nombre, String sexo, String fechaNacimiento) {
        this.txtId.setText(id);
        this.txtNombre.setText(nombre + " " + apellido1 + " " + apellido2);
        this.txtFechaNacimiento.setText(fechaNacimiento);
        this.txtSexo.setText(sexo);

        //buscar las notas
        ResultSet rs = tablaEditor.buscardato("idAlumno", this.txtId.getText());
        int count = 0;
        try {
            while (rs.next()) {
                notas[count][0] = rs.getString(1);
                notas[count][1] = rs.getString(2);
                notas[count][2] = rs.getString(3);
                notas[count][3] = rs.getString(4);
                notas[count][4] = rs.getString(5);
                count++;
            }
            cambioMateria();
        } catch (SQLException ex) {
        }
    }

    //Cuando en el comboBox se cambia de item se ejecutara este metodo, para actualizar la notas en la pantalla
    private void cambioMateria() {
        if (modeloTabla.getRowCount() > 0) {
            modeloTabla.removeRow(0);
        }
        switch (this.cmbxMaterias.getSelectedIndex()) {
            case 0: {//Si se ha selecionado la materia de matematicas
                setModeloTabla();
                break;
            }
            case 1: {//Si se ha selecionado la materia de Lenguaje y literatura
                setModeloTabla();
                break;
            }
            case 2: {//Si se ha selecionado la materia de Ciencias Salud y Medio Ambiente
                setModeloTabla();
                break;
            }
            case 3: {//Si se ha selecionado la materia de Sociales
                setModeloTabla();
                break;
            }
            default:
                break;
        }
    }
    
    
    //Configura el modeloTabla para el jtable, aqui se agregan las notas al jtable
    private void setModeloTabla() {
        int cualColumna = 0;
        int c = jTable1.getModel().getRowCount();
        for (int i = 0; i < notas.length; i++) {
            if (notas[i][2] != null) {
                String idmateria = String.valueOf(notas[i][1]);
                if (String.valueOf(cmbxMaterias.getSelectedIndex() + 1).equals(idmateria)) {
                    modeloTabla.setColumnCount(4);
                    modeloTabla.setRowCount(c + 1);
                    modeloTabla.setColumnIdentifiers(encabezados);
                    modeloTabla.setValueAt(notas[i][2], c, cualColumna);
                    idNota[cualColumna] = notas[i][0];
                    cualColumna++;
                    jTable1.setModel(modeloTabla);
                    this.jTable1.getColumnModel().getColumn(0).setResizable(false);
                    this.jTable1.getColumnModel().getColumn(1).setResizable(false);
                    this.jTable1.getColumnModel().getColumn(2).setResizable(false);
                    this.jTable1.getColumnModel().getColumn(3).setResizable(false);
                }
            }
        }
    }
    
    //Activa o desactiva los controles para no poder editar o editar los datos
    private void modoEditar() {
        if (modoEdicion) {
            this.txtFechaNacimiento.setEnabled(true);
            this.txtNombre.setEnabled(true);
            this.txtSexo.setEnabled(true);
            this.celdaEditable = true;
            this.btnEditar.setText("Editar datos (Activo)");
            modoEdicion = false;
        } else {
            this.txtFechaNacimiento.setEnabled(false);
            this.txtNombre.setEnabled(false);
            this.txtSexo.setEnabled(false);
            this.celdaEditable = false;
            this.btnEditar.setText("Editar datos (Desactivado)");
            modoEdicion = true;
        }
    }

    //Convierte una matriz en String
    private String ArrayToString(String[][] ds) {
        String array = "";
        for (int i = 0; i < ds.length; i++) {
            for (int j = 0; j < 5; j++) {
                array += notas[i][j] + "      ";
            }
            array += "\n";
        }
        return array;
    }
    //Convierte un vector en String
    private String VectorToString(String[] ds){
        String Array = "";
        for (int i = 0; i < ds.length; i++) {
            Array += ds[i]+", ";
        }
        Array = Array.substring(0, Array.length()-2);
        return Array;
    }
    //Configura el objeto listaAlumnos para obtener acceso a la tabla alumnos
    public void setListaAlumnos(listaAlumnos lstAlumnos) {
        this.lstAlumnos = lstAlumnos;
    }

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
            java.util.logging.Logger.getLogger(frmNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmNotas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private tareafinal_prnii.frmpTitulo barraTitulo;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnInforme;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cmbxMaterias;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel jpContenedor;
    private javax.swing.JLabel lblFechaNacimiento;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblMateria;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblnombre;
    private javax.swing.JTextField txtFechaNacimiento;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtSexo;
    // End of variables declaration//GEN-END:variables
}
