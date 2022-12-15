package com.yonghyeonJo.searchBlog.model;

import lombok.Getter;
import lombok.Setter;
import lombok.var;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Getter @Setter
public class NaverBlogReqVO {

   // 검색어
   private String query   = "";
   // 유사도 순
   private String sort    = "sim";
   // 검색결과 출력 수
   private int    display = 30;
   // 검색 시작 위치
   private int    start   = 1;

   public MultiValueMap<String, String> toMultiValueMap() {
      // 변수를 선언할 때 타입을 명시적으로 선언하지 않고, 표현식에서 타입을 추론하도록 함.
      var map = new LinkedMultiValueMap<String, String>();
      map.add("query", query);
      map.add("display", String.valueOf(display));
      map.add("start", String.valueOf(start));
      map.add("sort", sort);
      return map;
   }



   /**
    * HashMap :  Map에 있는 데이터를 뽑을때, 키를 기준으로 가져옴
    * TreeMap : HashMap과 동일한 기능에 추가 옵션(데이터가 들어올때마다 Key 값에 따라 알아서 자동으로 정렬)
    * LinkedHashMap : HashMap과 동일한 기능에 추가 옵션(예를 들어 HashMap에 C B A 로 했다면, 나중에 맵에있는 모든 값을 출력할때 그대로 나오게 해준다.)
    *
    * MultiValueMap : 키의 중복이 허용된다.
    * 언제 사용
    * 1. Map 을 사용하고 싶을때(시간복잡도)
    * 2. 중복된키로 들어오는 Value 값들을 온전하게 저장하고싶을때
    * 3. HashMap 으로 쓰는것보다 깔끔한 코딩을 원할 때
    */
}
