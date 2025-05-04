package com.my.bbs.controller.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SuggestionPageController {

    // 返回页面（建议页面）
    @GetMapping("/suggestion")
    public String suggestionPage() {
        // 返回页面名称（假设页面名为 suggestion.html）
        return "suggestion";
    }
}
