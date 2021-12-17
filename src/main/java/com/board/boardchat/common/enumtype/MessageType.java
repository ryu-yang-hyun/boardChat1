package com.board.boardchat.common.enumtype;

public enum MessageType implements EnumModel {

    INFO( "info"),
    CHAT("chat"),
    TYPING( "typing"),;

    private String value;

    MessageType(String value) {
        this.value = value;
    }

    @Override
    public String getKey() {
        return null;
    }

    @Override
    public String getValue() {
        return null;
    }
}