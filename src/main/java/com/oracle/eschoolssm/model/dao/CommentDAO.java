package com.oracle.eschoolssm.model.dao;



import com.oracle.eschoolssm.model.bean.Comment;

import java.util.List;

public interface CommentDAO {
    //列出所有评论
    public List<Comment> selectCommentAndProduct(int count, int page);
}
