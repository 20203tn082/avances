package mx.com.siso.model.users;
import mx.com.siso.model.department.BeanDepartment;
import mx.com.siso.model.user_type.BeanUser_type;

import java.util.Date;

public class BeanUsers {
    private int id_user;
    private String nameUser;
    private String passwordUser;
    private String name;
    private String lastname1;
    private String lastname2;
    private String email;
    private int currentUser;
    private String token;
    private Date hour_token;
    private BeanDepartment department_id;
    private BeanUser_type type_id;

    public BeanUsers() {
    }

    public BeanUsers(int id_user, String nameUser, String passwordUser, String name, String lastname1, String lastname2, String email, int currentUser, String token, Date hour_token, BeanDepartment department_id, BeanUser_type type_id) {
        this.id_user = id_user;
        this.nameUser = nameUser;
        this.passwordUser = passwordUser;
        this.name = name;
        this.lastname1 = lastname1;
        this.lastname2 = lastname2;
        this.email = email;
        this.currentUser = currentUser;
        this.token = token;
        this.hour_token = hour_token;
        this.department_id = department_id;
        this.type_id = type_id;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname1() {
        return lastname1;
    }

    public void setLastname1(String lastname1) {
        this.lastname1 = lastname1;
    }

    public String getLastname2() {
        return lastname2;
    }

    public void setLastname2(String lastname2) {
        this.lastname2 = lastname2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(int currentUser) {
        this.currentUser = currentUser;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getHour_token() {
        return hour_token;
    }

    public void setHour_token(Date hour_token) {
        this.hour_token = hour_token;
    }

    public BeanDepartment getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(BeanDepartment department_id) {
        this.department_id = department_id;
    }

    public BeanUser_type getType_id() {
        return type_id;
    }

    public void setType_id(BeanUser_type type_id) {
        this.type_id = type_id;
    }
}
