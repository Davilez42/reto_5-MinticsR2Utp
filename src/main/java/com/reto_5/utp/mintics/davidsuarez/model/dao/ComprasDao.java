package com.reto_5.utp.mintics.davidsuarez.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.reto_5.utp.mintics.davidsuarez.model.vo.ComprasVo;
import com.reto_5.utp.mintics.davidsuarez.util.JDBCutilites;

public class ComprasDao {

    public List<ComprasVo> obtenerReporte() throws SQLException {
        Connection connection = null;
        List<ComprasVo> respuesta = null;
        PreparedStatement statement = null;
        ResultSet rst = null;
        try {
            connection = JDBCutilites.getConnection();
            statement = connection.prepareStatement("SELECT ID_Compra ,p.Constructora ,p.Banco_Vinculado "
                    + "from Compra c"
                    + " join Proyecto p using(ID_Proyecto)"
                    + " where Proveedor = 'Homecenter' and p.Ciudad ='Salento';");
            respuesta = new ArrayList<>();

            rst = statement.executeQuery();
            while (rst.next()) {
                var compra = new ComprasVo(rst.getInt("ID_Compra"));
                compra.setConstructora(rst.getString("Constructora"));
                compra.setBancoVinculado(rst.getString("Banco_Vinculado"));
                respuesta.add(compra);

            }

        } finally {
            if (connection != null) {
                connection.close();
            }
            if (rst != null) {
                rst.close();
            }

        }
        return respuesta;
    }

}
