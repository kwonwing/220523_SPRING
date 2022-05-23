package com.example.wingsite.model;


import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * packageName : com.example.wingsite.model
 * fileName : Comment2Dto
 * author : naraekwon
 * date : 2022/05/23
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/05/23         naraekwon          최초 생성
 */
@Getter
@Setter
@ToString
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Comment2Dto extends commonDto {
    private Long idx;
    private Long boardIdx;
    private String content;
    private String writer;


}
