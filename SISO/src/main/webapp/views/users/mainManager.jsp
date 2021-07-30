<%@ page import="mx.com.siso.model.users.DaoUsers" %><%--
  Created by IntelliJ IDEA.
  User: natha
  Date: 15/07/2021
  Time: 10:41 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<html>
<head>
    <title>Listado de oficios</title>
    <link rel="stylesheet" href="${context}/assets/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${context}/assets/dist/css/styles.css">
    <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
<body>
    <div class="container">
        <a href="${context}/ServletRecords" class="btn btn-success"><i class="fas fa-plus"></i> Agregar oficio</a>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>No.</th>
                <th>Archivo</th>
                <th>Fecha de Canalización</th>
                <th>Fecha de Asignación</th>
                <th>Auxiliar</th>
                <th>Prioridad</th>
                <th>Atendido</th>
                <th>Acciones</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${ listMinutes }" var="minute" varStatus="status">
                <tr>
                    <td>${ status.count }</td>
                    <td>
                        <form action="${context}/ServletRecords" method="POST" style="display: inline;">
                            <input type="hidden" name="action" value="getRecordById">
                            <input type="hidden" name="id" value="${ minute.id_minutes}">
                            <button type="submit" class="btn"><img src="https://upload.wikimedia.org/wikipedia/commons/thumb/8/87/PDF_file_icon.svg/1200px-PDF_file_icon.svg.png" width="40" height="40"/> </button>
                        </form>
                    </td>
                    <td>${ minute.dateChannelling }</td>
                    <td>
                        <c:if test="${   minute.dateAssignment != null }">
                            ${ minute.dateAssignment}
                        </c:if>
                        <c:if test="${   minute.dateAssignment == null }">
                            Sin asignacion
                        </c:if>
                    </td>

                    <td>
                        <c:if test="${  minute.userId.id_user != 0 }">
                            ${ minute.userId.name}
                        </c:if>
                        <c:if test="${ minute.userId.id_user == 0 }">
                            Sin auxiliar
                        </c:if>
                    </td>
                    <td><c:if test="${ minute.priorityId.namePriority eq 'Urgente' }">
                        <label style="background-color: red "><p style="color: white">${ minute.priorityId.namePriority }</p></label>
                    </c:if>
                        <c:if test="${ minute.priorityId.namePriority eq 'Muy importante' }">
                            <label style="background-color: orange "><p style="color: white">${ minute.priorityId.namePriority }</p></label>
                        </c:if>
                        <c:if test="${ minute.priorityId.namePriority eq 'Importante' }">
                            <label style="background-color: #ffd700"><p style="color: white">${ minute.priorityId.namePriority }</p></label>
                        </c:if>
                        <c:if test="${ minute.priorityId.namePriority eq 'Normal' }">
                            <label style="background-color: green "><p style="color: white">${ minute.priorityId.namePriority }</p></label>
                        </c:if>
                    </td>
                    <td> <c:if test="${minute.attended eq 1}">
                    Atendido
                    </c:if>
                        <c:if test="${minute.attended eq 0}">
                            Sin atender
                        </c:if>
                    </td>
                    <td>
                        <c:if test="${minute.userId.id_user eq 0}">
                        <form action="${context}/ServletRecords" method="get" style="display: inline;">
                            <input type="hidden" name="action" value="assign">
                            <input type="hidden" name="id" value="${ minute.id_minutes}">
                            <button type="submit" class="btn btn-outline-primary"> Asignar</button>
                    </form>
                        </c:if>
                        <c:if test="${minute.userId.id_user ne 0 && minute.userId.id_user ne 0 && minute.attended eq 0}">
                            <button class="btn btn-outline-primary">Reasignar</button>
                        </c:if>
                        <c:if test="${minute.attended eq 1}">
                            <button class="btn btn-outline-primary">Detalle</button>
                        </c:if>
                    </td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>


    <script src="${context}/assets/plugins/bootstrap/js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <script src="${context}/assets/dist/js/main.js"></script>

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>

</body>
</html>