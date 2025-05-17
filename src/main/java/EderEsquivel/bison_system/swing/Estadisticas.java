/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package EderEsquivel.bison_system.swing;

import EderEsquivel.bison_system.DatosGenerales;
import EderEsquivel.bison_system.entidadesGraficas.DatosGraficaSL;
import EderEsquivel.bison_system.entidadesGraficas.DatosGraficaSD;
import EderEsquivel.bison_system.services.EntrenamientosServices;
import EderEsquivel.bison_system.services.GraficasServices;
import java.awt.Dimension;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author edere
 */
public class Estadisticas extends javax.swing.JInternalFrame {
     private GraficasServices gS;
     public ChartPanel chartPanel=null;
    /**
     * Creates new form Perfil
     */
    public Estadisticas(GraficasServices gS) {
        this.gS=gS;
        initComponents();
        this.setResizable(false);
    }
    
    private void mostrarGrafica() {
        // Crear dataset con datos reales
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        int gSelect=cbxGraficas.getSelectedIndex();
        
        switch(gSelect){
            case 0: 
                List<DatosGraficaSL> listEntrenamiento = new ArrayList<>();
                listEntrenamiento = gS.EntrenamientosPorMes(
                    DatosGenerales.getInfoUsuarios().getId(),
                    DatosGenerales.cambioFecha(dcFechaI.getDate()),
                    DatosGenerales.cambioFecha(dcFechaF.getDate())
                );
                if(listEntrenamiento.isEmpty()){
                    JOptionPane.showMessageDialog(this, "No hay datos",
                "¡Error!", JOptionPane.ERROR_MESSAGE);
                }else{
                    for (DatosGraficaSL em : listEntrenamiento) {
                    dataset.addValue(em.getDato(), "Veces por mes", em.getCampo());
                    }
                    JFreeChart barChart = ChartFactory.createBarChart(
                        "Entrenamientos por mes", // Título
                        "Mes",                    // Eje X
                        "Número de entrenamientos", // Eje Y
                        dataset,
                        PlotOrientation.VERTICAL,
                        true,                     // incluir leyenda
                        true,                     // tooltips
                        false                     // URLs
                    );

                    // Crear panel del gráfico y establecer tamaño reducido
                    chartPanel = new ChartPanel(barChart);
                    
                }
                break;
                
            case 1:
                List<DatosGraficaSD> listPeso=new ArrayList<>();
                listPeso=gS.evolucionPesoCargado(DatosGenerales.getInfoUsuarios().getId(), 
                        DatosGenerales.ejerciciosMap.get(5).getId_ejericio()
                                , DatosGenerales.cambioFecha(dcFechaI.getDate()),
                    DatosGenerales.cambioFecha(dcFechaF.getDate()));
                if (listPeso.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "No hay datos",
                        "¡Error!", JOptionPane.ERROR_MESSAGE);
                } else {
                    DefaultCategoryDataset datasetLinea = new DefaultCategoryDataset();
                    for (DatosGraficaSD ep : listPeso) {
                        datasetLinea.addValue(ep.getDato(), "Peso Usado", ep.getCampo());
                    }

                    JFreeChart lineChart = ChartFactory.createLineChart(
                        "Evolución del Peso Usado",     // Título
                        "Fecha",                        // Eje X
                        "Peso (kg)",                    // Eje Y
                        datasetLinea,
                        PlotOrientation.VERTICAL,
                        true,                           // incluir leyenda
                        true,                           // tooltips
                        false                           // URLs
                    );

                    chartPanel = new ChartPanel(lineChart);
                    
                }
                break;
                
            case 2:
                List<DatosGraficaSD> listPesoU=new ArrayList<>();
                listPesoU=gS.evolucionPesoUsuario(DatosGenerales.getInfoUsuarios().getId(),
                  DatosGenerales.cambioFecha(dcFechaI.getDate()),
                    DatosGenerales.cambioFecha(dcFechaF.getDate()));
                if (listPesoU.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "No hay datos",
                        "¡Error!", JOptionPane.ERROR_MESSAGE);
                } else {
                    DefaultCategoryDataset datasetLinea = new DefaultCategoryDataset();
                    for (DatosGraficaSD ep : listPesoU) {
                        datasetLinea.addValue(ep.getDato(), "Kg", ep.getCampo());
                    }

                    JFreeChart lineChart = ChartFactory.createLineChart(
                        "Evolución del Peso del Usuario",     // Título
                        "Fecha",                        // Eje X
                        "Peso (kg)",                    // Eje Y
                        datasetLinea,
                        PlotOrientation.VERTICAL,
                        true,                           // incluir leyenda
                        true,                           // tooltips
                        false                           // URLs
                    );

                   chartPanel = new ChartPanel(lineChart);
                   
                }
                break;
                
