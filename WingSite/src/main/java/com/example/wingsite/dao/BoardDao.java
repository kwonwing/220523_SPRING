package com.example.wingsite.dao;

import com.example.wingsite.model.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * packageName : com.example.wingsite.dao
 * fileName : BoardDao
 * author : naraekwon
 * date : 2022/05/17
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/05/17         naraekwon          최초 생성
 */
// @Mapper : mybatis에서 사용하는 어노테이션, xml에서 인터페이스를 구현함(CRUD sql문 작성)
@Mapper
public interface BoardDao {
//    insert sql문을 위한 메소드(sql: insert)
    int insertBoard(BoardDto params);

//    게시판 목록 조회하는 메소드 (sql: select )
    List<BoardDto> selectBoardAllList();

//    게시판 페이징 처리를 위한 메소드
    List<BoardDto> selectBoardList(BoardDto params);

//    게시판 상세목록 조회하는 메소드(sql: select, 매개변수: 게시판번호)
    BoardDto selectBoardDetail(Long idx);

//    게시물의 총 건수를 가져오는 메소드(select : 1건)
    int selectBoardTotalCount(BoardDto params);

//    게시판 글 수정 메소드
    int updateBoard(BoardDto params);

//    게시판 글 삭제 메소드
    int deleteBoard(Long idx);

}
