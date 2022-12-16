package com.yonghyeonJo.searchBlog.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
*
* NaverBlogEntity : 받은 결과를 저장하는 엔티티
*
* @author joyonghyeon
* @version 1.0.0
* @date 2022/12/16
**/

// 기본 생성자를 생성 ( 초기값 세팅이 필요한 final 변수가 있을 경우 컴파일 에러가 발생함 주의)
@NoArgsConstructor
@Data
//@Entity
public class NaverBlogEntity {

//    @Id
//    @GeneratedValue
    private Long id;
    private String bloggerlink;
    private String title;
    private String link;
    private String description;
    private String bloggername;

    public NaverBlogEntity(String bloggerlink, String title, String link, String description, String bloggername) {
        this.bloggerlink = bloggerlink;
        this.title       = title;
        this.link        = link;
        this.description = description;
        this.bloggername = bloggername;
    }
}
