package com.my.bbs.controller.rest;

import com.my.bbs.service.SuggestionService;
import com.my.bbs.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SuggestionController {

    @Autowired
    private SuggestionService suggestionService;

    // 处理意见建议提交
    @PostMapping("/submitSuggestion")
    public Map<String, Object> submitSuggestion(@RequestParam("suggestionContent") String content) {
        Map<String, Object> result = new HashMap<>();
        try {
            // 调用服务层发送邮件
            Result serviceResult = suggestionService.sendSuggestion(content);
            result.put("resultCode", serviceResult.getResultCode());
            result.put("message", serviceResult.getMessage());
        } catch (Exception e) {
            result.put("resultCode", 500);
            result.put("message", "意见建议提交失败：" + e.getMessage());
        }
        return result;  // 返回 JSON 响应
    }
}
