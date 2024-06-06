package com.example.webrtcapp.WebRTC.helpers;

import com.example.webrtcapp.WebRTC.WebRTCClient;

public abstract class CustomObserver {
    protected final WebRTCClient webRTC;

    protected CustomObserver(WebRTCClient webRTC) {
        this.webRTC = webRTC;
    }
}
