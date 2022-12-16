package com.yonghyeonJo.searchBlog.ctr;

import com.yonghyeonJo.searchBlog.model.NaverBlogEntity;
import com.yonghyeonJo.searchBlog.svc.impl.NaverBlogSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;



/**
*
* @className: ServerAPIController
* @description: 검색한 문자열을 전달받아 검색결과를 반환해주는 컨트롤러
* ===========================================================
*    AUTHOR             DATE                  NOTE
* -----------------------------------------------------------
* joyonghyeon    2022/12/16/1:01 PM         최초 생성
*
*/
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/restaurant")
public class ServerAPIController {

    private final NaverBlogSearchService naverBlogSearchService;


    @GetMapping("/searchBlog")
    public ModelAndView searchBlog(@RequestParam String query) throws Exception {

        List<NaverBlogEntity>  search_result = naverBlogSearchService.searchService(query);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/home/main");
        mav.addObject("search_result", search_result);
        return mav;
    }
}

/**
 *
 */
