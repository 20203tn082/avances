package mx.com.siso.model.department;

import mx.com.siso.model.user_type.BeanUser_type;
import mx.com.siso.model.users.BeanUsers;
import mx.com.siso.service.ConnectionMySQL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoDepartment {
    Connection con;
    CallableStatement cstm;
    ResultSet rs;

    public List<BeanDepartment> findDepartment() {
        List<BeanDepartment> listDepartment = new ArrayList<>();
        try {
            // SELECT * FROM users AS U INNER JOIN persons AS P ON U.idPerson = P.id INNER JOIN roles AS R ON U.idRole = R.id;
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call find_department}");
            rs = cstm.executeQuery();

            while (rs.next()) {
                BeanDepartment beanDepartment = new BeanDepartment();

                beanDepartment.setIdDepartment(rs.getInt("department_id"));
                beanDepartment.setNameDepartment(rs.getString("department_name"));
                beanDepartment.setDescription(rs.getString("description"));
                beanDepartment.setTelephoneNumber(rs.getString("phone_number"));
                beanDepartment.setCurrentDepartment(rs.getInt("department_status"));


                listDepartment.add(beanDepartment);
            }
        } catch (SQLException e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        } finally {
            ConnectionMySQL.closeConnection(con, cstm, rs);
        }
        return listDepartment;
    }

    public boolean create(BeanDepartment department) throws SQLException {
        boolean flag = false;
        try {
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call create_department(?,?,?,?)}");
            cstm.setString(1, department.getNameDepartment());
            cstm.setString(2, department.getDescription());
            cstm.setString(3, department.getTelephoneNumber());
            cstm.registerOutParameter(4, java.sql.Types.INTEGER);
            flag = cstm.execute();

            int error = cstm.getInt(4);
            if (error == 1) {
                System.out.println("El departamento ya existe");
            } else {
                System.out.println("Se registro correctamente");
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } finally {
            ConnectionMySQL.closeConnection(con, cstm);
        }
        return flag;
    }

    public BeanDepartment findDepartmentById(long id) {
        BeanDepartment beanDepartment = null;
        try {
            // SELECT * FROM users AS U INNER JOIN persons AS P ON U.idPerson = P.id INNER JOIN roles AS R ON U.idRole = R.id;
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call find_department_byId(?)}");
            cstm.setLong(1, id);
            rs = cstm.executeQuery();

            if (rs.next()) {
                beanDepartment = new BeanDepartment();

                beanDepartment.setIdDepartment(rs.getInt("department_id"));
                beanDepartment.setNameDepartment(rs.getString("department_name"));
                beanDepartment.setDescription(rs.getString("description"));
                beanDepartment.setTelephoneNumber(rs.getString("phone_number"));


            }
        } catch (SQLException e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        } finally {
            ConnectionMySQL.closeConnection(con, cstm, rs);
        }
        return beanDepartment;
    }

    public boolean update(BeanDepartment department) throws SQLException {
        boolean flag = false;
        try {
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call  modify_department(?,?,?,?,?,?,?)}");
            cstm.setInt(1, department.getIdDepartment());
            cstm.setString(2, department.getNameDepartment());
            cstm.setString(3, department.getDescription());
            cstm.setString(4, department.getTelephoneNumber());
            cstm.registerOutParameter(5, java.sql.Types.INTEGER);
            cstm.registerOutParameter(6, java.sql.Types.INTEGER);
            cstm.registerOutParameter(7, java.sql.Types.INTEGER);

            flag = cstm.execute();
            int errorCurrent = cstm.getInt(5);
            int errorName = cstm.getInt(6);
            int succes = cstm.getInt(7);
            if(succes==1){
                System.out.println("Se modifico correctamente");
            }else{
                if(errorCurrent==1){
                    System.out.println("El departamento no existe");
                }else{
                    if(errorName==1){
                        System.out.println("El nombre ya existe");
                    }

                }
            }
        } catch (SQLException e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        } finally {
            ConnectionMySQL.closeConnection(con, cstm);
        }
        return flag;
    }

    public boolean delete(BeanDepartment department) throws SQLException {
        boolean flag = false;
        try{
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call delete_department(?,?)}");
            cstm.setInt(1, department.getIdDepartment());
            cstm.registerOutParameter(2, java.sql.Types.INTEGER);
            flag = cstm.execute();
            int errorCurrent = cstm.getInt(2);
            if(errorCurrent==0){
                System.out.println("El departamento se eliminó correctamente");
            }else {
                System.out.println("El departamento no existe");
            }

        }catch(SQLException e){
            System.out.println("Error: " + e);
        }finally{
            ConnectionMySQL.closeConnection(con, cstm);
        }
        return flag;
    }
}
