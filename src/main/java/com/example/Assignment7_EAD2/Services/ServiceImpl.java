package com.example.Assignment7_EAD2.Services;

import com.example.Assignment7_EAD2.DBConnection.DBConnection;
import com.example.Assignment7_EAD2.Entity.Comments;
import com.example.Assignment7_EAD2.Entity.Posts;
import com.example.Assignment7_EAD2.Entity.Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceImpl implements Service{
    @Override
    public boolean addPost(Posts posts) {
        Connection con = null;
        PreparedStatement pstmt = null;
        boolean state = false;
        int count = 0;
        try {
            Class.forName(DBConnection.DRIVERCLASS);
            con = DriverManager.getConnection(DBConnection.DBURL, DBConnection.USER, DBConnection.PASSWORD);
            pstmt = con.prepareStatement("insert into posts values (?,?,?,?,?,?);");
            pstmt.setInt(1, posts.getId());
            pstmt.setInt(2, posts.getUserId());
            pstmt.setString(3, posts.getTitle());
            pstmt.setString(4, posts.getContent());
            pstmt.setInt(5, posts.getLikes());
            pstmt.setInt(6, posts.getDisLikes());
            count = pstmt.executeUpdate();
            if (count >= 0) {
                state = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionClose(con, pstmt);
        }
        return state;
    }
    public void connectionClose(Connection con, PreparedStatement pstmt) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean updatePost(Posts posts) {
        Connection con = null;
        PreparedStatement pstmt = null;
        boolean state = false;
        int result = 0;
        try {
            Class.forName(DBConnection.DRIVERCLASS);
            con = DriverManager.getConnection(DBConnection.DBURL, DBConnection.USER, DBConnection.PASSWORD);
            pstmt = con.prepareStatement("update posts set userId = ?, title = ?, " +
                    "content = ?, likes = ?, " +
                    "dislikes = ? where id = ?;");
            pstmt.setInt(1, posts.getUserId());
            pstmt.setString(2, posts.getTitle());
            pstmt.setString(3, posts.getContent());
            pstmt.setInt(4, posts.getLikes());
            pstmt.setInt(5, posts.getDisLikes());
            pstmt.setInt(6, posts.getId());
            result = pstmt.executeUpdate();
            if (result >= 0) {
                state = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionClose(con, pstmt);
        }
        return state;
    }

    @Override
    public Users getPostOwner(int postId) {
        Users user = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Class.forName(DBConnection.DRIVERCLASS);
            con = DriverManager.getConnection(DBConnection.DBURL, DBConnection.USER, DBConnection.PASSWORD);
            pstmt = con.prepareStatement("select users.* " +
                    "from posts inner join users on users.id = posts.userId " +
                    "where posts.id = ?;");
            pstmt.setInt(1, postId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                Users u = new Users();
                u.setId(rs.getInt(1));
                u.setName(rs.getString(2));
                u.setEmail(rs.getString(3));
                u.setPassword(rs.getString(4));
                user = u;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionClose(con, pstmt);
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return user;
    }

    @Override
    public Users getCommentOwner(int commentId) {
        Users user = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Class.forName(DBConnection.DRIVERCLASS);
            con = DriverManager.getConnection(DBConnection.DBURL, DBConnection.USER, DBConnection.PASSWORD);
            pstmt = con.prepareStatement("select users.* " +
                    "from comments inner join users on users.id = comments.userId " +
                    "where comments.id = ?;");
            pstmt.setInt(1, commentId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                Users u = new Users();
                u.setId(rs.getInt(1));
                u.setName(rs.getString(2));
                u.setEmail(rs.getString(3));
                u.setPassword(rs.getString(4));
                user = u;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionClose(con, pstmt);
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return user;
    }

    @Override
    public List<Posts> listAllPosts() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean state = false;
        List<Posts> list = new ArrayList<>();
        try {
            Class.forName(DBConnection.DRIVERCLASS);
            con = DriverManager.getConnection(DBConnection.DBURL, DBConnection.USER, DBConnection.PASSWORD);
            pstmt = con.prepareStatement("select * from posts;");
            state = pstmt.execute();
            if (state) {
                rs = pstmt.getResultSet();
                while (rs.next()) {
                    Posts post = new Posts();
                    post.setId(rs.getInt(1));
                    post.setUserId(rs.getInt(2));
                    post.setTitle(rs.getString(3));
                    post.setContent(rs.getString(4));
                    post.setLikes(rs.getInt(5));
                    post.setDisLikes(rs.getInt(6));
                    list.add(post);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionClose(con, pstmt);
        }
        return list;
    }

    @Override
    public List<Posts> listAllPostsOfUser(int userId) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean state = false;
        List<Posts> list = new ArrayList<>();
        try {
            Class.forName(DBConnection.DRIVERCLASS);
            con = DriverManager.getConnection(DBConnection.DBURL, DBConnection.USER, DBConnection.PASSWORD);
            pstmt = con.prepareStatement("select * from posts where userId = ?;");
            pstmt.setInt(1, userId);
            state = pstmt.execute();
            if (state) {
                rs = pstmt.getResultSet();
                while (rs.next()) {
                    Posts post = new Posts();
                    post.setId(rs.getInt(1));
                    post.setUserId(rs.getInt(2));
                    post.setTitle(rs.getString(3));
                    post.setContent(rs.getString(4));
                    post.setLikes(rs.getInt(5));
                    post.setDisLikes(rs.getInt(6));
                    list.add(post);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionClose(con, pstmt);
        }
        return list;
    }

    @Override
    public boolean addComment(Comments comments) {
        Connection con = null;
        PreparedStatement pstmt = null;
        boolean state = false;
        int count = 0;
        try {
            Class.forName(DBConnection.DRIVERCLASS);
            con = DriverManager.getConnection(DBConnection.DBURL, DBConnection.USER, DBConnection.PASSWORD);
            pstmt = con.prepareStatement("insert into comments values (?,?,?,?);");
            pstmt.setInt(1, comments.getId());
            pstmt.setInt(2, comments.getUserId());
            pstmt.setInt(3, comments.getPostId());
            pstmt.setString(4, comments.getComment());
            count = pstmt.executeUpdate();
            if (count >= 0) {
                state = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionClose(con, pstmt);
        }
        return state;
    }

    @Override
    public boolean updateComment(Comments comments) {
        Connection con = null;
        PreparedStatement pstmt = null;
        boolean state = false;
        int result = 0;
        try {
            Class.forName(DBConnection.DRIVERCLASS);
            con = DriverManager.getConnection(DBConnection.DBURL, DBConnection.USER, DBConnection.PASSWORD);
            pstmt = con.prepareStatement("update comments set userId = ?, postId = ?, " +
                    "content = ? where id = ?;");
            pstmt.setInt(1, comments.getUserId());
            pstmt.setInt(2, comments.getPostId());
            pstmt.setString(3, comments.getComment());
            pstmt.setInt(4, comments.getId());
            result = pstmt.executeUpdate();
            if (result >= 0) {
                state = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionClose(con, pstmt);
        }
        return state;
    }

    @Override
    public List<Comments> listAllComments() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean state = false;
        List<Comments> list = new ArrayList<>();
        try {
            Class.forName(DBConnection.DRIVERCLASS);
            con = DriverManager.getConnection(DBConnection.DBURL, DBConnection.USER, DBConnection.PASSWORD);
            pstmt = con.prepareStatement("select * from comments;");
            state = pstmt.execute();
            if (state) {
                rs = pstmt.getResultSet();
                while (rs.next()) {
                    Comments comment = new Comments();
                    comment.setId(rs.getInt(1));
                    comment.setUserId(rs.getInt(2));
                    comment.setPostId(rs.getInt(3));
                    comment.setComment(rs.getString(4));
                    list.add(comment);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionClose(con, pstmt);
        }
        return list;    }

    @Override
    public List<Comments> listAllCommentsOfPost(int postId) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean state = false;
        List<Comments> list = new ArrayList<>();
        try {
            Class.forName(DBConnection.DRIVERCLASS);
            con = DriverManager.getConnection(DBConnection.DBURL, DBConnection.USER, DBConnection.PASSWORD);
            pstmt = con.prepareStatement("select * from comments where postId = ?;");
            pstmt.setInt(1, postId);
            state = pstmt.execute();
            if (state) {
                rs = pstmt.getResultSet();
                while (rs.next()) {
                    Comments comment = new Comments();
                    comment.setId(rs.getInt(1));
                    comment.setUserId(rs.getInt(2));
                    comment.setPostId(rs.getInt(3));
                    comment.setComment(rs.getString(4));
                    list.add(comment);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionClose(con, pstmt);
        }
        return list;
    }
}
