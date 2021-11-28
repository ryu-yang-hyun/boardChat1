package com.board.boardchat.common.enumtype;

public enum TodoType implements EnumModel {

    TODO( "할일"),
    IN_PROGRESS("진행중"),
    DONE( "완료"),
    SAVE("보관함"),;

    private String value;

    TodoType(String value) {
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