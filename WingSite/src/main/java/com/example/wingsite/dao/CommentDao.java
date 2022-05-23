package com.example.wingsite.dao;

import com.example.wingsite.model.BoardDto;
import com.example.wingsite.model.CommentDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * packageName : com.example.wingsite.dao
 * fileName : BoardDao
 * author : naraekwon
 * date : 2022/05/20
 * description : CRUD를 위한 인터페이스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/05/20         naraekwon          최초 생성
 */
// @Mapper : mybatis에서 사용하는 어노테이션, xml에서 인터페이스를 구현함(CRUD sql문 작성)
@Mapper
public interface CommentDao {
//    insert sql문을 위한 메소드(sql: insert)
//    댓글 추가 메소드 (C insert)
    int insertComment(CommentDto params);

//    댓글 상세목록 조회하는 메소드(sql: select(R), 매개변수: 게시판번호)
    CommentDto selectCommentDetail(Long idx);

//    댓글 글 수정 메소드(U update)
    int updateComment(CommentDto params);

//    댓글 삭제 메소드(D delete)
    int deleteComment(Long idx);


//    댓글 페이징 처리를 위한 메소드
    List<CommentDto> selectCommentList(CommentDto params);

//    댓글의 총 건수를 가져오는 메소드(select : 1건)
    int selectCommentTotalCount(CommentDto params);

}
