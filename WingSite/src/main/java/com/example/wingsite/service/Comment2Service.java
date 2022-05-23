package com.example.wingsite.service;

import com.example.wingsite.model.Comment2Dto;
import com.example.wingsite.model.CommentDto;

import java.util.List;

/**
 * packageName : com.example.wingsite.service
 * fileName : Comment2Service
 * author : naraekwon
 * date : 2022/05/23
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/05/23         naraekwon          최초 생성
 */
public interface Comment2Service {
//    댓글 등록하는 서비스
    public boolean registerComment(Comment2Dto params);
//    댓글 삭제하는 서비스
    public boolean deleteComment(Long idx);
//    댓글 목록 조회 서비스
    public List<Comment2Dto> getCommentList(Comment2Dto params);
//    댓글 상세 조회 서비스
    public Comment2Dto getCommentDetail(Long idx);
}
