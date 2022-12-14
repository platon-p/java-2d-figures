package org.bibbob.packagenameinpackagename.figures;

import org.bibbob.packagenameinpackagename.Vector;

public interface Figure<T extends Number> {
    <S extends Number> void move(Vector<S> vector);

    Double getArea();

    Double getPerimeter();
}
