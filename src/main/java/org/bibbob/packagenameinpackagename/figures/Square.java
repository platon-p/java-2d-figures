package org.bibbob.packagenameinpackagename.figures;

import org.bibbob.packagenameinpackagename.Point;
import org.bibbob.packagenameinpackagename.Vector;

public class Square<T extends Number> implements Figure<T> {
    private Point<T> point;
    private Vector<T> side; // left side

    public Square(Point<T> point, Vector<T> side) {
        this.point = point;
        this.side = side;
    }

    @Override
    public <S extends Number> void move(Vector<S> vector) {
        point.move(vector);
    }

    @Override
    public Double getArea() {
        return side.getLength() * side.getLength();
    }

    @Override
    public Double getPerimeter() {
        return 4 * side.getLength();
    }

    @Override
    public String toString() {
        return String.format("[] %s, side: %s, area: %s, perimeter: %s", point, side.getLength(), getArea(), getPerimeter());
    }

    public Point<T> getPoint() {
        return point;
    }

    public void setPoint(Point<T> point) {
        this.point = point;
    }

    public Vector<T> getSide() {
        return side;
    }

    public void setSide(Vector<T> side) {
        this.side = side;
    }
}
