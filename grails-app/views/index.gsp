<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
	<head>
	    <script type="text/javascript" src="js/cometd.js"></script>
	    <script type="text/javascript" src="js/jquery-1.4.2.js"></script>
	    <script type="text/javascript" src="js/jquery.json-2.2.js"></script>
	    <script type="text/javascript" src="js/jquery.cometd.js"></script>	
	
	    <script type="text/javascript">
	        $(document).ready(function() {

	        	var olddata = "red";
	        	
	        	// initialize cometd
	        	var channel = '/redis';

	        	var tropoCallback = function(message) {
                    var data = message.data;
                    $("#color").removeClass(olddata).addClass(data);
        			olddata = data;
	        	};

	            $.cometd.configure({
	                url: 'http://localhost:8080/redis-voice/cometd',
	                logLevel: 'debug'
	            });
	            $.cometd.handshake();
	            $.cometd.subscribe('/redis', tropoCallback);

	        });
	    </script>
		<style type="text/css">
		
		body {
			background-color: red;
			text-align: center;
		}
		
		h2 {
			margin-top: 30px;	
		}
		
		.blue {
			background-color: blue;
		}
		
		.green {
			background-color: green;
		}
		
		.yellow {
			background-color: yellow;
		}
		
		.white {
			background-color: white;
		}
		
		</style>
	</head>
	<body id="color">
		<h2>Redis PubSub + Grails/Cometd Test</h2>
		<ul></ul>
	</body>
</html>