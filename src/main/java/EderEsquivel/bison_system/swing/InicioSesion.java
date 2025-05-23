/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package EderEsquivel.bison_system.swing;

import EderEsquivel.bison_system.CamposVaciosException;
import EderEsquivel.bison_system.DatosGenerales;
import EderEsquivel.bison_system.UsuarioException;
import EderEsquivel.bison_system.services.DetallesEntrenamientoServices;
import EderEsquivel.bison_system.services.EntrenamientosServices;
import EderEsquivel.bison_system.services.DatosDeUsuarioServices;
import EderEsquivel.bison_system.services.InicioSesionServices;
import EderEsquivel.bison_system.services.MedidasServices;
import EderEsquivel.bison_system.services.SeriesEntrenamientoServices;
import EderEsquivel.bison_system.services.UsuariosServices;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *Interfaz grafica para que el usuario inicie sesion al sistema.
 * 
 * Esta veentana de inicio de sesión para el sistema BisonGYM
 * 
 * Se conecta con los servicios {@link InicioSesionServices} para verificar 
 * credenciales y{@link UsuariosServices} para obtener información del usuario.
 * 
 * @author edere
 */
public class InicioSesion extends javax.swing.JFrame {

    private UsuariosServices usS;
    private InicioSesionServices isS;
    private MedidasServices mS;
    private EntrenamientosServices eS;
    private DetallesEntrenamientoServices deS;
    private SeriesEntrenamientoServices seS;
    private DatosDeUsuarioServices gS;
    private char contrasena;
    private String imagen = "/logoSinFondo200x200.png";
    private ImageIcon icon = new ImageIcon(getClass().getResource(imagen));
    
    /**
     * Se habilita el modo sin conexion.
     */
    public static boolean modoSinConexion;

    
    /**
     * Constructor que inicializa la ventana de inicio de sesión.
     * 
     * @param usS Instancia el servicio de {@link UsuariosServices}.
     * @param isS Instancia el servicio de {@link InicioSesionServices}.
     * @param mS Instancia el servicio de {@link MedidasServices}.
     * @param eS Instancia el servicio de {@link EntrenamientosServices}.
     * @param deS Instancia el servicio de {@link DetallesEntrenamientoServices}.
     * @param seS Instancia el servicio de {@link SeriesEntrenamientoServices}.
     * @param gS Instancia el servicio de {@link DatosDeUsuarioServices}.
     */
    public InicioSesion(UsuariosServices usS, InicioSesionServices isS, MedidasServices mS, EntrenamientosServices eS,
            DetallesEntrenamientoServices deS, SeriesEntrenamientoServices seS, DatosDeUsuarioServices gS) {
        initComponents();
        this.usS = usS;
        this.isS = isS;
        this.mS = mS;
        this.eS = eS;
        this.deS = deS;
        this.seS = seS;
        this.gS = gS;
        contrasena = pfContrasena.getEchoChar();
        setResizable(false);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        logo.setIcon(icon);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfUsuario = new javax.swing.JTextField();
        pfContrasena = new javax.swing.JPasswordField();
        chbxMostrar = new javax.swing.JCheckBox();
        btnIngresar = new javax.swing.JButton();
        logo = new javax.swing.JLabel();
        cmbTipoUsuario = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        btnRegistrarse = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(java.awt.SystemColor.window);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(26, 35, 126));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("BisonGYM");

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel3.setText("Tipo de usuario");

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel4.setText("Contraseña:");

