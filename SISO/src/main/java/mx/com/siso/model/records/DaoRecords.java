package mx.com.siso.model.records;

import mx.com.siso.model.department.BeanDepartment;
import mx.com.siso.model.priority.BeanPriority;
import mx.com.siso.model.users.BeanUsers;
import mx.com.siso.service.ConnectionMySQL;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoRecords {
    Connection con;
    CallableStatement cstm;
    ResultSet rs;

    public List<BeanRecords> findAllRecords(int idUser){
        List<BeanRecords> listMinutes = new ArrayList<>();
        try {
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call view_records(?,?)}");
            cstm.setInt(1, idUser);
            cstm.registerOutParameter(2, java.sql.Types.INTEGER);
            rs = cstm.executeQuery();
            int errorUser  = cstm.getInt(2);
            if(errorUser==0){
                System.out.println("Consulta exitosa");
            }else{
                System.out.println("El usuario no existe");
            }

            while(rs.next()){
                BeanUsers beanUsers =new BeanUsers();
                BeanDepartment beanDepartment = new BeanDepartment();
                BeanPriority beanPriority = new BeanPriority();
                BeanRecords beanRecords = new BeanRecords();

                beanPriority.setIdPriority(rs.getInt("priority_id"));
                beanPriority.setNamePriority(rs.getString("priority_name"));
                beanDepartment.setIdDepartment(rs.getInt("department_id"));
                beanDepartment.setNameDepartment(rs.getString("department_name"));
                beanUsers.setName(rs.getString("name"));
                beanUsers.setId_user(rs.getInt("user_id"));
                beanRecords.setDateChannelling(rs.getTimestamp("channelling_date"));
                beanRecords.setDateAssignment(rs.getTimestamp("assignment_date"));
                beanRecords.setId_minutes(rs.getInt("records_id"));
                beanRecords.setAttended(rs.getInt("attended"));
                beanRecords.setDepartmentId(beanDepartment);
                beanRecords.setUserId(beanUsers);
                beanRecords.setPriorityId(beanPriority);


                listMinutes.add(beanRecords);
            }
        }catch (SQLException e){
            System.out.printf("Ha ocurrido un error: " + e.getMessage());
        } finally {
            ConnectionMySQL.closeConnection(con, cstm, rs);
        }
        return listMinutes;
    }

    public List<BeanRecords> findRecordsByAssistant(int idUser){
        List<BeanRecords> listMinutes = new ArrayList<>();
        try {
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call view_records(?,?)}");
            cstm.setInt(1, idUser);
            cstm.registerOutParameter(2, java.sql.Types.INTEGER);
            rs = cstm.executeQuery();
            int errorUser  = cstm.getInt(2);
            if(errorUser==0){
                System.out.println("Consulta exitosa");
            }else{
                System.out.println("El usuario no existe");
            }

            while(rs.next()){
                BeanUsers beanUsers =new BeanUsers();
                BeanDepartment beanDepartment = new BeanDepartment();
                BeanPriority beanPriority = new BeanPriority();
                BeanRecords beanRecords = new BeanRecords();

                beanPriority.setIdPriority(rs.getInt("priority_id"));
                beanPriority.setNamePriority(rs.getString("priority_name"));
                beanDepartment.setIdDepartment(rs.getInt("department_id"));
                beanDepartment.setNameDepartment(rs.getString("department_name"));
                beanRecords.setDateChannelling(rs.getTimestamp("channelling_date"));
                beanRecords.setDateAssignment(rs.getTimestamp("assignment_date"));
                beanRecords.setId_minutes(rs.getInt("records_id"));
                beanRecords.setAttended(rs.getInt("attended"));
                beanRecords.setDepartmentId(beanDepartment);
                beanRecords.setUserId(beanUsers);
                beanRecords.setPriorityId(beanPriority);


                listMinutes.add(beanRecords);
            }
        }catch (SQLException e){
            System.out.printf("Ha ocurrido un error: " + e.getMessage());
        } finally {
            ConnectionMySQL.closeConnection(con, cstm, rs);
        }
        return listMinutes;
    }
    public boolean createRecord(BeanRecords minute) throws SQLException {
        boolean flag = false;
        try {
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call create_records(?,?,?,?,?)}");
            cstm.setBlob(1, minute.getFileMinutes());
            cstm.setInt(2,minute.getDepartmentId().getIdDepartment());
            cstm.setInt(3,minute.getPriorityId().getIdPriority());
            cstm.registerOutParameter(4, java.sql.Types.INTEGER);
            cstm.registerOutParameter(5, java.sql.Types.INTEGER);
            flag = cstm.execute();
            int errorDepartament = cstm.getInt(4);
            int errorPriority = cstm.getInt(5);
            if(errorDepartament==0 && errorPriority==0){
                System.out.println("Se registro correctamente");
            }else{
                if(errorDepartament==1){
                    System.out.println("El departamento no existe");
                }
                if(errorPriority==1){
                    System.out.println("La prioridad no existe");
                }
            }
        }catch (SQLException e){
            System.out.printf("Ha ocurrido un error: " + e.getMessage());
        } finally {
            con.close();
        }
        return flag;
    }

    public byte[]  findRecordsById(int id){
        byte[] b = null;
        byte[] datosPDF = null;
        try {
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call  find_record_byId(?)}");
            cstm.setLong(1, id);
            rs = cstm.executeQuery();

            if(rs.next()){
                b = rs.getBytes(1);
            }
            InputStream bos = new ByteArrayInputStream(b);

            int tamanoInput = bos.available();
            datosPDF = new byte[tamanoInput];
            bos.read(datosPDF, 0, tamanoInput);

        }catch (SQLException | IOException e){
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        } finally {
            ConnectionMySQL.closeConnection(con, cstm, rs);
        }
        return datosPDF;
    }
    public boolean assignRecord(BeanRecords records) throws SQLException {
        boolean flag = false;
        try {
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call assign_record(?,?,?,?,?)}");
            cstm.setInt(1,records.getId_minutes());
            cstm.setString(2,records.getUserId().getNameUser());
            cstm.registerOutParameter(3, java.sql.Types.INTEGER);
            cstm.registerOutParameter(4, java.sql.Types.INTEGER);
            cstm.registerOutParameter(5, java.sql.Types.INTEGER);
            cstm.execute();
            int errorUser = cstm.getInt(3);
            int errorRecord = cstm.getInt(4);
            int errorAssignment = cstm.getInt(5);
            if(errorUser==0 && errorRecord==0 && errorAssignment == 0) {
                flag = true;
            }else{
                flag = false;
            }
        }catch (SQLException e){
            System.out.printf("Ha ocurrido un error: " + e.getMessage());
        } finally {
            con.close();
        }
        return flag;
    }
    public List<BeanRecords> findAllRecordsByManager(int idUser){
        List<BeanRecords> listMinutes = new ArrayList<>();
        try {
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call view_records(?,?)}");
            cstm.setInt(1, idUser);
            cstm.registerOutParameter(2, java.sql.Types.INTEGER);
            rs = cstm.executeQuery();
            int errorUser  = cstm.getInt(2);
            if(errorUser==0){
                System.out.println("Consulta exitosa");
            }else{
                System.out.println("El usuario no existe");
            }

            while(rs.next()){
                BeanUsers beanUsers =new BeanUsers();
                BeanDepartment beanDepartment = new BeanDepartment();
                BeanPriority beanPriority = new BeanPriority();
                BeanRecords beanRecords = new BeanRecords();

                beanPriority.setIdPriority(rs.getInt("priority_id"));
                beanPriority.setNamePriority(rs.getString("priority_name"));
                beanUsers.setName(rs.getString("name"));
                beanUsers.setId_user(rs.getInt("user_id"));
                beanRecords.setDateChannelling(rs.getTimestamp("channelling_date"));
                beanRecords.setDateAssignment(rs.getTimestamp("assignment_date"));
                beanRecords.setId_minutes(rs.getInt("records_id"));
                beanRecords.setAttended(rs.getInt("attended"));
                beanRecords.setDepartmentId(beanDepartment);
                beanRecords.setUserId(beanUsers);
                beanRecords.setPriorityId(beanPriority);


                listMinutes.add(beanRecords);
            }
        }catch (SQLException e){
            System.out.printf("Ha ocurrido un error: " + e.getMessage());
        } finally {
            ConnectionMySQL.closeConnection(con, cstm, rs);
        }
        return listMinutes;
    }
    public List<BeanRecords> findAllRecords(){
        List<BeanRecords> listMinutes = new ArrayList<>();
        try {
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call find_records_byOfi}");

            rs = cstm.executeQuery();


            while(rs.next()){
                BeanUsers beanUsers =new BeanUsers();
                BeanDepartment beanDepartment = new BeanDepartment();
                BeanPriority beanPriority = new BeanPriority();
                BeanRecords beanRecords = new BeanRecords();

                beanPriority.setIdPriority(rs.getInt("priority_id"));
                beanPriority.setNamePriority(rs.getString("priority_name"));
                beanDepartment.setIdDepartment(rs.getInt("department_id"));
                beanDepartment.setNameDepartment(rs.getString("department_name"));
                beanUsers.setName(rs.getString("name"));
                beanUsers.setId_user(rs.getInt("user_id"));
                beanRecords.setDateChannelling(rs.getTimestamp("channelling_date"));
                beanRecords.setDateAssignment(rs.getTimestamp("assignment_date"));
                beanRecords.setId_minutes(rs.getInt("records_id"));
                beanRecords.setAttended(rs.getInt("attended"));
                beanRecords.setDepartmentId(beanDepartment);
                beanRecords.setUserId(beanUsers);
                beanRecords.setPriorityId(beanPriority);


                listMinutes.add(beanRecords);
            }
        }catch (SQLException e){
            System.out.printf("Ha ocurrido un error: " + e.getMessage());
        } finally {
            ConnectionMySQL.closeConnection(con, cstm, rs);
        }
        return listMinutes;
    }


}
