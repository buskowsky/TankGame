package com.jfonferko.tanks;

public class Bomb extends Weapon
{
    private int timeToExplode;

    public int getTimeToExplode()
    {
        return timeToExplode;
    }

    public void setTimeToExplode(int timeToExplode)
    {
        this.timeToExplode = timeToExplode;
    }
}
