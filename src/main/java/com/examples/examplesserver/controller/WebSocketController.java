package com.examples.examplesserver.controller;

import com.examples.examplesserver.service.WebSocketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Date;

@RestController
@Slf4j
public class WebSocketController {

    @GetMapping(value = "/sendMessage")
    public void sendMessage() throws IOException {
        WebSocketService.sendMessage("后端向前端返回数据:" + new Date().toString(), "xg");
    }
}
