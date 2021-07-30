<%--
  Created by IntelliJ IDEA.
  User: natha
  Date: 16/07/2021
  Time: 07:29 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<html>
<head>
    <title>Subir Oficio</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
</head>
<body>
<h1>Subir oficio</h1>
<form action="${context}/ServletRecords" method="POST" enctype="multipart/form-data">
    <input type="hidden" value="insert" name="action">
    <label>Departamento:</label>
    <select class="form-select" name="departmentId">
        <c:forEach items="${listDepartment}" var="department" varStatus="status">
            <option value="${department.idDepartment}">${department.nameDepartment}</option>
        </c:forEach>
    </select>
    <br>
    <label>Prioridad:</label>
    <select class="form-select" name="priorityId">
        <c:forEach items="${listPriority}" var="priority" varStatus="status">
            <option value="${priority.idPriority}">${priority.namePriority}</option>
        </c:forEach>
    </select>
    <br>
    <label>Subir archivo:</label>
    <input class="form-control" type="file" name="archivo" />
    <br>
    <button type="submit" class="btn btn-success"><i class="fas fa-plus"></i> Agregar</button>
</form>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</body>
</html>