package com.oracle.eschoolssm.service;



import com.oracle.eschoolssm.model.bean.Comment;

import java.util.List;

public interface CommentService {
    public List<Comment> processlistComment(int count, int page);
}
