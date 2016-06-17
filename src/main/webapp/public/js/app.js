(function($){
    $(function(){

        // materialize config
        $('.button-collapse').sideNav();
        $('.parallax').parallax();
        $('select').material_select();
        $('.datepicker').pickadate({
            selectMonths: true, // Creates a dropdown to control month
            selectYears: 15, // Creates a dropdown of 15 years to control year
            labelMonthNext: 'Next month',
            labelMonthPrev: 'Previous month',
            labelMonthSelect: 'Select a month',
            labelYearSelect: 'Select a year',
            monthsFull: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Setiembre', 'Octubre', 'Noviembre', 'Diciembre'],
            monthsShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun', 'Jul', 'Ago', 'Set', 'Oct', 'Nov', 'Dic'],
            weekdaysFull: ['Domingo', 'Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado'],
            weekdaysShort: [ 'Dom', 'Lun', 'Mar', 'Mie', 'Jue', 'Vie', 'Sab' ],
            weekdaysLetter: ['D', 'L', 'M', 'X', 'J', 'V', 'S'],
            //format: 'dd-mm-yyyy',
            formatSubmit: 'yyyy/mm/dd',
            today: 'Hoy',
            clear: 'Limpiar',
            close: 'Cerrar',
            onSet: function () {
                console.info("select day");
                this.close();
            }
        });



        var socket = new SockJS('/earthquakesocket');
        var stompClient = Stomp.over(socket);

        stompClient.connect({}, function(frame) {
            //setConnected(true);
            console.log('Connected: ' + frame);
            stompClient.subscribe('/notification/latest', function(greeting){
                debugger;
                console.log(greeting);
            });
        });
        //stompClient.send("/app//receivedata", {}, JSON.stringify({ 'name': name }));



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

