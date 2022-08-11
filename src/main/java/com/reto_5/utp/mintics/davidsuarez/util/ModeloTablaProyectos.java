/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto_5.utp.mintics.davidsuarez.util;

import com.reto_5.utp.mintics.davidsuarez.model.vo.ProyectoVo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author joses
 */
public class ModeloTablaProyectos extends AbstractTableModel {

    private List<ProyectoVo> datos;

    public ModeloTablaProyectos() {
        this.datos = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int row, int colum) {
        var proyecto = datos.get(row);
        switch (colum) {
            case 0:
                return proyecto.getId();
            case 1:
                return proyecto.getConstructora();
            case 2:
                return proyecto.getNumero_habitaciones();
            case 3:
                return proyecto.getCiudad();
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
             switch (columnIndex) {
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return Integer.class;
            case 3:
                return String.class;
        }
        return super.getColumnClass(columnIndex); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    @Override
    public String getColumnName(int column) {
                switch (column) {
            case 0:
                return "id";
            case 1:
                return "Constructora";
            case 2:
                return "Numero de habitaciones";
            case 3:
                return "Ciudad";
        }
        return super.getColumnName(column); //To change body of generated methods, choose Tools | Templates.
    }
    

    public void setDatos(List<ProyectoVo> proyectos) {
        this.datos = proyectos;
    }

}
