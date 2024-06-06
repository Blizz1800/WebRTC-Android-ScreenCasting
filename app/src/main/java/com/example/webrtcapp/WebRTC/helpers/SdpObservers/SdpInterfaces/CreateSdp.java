package com.example.webrtcapp.WebRTC.helpers.SdpObservers.SdpInterfaces;

import org.webrtc.SdpObserver;
import org.webrtc.SessionDescription;

public interface CreateSdp extends SdpObserver {
    @Override
    public default void onSetSuccess() {}

    @Override
    public default void onSetFailure(String s) {}

    @Override
    public void onCreateFailure(String s);
    @Override
    public void onCreateSuccess(SessionDescription sessionDescription);
}
