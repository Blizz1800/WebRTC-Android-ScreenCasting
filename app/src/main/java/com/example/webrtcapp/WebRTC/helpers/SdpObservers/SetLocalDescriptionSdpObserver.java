package com.example.webrtcapp.WebRTC.helpers.SdpObservers;

import com.example.webrtcapp.WebRTC.WebRTCClient;
import com.example.webrtcapp.WebRTC.helpers.CustomObserver;
import com.example.webrtcapp.WebRTC.helpers.SdpObservers.SdpInterfaces.SetSdp;

import org.webrtc.SdpObserver;
import org.webrtc.SessionDescription;

public class SetLocalDescriptionSdpObserver extends CustomObserver implements SetSdp {

    public SetLocalDescriptionSdpObserver(WebRTCClient webRTC) {
        super(webRTC);
    }

    @Override
    public void onSetSuccess() {
        // Implement this
        // Send the offer to the remote peer
        // This will depend on your signaling implementation
    }

    @Override
    public void onSetFailure(String s) {
        // Implement this
    }
}
