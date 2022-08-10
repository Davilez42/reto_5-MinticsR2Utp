package com.reto_5.utp.mintics.davidsuarez.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.reto_5.utp.mintics.davidsuarez.model.vo.LiderVo;
import com.reto_5.utp.mintics.davidsuarez.util.JDBCutilites;

public class LiderDao {

    public List<LiderVo> obtenerReporte() throws SQLException {
        Connection connection = null;
        List<LiderVo> respuesta = null;
        PreparedStatement statement = null;
        ResultSet rst = null;
        try {
            connection = JDBCutilites.getConnection();
            statement = connection.prepareStatement("SELECT ID_Lider,Nombre,Primer_apellido,Ciudad_Residencia FROM Lider order by Ciudad_Residencia ASC");
            respuesta = new ArrayList<>();

            rst = statement.executeQuery();
            while (rst.next()) {
                var lider = new LiderVo(rst.getInt("ID_Lider"));
                lider.setCiudad_Residencia(rst.getString("Ciudad_Residencia"));
                lider.setNombre(rst.getString("Nombre"));
                lider.setPrimer_Apellido(rst.getString("Primer_apellido"));
                respuesta.add(lider);
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
