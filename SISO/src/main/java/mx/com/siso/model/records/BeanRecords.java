package mx.com.siso.model.records;

import mx.com.siso.model.department.BeanDepartment;
import mx.com.siso.model.priority.BeanPriority;
import mx.com.siso.model.users.BeanUsers;

import java.io.InputStream;
import java.sql.Timestamp;
import java.util.Date;

public class BeanRecords {
    private int id_minutes;
    private InputStream fileMinutes;
    private int attended;
    private Timestamp dateChannelling;
    private Timestamp dateAssignment;
    private Timestamp dateResponse;
    private String comment;
    private int currentMinutes;
    private BeanDepartment departmentId;
    private BeanUsers userId;
    private BeanPriority priorityId;

    public BeanRecords() {
    }

    public BeanRecords(int id_minutes, InputStream fileMinutes, int attended, Timestamp dateChannelling, Timestamp dateAssignment, Timestamp dateResponse, String comment, int currentMinutes, BeanDepartment departmentId, BeanUsers userId, BeanPriority priorityId) {
        this.id_minutes = id_minutes;
        this.fileMinutes = fileMinutes;
        this.attended = attended;
        this.dateChannelling = dateChannelling;
        this.dateAssignment = dateAssignment;
        this.dateResponse = dateResponse;
        this.comment = comment;
        this.currentMinutes = currentMinutes;
        this.departmentId = departmentId;
        this.userId = userId;
        this.priorityId = priorityId;
    }

    public int getId_minutes() {
        return id_minutes;
    }

    public void setId_minutes(int id_minutes) {
        this.id_minutes = id_minutes;
    }

    public InputStream getFileMinutes() {
        return fileMinutes;
    }

    public void setFileMinutes(InputStream fileMinutes) {
        this.fileMinutes = fileMinutes;
    }

    public int getAttended() {
        return attended;
    }

    public void setAttended(int attended) {
        this.attended = attended;
    }

    public Date getDateChannelling() {
        return dateChannelling;
    }

    public void setDateChannelling(Timestamp dateChannelling) {
        this.dateChannelling = dateChannelling;
    }

    public Date getDateAssignment() {
        return dateAssignment;
    }

    public void setDateAssignment(Timestamp dateAssignment) {
        this.dateAssignment = dateAssignment;
    }

    public Date getDateResponse() {
        return dateResponse;
    }

    public void setDateResponse(Timestamp dateResponse) {
        this.dateResponse = dateResponse;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getCurrentMinutes() {
        return currentMinutes;
    }

    public void setCurrentMinutes(int currentMinutes) {
        this.currentMinutes = currentMinutes;
    }

    public BeanDepartment getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(BeanDepartment departmentId) {
        this.departmentId = departmentId;
    }

    public BeanUsers getUserId() {
        return userId;
    }

    public void setUserId(BeanUsers userId) {
        this.userId = userId;
    }

    public BeanPriority getPriorityId() {
        return priorityId;
    }

    public void setPriorityId(BeanPriority priorityId) {
        this.priorityId = priorityId;
    }
}