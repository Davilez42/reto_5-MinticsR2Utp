package com.reto_5.utp.mintics.davidsuarez.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.reto_5.utp.mintics.davidsuarez.model.vo.ProyectoVo;
import com.reto_5.utp.mintics.davidsuarez.util.JDBCutilites;

public class ProyectoDao {

    public List<ProyectoVo> obtenerReporte() throws SQLException {
        Connection connection = null;
        List<ProyectoVo> respuesta = null;
        PreparedStatement statement = null;
        ResultSet rst = null;
        try {
            connection = JDBCutilites.getConnection();
            statement = connection.prepareStatement("SELECT ID_Proyecto,Constructora ,Numero_Habitaciones ,Ciudad "
            +" from Proyecto p" 
            +" WHERE Ciudad  in('Santa Marta','Cartagena','Barranquilla') and Clasificacion = 'Casa Campestre';");
            respuesta = new ArrayList<>();

            rst = statement.executeQuery();
            while (rst.next()) {
                var proyecto = new ProyectoVo(rst.getInt("ID_Proyecto"));
                proyecto.setCiudad(rst.getString("Ciudad"));
                proyecto.setConstructora(rst.getString("Constructora"));
                proyecto.setNumero_habitaciones(rst.getInt("Numero_Habitaciones"));
                respuesta.add(proyecto);
              
            }

        } finally {
            if (connection != null) {
                connection.close();
            }
            if(rst!=null){
                rst.close();
            }
          

        }
        return respuesta;
    }
    
}
