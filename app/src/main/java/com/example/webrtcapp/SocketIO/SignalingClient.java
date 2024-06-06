package com.example.webrtcapp.SocketIO;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

import org.json.JSONObject;

import java.net.URI;
import java.net.URISyntaxException;

public class SignalingClient {
    private Socket socket;

    public SignalingClient(String uri) throws URISyntaxException {
        socket = IO.socket(uri);

        socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                // Implement this
            }
        }).on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                // Implement this
            }
        }).on(Socket.EVENT_CONNECT_ERROR, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                // Implement this
            }
        });

    }

    public void emit(String event, JSONObject data) {
        socket.emit(event, data);
    }

    public void on(String event, Emitter.Listener listener) {
        socket.on(event, listener);
    }

    public void connect() {
        socket.connect();
    }
}