<%--
  Created by IntelliJ IDEA.
  User: natha
  Date: 14/07/2021
  Time: 12:05 a. m.
  To change this template use File | Settings | File Templates.
<%-- --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<html>
<head>
  <title>Listado de usuarios</title>
  <link rel="stylesheet" href="${context}/assets/plugins/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="${context}/assets/dist/css/styles.css">
  <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="w3-sidebar w3-bar-block w3-card w3-animate-left" style="display:none" id="mySidebar">
  <form action="${context}/ServletRecords" method="get">
    <input type="hidden" value="records" name="action">
    <button type="submit" class="w3-bar-item w3-button">Página principal</button>
  </form>

  <form action="${context}/ServletDepartments" method="get">
    <input type="hidden" value="departments" name="action">
    <button type="submit" class="w3-bar-item w3-button">Departamentos</button>
  </form>

  <a href="#" class="w3-bar-item w3-button">Link 2</a>
  <a href="#" class="w3-bar-item w3-button">Link 3</a>
</div>

<div id="main">

  <div class="w3-teal">
    <button id="openNav" class="w3-button w3-teal w3-xlarge" onclick="abrirCerrar()">&#9776;</button>
    <div class="w3-container">
    </div>
  </div>

  <div class="container">
    <br>
    <form action="${context}/ServletUsers" method="get">
      <input type="hidden" value="register" name="action">
      <button type="submit" class="btn btn-success"><i class="fas fa-plus"></i> Agregar usuario</button>

    </form>
    <br>
<table class="table table-striped">
  <thead>
  <tr>
    <th>No.</th>
    <th>Nombre de usuario</th>
    <th>Nombre</th>
    <th>Apellido paterno</th>
    <th>Apellido materno</th>
    <th>Correo</th>
    <th>Tipo de usuario</th>
    <th>Departamento</th>
    <th>Acciones</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${ listUsers }" var="user" varStatus="status">
    <tr>
      <td>${ status.count }</td>
      <td>${ user.nameUser }</td>
      <td>${ user.name }</td>
      <td>${ user.lastname1 }</td>
      <td>${ user.lastname2 }</td>
      <td>${ user.email }</td>
      <td>${ user.department_id.nameDepartment }</td>
      <td>${ user.type_id.nameType }</td>

      <td>
          <form action="${context}/ServletUsers" method="POST" style="display: inline;">
            <input type="hidden" name="action" value="getUserById">
            <input type="hidden" name="id" value="${ user.id_user }">
            <button type="submit" class="btn btn-outline-primary"><i class="fas fa-edit"></i> Modificar</button>
          </form>
        <button type="button" class="btn btn-outline-danger btn-sm" onclick="recibir('${ user.id_user }', '${user.name}')" data-bs-toggle="modal" data-bs-target="#delete"><i class="fas fa-trash"></i> Eliminar</button>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
  </div>
<%-- MODAL --%>
<div class="modal fade" id="delete" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Eliminar usuario</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        ¿Estas seguro de querer eliminar a <span id="name"></span>?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal"><i class="fas fa-times"></i> Cerrar</button>
        <form action="${context}/ServletUsers" method="POST" style="display: inline;">
          <input type="hidden" name="action" value="delete">
          <input type="hidden" name="id" value="" id="codigo">
          <button type="submit" class="btn btn-danger"><i class="fas fa-trash"></i> Eliminar</button>
        </form>
      </div>
    </div>
  </div>
</div>


<script language="javascript">
  function recibir(id, name)
  {
    document.getElementById("name").innerHTML = name;
    document.getElementById("codigo").value=id;

  }
</script>

<script src="${context}/assets/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script src="${context}/assets/dist/js/main.js"></script>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
  <script>
    var turno=1;
    function abrirCerrar(){
      if(turno==1){
        document.getElementById("main").style.marginLeft = "25%";
        document.getElementById("mySidebar").style.width = "25%";
        document.getElementById("mySidebar").style.display = "block";
        document.getElementById("openNav").style.display = 'inline-block';
        turno=2
      }else{
        document.getElementById("main").style.marginLeft = "0%";
        document.getElementById("mySidebar").style.display = "none";
        document.getElementById("openNav").style.display = "inline-block";
        turno=1
      }
    }
  </script>

</body>
</html>
