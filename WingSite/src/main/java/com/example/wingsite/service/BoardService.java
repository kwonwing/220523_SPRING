package com.example.wingsite.service;

import com.example.wingsite.model.BoardDto;

import java.util.List;

/**
 * packageName : com.example.wingsite.service
 * fileName : Boardservice
 * author : naraekwon
 * date : 2022/05/18
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/05/18         naraekwon          최초 생성
 */
public interface BoardService {
//    게시판에 insert하는 서비스
    boolean registerBoard(BoardDto params);
//    상세목록을 확인하는 서비스(select :1건)
    BoardDto getBoardDetail(Long idx);

//    게시판의 글 목록을 가져오는 서비스(select : 전체 글목록)
    public List<BoardDto> getBoardAllList();

//    페이징 처리를 위한 서비스
    public List<BoardDto> getBoardList(BoardDto params);

//    게시판 글을 삭제하는 서비스 (update):delete_YN = 'Y'
    public boolean deleteBoard(Long idx);
}
