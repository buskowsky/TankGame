package com.jfonferko.tanks;

public class Player
{
    private String name;
    private int positionX;
    private int positionY;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getPositionX()
    {
        return positionX;
    }

    public void setPositionX(int positionX)
    {
        this.positionX = positionX;
    }

    public int getPositionY()
    {
        return positionY;
    }

    public void setPositionY(int positionY)
    {
        this.positionY = positionY;
    }

    public void setPosition(int x, int y)
    {
        this.positionX = x;
        this.positionY = y;
    }

}
