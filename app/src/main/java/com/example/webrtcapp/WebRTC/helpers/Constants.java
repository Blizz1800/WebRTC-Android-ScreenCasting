package com.example.webrtcapp.WebRTC.helpers;

import org.webrtc.PeerConnection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Constants {
    public static final List<PeerConnection.IceServer> ICE_SERVERS = Arrays.asList(
            PeerConnection.IceServer.builder("stun:stun.relay.metered.ca:80").createIceServer(),
            PeerConnection.IceServer.builder("turn:global.relay.metered.ca:80")
                    .setUsername("ef20ea7fb58f60a104894329")
                    .setPassword("KccuwUQetvqKrtJB")
                    .createIceServer(),
            PeerConnection.IceServer.builder("turn:global.relay.metered.ca:80?transport=tcp")
                    .setUsername("ef20ea7fb58f60a104894329")
                    .setPassword("KccuwUQetvqKrtJB")
                    .createIceServer(),
            PeerConnection.IceServer.builder("turn:global.relay.metered.ca:443")
                    .setUsername("ef20ea7fb58f60a104894329")
                    .setPassword("KccuwUQetvqKrtJB")
                    .createIceServer(),
            PeerConnection.IceServer.builder("turns:global.relay.metered.ca:443?transport=tcp")
                    .setUsername("ef20ea7fb58f60a104894329")
                    .setPassword("KccuwUQetvqKrtJB")
                    .createIceServer()
    );
}
