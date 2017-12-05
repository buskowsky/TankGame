package com.jfonferko.tanks;

public enum FIELD_TYPE
{
    EMPTY(" "), REGULAR("R"), FORTIFIED("F"), INDESTRUCTIBLE("I");

    String sign;

    FIELD_TYPE(String sign)
    {
        this.sign= sign;
    }

    public String getSign()
    {
        return sign;
    }

    public void setSign(String sign)
    {
        this.sign = sign;
    }
}
