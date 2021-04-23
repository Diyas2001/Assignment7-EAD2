package com.example.Assignment7_EAD2.Services;
import com.example.Assignment7_EAD2.Entity.Comments;
import com.example.Assignment7_EAD2.Entity.Posts;
import com.example.Assignment7_EAD2.Entity.Users;
import java.util.List;

public interface Service {
    boolean addPost(Posts posts);
    boolean updatePost(Posts posts);
    Users getPostOwner(int postId);
    Users getCommentOwner(int commentId);
    List<Posts> listAllPosts();
    List<Posts> listAllPostsOfUser(int userId);
    boolean addComment(Comments comments);
    boolean updateComment(Comments comments);
    List<Comments> listAllComments();
    List<Comments> listAllCommentsOfPost(int postId);
}
