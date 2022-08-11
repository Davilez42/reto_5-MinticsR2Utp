/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto_5.utp.mintics.davidsuarez.util;

import com.reto_5.utp.mintics.davidsuarez.model.vo.ComprasVo;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author joses
 */
public class ModeloTablaCompras extends AbstractTableModel {

    List<ComprasVo> datos;

    public ModeloTablaCompras() {
        this.datos = new ArrayList<>();
    }

    public void setDatos(List<ComprasVo> datos) {
        this.datos = datos;
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int row, int colum) {
        var compra = datos.get(row);
        switch (colum) {
            case 0:
                return compra.getId();
            case 1:
                return compra.getConstructora();
            case 2:
                return compra.getBancoVinculado();
        }
return null;
    }

    @Override
    public String getColumnName(int colum) {
         switch (colum) {
            case 0:
                return "id";
            case 1:
                return "Constructora";
            case 2:
                return "Banco Vinculado";
        }
        return super.getColumnName(colum); //To change body of generated methods, choose Tools | Templates.
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
        }
        return super.getColumnClass(columnIndex); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
