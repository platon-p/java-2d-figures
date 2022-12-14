package org.bibbob.packagenameinpackagename;

import org.bibbob.packagenameinpackagename.figures.Figure;

public class Vector<T extends Number> implements Figure<T> {
    private Double x;
    private Double y;

    public Vector(T x, T y) {
        this.x = x.doubleValue();
        this.y = y.doubleValue();
    }

    public Vector() {
        this.x = 0.0;
        this.y = 0.0;
    }

    public Vector<T> rotate(Double angle) {
        Vector<T> result = new Vector<>();
        result.x = x * Math.cos(angle) - y * Math.sin(angle);
        result.y = x * Math.sin(angle) + y * Math.cos(angle);
        return result;
    }

    public Double getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x.doubleValue();
    }

    public void setX(Double x) {
        this.x = x;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Double getY() {
        return y;
    }

    public void setY(T y) {
        this.y = y.doubleValue();
    }

    public double getLength() {
        return Math.sqrt(x * x + y * y);
    }

    public Vector<Double> subtract(Vector<T> vector) {
        return new Vector<>(x - vector.x, y - vector.y);
    }

    public Vector<T> add(Vector<T> vector) {
        Vector<T> v = new Vector<>();
        v.setX(x + vector.x);
        v.setY(y + vector.y);
        return v;
    }

    @Override
    public <S extends Number> void move(Vector<S> vector) {
        x += vector.getX();
        y += vector.getY();
    }

    @Override
    public Double getArea() {
        return 0.;
    }

    @Override
    public Double getPerimeter() {
        return getLength();
    }

    @Override
    public String toString() {
        return String.format("-> (%s %s)", x, y);
    }
}
