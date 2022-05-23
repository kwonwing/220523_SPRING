package com.example.wingsite.service;

import com.example.wingsite.model.BoardDto;
import com.example.wingsite.model.CommentDto;

import java.util.List;

/**
 * packageName : com.example.wingsite.service
 * fileName : Boardservice
 * author : naraekwon
 * date : 2022/05/20
 * description : Dao, Model 이용해서 업무로직을 작성하는 인터페이스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/05/18         naraekwon          최초 생성
 */
public interface CommentService {
//    댓글(등록)  insert하는 서비스
   public boolean registerComment(CommentDto params);
    //    댓글을 삭제하는 서비스 (update):delete_YN = 'Y'
    public boolean deleteComment(Long idx);

    //    댓글 글 목록 조회 서비스(select : 여러건)
    public List<CommentDto> getCommentList(CommentDto params);

    //    댓글 상세 조회 서비스(select :1건)
    public CommentDto getCommentDetail(Long idx);



}
