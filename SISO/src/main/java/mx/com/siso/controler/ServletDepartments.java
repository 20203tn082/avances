package mx.com.siso.controler;

import mx.com.siso.model.department.BeanDepartment;
import mx.com.siso.model.department.DaoDepartment;
import mx.com.siso.model.user_type.BeanUser_type;
import mx.com.siso.model.users.BeanUsers;
import mx.com.siso.model.users.DaoUsers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletDepartments", value = "/ServletDepartments")
public class ServletDepartments extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        switch(action) {
            case "departments":
                request.setAttribute("listDepartments", new DaoDepartment().findDepartment());
                request.getRequestDispatcher("/views/department/departments.jsp").forward(request, response);
                break;
            case "register":

                request.getRequestDispatcher("/views/department/register.jsp").forward(request, response);
                break;
            default:
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        switch(action){
            case "create":
                // do something
                String nameDepartment = request.getParameter("nameDepartment") != null ? request.getParameter("nameDepartment") : "";
                String description = request.getParameter("description")!= null ? request.getParameter("description") : "";
                String telephoneNumber = request.getParameter("telephoneNumber")!= null ? request.getParameter("telephoneNumber") : "";

                BeanDepartment beanDepartment = new BeanDepartment(0, nameDepartment, description, telephoneNumber, 0);

                try {
                    if(new DaoDepartment().create(beanDepartment)){
                        request.setAttribute("message", "Departamento registrado correctamente");
                    } else {
                        request.setAttribute("message", "Departamento no registrado");
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

                request.setAttribute("listDepartments", new DaoDepartment().findDepartment());
                request.getRequestDispatcher("/views/department/departments.jsp").forward(request, response);
                break;

            case "getDepartmentById":
                long id = Long.parseLong(request.getParameter("id"));
                request.setAttribute("department", new DaoDepartment().findDepartmentById(id));
                request.getRequestDispatcher("/views/department/update.jsp").forward(request, response);
                break;
            case "update":
                // do something
                int idDepartment = Integer.parseInt(request.getParameter("id")!= null ? request.getParameter("id") : "");
                String nameDepartment1 = request.getParameter("nameDepartment") != null ? request.getParameter("nameDepartment") : "";
                String description1 = request.getParameter("description")!= null ? request.getParameter("description") : "";
                String telephoneNumber1 = request.getParameter("telephoneNumber")!= null ? request.getParameter("telephoneNumber") : "";

                BeanDepartment beanDepartment1 = new BeanDepartment(idDepartment, nameDepartment1, description1, telephoneNumber1, 0);

                try {
                    if(new DaoDepartment().update(beanDepartment1)){
                        request.setAttribute("message", "Departamento actualizado correctamente");
                    } else {
                        request.setAttribute("message", "Departamento no actualizado");
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

                request.setAttribute("listDepartments", new DaoDepartment().findDepartment());
                request.getRequestDispatcher("/views/department/departments.jsp").forward(request, response);

                break;
            case "delete":
                // do something
                int idDepartment1 = Integer.parseInt(request.getParameter("id")!= null ? request.getParameter("id") :"");
                BeanDepartment beanDepartment2 = new BeanDepartment(idDepartment1, "", "", "", 0);
                try {
                    if(new DaoDepartment().delete(beanDepartment2)){
                        request.setAttribute("message", "Departamento eliminado correctamente");
                    } else {
                        request.setAttribute("message", "Departamento no eliminado");
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

                request.setAttribute("listDepartments", new DaoDepartment().findDepartment());
                request.getRequestDispatcher("/views/department/departments.jsp").forward(request, response);

                break;
            default:
                // no supported
                break;
        }
    }
}
