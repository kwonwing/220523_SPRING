package com.example.wingsite.controller;

import com.example.wingsite.model.Comment2Dto;
import com.example.wingsite.model.CommentDto;
import com.example.wingsite.service.Comment2ServiceImpl;
import com.example.wingsite.service.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * packageName : com.example.wingsite.controller
 * fileName : Comment2Controller
 * author : naraekwon
 * date : 2022/05/23
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/05/23         naraekwon          최초 생성
 */
@RestController
@RequestMapping("/api")
public class Comment2Controller {
    @Autowired
    Comment2ServiceImpl comment2Service;//클래스 가져와서 객체 정의 (null 상태에서  @Autowired 달고 스프링객체로 !)
//    댓글 추가
    @PostMapping("/board2/comments2/")
    public List<Comment2Dto> registerBoard(@RequestBody Comment2Dto comment2Dto){
        boolean isRegistered = comment2Service.registerComment(comment2Dto);
        return comment2Service.getCommentList(comment2Dto);
    }
//    댓글 조회
    @GetMapping("/board/{boardIdx}/comments2")
    public List<Comment2Dto> openCommentList(Comment2Dto comment2Dto){
        return comment2Service.getCommentList(comment2Dto);
    }
//댓글 상세 조회
    @GetMapping("/board2/comments2/{idx}")
    public Comment2Dto openCommentDetail(@PathVariable("idx") Long idx ){
        return comment2Service.getCommentDetail(idx);
    }

    @PutMapping("/board2/comments2/delection2/{idx}")
    public Comment2Dto deleteComment(Comment2Dto comment2Dto){
//        삭제 서비스 호출
        boolean isDeleted = comment2Service.deleteComment(comment2Dto.getIdx());

//        삭제가 잘 되었는지 댓글 목록 조회
        return comment2Service.getCommentDetail(comment2Dto.getIdx());
    }
}
