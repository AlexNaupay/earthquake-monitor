package com.earthquakemon.websocket;

public interface Brodcaster {
    static final String LATEST_EARTHQUAKE = "/notification/latest";

    void broadcast(String subscribers, Object data);
}
