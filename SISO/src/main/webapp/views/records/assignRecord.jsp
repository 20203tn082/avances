<%--
  Created by IntelliJ IDEA.
  User: natha
  Date: 23/07/2021
  Time: 10:13 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<html>
<head>
  <title>Asignar Oficio</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
</head>
<body>
<h1>Asignar oficio</h1>
<form action="${context}/ServletRecords" method="POST">
  <input type="hidden" value="assign" name="action">
  <input type="hidden" value="${idRecords}" name="id">
  <label>Auxiliares:</label>

  <select class="form-select" name="assistant">
    <c:forEach items="${listAssistant}" var="assistant" varStatus="status">
      <option value="${assistant.nameUser}">${assistant.name}</option>
    </c:forEach>
  </select>
  <br>
  <button type="submit" class="btn btn-success"><i class="fas fa-plus"></i> Asignar</button>
</form>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</body>
</html>
