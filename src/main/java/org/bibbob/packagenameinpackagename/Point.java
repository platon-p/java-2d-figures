package org.bibbob.packagenameinpackagename;

import org.bibbob.packagenameinpackagename.figures.Figure;

public class Point<T extends Number> implements Figure<T> {
    private Vector<T> coordinates;

    public Point(T x, T y) {
        coordinates = new Vector<>(x, y);
    }

    public Point(Vector<T> coordinates) {
        this.coordinates = new Vector<T>().add(coordinates);
    }

    public Vector<T> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Vector<T> coordinates) {
        this.coordinates = coordinates;
    }

    public Vector<Double> getDistance(Point<T> point) {
        return coordinates.subtract(point.coordinates);
    }

    @Override
    public <S extends Number> void move(Vector<S> vector) {
        this.coordinates.move(vector);
    }

    @Override
    public Double getArea() {
        return 0.;
    }

    @Override
    public Double getPerimeter() {
        return 0.;
    }

    @Override
    public String toString() {
        return String.format("(%s %s)", coordinates.getX(), coordinates.getY());
    }
}
