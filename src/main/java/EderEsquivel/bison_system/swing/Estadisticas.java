/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package EderEsquivel.bison_system.swing;

import EderEsquivel.bison_system.CamposVaciosException;
import EderEsquivel.bison_system.DatosGenerales;
import EderEsquivel.bison_system.entidadesGraficas.DatosGraficaSL;
import EderEsquivel.bison_system.entidadesGraficas.DatosGraficaSD;
import EderEsquivel.bison_system.model.Ejercicios;
import EderEsquivel.bison_system.model.ZonasAnatomicas;
import EderEsquivel.bison_system.services.DatosDeUsuarioServices;
import static EderEsquivel.bison_system.swing.CategoriasEjercicios.listaEjercicios;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author edere
 */
public class Estadisticas extends javax.swing.JInternalFrame {
     private DatosDeUsuarioServices gS;
     public ChartPanel chartPanel=new ChartPanel(null);
     public Ejercicios ejercicioSelect;
    /**
     * Creates new form Perfil
     */
    public Estadisticas(DatosDeUsuarioServices gS) {
        this.gS=gS;
        initComponents();
        this.setResizable(false);
        for (ZonasAnatomicas zona : DatosGenerales.zonasAnatomicasMap.values()) {
            cbxCategoria.addItem(zona.getNombre_zona());
        }
        cbxCategoria.setSelectedIndex(-1);
        cbxCategoria.setVisible(false);
        cbxEjercicio.setVisible(false);
        cbxGraficas.setSelectedIndex(-1);
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
                Integer idEjercicio=obtenerIDEjercicio(cbxEjercicio.getSelectedItem().toString());
                listPeso=gS.evolucionPesoCargado(DatosGenerales.getInfoUsuarios().getId(), 
                        idEjercicio, DatosGenerales.cambioFecha(dcFechaI.getDate()),
                    DatosGenerales.cambioFecha(dcFechaF.getDate()));
                if (listPeso.size()<=1) {
                    JOptionPane.showMessageDialog(this, "No hay datos",
                        "¡Error!", JOptionPane.ERROR_MESSAGE);
                } else {
                    DefaultCategoryDataset datasetLinea = new DefaultCategoryDataset();
                    for (DatosGraficaSD ep : listPeso) {
                        datasetLinea.addValue(ep.getDato(), "Peso Usado", ep.getCampo());
                    }

                    JFreeChart lineChart = ChartFactory.createLineChart(
                        "Evolución del Peso Usado en "+cbxEjercicio.getSelectedItem().toString(),     // Título
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
                if (listPesoU.size()<=1) {
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
                if (listPGC.size()<=1) {
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
            case 4:
                List<DatosGraficaSL> listDificultad=new ArrayList<>();
                listDificultad=gS.ejerciciosHechosDificultad(DatosGenerales.getInfoUsuarios().getId(),
                  DatosGenerales.cambioFecha(dcFechaI.getDate()),
                    DatosGenerales.cambioFecha(dcFechaF.getDate()));
                if (listDificultad.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "No hay datos",
                        "¡Error!", JOptionPane.ERROR_MESSAGE);
                } else {
                    DefaultPieDataset datasetPastel = new DefaultPieDataset();

                    for (DatosGraficaSL ep : listDificultad) {
                        datasetPastel.setValue(ep.getCampo(), ep.getDato());
                    }

                    JFreeChart pieChart = ChartFactory.createPieChart(
                        "Ejercicios por Dificultad",  // Título
                        datasetPastel,                // Dataset
                        true,                         // Leyenda
                        true,                         // Tooltips
                        false                         // URLs
                    );
                    PiePlot plot = (PiePlot) pieChart.getPlot();
                    plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}: {1}"));
                    chartPanel = new ChartPanel(pieChart);
                   
                }
                break;
                
            case 5:
                List<DatosGraficaSL> listZonas=new ArrayList<>();
                listZonas=gS.zonasMEntrenadas(DatosGenerales.getInfoUsuarios().getId(),
                  DatosGenerales.cambioFecha(dcFechaI.getDate()),
                    DatosGenerales.cambioFecha(dcFechaF.getDate()));
                if (listZonas.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "No hay datos",
                        "¡Error!", JOptionPane.ERROR_MESSAGE);
                } else {
                    DefaultCategoryDataset datasetBarras = new DefaultCategoryDataset();

                    for (DatosGraficaSL ep : listZonas) {
                        datasetBarras.addValue(ep.getDato(), "Cantidad", ep.getCampo());
                    }

                    JFreeChart barChart = ChartFactory.createBarChart(
                        "Zonas Más Entrenadas",       // Título
                        "Zona Anatómica",             // Eje X
                        "Cantidad de Ejercicios",     // Eje Y
                        datasetBarras,
                        PlotOrientation.HORIZONTAL,   // Orientación horizontal
                        true,                         // Leyenda
                        true,                         // Tooltips
                        false                         // URLs
                    );

                    chartPanel = new ChartPanel(barChart);
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

        jPanel1 = new javax.swing.JPanel();
        cbxGraficas = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        dcFechaI = new com.toedter.calendar.JDateChooser();
        dcFechaF = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnSG = new javax.swing.JButton();
        cbxCategoria = new javax.swing.JComboBox<>();
        cbxEjercicio = new javax.swing.JComboBox<>();
        jpGrafica = new javax.swing.JPanel();

        setBackground(java.awt.SystemColor.window);
        setClosable(true);
        setIconifiable(true);
        setPreferredSize(new java.awt.Dimension(800, 500));
        setVerifyInputWhenFocusTarget(false);
        setVisible(true);

        jPanel1.setBackground(java.awt.SystemColor.window);

        cbxGraficas.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cbxGraficas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Entrenamiento por mes", "Evolucion peso por ejercicio", "Peso de usuario", "Porcentaje de grasa corporal", "Ejercicios hechos por dificultad", "Zonas musculares entrenadas" }));
        cbxGraficas.setSelectedIndex(-1);
        cbxGraficas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cbxGraficas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxGraficasActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel1.setText("Selecciona una grafica");

        dcFechaI.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        dcFechaI.setDateFormatString("yyyy-MM-dd ");

        dcFechaF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
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

        cbxCategoria.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cbxCategoria.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cbxCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCategoriaActionPerformed(evt);
            }
        });

