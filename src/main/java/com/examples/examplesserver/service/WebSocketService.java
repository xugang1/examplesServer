package com.examples.examplesserver.service;

import com.examples.examplesserver.entity.WebSocket;
import jakarta.websocket.*;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

@Service
@ServerEndpoint("/websocket/{username}")
@Slf4j
public class WebSocketService {

    private String username;

    private Session session;

    private static int onlineSum = 0;

    private static ConcurrentHashMap<String, WebSocket> webSocketMap = new ConcurrentHashMap<>();

    @OnOpen
    public void open(Session session, @PathParam("username") String username) {
        if(!webSocketMap.containsKey(username)) {
            onlineSum++;
        }
        this.username = username;
        this.session = session;

        WebSocket webSocket = new WebSocket();
        webSocket.setSession(session);
        webSocket.setUri(session.getRequestURI().toString());
        webSocketMap.put(username, webSocket);

        log.info("用户连接:" + username + "。当前连接人数:" + onlineSum);
        try {
            sendMessage("通知前端: 连接成功");
        }catch (Exception e) {
            log.error("用户:"+username+",网络异常!!!!!!");
        }
    }

    public void sendMessage(String message) throws IOException {
        synchronized (session) {
            this.session.getBasicRemote().sendText(message);
        }
    }

    public static void sendMessage(String message, String username) throws IOException {
        if(webSocketMap.containsKey(username)) {
            WebSocket webSocket = webSocketMap.get(username);
            if(webSocket != null) {
                webSocket.getSession().getBasicRemote().sendText(message);
            }
        }
    }

    @OnMessage
    public void message(String message, Session session) {
        log.info("收到用户消息:"+username+",报文:"+message);
        //可以群发消息
        //消息保存到数据库、redis
//        if(StringUtils.isNotBlank(message)){
//
//        }
    }

    @OnClose
    public void close() {
        if(webSocketMap.containsKey(username)) {
            onlineSum--;
            webSocketMap.remove(username);
        }
        log.info(username+"用户退出,当前在线人数为:" + onlineSum);
    }

    @OnError
    public void error(Session session, Throwable error) {
        log.error("用户错误:"+this.username+",原因:"+error.getMessage());
        error.printStackTrace();
    }
}
