package com.jfonferko.tanks;

public class Field
{
    private FIELD_TYPE field_type = FIELD_TYPE.EMPTY;

    private Field(){}

    public Field(FIELD_TYPE field_type)
    {
        this.field_type = field_type;
    }

    public FIELD_TYPE getField_type()
    {
        return field_type;
    }

    public void setField_type(FIELD_TYPE field_type)
    {
        this.field_type = field_type;
    }

}
