package com.example.webrtcapp.WebRTC.helpers.SdpObservers.SdpInterfaces;

import org.webrtc.SdpObserver;
import org.webrtc.SessionDescription;

public interface SetSdp extends SdpObserver {

    @Override
    public void onSetSuccess();

    @Override
    public void onSetFailure(String s);

    @Override
    public default void onCreateFailure(String s) {}
    @Override
    public default void onCreateSuccess(SessionDescription sessionDescription) {}

}
