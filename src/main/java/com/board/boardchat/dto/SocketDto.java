package com.board.boardchat.dto;

import com.board.boardchat.common.enumtype.MessageType;

public class SocketDto {

    //message
    private String msg;
    //user 닉네임
    private String nick;
    //message Type
    private MessageType messageType;

    public SocketDto(String nick, String msg) {
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }
}
