package com.yonghyeonJo.searchBlog.ctr;

import com.yonghyeonJo.searchBlog.model.NaverBlogReqVO;
import com.yonghyeonJo.searchBlog.model.NaverBlogResVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;


@Component
@Slf4j
public class NaverBlogRestController {


    public ResponseEntity<NaverBlogResVO> searchBlog(NaverBlogReqVO naverBlogReqVO) {

        // 입력받은 파라미터를 ByteBuffer 타입으로 변경 후 UTF_8 인코딩
        ByteBuffer byteBuffer = StandardCharsets.UTF_8.encode((String)naverBlogReqVO.getQuery());
        String searchValueEncode = StandardCharsets.UTF_8.decode(byteBuffer).toString();

        // request URI 생성
        URI uri = UriComponentsBuilder
                .fromUriString("https://openapi.naver.com")
                .path("/v1/search/blog.json")
                .queryParams(naverBlogReqVO.toMultiValueMap())
                .encode()
                .build()
                .toUri();

        /**
         * RestTemplate 란?
         * Spring 에서 지원하는 객체로 간편하게 Rest 방식 API를 호출할 수 있는 Spring 내장 클래스
         * json, xml 응답을 모두 받을 수 있다.
         * Header, Content-Type 등을 설정하여 외부 API 호출
         *
         * API 호출 클래스 종류
         * RestTemplate : REST API 호출이후 응답을 받을 때까지 기다리는 동기방식
         * AsyncRestTemplate : Spring 4에 추가된 비동기 RestTemplate Spring5.0에서는 deprected 되었다.
         * WebClient : Spring 5에 추가된 논블럭, 리엑티브 웹 클라이언트로 동기, 비동기 방식을 지원
         */

        log.info("uri : {}", uri);

        RestTemplate restTemplate = new RestTemplate();

        RequestEntity<Void> req = RequestEntity
                .get(uri)
                .header("X-Naver-Client-Id", "uUWNh8Xem0CgqZaqKg3P")
                .header("X-Naver-Client-Secret", "mpmseoykey")
                .build();

        ResponseEntity<NaverBlogResVO> responseEntity = new RestTemplate().exchange(req, NaverBlogResVO.class);
        System.out.println("responseEntity = " + responseEntity);

        return responseEntity;
    }
}
