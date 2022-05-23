package com.example.wingsite.model;

import com.example.wingsite.paging.Criteria;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * packageName : com.example.wingsite.model
 * fileName : commonDto
 * author : naraekwon
 * date : 2022/05/18
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/05/18         naraekwon          최초 생성
 */
@Getter
@Setter
@ToString
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class commonDto extends Criteria {

    //    삭제여부
    private String deleteYn;
    //    등록일 LocalDateTime(date타입)
    private LocalDateTime insertTime;
    //    수정일
    private LocalDateTime updateTime;
    //    삭제일
    private LocalDateTime deleteTime;

}
