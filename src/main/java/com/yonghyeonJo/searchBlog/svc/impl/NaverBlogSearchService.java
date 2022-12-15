package com.yonghyeonJo.searchBlog.svc.impl;

import com.yonghyeonJo.searchBlog.ctr.NaverBlogRestController;
import com.yonghyeonJo.searchBlog.model.NaverBlogEntity;
import com.yonghyeonJo.searchBlog.model.NaverBlogReqVO;
import com.yonghyeonJo.searchBlog.model.NaverBlogResVO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
// final 변수, NotNull 표시가 된 변수처럼 필수적인 정보를 세팅하는 생성자를 만들어 준다.
@RequiredArgsConstructor
public class NaverBlogSearchService {

    private final NaverBlogRestController naverBlogRestController;
//    private final NaverBlogRepository     naverBlogRepository;

    public List<NaverBlogEntity> searchService(String query) {
        NaverBlogReqVO req = new NaverBlogReqVO();
        req.setQuery(query);

        ResponseEntity<NaverBlogResVO> res = naverBlogRestController.searchBlog(req);
        List<NaverBlogEntity> naverBlogEntities = res.getBody().getItems().stream().map(o -> new NaverBlogEntity(o.getBloggerlink(),
                                                                                                                 o.getTitle(),
                                                                                                                 o.getLink(),
                                                                                                                 o.getDescription(),
                                                                                                                 o.getBloggername())).collect(Collectors.toList());
        return naverBlogEntities;
    }
}
