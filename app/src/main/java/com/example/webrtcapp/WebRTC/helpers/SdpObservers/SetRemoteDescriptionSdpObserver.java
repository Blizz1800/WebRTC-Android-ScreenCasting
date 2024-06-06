package com.example.webrtcapp.WebRTC.helpers.SdpObservers;

import com.example.webrtcapp.WebRTC.WebRTCClient;
import com.example.webrtcapp.WebRTC.helpers.CustomObserver;
import com.example.webrtcapp.WebRTC.helpers.SdpObservers.SdpInterfaces.SetSdp;

import org.webrtc.SdpObserver;
import org.webrtc.SessionDescription;

public class SetRemoteDescriptionSdpObserver extends CustomObserver implements SetSdp {
    protected SetRemoteDescriptionSdpObserver(WebRTCClient webRTC) {
        super(webRTC);
    }

    @Override
    public void onSetSuccess() {

    }

    @Override
    public void onSetFailure(String s) {

    }

}
