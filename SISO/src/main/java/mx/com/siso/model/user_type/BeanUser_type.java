package mx.com.siso.model.user_type;

public class BeanUser_type {
    private int idType;
    private String nameType;

    public BeanUser_type() {
    }

    public BeanUser_type(int idType, String nameType) {
        this.idType = idType;
        this.nameType = nameType;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }
}
