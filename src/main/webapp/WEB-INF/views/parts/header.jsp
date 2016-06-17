<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
    <meta name="description" content="Despliegue de un aplicación web en la nube de openshift.">
    <link rel="icon" href="<c:url value="/public/images/uigv_minilogo.png"/>">
    <title>Real Time Earthquake Monitor</title>

    <!-- CSS  -->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="<c:url value="/public/vendors/materialize/css/materialize.min.css"/>" type="text/css" rel="stylesheet" media="screen,projection"/>
    <link href="<c:url value="/public/css/app.css"/>" type="text/css" rel="stylesheet" media="screen,projection"/>
</head>

<body>
<nav class="blue darken-3" role="navigation">
    <div class="nav-wrapper container">
        <a id="logo-container" href="/" class="brand-logo hide-on-med-and-down">
            <%--<img src="<c:url value="/public/images/logo.png"/>" alt="">--%>
            <img src="<c:url value="/public/images/uigv_minilogo.png"/>" alt="">
        </a>
        <a href="/" id="mini-logo-container" class="brand-logo hide-on-large-only">
            <img src="<c:url value="/public/images/uigv_minilogo.png"/>" alt="">
        </a>
        <ul class="right hide-on-med-and-down">
            <li><a class="white-text" href="/">Home</a></li>
        </ul>

        <ul id="nav-mobile" class="side-nav uigv-blue">
            <li>
                <a href="/" class="center">
                    <img src="<c:url value="/public/images/uigv_minilogo.png"/>" alt="" height="64px">
                </a>
            </li>
            <li><a class="white-text" href="/">Home</a></li>
        </ul>
        <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons white-text">menu</i></a>
    </div>
</nav>