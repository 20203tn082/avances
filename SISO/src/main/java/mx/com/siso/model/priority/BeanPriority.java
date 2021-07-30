package mx.com.siso.model.priority;

public class BeanPriority {
    private int idPriority;
    private  String namePriority;

    public BeanPriority() {
    }

    public BeanPriority(int idPriority, String namePriority) {
        this.idPriority = idPriority;
        this.namePriority = namePriority;
    }

    public int getIdPriority() {
        return idPriority;
    }

    public void setIdPriority(int idPriority) {
        this.idPriority = idPriority;
    }

    public String getNamePriority() {
        return namePriority;
    }

    public void setNamePriority(String namePriority) {
        this.namePriority = namePriority;
    }
}
