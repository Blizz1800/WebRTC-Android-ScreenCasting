package com.example.webrtcapp.WebRTC.helpers.SdpObservers;

import com.example.webrtcapp.WebRTC.WebRTCClient;
import com.example.webrtcapp.WebRTC.helpers.CustomObserver;
import com.example.webrtcapp.WebRTC.helpers.SdpObservers.SdpInterfaces.CreateSdp;

import org.webrtc.*;

public class CreateOfferSdpObserver extends CustomObserver implements CreateSdp {

    public CreateOfferSdpObserver(WebRTCClient webRTC) {
        super(webRTC);
    }

    @Override
    public void onCreateSuccess(SessionDescription sessionDescription) {
        // Implement this
        // Set the local description to the created offer
        this.webRTC.peerConnection.setLocalDescription(new SetLocalDescriptionSdpObserver(this.webRTC), sessionDescription);
    }

    @Override
    public void onCreateFailure(String s) {
        // Implement this
    }
}
