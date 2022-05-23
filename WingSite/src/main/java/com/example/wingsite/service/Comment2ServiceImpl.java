package com.example.wingsite.service;

import com.example.wingsite.dao.Comment2Dao;
import com.example.wingsite.dao.CommentDao;
import com.example.wingsite.model.Comment2Dto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * packageName : com.example.wingsite.service
 * fileName : Comment2ServiceImpl
 * author : naraekwon
 * date : 2022/05/23
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/05/23         naraekwon          최초 생성
 */
@Service
public class Comment2ServiceImpl implements Comment2Service {
    @Autowired
    Comment2Dao comment2Dao;

    @Override
    public boolean registerComment(Comment2Dto params) {
        int queryResult =0;
        if(params.getIdx()==null){
            queryResult = comment2Dao.insertComment(params);
        }else {
            queryResult = comment2Dao.updateComment(params);
        }
        return (queryResult==1)? true:false;
    }

    @Override
    public boolean deleteComment(Long idx) {
        int queryResult =0;
        Comment2Dto comment= comment2Dao.selectCommentDetail(idx);
        if(comment != null && "N".equals(comment.getDeleteYn())){
            queryResult = comment2Dao.deleteComment(idx);
        }
        return (queryResult==1)? true:false;
    }

    @Override
    public List<Comment2Dto> getCommentList(Comment2Dto params) {
//        빈값으로 초기화
        List<Comment2Dto> commentList = Collections.emptyList();

        int commentTotalCount = comment2Dao.selectCommentTotalCount(params);
        if(commentTotalCount>0){
            commentList = comment2Dao.selectCommentList(params);

        }
        return commentList;
    }

    @Override
//    글번호에 해당하는 상세목록 보기
    public Comment2Dto getCommentDetail(Long idx) {
        Comment2Dto comment2Dto = comment2Dao.selectCommentDetail(idx);
        return comment2Dto;
    }
}
