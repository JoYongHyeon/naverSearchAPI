package com.yonghyeonJo.searchBlog.ctr;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
*
* PageController : 블로그 검색 화면 이동을 위한 컨트롤러 index.html ->
*
* @author joyonghyeon
* @version 1.0.0
* @date 2022/12/16
**/
@Slf4j
@Controller
public class PageController {

    @GetMapping("/home")
    public String main()
    {
        return "/home/main";
    }
}
