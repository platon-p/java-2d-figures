package org.bibbob.packagenameinpackagename;

import org.bibbob.packagenameinpackagename.figures.Square;
import org.bibbob.packagenameinpackagename.figures.Triangle;

public class Main {
    public static void main(String[] args) {
        // Square
        Square<Integer> square = new Square<>(new Point<>(0, 0), new Vector<>(1, 0));
        System.out.println("INFO: " + square);
        System.out.println("Perimeter: " + square.getPerimeter().toString());
        System.out.println("Area: " + square.getArea().toString());

        // example of changing side
        // square.setSide(new Vector<>(4, 0));

        // move
        square.move(new Vector<>(1, 2));
        System.out.println("INFO: " + square);
        System.out.println("Perimeter: " + square.getPerimeter().toString());
        System.out.println("Area: " + square.getArea().toString());

        // Triangle
        Triangle<Integer> triangle = new Triangle<>(new Point<>(0, 0), new Point<>(2, 0), new Point<>(1, 5));
        System.out.println("INFO: " + triangle);
        System.out.println("Perimeter: " + triangle.getPerimeter().toString());
        System.out.println("Area: " + triangle.getArea().toString());

        // move
        triangle.move(new Vector<>(1, 2));
        System.out.println("INFO: " + triangle);
        System.out.println("Perimeter: " + triangle.getPerimeter().toString());
        System.out.println("Area: " + triangle.getArea().toString());

    }
}