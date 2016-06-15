(function () {

    var socket = new SockJS('/earthquakesocket');
    var stompClient = Stomp.over(socket);

    stompClient.connect({}, function(frame) {
        //setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/notification/latest', function(greeting){
            console.log(greeting);
        });
    });


    //stompClient.send("/app//receivedata", {}, JSON.stringify({ 'name': name }));
})();