        cbxEjercicio.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cbxEjercicio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cbxEjercicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEjercicioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbxEjercicio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(399, 399, 399))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(cbxGraficas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dcFechaI, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(dcFechaF, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(83, 83, 83))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(295, 295, 295)
                .addComponent(btnSG)
                .addGap(0, 0, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxEjercicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSG)
                .addContainerGap(11, Short.MAX_VALUE))
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
            .addGap(0, 330, Short.MAX_VALUE)
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
        try{   
            if(cbxGraficas.getSelectedIndex()==-1){
                throw new CamposVaciosException("Selecciona una tipo de grafica");
            }
            if(dcFechaI.getDate()==null || dcFechaF.getDate()==null){
                throw new CamposVaciosException("Selecciona las fechas");
            }
            
            if(dcFechaF.getDate().before(dcFechaI.getDate())){
                throw new Exception("La fecha de fin debe ser despues de la fecha de inicio\nSelecciona de nuevo");
            }
            
            if(dcFechaF.getDate().equals(dcFechaI.getDate())){
                throw new Exception("Las fechas no deben ser las mismas\nSelecciona de nuevo");
            }
            
             if(cbxGraficas.getSelectedIndex()==1){
                 if(cbxCategoria.getSelectedIndex()==-1 || cbxEjercicio.getSelectedIndex()==-1){
                     throw new CamposVaciosException("Selecciona una ejercicio");
                 }
             } 
             
             if(!DatosGenerales.hayConexion()){
                throw new Exception("No hay conexión a internet.\nIntente reconectarse a una red.");
            }
             mostrarGrafica();
        }catch(CamposVaciosException ex){
            JOptionPane.showMessageDialog(this, ex.getMessage(), "¡Error!",
                    JOptionPane.ERROR_MESSAGE);

        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, ex.getMessage(), "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
        }
           
        
    }//GEN-LAST:event_btnSGActionPerformed

    private void cbxCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCategoriaActionPerformed
        // TODO add your handling code here:
        cbxEjercicio.removeAllItems();
        int idZonaSelecionada=cbxCategoria.getSelectedIndex()+1;
        listaEjercicios=DatosGenerales.obtenerEjerciciosPorZona(idZonaSelecionada);
        for (Ejercicios ejercicio : listaEjercicios) {
            cbxEjercicio.addItem(ejercicio.getNombre());
        }
        cbxEjercicio.setSelectedIndex(-1);
        
    }//GEN-LAST:event_cbxCategoriaActionPerformed

    private void cbxGraficasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxGraficasActionPerformed
        // TODO add your handling code here:
        if(cbxGraficas.getSelectedIndex()!=1){
            cbxCategoria.setVisible(false);
            cbxEjercicio.setVisible(false);
            cbxCategoria.setSelectedIndex(-1);
            cbxEjercicio.setSelectedIndex(-1);
        }
        else{
            cbxCategoria.setVisible(true);
            cbxEjercicio.setVisible(true);

        }
    }//GEN-LAST:event_cbxGraficasActionPerformed

    private void cbxEjercicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEjercicioActionPerformed
        // TODO add your handling code here:
        String ejercicioSeleccionado = (String) cbxEjercicio.getSelectedItem();

        for(Ejercicios ej:DatosGenerales.ejerciciosMap.values()){
            if(ej.getNombre()== ejercicioSeleccionado)
                ejercicioSelect=ej;
        }
    }//GEN-LAST:event_cbxEjercicioActionPerformed
    
    public static Integer obtenerIDEjercicio(String nombreEjercicio) {
    for (Map.Entry<Integer, Ejercicios> entry : DatosGenerales.ejerciciosMap.entrySet()) {
        Ejercicios ejercicio = entry.getValue();
        if (ejercicio.getNombre().equalsIgnoreCase(nombreEjercicio)) {
            return entry.getKey();
        }
    }
    return null; 
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSG;
    private javax.swing.JComboBox<String> cbxCategoria;
    private javax.swing.JComboBox<String> cbxEjercicio;
    private javax.swing.JComboBox<String> cbxGraficas;
    private com.toedter.calendar.JDateChooser dcFechaF;
    private com.toedter.calendar.JDateChooser dcFechaI;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jpGrafica;
    // End of variables declaration//GEN-END:variables
}
