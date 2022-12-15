package com.yonghyeonJo.searchBlog.model;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class NaverBlogResVO {
    // 검색 결과를 생성한 시간
    private String lastBuildDate;
    // 총 검색 결과 개수
    private int total;
    // 검색 시작 위치
    private int start;
    // 한 번에 표시할 검색 결과 개수
    private int display;
    // 개별 검색 결과. JSON 형식의 결괏값에서는 items 속성의 JSON 배열로 개별 검색 결과를 반환한다.
    private List<SearchLocalItem> items;

    @Getter @Setter
    public static class SearchLocalItem {
        // 블로그 포스트의 제목. 제목에서 검색어와 일치하는 부분은<b> 태그로 감싸져 있다.
        private String title;
        // 블로그 포스트의 URL
        private String link;
        // 블로그 포스트의 내용을 요약한 패시지 정보. 패시지 정보에서 검색어와 일치하는 부분은 <b> 태그로 감싸져 있다.
        private String description;
        // 블로그 포스트가 있는 블로그의 이름
        private String bloggername;
        // 블로그 포스트가 있는 블로그의 주소
        private String bloggerlink;
    }
}
