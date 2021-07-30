<%--
  Created by IntelliJ IDEA.
  User: natha
  Date: 14/07/2021
  Time: 09:23 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<html>
<head>
  <title>Modificar Usuario </title>
  <link rel="stylesheet" href="${context}/assets/plugins/bootstrap/css/bootstrap.min.css">
  <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<h1>Modificar Usuario</h1>
<form action="${context}/ServletUsers" method="POST">
  <input type="hidden" value="update" name="action">
  <input type="hidden" value="${ user.id_user }" name="id">

  <label>Nombre de usuario:</label>
  <input class="form-control" type="text" name="nameUser" value="${user.nameUser}" />
  <br>
  <label>Contraseña:</label>
  <input class="form-control" type="password" name="password" value="${user.passwordUser}" />
  <br>
  <label>Nombre(s):</label>
  <input class="form-control" type="text" name="name" value="${user.name}" />
  <br>
  <label>Apellido paterno:</label>
  <input class="form-control" type="text" name="lastname1" value="${user.lastname1}" />
  <br>
  <label>Apellido materno:</label>
  <input class="form-control" type="text" name="lastname2" value="${user.lastname2}" />
  <br>
  <label>Correo:</label>
  <input class="form-control" type="email" name="email" value="${user.email}" />
  <br>
  <label>Tipo de usuario:</label>
  <select class="form-select" name="type" >
    <option value="0">Seleccione un tipo de usuario...</option>
    <option value="1">Auxiliar</option>
    <option value="2">Responsable de departamento</option>
    <option value="3">Oficialía de partes</option>
  </select>
  <br>
  <label>Departamento:</label>
  <select class="form-select" name="departmentId">
    <c:forEach items="${listDepartment}" var="department" varStatus="status">
    <option value="${department.idDepartment}">${department.nameDepartment}</option>
    </c:forEach>
  </select>
  <br>
  <button type="submit" class="btn btn-primary"><i class="fas fa-edit"></i> Modificar</button>
</form>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>

<script src="${context}/assets/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
</body>
</html>
