package com.oracle.eschoolssm.service;


import com.oracle.eschoolssm.model.bean.Comment;
import com.oracle.eschoolssm.model.dao.CommentDAO;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller("commentService")
public class CommentServiceImp implements CommentService{
    private CommentDAO commentDAO;

    public CommentDAO getCommentDAO() {
        return commentDAO;
    }

    public void setCommentDAO(CommentDAO commentDAO) {
        this.commentDAO = commentDAO;
    }

    public List<Comment> processlistComment(int count, int page) {
        List<Comment> u=commentDAO.selectCommentAndProduct(1,2);
        return u;
    }
}