            case 3:
                List<DatosGraficaSL> listPGC=new ArrayList<>();
                listPGC=gS.evolucionPGC(DatosGenerales.getInfoUsuarios().getId(),
                  DatosGenerales.cambioFecha(dcFechaI.getDate()),
                    DatosGenerales.cambioFecha(dcFechaF.getDate()));
                if (listPGC.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "No hay datos",
                        "¡Error!", JOptionPane.ERROR_MESSAGE);
                } else {
                    DefaultCategoryDataset datasetLinea = new DefaultCategoryDataset();
                    for (DatosGraficaSL ep : listPGC) {
                        datasetLinea.addValue(ep.getDato(), "%", ep.getCampo());
                    }

                    JFreeChart lineChart = ChartFactory.createLineChart(
                        "Evolución del porcentaje de grasa corporal del Usuario",     // Título
                        "Fecha",                        // Eje X
                        "Porcentaje Grasa Corporal",                    // Eje Y
                        datasetLinea,
                        PlotOrientation.VERTICAL,
                        true,                           // incluir leyenda
                        true,                           // tooltips
                        false                           // URLs
                    );

                   chartPanel = new ChartPanel(lineChart);
                   
                }
                break;
        }
        if (chartPanel != null) {
            jpGrafica.remove(chartPanel);
        }
        

        jpGrafica.removeAll();
        jpGrafica.setLayout(new java.awt.BorderLayout());
        jpGrafica.add(chartPanel, java.awt.BorderLayout.CENTER);
        jpGrafica.revalidate();
        jpGrafica.repaint();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCalendar1 = new com.toedter.calendar.JCalendar();
        jPanel1 = new javax.swing.JPanel();
        cbxGraficas = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        dcFechaI = new com.toedter.calendar.JDateChooser();
        dcFechaF = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnSG = new javax.swing.JButton();
        jpGrafica = new javax.swing.JPanel();

        setBackground(java.awt.SystemColor.window);
        setClosable(true);
        setIconifiable(true);
        setPreferredSize(new java.awt.Dimension(800, 500));
        setVerifyInputWhenFocusTarget(false);
        setVisible(true);

        jPanel1.setBackground(java.awt.SystemColor.window);

        cbxGraficas.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cbxGraficas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Entrenamiento por mes", "Evolucion peso por ejecicio", "Peso de usuario", "Porcentaje de grasa corporal", "Ejercicios hechos por dificultad", "Zonas musculares entrenadas" }));
        cbxGraficas.setSelectedIndex(-1);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel1.setText("Selecciona una grafica");

        dcFechaI.setDateFormatString("yyyy-MM-dd ");

        dcFechaF.setDateFormatString("yyyy-MM-dd");

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel2.setText("Fecha de Inicio");

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel3.setText("Fecha de Fin");

        btnSG.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnSG.setText("Seleccionar grafica");
        btnSG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSGActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(cbxGraficas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dcFechaI, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(dcFechaF, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(83, 83, 83))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(285, 285, 285)
                .addComponent(btnSG)
                .addGap(0, 356, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dcFechaI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dcFechaF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxGraficas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSG)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jpGrafica.setBackground(java.awt.SystemColor.window);

        javax.swing.GroupLayout jpGraficaLayout = new javax.swing.GroupLayout(jpGrafica);
        jpGrafica.setLayout(jpGraficaLayout);
        jpGraficaLayout.setHorizontalGroup(
            jpGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpGraficaLayout.setVerticalGroup(
            jpGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpGrafica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpGrafica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSGActionPerformed
        // TODO add your handling code here:
        
            mostrarGrafica();
        
    }//GEN-LAST:event_btnSGActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSG;
    private javax.swing.JComboBox<String> cbxGraficas;
    private com.toedter.calendar.JDateChooser dcFechaF;
    private com.toedter.calendar.JDateChooser dcFechaI;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jpGrafica;
    // End of variables declaration//GEN-END:variables
}
