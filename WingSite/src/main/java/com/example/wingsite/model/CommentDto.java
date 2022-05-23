package com.example.wingsite.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

/**
 * packageName : com.example.wingsite.model
 * fileName : CommentDto
 * author : naraekwon
 * date : 2022/05/19
 * description : TB_COMMENT 댓글 테이블을 위한 모델 클래스(DB데이터가 저장되는 클래)
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/05/19         naraekwon          최초 생성
 */


//-- 미션 댓글위한 테이블 설계를 보고 CURD 서비스 만들기
//        -- 게시판 소스 참고해서 Dao - xml - service - controller
//        -- 게시판 ( 페이징 * 검색 ) + 댓글 붙이기
//        CREATE TABLE TB_COMMENT (
//        IDX NUMBER NOT NULL -- 댓글 번호(PK 예정)
//        , BOARD_IDX NUMBER -- 게시판 번호
//        , CONTENT VARCHAR2(1000) -- 댓글 내용
//        , WRITER VARCHAR2(25) -- 댓글 작성자
//        , DELETE_YN CHAR(1) DEFAULT 'N'
//        , INSERT_DATE DATE -- 댓글 등록 일시
//        , UPDATE_DATE DATE -- 댓글 수정 일시
//        , DELETE_DATE DATE -- 댓글 삭제 일시
//        );
//        CREATE SEQUENCE SQ_TB_COMMENT
//        INCREMENT BY 1 START WITH 1
//        MINVALUE 1
//        MAXVALUE 99999999;
@Getter
@Setter
@ToString
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CommentDto extends commonDto{
    private Long idx;// 댓글 멤버변수
    private Long boardIdx; // 게시판 번호
    private String content; // 댓글내용
    private String writer; // 댓글 작성자
}
