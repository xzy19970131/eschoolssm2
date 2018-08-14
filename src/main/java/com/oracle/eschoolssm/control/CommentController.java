package com.oracle.eschoolssm.control;


import com.oracle.eschoolssm.model.bean.Comment;
import com.oracle.eschoolssm.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CommentController {
    private CommentService commentService;

    public CommentService getCommentService() {
        return commentService;
    }

    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }
    @RequestMapping("/commentList")
    public String  listComment(Model model){
        List<Comment> comments=commentService.processlistComment(1,2);
        model.addAttribute("allComment",comments);
        for (Comment a:comments){
            System.out.println(a);
        } return "comment_list";
    }
}
