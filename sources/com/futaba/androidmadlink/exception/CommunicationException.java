package com.futaba.androidmadlink.exception;

public class CommunicationException extends Exception {
    private static final long serialVersionUID = -3039306024922902759L;

    public CommunicationException() {
    }

    public CommunicationException(String detailMessage) {
        super(detailMessage);
    }
}
