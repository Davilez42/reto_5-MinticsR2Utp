/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto_5.utp.mintics.davidsuarez.controller;

import com.reto_5.utp.mintics.davidsuarez.model.dao.ComprasDao;
import com.reto_5.utp.mintics.davidsuarez.model.dao.LiderDao;
import com.reto_5.utp.mintics.davidsuarez.model.dao.ProyectoDao;
import com.reto_5.utp.mintics.davidsuarez.model.vo.ComprasVo;
import com.reto_5.utp.mintics.davidsuarez.model.vo.LiderVo;
import com.reto_5.utp.mintics.davidsuarez.model.vo.ProyectoVo;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author joses
 */
public class AppControllerGui {
    private LiderDao liderdao;
    private ComprasDao comprasdao;
    private ProyectoDao proyectodao; 

    public AppControllerGui() {
    this.liderdao = new LiderDao();
    this.comprasdao = new ComprasDao();
    this.proyectodao = new ProyectoDao();
    }
    
    public List<LiderVo> obtenerInformeLideres() throws SQLException{
        return liderdao.obtenerReporte();
    }
    
    public List<ComprasVo> obtenerInformeCompras() throws SQLException{
        return comprasdao.obtenerReporte();
    }
     public List<ProyectoVo> obtenerInformeProyectos() throws SQLException{
        return proyectodao.obtenerReporte();
    }
    
}
