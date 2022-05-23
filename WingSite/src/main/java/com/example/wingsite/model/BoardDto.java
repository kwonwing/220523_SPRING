package com.example.wingsite.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * packageName : com.example.wingsite.model
 * fileName : BoardDto
 * author : naraekwon
 * date : 2022/05/17
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/05/17         naraekwon          최초 생성
 */
// 롬북 라이브러리에서 제공하는 어노테이션
@Getter
@Setter
@ToString
// snake camel 한번에 정리
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class BoardDto extends commonDto{
//    번호 (PK:기본키)
    private Long idx;
//    제목
    private String title;
//    내용
    private String content;
//    작성자
    private String writer;
//    조회수
    private int viewCnt;
//    공지여부
    private String noticeYn;
//    비밀여부
    private String secretYn;

}
