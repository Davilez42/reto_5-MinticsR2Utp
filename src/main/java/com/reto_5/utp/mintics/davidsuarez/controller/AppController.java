package com.reto_5.utp.mintics.davidsuarez.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;

import com.reto_5.utp.mintics.davidsuarez.model.dao.ComprasDao;
import com.reto_5.utp.mintics.davidsuarez.model.dao.LiderDao;
import com.reto_5.utp.mintics.davidsuarez.model.dao.ProyectoDao;
import com.reto_5.utp.mintics.davidsuarez.model.vo.ComprasVo;
import com.reto_5.utp.mintics.davidsuarez.model.vo.LiderVo;
import com.reto_5.utp.mintics.davidsuarez.model.vo.ProyectoVo;
import com.reto_5.utp.mintics.davidsuarez.view.ViewMain;;

public class AppController implements ActionListener, FunctionsController {
    // views
    private ViewMain viewmain;

    /// buttons
    private JButton boton1, boton2, boton3;
    //DAO
    private LiderDao consultaLideres;
    private ProyectoDao consultaProyectos;
    private ComprasDao consultaCompras;
    

    public AppController() {
        viewmain = new ViewMain(this);
        consultaLideres = new LiderDao();
        consultaProyectos = new ProyectoDao();
        consultaCompras  = new ComprasDao();
     
    }

    public void setBoton1(JButton boton1) {
        this.boton1 = boton1;
    }

    public void setBoton2(JButton boton2) {
        this.boton2 = boton2;
    }

    public void setBoton3(JButton boton3) {
        this.boton3 = boton3;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton1) {
            getReportLideres();
        }
        if (e.getSource() == boton2) {
            getReportBuys();
        }
        if (e.getSource() == boton3) {
            getReportProyects();
        }
    }

    public void initApp() {
        viewmain.setVisible(true);
    }

    @Override
    public void getReportLideres() {
        try {

            var lideres = consultaLideres.obtenerReporte();
            viewmain.mostrarLideres(lideres);
        } catch (SQLException e) {
        viewmain.mostrarExcepcion("Error al conectar en la base de datos \n" + e.getClass() + e.getLocalizedMessage());
        }
    }

    @Override
    public void getReportProyects() {
        try {

            var proyectos = consultaProyectos.obtenerReporte();
            viewmain.mostrarProyectos(proyectos);
        } catch (SQLException e) {
        viewmain.mostrarExcepcion("Error al conectar en la base de datos \n" + e.getClass() + e.getLocalizedMessage());
        }

    }

    @Override
    public void getReportBuys() {
        try {

            var proyectos = consultaCompras.obtenerReporte();
            viewmain.mostrarCompras(proyectos);
        } catch (SQLException e) {
        viewmain.mostrarExcepcion("Error al conectar en la base de datos \n" + e.getClass() + e.getLocalizedMessage());
        }

    }

}
