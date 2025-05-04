package com.my.bbs.service.impl;


import com.my.bbs.service.SuggestionService;
import com.my.bbs.util.Result;
import com.my.bbs.util.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SuggestionServiceImpl implements SuggestionService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String from;

    @Value("${target.qq.email}")
    private String to;

    @Override
    public Result sendSuggestion(String content) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(from);
            message.setTo(to);
            message.setSubject("用户意见建议");
            message.setText(content);
            javaMailSender.send(message);
            return ResultGenerator.genSuccessResult("意见建议发送成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultGenerator.genFailResult("意见建议发送失败");
        }
    }
}