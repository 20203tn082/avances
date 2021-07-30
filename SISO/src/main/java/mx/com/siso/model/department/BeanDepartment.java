package mx.com.siso.model.department;

public class BeanDepartment {
    private int idDepartment;
    private String nameDepartment;
    private String description;
    private String telephoneNumber;
    private int currentDepartment;

    public BeanDepartment() {
    }

    public BeanDepartment(int idDepartment, String nameDepartment, String description, String telephoneNumber, int currentDepartment) {
        this.idDepartment = idDepartment;
        this.nameDepartment = nameDepartment;
        this.description = description;
        this.telephoneNumber = telephoneNumber;
        this.currentDepartment = currentDepartment;
    }

    public int getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(int idDepartment) {
        this.idDepartment = idDepartment;
    }

    public String getNameDepartment() {
        return nameDepartment;
    }

    public void setNameDepartment(String nameDepartment) {
        this.nameDepartment = nameDepartment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public int getCurrentDepartment() {
        return currentDepartment;
    }

    public void setCurrentDepartment(int currentDepartment) {
        this.currentDepartment = currentDepartment;
    }
}
