package com.oracle.eschoolssm.model.dao;

import com.oracle.eschoolssm.model.bean.Comment;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller("commentDAO")
public class CommentDAOImp extends BaseDAO implements CommentDAO{
    public List<Comment> selectCommentAndProduct(int count, int page) {
       CommentDAO dao=getSqlSession().getMapper(CommentDAO.class);
        return dao.selectCommentAndProduct(1,2);
    }
}
