package mx.com.siso.controler;

import mx.com.siso.model.department.BeanDepartment;
import mx.com.siso.model.department.DaoDepartment;
import mx.com.siso.model.records.BeanRecords;
import mx.com.siso.model.records.DaoRecords;
import mx.com.siso.model.priority.BeanPriority;
import mx.com.siso.model.priority.DaoPriority;
import mx.com.siso.model.users.BeanUsers;
import mx.com.siso.model.users.DaoUsers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name = "ServletRecords", value = "/ServletRecords")
@MultipartConfig(maxFileSize = 16177215)
public class ServletRecords extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        switch(action) {
            case "upload":
            request.setAttribute("listDepartment", new DaoDepartment().findDepartment());
            request.setAttribute("listPriority", new DaoPriority().findPriority());
            request.getRequestDispatcher("/views/records/uploadRecord.jsp").forward(request, response);
            break;
            case "assign":
                request.setAttribute("listAssistant", new DaoUsers().findAllAssitant());
                request.getSession().setAttribute("idRecords",request.getParameter("id")!= null ? request.getParameter("id") : "");
                request.getRequestDispatcher("/views/records/assignRecord.jsp").forward(request, response);
                break;
            case "records":
                request.setAttribute("listMinutes", new DaoRecords().findAllRecords());
                request.getRequestDispatcher("/views/users/mainOficialia.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        switch(action) {
            case "insert":
                int department = Integer.parseInt(request.getParameter("departmentId")!= null ? request.getParameter("departmentId") : "");
                int priority = Integer.parseInt(request.getParameter("priorityId")!= null ? request.getParameter("priorityId") : "");
                BeanDepartment beanDepartment = new BeanDepartment(department, "", "","",0);
                BeanPriority beanPriority = new BeanPriority(priority, "");
                InputStream inputStream = null;
                System.out.println(department);
                int resultado[] = new int[2];
                String nameUser2 = (String) request.getSession().getAttribute("usuariom");
                String password2 = (String) request.getSession().getAttribute("contram");

                BeanUsers beanUsers3 = new BeanUsers(0, nameUser2, password2, "", "", "","",0, "", null, null, null);
                System.out.println(priority);
                try {
                    Part filePart = request.getPart("archivo");
                    resultado = new DaoUsers().login(beanUsers3);
                    if (filePart.getSize() > 0) {
                        System.out.println(filePart.getName());
                        System.out.println(filePart.getSize());
                        System.out.println(filePart.getContentType());
                        inputStream = filePart.getInputStream();
                        BeanRecords beanRecords = new BeanRecords(0, inputStream, 0, null, null, null,"", 0, beanDepartment, null, beanPriority);
                        if(new DaoRecords().createRecord(beanRecords)){
                            System.out.println("Se inserto");
                        }else{
                            System.out.println("No se inserto");
                        }
                    }
                } catch (Exception ex) {
                    System.out.println("fichero: "+ ex.getMessage());
                }
                request.setAttribute("listMinutes", new DaoRecords().findAllRecords(resultado[0]));
                request.getRequestDispatcher("/views/users/mainOficialia.jsp").forward(request, response);
                break;
            case "getRecordById":
                response.setContentType("application/pdf");
                int recordId = Integer.parseInt(request.getParameter("id") != null ? request.getParameter("id") : "");

                response.getOutputStream().write(new DaoRecords().findRecordsById(recordId));
                break;
            case "assign":
                String username = request.getParameter("assistant") != null ? request.getParameter("assistant") : "";
                int id = Integer.parseInt(request.getParameter("id") != null ? request.getParameter("id") : "");
                BeanUsers beanUsers = new BeanUsers(0, username, "", "", "", "", "", 0, "", null, null, null);
                BeanRecords beanRecords = new BeanRecords(id, null, 0, null, null, null, "", 0, null, beanUsers, null);
                try {
                    if (new DaoRecords().assignRecord(beanRecords)){
                        System.out.println("Se asignó");
                    } else{
                        System.out.println("No se asignó");
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                int resultado2[] = new int[2];
                String nameUser3 = (String) request.getSession().getAttribute("usuariom1");
                String password3 = (String) request.getSession().getAttribute("contram1");

                BeanUsers beanUsers4 = new BeanUsers(0, nameUser3, password3, "", "", "","",0, "", null, null, null);
                try {
                    resultado2 = new DaoUsers().login(beanUsers4);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

                request.setAttribute("listMinutes", new DaoRecords().findAllRecordsByManager(resultado2[0]));
                request.getRequestDispatcher("/views/users/mainManager.jsp").forward(request, response);
                break;
            default:

        }
    }
}