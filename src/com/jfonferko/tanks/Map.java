package com.jfonferko.tanks;

import java.util.Random;

public class Map
{
    private int regularCount;
    private int fortifiedCount;
    private int indestructibleCount;
    private int sizeX;
    private int sizeY;
    private Field[][] fields;
    private static Random rn = new Random();
    private Player[] players = new Player[2];

    public Map(int sizeX, int sizeY, int regular, int fortified, int indestructable) throws Exception
    {
        initializeMap(sizeX, sizeY, regular, fortified, indestructable);
        createPlayers();
        fillMap();
    }

    private boolean isFieldEmpty(int positionX, int positionY)
    {
        return this.fields[positionX][positionY].getField_type().equals(FIELD_TYPE.EMPTY);
    }

    private void initializeMap(int sizeX, int sizeY, int regular, int fortified, int indestrucible) throws Exception
    {
        if (sizeX * sizeY > regular + fortified + indestrucible)
        {

            this.sizeX = sizeX;
            this.sizeY = sizeY;
            this.regularCount = regular;
            this.fortifiedCount = fortified;
            this.indestructibleCount = indestrucible;
            this.fields = new Field[sizeX][sizeY];

            for (int x = 0; x < sizeX; x++)
            {
                for (int y = 0; y < sizeY; y++)
                {
                    this.fields[x][y] = new Field(FIELD_TYPE.EMPTY);
                }
            }
        }
        else
            throw new Exception("There are more special fields than map has");
    }

    public void createPlayers()
    {
        players[0] = new Player();
        players[0].setPosition(0, 0);

        players[1] = new Player();
        players[1].setPosition(sizeX - 1, sizeY - 1);
    }

    public void fillMap()
    {
        setFields(regularCount, FIELD_TYPE.REGULAR);
        setFields(fortifiedCount, FIELD_TYPE.FORTIFIED);
        setFields(indestructibleCount, FIELD_TYPE.INDESTRUCTIBLE);
    }

    public void printmap()
    {
        for (int x = 0; x < this.sizeX; x++)
        {
            System.out.print("|");
            for (int y = 0; y < this.sizeY; y++)
            {
                if (players[0].getPositionX() == x && players[0].getPositionY() == y)
                {
                    System.out.print("1|");
                    continue;
                }
                if (players[1].getPositionX() == x && players[1].getPositionY() == y)
                {
                    System.out.print("2|");
                    continue;
                }
                System.out.print(this.fields[x][y].getField_type().getSign() + "|");
            }
            System.out.println();
        }
    }

    private void setFields(int count, FIELD_TYPE field_type)
    {
        int x = 0;
        while (x < count)
        {
            int randomX = getRandomValue(this.sizeX);
            int randomY = getRandomValue(this.sizeY);
            if (isFieldEmpty(randomX, randomY) || (randomX != 0 && randomY != 0) || (randomX != sizeX && randomY != sizeY))
            {
                this.fields[randomX][randomY] = new Field(field_type);
                x++;
            }
        }
    }

    private int getRandomValue(int range)
    {
        return rn.nextInt(range);
    }

    public Player[] getPlayers()
    {
        return players;
    }

    public void setPlayers(Player[] players)
    {
        this.players = players;
    }
}
