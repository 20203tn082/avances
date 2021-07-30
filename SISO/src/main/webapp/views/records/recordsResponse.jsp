<%--
  Created by IntelliJ IDEA.
  User: natha
  Date: 23/07/2021
  Time: 12:38 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<html>
<head>
  <title>Oficios de respuesta</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
</head>
<body>
<%String id =request.getParameter("id")!= null ? request.getParameter("id") : "";%>
<h1>Subir oficios de respuesta</h1>
<form action="${context}/ServletResponse" method="POST" enctype="multipart/form-data">
  <input type="hidden" value="insert" name="action">
  <input type="hidden" value="<%=id%>" name="id">
  <label>Subir archivo:</label>
  <input class="form-control" type="file" name="archivos" multiple="true" />
  <br>
  <label>Comentario:</label>
  <input class="form-control" type="text" name="comment" />
  <br>
  <button type="submit" class="btn btn-success"><i class="fas fa-plus"></i> Subir</button>
</form>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</body>
</html>