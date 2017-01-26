<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<footer class="page-footer blue-grey darken-3">
    <div class="content">
        <div class="row">
            <div class="col l6 s12">
                <h5 class="white-text">Acerca del proyecto</h5>
                <p class="grey-text text-lighten-4">
                    Este es un proyecto en el cual se pone en práctica el concepto de websocket ,
                    como parte del curso de Sistemas Distribuidos en la EAP de Ingeniría de Sistemas de la
                    Universidad Nacional Mayor de San Marcos.
                    <a href="https://github.com/AlexNaupay/earthquake-monitor">Accede al código fuente.</a>
                    <%--We are a team of college students working on this project like it's our full time job. Any amount would help support and continue development on this project and is greatly appreciated.--%>
                </p>
            </div>
            <div class="col l2 s12">
                <h5 class="white-text">Equipo</h5>
                <ul>
                    <li><a class="white-text" href="https://www.facebook.com/anaupayf" target="_blank" rel="author">@alexh</a></li>
                    <li><a class="white-text" href="https://www.facebook.com/magally.acosta.16" target="_blank" rel="author">@magally</a></li>
                    <li><a class="white-text" href="https://www.facebook.com/luisunmsm" target="_blank" rel="author">@luis</a></li>
                </ul>
            </div>
            <div class="col l4 s12">
                <h5 class="white-text">Enlaces de Interés</h5>
                <ul>
                    <li><a class="white-text" href="http://jguerra91.wix.com/sistdistfisi" target="_blank">El curso</a></li>
                    <li><a class="white-text" href="http://www.igp.gob.pe/" target="_blank">Instituto Geofísico del Perú </a></li>
                    <li><a class="white-text" href="http://www.igp.gob.pe/ultimosismo/ultimosismo.php" target="_blank">IGP - Último Sismo</a></li>
                    <li><a class="white-text" href="http://earthquake.usgs.gov/" target="_blank">USGS, oficina federal de los EEUU</a></li>
                    <li><a class="white-text" href="https://www.websocket.org/" target="_blank">websocket.org</a></li>
                    <li><a class="white-text" href="https://www.openshift.com" target="_blank">Openshift</a></li>
                    <li><a class="white-text" href="https://www.heroku.com" target="_blank">Heroku</a></li>
                </ul>
            </div>
        </div>
    </div>
    <div class="footer-copyright">
        <div class="container center-block center-align">
            Facultad de Ingeniería de Sistemas e Informática 2016
        </div>
    </div>
</footer>


<!--  Scripts-->
<script async src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script async src="<c:url value="public/vendors/underscore/underscore-min.js"/>"></script>
<script async src="<c:url value="public/vendors/materialize/js/materialize.min.js"/>"></script>
<script async src="<c:url value="public/vendors/momentjs/moment-with-locales.min.js"/>"></script>

<%-- https://github.com/jmesnil/stomp-websocket debug: line 145 --%>
<script async src="<c:url value="/public/vendors/stomp.min.js"/>"></script>
<%-- https://github.com/sockjs/sockjs-client --%>
<script async src="<c:url value="/public/vendors/sockjs-0.3.4.js"/>"></script>

<%--<script src="http://maps.googleapis.com/maps/api/js?v=3.exp"></script>--%>

<script async src="http://maps.googleapis.com/maps/api/js?key=AIzaSyBDh2PIO2lCxaHKYf2s2BfG-hZ3MDnJDWQ&libraries=geometry"></script>

<script async src="<c:url value="/public/js/app.min.js"/>"></script>

</body>
</html>

