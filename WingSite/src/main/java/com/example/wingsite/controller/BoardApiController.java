package com.example.wingsite.controller;

import com.example.wingsite.model.Board2Dto;
import com.example.wingsite.model.BoardDto;
import com.example.wingsite.model.CommentDto;
import com.example.wingsite.service.Board2ServiceImpl;
import com.example.wingsite.service.BoardService;
import com.example.wingsite.service.BoardServiceImpl;
import com.example.wingsite.service.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * packageName : com.example.wingsite.controller
 * fileName : BoardApiController
 * author : naraekwon
 * date : 2022/05/18
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/05/18         naraekwon          최초 생성
 */
//RestApi @RestController (json, text 로 프론트엔드로 전송, vue , react)
//    비교) @Controller : html, jsp , 타임리프 파일로 바로 출력
//    @RequestMapping("/api") : http://localhost:8000/api/board 의 /api 자동으로 설정 해줌
@RestController
@RequestMapping("/api")
public class BoardApiController {

    @Autowired
    BoardServiceImpl boardService; //정의(객체 생성 해줘야함-> @Autowired)

    @Autowired
    Board2ServiceImpl board2Service;//클래스 가져와서 객체 정의 (null 상태에서  @Autowired 달고 스프링객체로 !)
    @GetMapping("/board/write/{idx}")
//    @PathVariable("idx")Long idx : ("idx") 생략가능
    public BoardDto openBoardWrite(@PathVariable("idx")Long idx){
//        상세목록 보기 서비스를 호출 (select : 1건)
        BoardDto detail = boardService.getBoardDetail(idx);
        return detail;
    }



//  @PostMapping : insert할때 사용하는 어노테이션
//    @RequestBody : 입력테스트시 json형태로 데이터를 전송할수있음
    @PostMapping("/board/register")
    public List<BoardDto> registerBoard(@RequestBody BoardDto boardDto){
        try{
            System.out.println("controller boardDto:"+ boardDto);
//            insert문 실행
            boolean isRegistered = boardService.registerBoard(boardDto);
        }catch (DataAccessException e){
//            DB관련된 에러
//            TODO => DB 처리 과정에 문제가 발생했다는 메세지를 출력

        }catch (Exception e){
//            DB외의 에러
//            TODO=>시스템에 문제가 발생했다는 메세지를 출력

        }
//        insert완료후 데이터 확인을 위한 전체 조회(select)
        return boardService.getBoardAllList();
    };

    @PutMapping(value="/board/delete/{idx}")
    public List<BoardDto> deleteBoard(@PathVariable("idx") Long idx){
//        삭제 서비스 호출
        boolean isDeleted = boardService.deleteBoard(idx);
//        삭제되었는지 전체 조회
        return boardService.getBoardAllList();
    }

//    페이징 처리를 위한 게시물 검색 메뉴1
    @GetMapping("/board/list/cur-page-no/{currentPageNo}/records-per-page/{recordsPerPage}")
    public List<BoardDto> openBoardList(BoardDto params){

        return boardService.getBoardList(params);
    };

//    페이징 처리를 위한 게시물 검색 메뉴2
    @GetMapping("/board/list/cpage/{currentPageNo}/rpage/{recordsPerPage}/sword/{searchKeyword}/stype/{searchType}")
    public List<BoardDto> openBoardList2(BoardDto params){

        return boardService.getBoardList(params);
    };

}

