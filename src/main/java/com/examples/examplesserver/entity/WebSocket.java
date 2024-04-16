package com.examples.examplesserver.entity;

import jakarta.websocket.Session;

public class WebSocket {
    private String uri;
    private Session session;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
