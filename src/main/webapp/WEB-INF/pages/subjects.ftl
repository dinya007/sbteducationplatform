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
        <div class="posts" style="overflow-y: scroll; height: 65%; width: 100%; position:absolute;">
            <#list 0..subjects[i].posts?size-1 as j>
                <p>${subjects[i].posts[j].author} : ${subjects[i].posts[j].message}</p>
            </#list>
        </div>
        <div style="right: 25%; bottom: 25px; position: absolute;">
            <span class="errorField" style="color: red; display: none;">Warning</span>
            <br>
            <input type="hidden" class="subjectId" value="${subjects[i].id}">
            <input type="hidden" class="tabId" value="${i}">
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
    $(".addPost").click(function () {

        var subjectId = getSiblingValue($(this), ".subjectId");
        var author = $(this).siblings(".author");
        var message = $(this).siblings(".message");

        var currentPosts = $("#tabs-" + getSiblingValue($(this), ".tabId")).find(".posts")
        var errorField = $(this).siblings(".errorField");

        if (isEmptyValue(author.val(), "Please, enter an author", errorField)) return;
        if (isEmptyValue(message.val(), "Please, enter a message", errorField)) return;

        $.post("/rest/posts/" + subjectId + "/" + author.val() + "/" + message.val(), function (data) {
            currentPosts.prepend("<p>" + data.author + " : " + data.message + "</p>");
        });

        author.val("");
        message.val("");

    });

    var getSiblingValue = function (original, selector) {
        return original.siblings(selector).val();
    }

    var isEmptyValue = function (filedValue, errorMessage, errorField) {
        if (!filedValue) {
            errorField.text(errorMessage);
            errorField.show();
            errorField.delay(1000);
            errorField.hide("drop", {direction: "down"}, "slow");
            return true;
        }
        return false;
    }


</script>

</body>
</html>