package com.example.wingsite.paging;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * packageName : com.example.wingsite.paging
 * fileName : Criteria
 * author : naraekwon
 * date : 2022/05/18
 * description : 페이징 처리를 위한 클래스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/05/18         naraekwon          최초 생성
 */
@Getter
@Setter
@ToString
// snake camel 한번에 정리
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Criteria {
//    현재 페이지 번호
    private int currentPageNo;

//    페이지당 출력할 데이터 개수
    private int recordsPerPage;

//    화면 하단에 출력할 페이지 사이즈
    private int pageSize;

//    검색 키워드
    private String searchKeyword;

//    검색 유형(제목, 내용, 작성자 등)
    private String searchType;

//    기본 생성자: 페이지 초기화
    public Criteria(){
        this.currentPageNo =1;//현재페이지
        this.recordsPerPage = 10; //1페이지당 10건
        this.pageSize = 10;//총 페이지 10
    }

//프론트엔드에서 쿼리스트링을 만들어서 날려주는 메소드
//    쿼리스트링(query string)  : http://localhost:8000/board?currentPageNo=5&recordsPerPage=3
//    Rest API :  http://localhost:8000/board/currentPageNo/5/recordsPerPage/3

//    빌더 패턴: 생성자역할을 대신하는 디자인 패턴 
    public String makeQueryString(int pageNo){
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .queryParam("currentPageNo", pageNo)
                .queryParam("recordsPerPage", recordsPerPage)
                .queryParam("pageSize", pageSize)
                .queryParam("searchType", searchType)
                .queryParam("searchKeyword", searchKeyword)
                .build()
                .encode();
        return uriComponents.toUriString();
    }
}
