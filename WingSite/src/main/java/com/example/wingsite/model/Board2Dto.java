package com.example.wingsite.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * packageName : com.example.wingsite.model
 * fileName : BoardDto
 * author : naraekwon
 * date : 2022/05/20
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/05/20         naraekwon          최초 생성
 */
// 롬북 라이브러리에서 제공하는 어노테이션
@Getter
@Setter
//@ToString: 객체 주소를 string(객체의 값)으로 바꿔주는 어노테이션
@ToString
// JSON 데이터와 자바클래스 멤버변수 맞춰줌 / snake camel 한번에 정리
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Board2Dto extends commonDto{
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
