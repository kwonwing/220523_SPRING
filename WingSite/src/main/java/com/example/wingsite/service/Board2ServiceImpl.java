package com.example.wingsite.service;

import com.example.wingsite.dao.Board2Dao;
import com.example.wingsite.dao.BoardDao;
import com.example.wingsite.model.Board2Dto;
import com.example.wingsite.model.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * packageName : com.example.wingsite.service
 * fileName : BoardserviceImpl
 * author : naraekwon
 * date : 2022/05/18
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/05/18         naraekwon          최초 생성
 */
//  @Service: 스프링에 객체로 생성되는 어노테이션
    @Service
public class Board2ServiceImpl implements Board2Service{

        @Autowired
        private Board2Dao board2Dao; //객체 생성안되고 정의만 됨->@Autowired가 멤버변수에 스프링의 객체를 넣어줌

//    게시판에 idx(글번호)가 없으면 insert문 실행 (사용자가 새글쓰기 버튼 클릭)
//    글번호가 있으면 update문 실행 (사용자가 글목록 버튼을 클릭 + 수정 버튼 클릭 )
        @Override
        public boolean registerBoard(Board2Dto params) {
//            insert 또는 update결과를 저장하는 변수
//            위의 sql문이 정상수행되면 :1 아니면 다른값
            int queryResult = 0;

            if(params.getIdx()==null) {
//                새글쓰기
                queryResult = board2Dao.insertBoard(params);
            }else{
//                상세목록에서 글 수정(update문 실행)
                queryResult = board2Dao.updateBoard(params);
            }
            return (queryResult == 1) ? true : false;
        }

        @Override
        public Board2Dto getBoardDetail(Long idx) {
//            글번호(idx)에 해당하는 상세목록보기(select 문 실행 : 1건)
            return board2Dao.selectBoardDetail(idx);
        }

        @Override
        public List<Board2Dto> getBoardAllList() {
            List<Board2Dto> board2List = Collections.emptyList();
//      select(전체게시물)문 실행
            board2List = board2Dao.selectBoardAllList();

            return board2List;
        }

//        게시판번호를 받아서 게시물을 삭제하는 서비스
        @Override
        public boolean deleteBoard(Long idx) {
            int queryResult = 0;
//            게시물이 있는지 확인(select :1건)
//            게시물이 있으면 board != null
            Board2Dto board = board2Dao.selectBoardDetail(idx);

//            N일때 () 삭제 진행
            if(board != null && "N".equals(board.getDeleteYn())){
//                게시물 삭제 서비스(진짜 삭제는 안하고 업데이터 처리 )
                queryResult = board2Dao.deleteBoard(idx);
            }
            return (queryResult == 1)? true:false;
        }
// 게시판 페이징 처리를 위한 서비스 구현
    @Override
    public List<Board2Dto> getBoardList(Board2Dto params) {

            List<Board2Dto> board2Dto = Collections.emptyList();

//            DB params에 해당하는 데이터가 있는지 먼저 확인
            int boardTotoalCount = board2Dao.selectBoardTotalCount(params);

            if(boardTotoalCount>0){
//                페이징 처리 서비스 호출
                board2Dto = board2Dao.selectBoardList(params);
            }
            return board2Dto;
    }
}
