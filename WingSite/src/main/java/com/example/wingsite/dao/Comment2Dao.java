package com.example.wingsite.dao;

import com.example.wingsite.model.Comment2Dto;
import com.example.wingsite.model.CommentDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * packageName : com.example.wingsite.dao
 * fileName : Comment2Dao
 * author : naraekwon
 * date : 2022/05/23
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/05/23         naraekwon          최초 생성
 */
@Mapper
public interface Comment2Dao {
//    댓글 추가 메소드
    int insertComment(Comment2Dto params);

//  댓글 상세목록 조회하는 메소드
      Comment2Dto selectCommentDetail(Long idx);

// 댓글 수정 메소드
    int updateComment(Comment2Dto params);

//    댓글 삭제 메소드
    int deleteComment(Long idx);

//    댓글 페이징 처리를 위한 메소드
    List<Comment2Dto> selectCommentList(Comment2Dto params);

//    댓글의 총 건수를 가져오는 메소드
    int selectCommentTotalCount(Comment2Dto params);
}