        tfUsuario.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tfUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        pfContrasena.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        pfContrasena.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        chbxMostrar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        chbxMostrar.setText("Mostrar Contraseña");
        chbxMostrar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        chbxMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbxMostrarActionPerformed(evt);
            }
        });

        btnIngresar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        cmbTipoUsuario.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cmbTipoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Usuario", "Administrador" }));
        cmbTipoUsuario.setSelectedIndex(-1);
        cmbTipoUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel5.setText("Usuario:");

        btnRegistrarse.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnRegistrarse.setText("Crear cuenta");
        btnRegistrarse.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "¿Eres nuevo?", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 3, 10))); // NOI18N
        btnRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnIngresar)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfUsuario)
                                    .addComponent(pfContrasena, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                                    .addComponent(cmbTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(chbxMostrar))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(btnRegistrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(33, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(10, 10, 10)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(pfContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chbxMostrar))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIngresar)
                    .addComponent(btnRegistrarse))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Maneja el evento del checkbox para mostrar/ocultar la contraseña.
     * 
     * @param evt Evento de acción del checkbox.
     */
    private void chbxMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbxMostrarActionPerformed
        // TODO add your handling code here:

        if (chbxMostrar.isSelected()) {
            pfContrasena.setEchoChar((char) 0);
        } else {
            pfContrasena.setEchoChar(contrasena);
        }

    }//GEN-LAST:event_chbxMostrarActionPerformed
    
    /**
     * Maneja el evento del botón de inicio de sesión.
     * 
     * @param evt Evento de acción del botón
     */
    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        // TODO add your handling code here:t
        try {
            if (cmbTipoUsuario.getSelectedIndex() == -1 || tfUsuario.getText().trim().isEmpty()
                    || pfContrasena.getPassword().length == 0) {
                throw new CamposVaciosException("Debes llenar todos los campos.");
            }

            if (!DatosGenerales.hayConexion()) {
                int opcion = JOptionPane.showConfirmDialog(this,
                        "No hay conexión a internet.\n¿Deseas continuar en modo sin conexión?",
                        "Sin conexión",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE);
                
                //Si acepta el usuario,entra al modo sin conexion.
                if (opcion == JOptionPane.YES_OPTION) {
                    modoSinConexion = true;
                    MenuGeneral menu = new MenuGeneral(null, null, null, null, null, null);
                    menu.setVisible(true);
                    menu.setLocationRelativeTo(null);
                    this.dispose();
                    return;
                } else {
                    return; // Si elige NO, simplemente no continúa
                }
            }
            String usuario = tfUsuario.getText();
            String password = new String(pfContrasena.getPassword());
            Integer tuElegido = (cmbTipoUsuario.getSelectedIndex() == 0) ? 1 : 2;

            boolean verificarUsuario = isS.verificarUsuario(usuario, password, tuElegido);

            if (!verificarUsuario) {
                throw new UsuarioException("No existe el usuario.");
            }

            JOptionPane.showMessageDialog(this, "Inicio de Sesión Correcto");
            DatosGenerales.setInfoUsuarios(usS.infoUsuario(usuario));

            MenuGeneral menu = new MenuGeneral(usS, mS, eS, deS, seS, gS);
            menu.setVisible(true);
            menu.setLocationRelativeTo(null);
            this.dispose();

        } catch (CamposVaciosException | UsuarioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "¡Error!", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Ha ocurrido un error inesperado.\nDetalle: " + ex.getMessage(),
                    "¡Error!", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }

    }//GEN-LAST:event_btnIngresarActionPerformed

    /**
     * Maneja el evento de cierre de la ventana.Cierra completamente la
     * aplicación cuando se intenta cerrar esta ventana.
     * 
     * @param evt Evento de cierre de ventana
     */
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        dispose(); // Cierra la ventana
        System.exit(0);

    }//GEN-LAST:event_formWindowClosing
    
    /**
     * Maneja el evento del botón de registro.Abre la ventana de registro 
     * para crear una nueva cuenta de usuario.
     * 
     * @param evt Evento de acción del botón.
     */
    private void btnRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarseActionPerformed
        // TODO add your handling code here:
        Registro registro = new Registro(this, usS);
        registro.setLocationRelativeTo(null);
        registro.setBackground(Color.white);
        registro.setVisible(true);
    }//GEN-LAST:event_btnRegistrarseActionPerformed

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
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnRegistrarse;
    private javax.swing.JCheckBox chbxMostrar;
    private javax.swing.JComboBox<String> cmbTipoUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel logo;
    private javax.swing.JPasswordField pfContrasena;
    private javax.swing.JTextField tfUsuario;
    // End of variables declaration//GEN-END:variables
}
