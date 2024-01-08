<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Producer Page</title>
</head>
<body>
<h1>Producer Page</h1>

<div id="messages"></div>

<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script src="/webjars/sockjs-client/1.0.5/sockjs.min.js"></script>
<script src="/webjars/stomp-websocket/2.3.3/dist/stomp.min.js"></script>
<script>
    var stompClient = null;

    function connect() {
        var socket = new SockJS('/ws-endpoint');
        stompClient = Stomp.over(socket);

        stompClient.connect({}, function (frame) {
            console.log('Connected: ' + frame);

            stompClient.subscribe('/topic/messages', function (response) {
                showMessage(JSON.parse(response.body));
            });
        });
    }

    function showMessage(message) {
        var messageDiv = document.getElementById('messages');
        var messageContent = '<p>' + JSON.stringify(message) + '</p>';
        messageDiv.innerHTML += messageContent;
    }

    $(document).ready(function () {
        connect();
    });
</script>
</body>
</html>
