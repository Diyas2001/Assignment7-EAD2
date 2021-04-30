<%@ page import="com.example.Assignment7_EAD2.Services.ServiceImpl" %>
<%@ page import="com.example.Assignment7_EAD2.Entity.Posts" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.Assignment7_EAD2.Entity.Users" %>
<%@ page import="com.example.Assignment7_EAD2.Entity.Comments" %>
<%@include file="header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    ServiceImpl service = new ServiceImpl();
    List<Posts> posts = service.listAllPostsOfUser(1);
    for (Posts post: posts) {
        Users user1 = service.getPostOwner(post.getId());
        List<Comments> comments = service.listAllCommentsOfPost(post.getId());
%>
<div class="container-fluid mt-100">
    <div class="row">
        <div class="col-md-12">
            <div class="card mb-4">
                <div class="card-header">
                    <div class="media-body ml-3"> <a href="javascript:void(0)" data-abc="true"><%=user1.getName()%></a>
                        <div class="text-muted small">13 days ago</div>
                    </div>
                    <div class="text-muted small ml-3">
                        <div><%=post.getTitle()%> <strong>01/1/2019</strong></div>
                        <div><strong>134</strong> posts</div>
                    </div>
                </div>
            </div>
            <div class="card-body">
                <p> <%=post.getContent()%></p>

            </div>
            <div class="card-footer d-flex flex-wrap justify-content-between align-items-center px-0 pt-0 pb-3">
                <div class="px-4 pt-3"> <a href="javascript:void(0)" class="text-muted d-inline-flex align-items-center align-middle" data-abc="true">
                    <i class="fa fa-heart text-danger"></i>&nbsp;
                    <span class="align-middle"><%=post.getLikes()%></span> </a>
                    <span class="text-muted d-inline-flex align-items-center align-middle ml-4">
                            <i class="fa fa-eye text-muted fsize-3"></i>&nbsp;
                            <span class="align-middle"><%=post.getDisLikes()%></span> </span> </div>
                <div class="px-4 pt-3"> <button type="button" class="btn btn-primary"><i class="ion ion-md-create"></i>&nbsp; Reply</button> </div>
            </div>
        </div>
    </div>
</div>
</div>
<% } %>
</body>
</html>
