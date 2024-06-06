package com.example.webrtcapp.WebRTC.helpers;

import com.example.webrtcapp.WebRTC.WebRTCClient;
import com.example.webrtcapp.WebRTC.helpers.SdpObservers.CreateOfferSdpObserver;
import com.example.webrtcapp.WebRTC.helpers.SdpObservers.SetLocalDescriptionSdpObserver;

import org.webrtc.DataChannel;
import org.webrtc.IceCandidate;
import org.webrtc.MediaStream;
import org.webrtc.PeerConnection;
import org.webrtc.RtpReceiver;
import org.webrtc.SdpObserver;
import org.webrtc.SessionDescription;

public class PeerConnectionObserver extends CustomObserver implements PeerConnection.Observer {
    public PeerConnectionObserver(WebRTCClient webRTC) {
        // Constructor
        super(webRTC);
    }

    @Override
    public void onSignalingChange(PeerConnection.SignalingState signalingState) {
        switch (signalingState) {

            case HAVE_LOCAL_OFFER:
                // Create an offer
                webRTC.peerConnection.createOffer(new CreateOfferSdpObserver(webRTC), webRTC.mediaConstraints);
                break;

            case HAVE_REMOTE_OFFER:
                /* The HAVE_REMOTE_OFFER signaling state in WebRTC indicates that a remote
                description of type "offer" has been successfully applied. This typically happens
                when you receive an offer from the remote peer and set it as the remote description
                of your PeerConnection.  In the context of your code, you might handle this in the
                onSignalingChange method of your PeerConnectionObserver class. When the signaling
                state changes to HAVE_REMOTE_OFFER, you can create an answer and send it to the
                remote peer. */
                break;

            case HAVE_LOCAL_PRANSWER:
                /* The HAVE_LOCAL_PRANSWER signaling state in WebRTC indicates that a local
                description of type "pranswer" has been successfully applied.  A "pranswer", or
                provisional answer, is a type of answer that can be used when the remote peer wants
                to start sending media before the final answer is received. This can be useful in
                scenarios where media needs to be set up as quickly as possible, and the
                negotiation process can't wait for the full offer-answer exchange to complete. */
                break;

            case HAVE_REMOTE_PRANSWER:
                /* The HAVE_REMOTE_PRANSWER signaling state in WebRTC indicates that a remote
                description of type "pranswer" has been successfully applied.  A "pranswer", or
                provisional answer, is a type of answer that can be used when the local peer wants
                to start receiving media before the final answer is received. This can be useful in
                scenarios where media needs to be set up as quickly as possible, and the negotiation
                process can't wait for the full offer-answer exchange to complete. */
                break;

            case CLOSED:
                break;
        }
    }

    @Override
    public void onIceConnectionChange(PeerConnection.IceConnectionState iceConnectionState) {

    }

    @Override
    public void onIceConnectionReceivingChange(boolean b) {

    }

    @Override
    public void onIceGatheringChange(PeerConnection.IceGatheringState iceGatheringState) {

    }

    @Override
    public void onIceCandidate(IceCandidate iceCandidate) {

    }

    @Override
    public void onIceCandidatesRemoved(IceCandidate[] iceCandidates) {

    }

    @Override
    public void onAddStream(MediaStream mediaStream) {

    }

    @Override
    public void onRemoveStream(MediaStream mediaStream) {

    }

    @Override
    public void onDataChannel(DataChannel dataChannel) {

    }

    @Override
    public void onRenegotiationNeeded() {

    }

    @Override
    public void onAddTrack(RtpReceiver rtpReceiver, MediaStream[] mediaStreams) {

    }
}
