package mx.com.siso.model.superadministrador;

public class BeanSuperadministrador {
    private String nameAdmin;
    private String passwordAdmin;

    public BeanSuperadministrador() {
    }

    public BeanSuperadministrador(String nameAdmin, String passwordAdmin) {
        this.nameAdmin = nameAdmin;
        this.passwordAdmin = passwordAdmin;
    }

    public String getNameAdmin() {
        return nameAdmin;
    }

    public void setNameAdmin(String nameAdmin) {
        this.nameAdmin = nameAdmin;
    }

    public String getPasswordAdmin() {
        return passwordAdmin;
    }

    public void setPasswordAdmin(String passwordAdmin) {
        this.passwordAdmin = passwordAdmin;
    }
}
