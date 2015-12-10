package com.github.felipecao.rover.entity;

/**
 * Created by felipe on 10/12/15.
 */
public class Coordinates {
    protected Integer x;
    protected Integer y;

    public Coordinates(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinates that = (Coordinates) o;

        if (x != null ? !x.equals(that.x) : that.x != null) return false;
        return !(y != null ? !y.equals(that.y) : that.y != null);

    }

    @Override
    public String toString() {
        return "{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }


}
