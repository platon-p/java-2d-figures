package org.bibbob.packagenameinpackagename.figures;

import org.bibbob.packagenameinpackagename.Point;
import org.bibbob.packagenameinpackagename.Vector;

import java.util.ArrayList;

public class Triangle<T extends Number> implements Figure<T> {
    private Point<T> a;
    private Point<T> b;
    private Point<T> c;

    private Boolean validate() {
        Vector<Double> ab = a.getDistance(b), bc = b.getDistance(c), ca = c.getDistance(a);
        ArrayList<Double> arr = new ArrayList<>();
        arr.add(ab.getLength());
        arr.add(bc.getLength());
        arr.add(ca.getLength());
        arr.sort(Double::compareTo);
        return arr.get(0) + arr.get(1) > arr.get(2);
    }

    public Triangle(Point<T> a, Point<T> b, Point<T> c) throws IllegalArgumentException {
        this.a = a;
        this.b = b;
        this.c = c;
        if (!validate()) {
            throw new IllegalArgumentException("Invalid triangle");
        }
    }

    /**
     * @param a    - left down point
     * @param side - side of equilateral triangle
     */
    public Triangle(Point<T> a, T side) {
        this.a = a;
        Vector<T> moveB = new Vector<>();
        moveB.setX(side);
        moveB.setY(0.0);
        moveB = moveB.rotate(Math.PI / 3);
        this.b = new Point<>(a.getCoordinates().add(moveB));
        this.c = new Point<>(a.getCoordinates().add(new Vector<>(side, side)));
    }

    @Override
    public <S extends Number> void move(Vector<S> vector) {
        a.move(vector);
        b.move(vector);
        c.move(vector);
    }

    @Override
    public Double getArea() {
        double p = getPerimeter() / 2;
        double ab = a.getDistance(b).getLength(), bc = b.getDistance(c).getLength(), ca = c.getDistance(a).getLength();
        return Math.sqrt(p * (p - ab) * (p - bc) * (p - ca));
    }

    @Override
    public Double getPerimeter() {
        return a.getDistance(b).getLength() + b.getDistance(c).getLength() + c.getDistance(a).getLength();
    }

    public Point<T> getA() {
        return a;
    }

    public Point<T> getB() {
        return b;
    }

    public Point<T> getC() {
        return c;
    }

    public void setA(Point<T> a) throws IllegalArgumentException {
        this.a = a;
        if (!validate()) {
            throw new IllegalArgumentException("Invalid triangle");
        }
    }

    public void setB(Point<T> b) throws IllegalArgumentException {
        this.b = b;
        if (!validate()) {
            throw new IllegalArgumentException("Invalid triangle");
        }
    }

    public void setC(Point<T> c) throws IllegalArgumentException {
        this.c = c;
        if (!validate()) {
            throw new IllegalArgumentException("Invalid triangle");
        }
    }

    @Override
    public String toString() {
        return String.format("∆ { %s %s %s }; Area: %s, perimeter: %s", a, b, c, getArea(), getPerimeter());
    }
}
