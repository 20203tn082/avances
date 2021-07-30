<%--
  Created by IntelliJ IDEA.
  User: natha
  Date: 15/07/2021
  Time: 11:01 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<html>
<head>

    <title>SISO</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <link href="https://cdn.jsdelivr.net/npm/metismenu@3.0.7/dist/metisMenu.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/startbootstrap-sb-admin-2@4.1.4/css/sb-admin-2.css" rel="stylesheet">
    <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-4 offset-md-4">
            <br><br>
            <div class="row">
                <div class="col-md-11 text-center">
                    <img src="${context}/img/utez.png" style="width: 50%;"/>
                </div>
            </div>
            <br/>
            <div class="login-panel panel panel-default">
                <div class="panel-heading">
                    <h5 class="panel-title">
                        Inicio de sesión
                    </h5>
                </div>
                <div class="panel-body">
                    <form action="${context}/ServletUsers" method="POST">
                        <input type="hidden" value="access" name="action">
                        <fieldset>
                            <div class="form-group">
                                <input class="form-control"  placeholder="Tu usuario" name="nameUser" type="text" autofocus required>
                            </div>
                            <div class="form-group">
                                <input class="form-control" placeholder="Tu contraseña" name="password" type="password"  maxlength="30" value="" required>
                            </div>
                            <div>
                                <label>
                                    <a href="${context}/views/users/requestToken.jsp">¿Olvidaste tu contraseña?</a>
                                </label>
                            </div>
                            <button type="submit" class="btn btn-lg btn-success btn-block ng-binding">Iniciar</button>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>