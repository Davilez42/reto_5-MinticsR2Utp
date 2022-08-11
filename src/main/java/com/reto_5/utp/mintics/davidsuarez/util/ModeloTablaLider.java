/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto_5.utp.mintics.davidsuarez.util;

import com.reto_5.utp.mintics.davidsuarez.model.vo.LiderVo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author joses
 */
public class ModeloTablaLider extends AbstractTableModel {

    List<LiderVo> datos;
    
    public ModeloTablaLider() {
        datos = new ArrayList<>();
    }
    //Metodos Propios

    public List<LiderVo> getDatos() {
        return datos;
    }

    public void setDatos(List<LiderVo> datos) {
        this.datos = datos;
        fireTableDataChanged();
    }
    public void setDato(LiderVo lider) {
        this.datos.add(lider);
        var row = getRowCount()-1;
        fireTableRowsInserted(row, row);
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
        var lider = datos.get(row);
        switch (colum) {
            case 0:
                return lider.getId();
            case 1:
                return lider.getNombre();
            case 2:
                return lider.getPrimer_Apellido();
            case 3:
                return lider.getCiudad_Residencia();

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
                return String.class;
                      
            case 3:
                return String.class;

        }
        return super.getColumnClass(columnIndex); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    @Override
    public String getColumnName(int colum) {
        
        switch (colum) {
            case 0:
                return "Id";
            case 1:
                return "Nombre";
            case 2:
                return "Primer Apellido";
                      
            case 3:
                return "Ciudad Residencia";

        }
        
        return super.getColumnName(colum); //To change body of generated methods, choose Tools | Templates.
    }
    

}
