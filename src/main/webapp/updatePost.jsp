
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" type="text/css" href="http://www.shieldui.com/shared/components/latest/css/light/all.min.css" />
    <script type="text/javascript" src="http://www.shieldui.com/shared/components/latest/js/shieldui-all.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row" id="row_style">
        <h4 class="text-center">Submit new post</h4>
        <div class="col-md-4   col-md-offset-4">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Title">
            </div>
            <textarea id="editor" cols="30" rows="10">Submit your text post here...</textarea>
            <br>
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Tags">
            </div>
            <div class="form-group">
                <button class="btn btn-primary" id="submit">Submit new post</button>
            </div>
        </div>
    </div>
</div>
<script>
    $(function () {
        $("#editor").shieldEditor({
            height: 260
        });
    })
</script>
<style>
    #row_style {
        margin-top: 30px;
    }

    #submit {
        display: block;
        margin: auto;
    }
</style>
</body>
</html>
