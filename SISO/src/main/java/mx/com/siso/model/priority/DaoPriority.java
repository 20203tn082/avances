package mx.com.siso.model.priority;

import mx.com.siso.model.department.BeanDepartment;
import mx.com.siso.service.ConnectionMySQL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoPriority {
    Connection con;
    CallableStatement cstm;
    ResultSet rs;
    public List<BeanPriority> findPriority() {
        List<BeanPriority> listPriority = new ArrayList<>();
        try {
            // SELECT * FROM users AS U INNER JOIN persons AS P ON U.idPerson = P.id INNER JOIN roles AS R ON U.idRole = R.id;
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call find_priority}");
            rs = cstm.executeQuery();

            while (rs.next()) {
                BeanPriority beanPriority = new BeanPriority();

                beanPriority.setIdPriority(rs.getInt("priority_id"));
                beanPriority.setNamePriority(rs.getString("priority_name"));


                listPriority.add(beanPriority);
            }
        } catch (SQLException e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        } finally {
            ConnectionMySQL.closeConnection(con, cstm, rs);
        }
        return listPriority;
    }

}
