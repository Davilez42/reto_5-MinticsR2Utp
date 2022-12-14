/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto_5.utp.mintics.davidsuarez.view;

import com.reto_5.utp.mintics.davidsuarez.controller.AppControllerGui;
import com.reto_5.utp.mintics.davidsuarez.util.ModeloTablaCompras;
import com.reto_5.utp.mintics.davidsuarez.util.ModeloTablaLider;
import com.reto_5.utp.mintics.davidsuarez.util.ModeloTablaProyectos;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.multi.MultiLookAndFeel;

/**
 *
 * @author joses
 */
public class AppMainViewGUI extends javax.swing.JFrame {

    //Controlador
    private AppControllerGui controlador;

    //Tablas
    private ModeloTablaLider modeloTablaLider;
    private ModeloTablaCompras modeloTablaCompras;
    private ModeloTablaProyectos modelotablaproyectos;
    
    
    public AppMainViewGUI() {
        initComponents();
        setSize(700, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        this.controlador = new AppControllerGui();
        this.modeloTablaLider = new ModeloTablaLider();
        this.modeloTablaCompras = new ModeloTablaCompras();
        this.modelotablaproyectos = new ModeloTablaProyectos();
        this.tablaInformes.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        Titulo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaInformes = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        imfLideres = new javax.swing.JButton();
        imfCompras = new javax.swing.JButton();
        imfProyectos = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Reto 5");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Informe"));
        jPanel3.setLayout(new java.awt.BorderLayout());

        Titulo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jPanel2.add(Titulo);

        jPanel3.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jScrollPane2.setViewportView(tablaInformes);

        jPanel3.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Botones"));

        imfLideres.setText("Informe Lideres");
        imfLideres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imfLideresActionPerformed(evt);
            }
        });

        imfCompras.setText("Informe Compras");
        imfCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imfComprasActionPerformed(evt);
            }
        });

        imfProyectos.setText("Informe Proyectos");
        imfProyectos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imfProyectosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(imfProyectos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(imfCompras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(imfLideres, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(imfLideres, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(imfCompras, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(imfProyectos, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel7, java.awt.BorderLayout.LINE_START);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Proyectos  Construcciones");
        jPanel1.add(jLabel1);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void imfLideresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imfLideresActionPerformed
        
        try {
            tablaInformes.removeAll();
            var lideres = controlador.obtenerInformeLideres();
            modeloTablaLider.setDatos(lideres);
            tablaInformes.setModel(modeloTablaLider);
            Titulo.setText("INFORME DE LIDERES");
        } catch (SQLException ex) {
            mostrarError("Error al obtener informe de lideres" + ex);
        }
    }//GEN-LAST:event_imfLideresActionPerformed

    private void imfComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imfComprasActionPerformed
         try {
             tablaInformes.removeAll();
            var compras = controlador.obtenerInformeCompras();
            modeloTablaCompras.setDatos(compras);
            tablaInformes.setModel(modeloTablaCompras);
            Titulo.setText("INFORME DE COMPRAS");
            
         
        } catch (SQLException ex) {
            mostrarError("Error al obtener informe de Compras" + ex);
        }
    }//GEN-LAST:event_imfComprasActionPerformed

    private void imfProyectosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imfProyectosActionPerformed
            try {
             tablaInformes.removeAll();
            var proyectos = controlador.obtenerInformeProyectos();
            modelotablaproyectos.setDatos(proyectos);
            tablaInformes.setModel(modelotablaproyectos);
            Titulo.setText("INFORME DE PROYECTOS");
            
         
        } catch (SQLException ex) {
            mostrarError("Error al obtener informe de Compras" + ex);
        }
    }//GEN-LAST:event_imfProyectosActionPerformed

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
            java.util.logging.Logger.getLogger(AppMainViewGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AppMainViewGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppMainViewGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppMainViewGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new AppMainViewGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Titulo;
    private javax.swing.JButton imfCompras;
    private javax.swing.JButton imfLideres;
    private javax.swing.JButton imfProyectos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaInformes;
    // End of variables declaration//GEN-END:variables

    private void mostrarError(String string) {
        JOptionPane.showMessageDialog(this, string, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
