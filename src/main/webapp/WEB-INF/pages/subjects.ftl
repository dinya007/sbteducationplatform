<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Subjects</title>
    <link rel="stylesheet" href="/resources/lib/js/jquery-ui-1.11.4.custom/jquery-ui.css">
    <script src="/resources/lib/js/jquery-ui-1.11.4.custom/external/jquery/jquery.js"></script>
    <script src="/resources/lib/js/jquery-ui-1.11.4.custom/jquery-ui.js"></script>
    <script>
        $(function() {
            $( "#tabs" ).tabs();
        });
        $.get( "/rest/subjects", function( data ) {
            console.log( data );
            data = jQuery.parseJSON(data);
            for(var i = 0; i < 2; i++){
                $("#tabs").children()[0].children[i].children[0].innerText = data[i].name;
                for(var j = 0; j < data[i].posts.length; j++){
                    var postNode = document.createElement("p");                 // Create a <p> node
                    var textNode = document.createTextNode(data[i].posts[j].author + ": " + data[i].posts[j].message);         // Create a text node
                    postNode.appendChild(textNode);
                    $("#tabs").children()[i+1].appendChild(postNode);
                }
            }
        });
    </script>
</head>
<body>

<div id="tabs">
    <ul>
        <li><a href="#tabs-1">Nunc tincidunt</a></li>
        <li><a href="#tabs-2">Proin dolor</a></li>
    </ul>
    <div id="tabs-1">
    </div>
    <div id="tabs-2">
    </div>
</div>


</body>
</html>