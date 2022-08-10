package com.reto_5.utp.mintics.davidsuarez.view;

import java.awt.Color;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;

import com.reto_5.utp.mintics.davidsuarez.controller.AppController;
import com.reto_5.utp.mintics.davidsuarez.model.vo.ComprasVo;
import com.reto_5.utp.mintics.davidsuarez.model.vo.LiderVo;
import com.reto_5.utp.mintics.davidsuarez.model.vo.ProyectoVo;

public class ViewMain extends JFrame {
    private JPanel panel1, panel2;
    private JButton reportLider,reportproyects,reportbuys;
    private AppController controller;
    private JScrollPane sc;
    private JTable table;
    private DefaultTableModel model;

    

    public ViewMain(AppController controller) {

        initComponents(controller);
       
    }

    private void initComponents(AppController controller) {
        setTitle("reto 5");
        panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());


        panel2 = new JPanel();
    

        this.controller = controller;
        


        reportLider = new JButton("ReportLider");
        reportLider.addActionListener(controller);
        panel2.add(reportLider);

        reportproyects = new JButton("reportproyects");
        reportproyects.addActionListener(controller);
        panel2.add(reportproyects);

        reportbuys = new JButton("reportbuys");
        reportbuys.addActionListener(controller);
        panel2.add(reportbuys);

        model =  new DefaultTableModel();
        
        table = new JTable(model);
        table.setEnabled(false);
        sc = new JScrollPane(table);
        

        

        
        panel1.add(sc,BorderLayout.CENTER);

        getContentPane().setLayout(new BorderLayout());
        controller.setBoton1(reportLider);
        controller.setBoton2(reportbuys);
        controller.setBoton3(reportproyects);
        add(panel2, BorderLayout.NORTH);
        add(panel1, BorderLayout.CENTER);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setResizable(false);
    }

    
    public void mostrarLideres(List<LiderVo> lideres) {
        panel1.removeAll();
        panel1.revalidate();
        model = new DefaultTableModel();
        
        table = new JTable(model);
        table.setEnabled(false);
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Apellido");
        model.addColumn("Ciudad Residencia");
        for (LiderVo liderVo : lideres) {
            Object[] fila = new Object[4];
            fila[0] = liderVo.getId();
            fila[1] = liderVo.getNombre();
            fila[2] = liderVo.getPrimer_Apellido();
            fila[3] = liderVo.getCiudad_Residencia();
            model.addRow(fila);

            
        }
        
        sc = new JScrollPane(table);
        panel1.add(new JLabel("Lideres"),BorderLayout.NORTH);
        panel1.add(sc,BorderLayout.CENTER);
        panel1.repaint();

    }

    public void mostrarExcepcion(String string) {
        JOptionPane.showMessageDialog(this, string);
    }

    public void mostrarProyectos(List<ProyectoVo> proyectos) {
        panel1.removeAll();
        panel1.revalidate();
        model = new DefaultTableModel();
        table = new JTable(model);
        table.setEnabled(false);
        model.addColumn("ID_Proyecto");
        model.addColumn("Constructora");
        model.addColumn("Nùmero_Habitaciones");
        model.addColumn("Ciudad");
        for (ProyectoVo p : proyectos) {
            Object[] fila = new Object[4];
            fila[0] = p.getId();
            fila[1] = p.getConstructora();
            fila[2] = p.getNumero_habitaciones();
            fila[3] = p.getCiudad();
            model.addRow(fila);;
            

            
        }
        sc = new JScrollPane(table);
        panel1.add(new JLabel("Proyectos"),BorderLayout.NORTH);
        panel1.add(sc,BorderLayout.CENTER);
        panel1.repaint();
    }

    public void mostrarCompras(List<ComprasVo> compras) {
        panel1.removeAll();
        panel1.revalidate();
        model = new DefaultTableModel();
        table = new JTable(model);
        table.setEnabled(false);
        model.addColumn("ID_Proyecto");
        model.addColumn("Constructora");
        model.addColumn("Banco Vinculado");
        for (ComprasVo c : compras) {
            Object[] fila = new Object[3];
            fila[0] = c.getId();
            fila[1] = c.getConstructora();
            fila[2] = c.getBancoVinculado();
            model.addRow(fila);;
            

            
        }
        sc = new JScrollPane(table);
        panel1.add(new JLabel("Compras"),BorderLayout.NORTH);
        panel1.add(sc,BorderLayout.CENTER);
        panel1.repaint();
    }

}
