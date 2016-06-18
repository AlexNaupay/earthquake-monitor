<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="parts/header.jsp"/>

<div class="content">
    <div class="row">
        <div class="col s12 m4 l3">
            <h6 class="last-update z-depth-2"><strong>Última actualización</strong>: <span id="last-update">por determinar</span></h6>

            <div class="card deep-orange darken-1 hide" id="earthquake-detail">
                <%--<div class="card-content white-text">
                    <span class="card-title">
                        <span class="waves-effect waves-light" id="back-button"><i class="material-icons">list</i></span>
                        TITLE
                    </span>
                    <p><strong>Magnitud: </strong> 3.2 <i class="material-icons green-text">album</i></p>
                    <p><strong>Lugar: </strong> Lima, Perú west</p>
                    <p><strong>Fecha: </strong> 2016-15-25 10:45:12 pm</p>
                    <p><strong>Profundidad: </strong> 5km</p>
                    <p><strong>Significancia: </strong> 9</p>

                </div>
                <div class="card-action">
                    <a href="#">Más detalles</a>
                </div>--%>
            </div>


            <div id="earthquakes" class="earthquakes-list-content z-depth-2">
                <ul class="collection earthquakes-collection" id="earthquakes-collection">
                    <%--
                    <li class="collection-item earthquake-item avatar">
                        <span class="magnitude circle red white-text">
                            5.2
                        </span>
                        <span class="title">Title</span>
                        <p>First Line</p>
                        <a href="#!" class="secondary-content"><i class="material-icons">navigation</i></a>
                    </li>
                    --%>
                </ul>

            </div>
        </div>
        <div class="col s12 m8 l9">
            <div id="content-map">
                <div id="mapview">
                </div>
                <%--<button id="button-map-edit" class="btn btn-default btn-success pull-right disabled">Guardar Ruta</button>--%>
            </div>
        </div>
    </div>
</div>

<script type="text/template" id="template-earthquake">
    <li class="collection-item earthquake-item avatar" data-id="[[earthquake.id]]">
        <span class="magnitude circle [[earthquake.alerta]] white-text tooltipped"
              data-position="bottom" data-delay="50" data-tooltip="Moment Magnitude (Mw)">
            [[earthquake.magnitud]]
        </span>
        <span class="title">[[earthquake.lugar]]</span>
        <p title="[[earthquake.tiempo.format('dddd, DD MMMM YYYY, h:mm:ss a')]]">[[earthquake.tiempo.fromNow()]],
            <spam class="time-format">[[earthquake.tiempo.calendar()]]</spam>
        </p>
        <a href="[[earthquake.url]]" target="_blank" class="secondary-content" title="Más detalles">
            <i class="material-icons deep-orange-text">navigation</i>
        </a>
    </li>
</script>

<script type="text/template" id="template-earthquake-detail" >
    <div class="card-content white-text">
        <span class="card-title">
            <span class="btn-floating deep-orange darken-1 waves-effect waves-light" id="back-button">
                <i class="material-icons">done</i> &nbsp;
            </span>
            [[earthquake.titulo]]
        </span>
        <h5><strong>Magnitud: </strong> <strong class="">[[earthquake.magnitud]]Mw</strong> </h5>
        <p><strong>Lugar: </strong> [[earthquake.lugar]]</p>
        <p><strong>Fecha: </strong> [[earthquake.tiempo.format('dddd, DD MMMM YYYY, h:mm:ss a')]]</p>
        <p><strong>Profundidad: </strong> [[earthquake.profundidad]]km</p>
        <p><strong>Significancia: </strong> [[earthquake.significancia]]</p>

        </div>
        <div class="card-action">
                <a class="white-text" target="_blank" href="[[earthquake.url]]">Más detalles</a>
        </div>
</script>

<jsp:include page="parts/footer.jsp"/>