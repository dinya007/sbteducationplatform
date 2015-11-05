<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Subjects</title>
    <link rel="stylesheet" href="/resources/lib/js/jquery-ui-1.11.4.custom/jquery-ui.css">
    <script src="/resources/lib/js/jquery-ui-1.11.4.custom/external/jquery/jquery.js"></script>
    <script src="/resources/lib/js/jquery-ui-1.11.4.custom/jquery-ui.js"></script>
    <script>

        $(function () {
            $("#tabs").tabs();
        });

        $.ajaxSetup({
            contentType: "application/json; charset=utf-8"
        });


        //        $.get("/rest/subjects", function (data) {
        //            console.log(data);
        //            data = jQuery.parseJSON(data);
        //            for (var i = 0; i < 2; i++) {
        //                $("#tabs").children()[0].children[i].children[0].innerText = data[i].name;
        //                for (var j = 0; j < data[i].posts.length; j++) {
        //                    var postNode = document.createElement("p");                 // Create a <p> node
        //                    var textNode = document.createTextNode(data[i].posts[j].author + ": " + data[i].posts[j].message);         // Create a text node
        //                    postNode.appendChild(textNode);
        //                    $("#tabs").children()[i + 1].appendChild(postNode);
        //                }
        //            }
        //        });
    </script>
</head>
<body>

<div id="tabs" style="position: fixed; width: 100%;height: 100%;">
    <ul>
    <#list 0..subjects?size-1 as i>
        <li><a href="#tabs-${i}">${subjects[i].name}</a></li>
    </#list>
    </ul>
<#list 0..subjects?size-1 as i>
    <div id="tabs-${i}">
        <#list 0..subjects[i].posts?size-1 as j>
            <p>${subjects[i].posts[j].author} : ${subjects[i].posts[j].message}</p>
        </#list>
        <div style="right: 25%; bottom: 25px; position: absolute;" id="postForm-${i}">
            <input type="hidden" class="subjectId" value="${subjects[i].id}">
            <input class="author" type="text" size="41" placeholder="Enter your name here ... " required="required"/>
            <button class="addPost">Add post</button>
            <br>
        <textarea style="margin-top: 5px;" class="message" rows="4" cols="50"
                  placeholder="Enter a message here ... "></textarea>
        </div>
    </div>
</#list>


</div>

<script>
    $(".addPost").click(function (event) {
        var subjectId = $(this).siblings(".subjectId").val();
        var author = $(this).siblings(".author").val();
        var message = $(this).siblings(".message").val();
        author = "Denis";
        message = "Post message"
        $.post("/rest/subjects/" + subjectId + "/" + author + "/" + message, function (data) {
            alert(data);
        });
//        $.post("/rest/subjects/", { subjectID: subjectId, author: author, message:message },function (data) {
//            alert(data);
//        });
//        $.ajax({
//            method: "POST",
//            url: "/rest/subjects/" + subjectId + "/" + author + "/" + message,
//            headers: {
//                Accept : "application/json",
//            },
////            data: { subjectId: subjectId, author: author, message:message }
//            success : function(response) {
//                console.log(response);
//            } });
    });


</script>

</body>
</html>