package com.board.boardchat.common;


import org.springframework.core.convert.ConversionException;

public abstract class AbstractDataConverter<Source, Target> implements DataConverter<Source, Target> {
    @Override
    public Target convert(Source source) throws ConversionException {
        return convert(source, createTarget());
    }

    protected abstract Target createTarget();
}
