package com.example.wingsite.controller;

import com.example.wingsite.model.CommentDto;
import com.example.wingsite.service.CommentServiceImpl;
// logger 라이브러리  slf4j
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * packageName : com.example.wingsite.controller
 * fileName : CommentApiController
 * author : naraekwon
 * date : 2022/05/20
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/05/20         naraekwon          최초 생성
 */
//RestApi @RestController (json, text 로 프론트엔드로 전송, vue , react)
//    비교) @Controller : html, jsp , 타임리프 파일로 바로 출력
//    @RequestMapping("/api") : http://localhost:8000/api/board 의 /api 자동으로 설정 해줌
@RestController
@RequestMapping("/api")
public class CommentApiController {

//    로그 정의 : slf4j 로그
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CommentServiceImpl commentService;//클래스 가져와서 객체 정의 (null 상태에서  @Autowired 달고 스프링객체로 !)

//    댓글 조회
//    /board/1/comments -> 게시물 1의 댓글(보고 바로 알수있게 직관적으로 설계
    @GetMapping("/board/{boardIdx}/comments")
//    @PathVariable("idx")Long idx : ("idx") 생략가능
    public List<CommentDto> openCommentList(CommentDto commentDto){
//        콘솔에 로그 찍기
        logger.info("commentDto: {}",commentDto);
//        게시물 번호를 받아서 댓긍릉 조회하는 메뉴
        return commentService.getCommentList(commentDto);
    }

    //    댓글 상세 조회
//    /board/1/comments -> 게시물 1의 댓글(보고 바로 알수있게 직관적으로 설계
    @GetMapping("/board/comments/{idx}")
//    @PathVariable("idx")Long idx : ("idx") 생략가능
//    idx: 댓글번호, 비교) board_idx : 게시물 번호 (헷갈리면안돼)
    public CommentDto openCommentDetail(@PathVariable("idx") Long idx){

        logger.info("openCommentDetail(idx): ", idx);
        return commentService.getCommentDetail(idx);
    }


//  @PostMapping : insert할때 사용하는 어노테이션
//    @RequestBody : 입력테스트시 json형태로 데이터를 전송할수있음
//    idx를 null로 넣어야함(자동 업데이트(
    @PostMapping("/board/comments")
    public List<CommentDto> registerBoard(@RequestBody CommentDto commentDto){

//            insert문 실행: 댓글 추가
            boolean isRegistered = commentService.registerComment(commentDto);

//        insert완료후 데이터 확인을 위한 조회(select)
        return commentService.getCommentList(commentDto);
    };

    @PutMapping("/board/comments/delection/{idx}")
    public CommentDto deleteComment(CommentDto commentDto){
//        삭제 서비스 호출
        boolean isDeleted = commentService.deleteComment(commentDto.getIdx());

//        삭제가 잘 되었는지 댓글 목록 조회
        return commentService.getCommentDetail(commentDto.getIdx());
    }
}

