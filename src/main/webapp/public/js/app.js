(function($){
    $(function(){
        // materialize config
        $('.button-collapse').sideNav();
        $('.parallax').parallax();
        $('select').material_select();
        $('.tooltipped').tooltip({delay: 50});

        // underscore config 
        _.templateSettings = {
            interpolate: /\[\[(.+?)\]\]/g
        };
        
        // momentjs config
        moment.locale("es");

        // Google maps API
        var mapOptions = {
            center: new google.maps.LatLng(-12.15408, -76.97184),
            zoom: 4,
            mapTypeId: google.maps.MapTypeId.ROADMAP
        };
        var map = new google.maps.Map(document.getElementById('mapview'), mapOptions);
        var infowindow = new google.maps.InfoWindow({});

        
        // Variables
        var earthquakeCollectionNode = $("#earthquakes-collection");
        
        var socket = new SockJS('/earthquakesocket');
        var stompClient = Stomp.over(socket);

        stompClient.connect({}, function(frame) {
            //setConnected(true);
            console.log('Connected: ' + frame);
            stompClient.subscribe('/notification/latest', function(data){
                var body = JSON.parse(data.body);
                if( _.isArray(body.earthquakes)){
                    if (body.earthquakes.length > 0){
                        addEarthquakes(body.earthquakes);
                        Materialize.toast(body.earthquakes.length + 'Nuevo(s) eventos', 5000); // 4000 is the duration of the toast
                    }
                }
                $('#last-update').html( moment(body.fechagenerado).calendar() );
            });
        });
        //stompClient.send("/app/receivedata", {}, JSON.stringify({ 'name': name }));

        requestServer('/latest', function (status, earthquakes) {
            addEarthquakes(earthquakes);

        });

        earthquakeCollectionNode.on('click','.earthquake-item',function (event) {
            var id = $(this).data('id');
            requestServer('/earthquake/'+id, function (status, earthquake) {
                var position = new google.maps.LatLng(earthquake.latitud, earthquake.longitud);
                map.panTo(position);
                infowindow.setContent(earthquake.titulo);
                infowindow.setPosition(position);
                infowindow.open(map);

                earthquake = processEarthquake(earthquake);
                var compiled_text = processTemplate('#template-earthquake-detail', {earthquake: earthquake});
                $('#earthquake-detail').html(compiled_text);

                switchElements('#earthquakes', '#earthquake-detail');
                
            })
        });
        
        $('#earthquake-detail').on('click','#back-button', function () {
            switchElements('#earthquake-detail', '#earthquakes');
        });

        /**
         * Switch classes 
         * @param selectorAdd Add class
         * @param selectorRemove Remove class
         * @param className
         */
        function switchElements(selectorAdd, selectorRemove, className){
            className = className || 'hide';
            $(selectorAdd).addClass(className);
            $(selectorRemove).removeClass(className);
        }

        /**
         * Add earthquakes to layout html
         * @param earthquakes
         */
        function addEarthquakes(earthquakes) {
            earthquakes.forEach(function (item) {
                item = processEarthquake(item);
                var compiled_text = processTemplate('#template-earthquake', {earthquake: item});
                earthquakeCollectionNode.prepend(compiled_text);
                addMarkerOnMap(item);
                $('.tooltipped').tooltip({delay: 50});
            });
        }

        /**
         * Compile template with values
         * @param templateSelector
         * @param data data going to compiled
         */
        function processTemplate(templateSelector, data) {
            var template_text = $(templateSelector).html();
            var template = _.template(template_text);
            return template(data);
        }

        /**
         * process earthquake
         * @param earthquake
         * @returns {earthquake}
         */
        function processEarthquake(earthquake) {
            earthquake.alerta = alertForEarthquake(earthquake);
            earthquake.tiempo = moment(earthquake.tiempo);
            return earthquake;
        }

        /**
         * Add marker on map
         * @param earthquake
         */
        function addMarkerOnMap(earthquake) {
            var marker = new google.maps.Marker({
                position: new google.maps.LatLng(earthquake.latitud, earthquake.longitud),
                title:earthquake.titulo,
                draggable:false,
                icon:'/public/images/earthquake32.png'
            });
            marker.addListener('click', function () {
                infowindow.setContent(earthquake.titulo);
                infowindow.open(map, marker);
            });
            marker.setMap(map);
        }

        /**
         * Alert level
         * @param earthquake
         * @returns red | green | orange | blue
         */
        function alertForEarthquake(earthquake) {
            if (earthquake.alerta == null)
                if (earthquake.magnitud <= 3)
                    return "blue";
                else if (earthquake.magnitud <= 5)
                    return "green";
                else if (earthquake.magnitud <= 6)
                    return "orange";
                else return "red";
            return earthquake.alerta;
        }

        /**
         * Request server
         * @param uriServer uri
         * @param data Object to send
         * @param method HTTP verb
         * @param callback
         */
        function requestServer(uriServer, data, method ,callback) {
            if ( typeof data === 'function'){
                callback = data;
                method = 'GET';
                data = {};
            }else if ( typeof method === 'function'){
                callback = method;
                method = 'GET';
            }

            var request = $.ajax({
                url: uriServer,
                method: method,
                contentType: "application/json",
                data: decodeURIComponent( JSON.stringify(data) )
            });

            request.success(function (response) {
                callback(0, response);
            });

            request.fail(function (message) {
                callback(1, message);
            });
        }

    }); // end of document ready
})(jQuery);

