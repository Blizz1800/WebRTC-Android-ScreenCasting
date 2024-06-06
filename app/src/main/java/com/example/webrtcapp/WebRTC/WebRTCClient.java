package com.example.webrtcapp.WebRTC;

import android.content.Context;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.webrtcapp.WebRTC.helpers.Constants;
import com.example.webrtcapp.WebRTC.helpers.PeerConnectionObserver;

import org.webrtc.*;

import java.util.ArrayList;

public class WebRTCClient {
    final String TAG = "WebRTCClient";

    // WebRTC Variables
    private PeerConnectionFactory peerConnectionFactory;
    public PeerConnection peerConnection;
    private MediaStream mediaStream;
    public MediaConstraints mediaConstraints;

    // Interfaces
    PeerConnectionObserver peerConnectionObserver;

    public WebRTCClient(Context context) {
        initVars();
    }

    public void initEverything(Context context){
        initPeerConnectionFactory(context);
        createLocalMediaStream();
        createVideoTrack();
        // createAudioTrack();
        createPeerConnection();
        addStreamToPeerConnection();
    }

    private void initVars(){
        mediaStream = null;
        peerConnection = null;
        peerConnectionFactory = null;
        peerConnectionObserver = new PeerConnectionObserver(this);
        mediaConstraints = new MediaConstraints();
    }

    private void initPeerConnectionFactory(Context context) {
        Log.i(TAG, "Initializing PeerConnectionFactory...");
        PeerConnectionFactory.InitializationOptions initializationOptions =
                PeerConnectionFactory.InitializationOptions.builder(context)
                        .createInitializationOptions();
        PeerConnectionFactory.initialize(initializationOptions);
        peerConnectionFactory = PeerConnectionFactory.builder()
                .createPeerConnectionFactory();
        Log.i(TAG, "Initialized PeerConnectionFactory!");
    }

    private void createVideoTrack(){
        Log.i(TAG, "Creating local Video and Audio Tracks!");
        // Create Local Video Track
        VideoSource videoSource = peerConnectionFactory.createVideoSource(true);
        VideoTrack videoTrack = peerConnectionFactory.createVideoTrack("ScreenCastVideoTrack", videoSource);
        mediaStream.addTrack(videoTrack);
    }

    private void createAudioTrack(){
        Log.i(TAG, "Creating local Audio Track!");
        // Create Local Audio Track
        AudioSource audioSource = peerConnectionFactory.createAudioSource(mediaConstraints);
        AudioTrack audioTrack = peerConnectionFactory.createAudioTrack("ScreenCastAudioTrack", audioSource);
        mediaStream.addTrack(audioTrack);
    }

    private void createLocalMediaStream() {
        Log.i(TAG, "Creating local media stream...");
        mediaStream = peerConnectionFactory.createLocalMediaStream("mediaStream");
        Log.i(TAG, "Created local media stream!");
    }

    private void createPeerConnection() {
        Log.i(TAG, "Creating PeerConnection...");
        PeerConnection.RTCConfiguration rtcConfig =
                new PeerConnection.RTCConfiguration(Constants.ICE_SERVERS);
        peerConnection = peerConnectionFactory.createPeerConnection(rtcConfig, peerConnectionObserver);
        Log.i(TAG, "Created PeerConnection!");
    }

    private void addStreamToPeerConnection() {
        Log.i(TAG, "Adding local media stream to PeerConnection...");
        peerConnection.addStream(mediaStream);
        // peerConnection automatic committed changes on addStream
        Log.i(TAG, "Added local media stream to PeerConnection!");
    }
}