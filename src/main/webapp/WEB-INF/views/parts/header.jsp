<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
    <meta name="description" content="Despliegue de un aplicación web en la nube de openshift.">
    <link rel="icon" href="<c:url value="/public/images/logo5.png"/>">
    <title>Real Time Earthquake Monitor</title>

    <!-- CSS  -->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="<c:url value="/public/vendors/materialize/css/materialize.min.css"/>" type="text/css" rel="stylesheet" media="screen,projection"/>
    <link href="<c:url value="/public/css/app.css"/>" type="text/css" rel="stylesheet" media="screen,projection"/>
</head>

<body>
<nav class="deep-orange  darken-2 z-depth-2" role="navigation">
    <div class="nav-wrapper container">
        <a id="logo-container" href="/" class="brand-logo">
            <img src="<c:url value="/public/images/logo5.png"/>" alt="">
        </a>

        <ul class="right hide-on-med-and-down">
            <li><a class="white-text" href="/"><i class="material-icons white-text">loop</i></a></li>
        </ul>

        <ul id="nav-mobile" class="side-nav uigv-blue">
            <li>
                <a href="/" class="center">
                    <img src="<c:url value="/public/images/logo5.png"/>" alt="" height="64px">
                </a>
            </li>
            <li><a class="white-text" href="/">Home</a></li>
        </ul>
        <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons white-text">menu</i></a>
    </div>
</nav>