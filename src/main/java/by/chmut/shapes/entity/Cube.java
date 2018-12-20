package by.chmut.shapes.entity;


import by.chmut.shapes.observer.ShapeEvent;
import by.chmut.shapes.observer.ShapeObserver;
import by.chmut.shapes.util.IdGenerator;
import by.chmut.shapes.warehouse.Warehouse;

import java.util.Arrays;
import java.util.Objects;

public class Cube implements Shape {

    private static final String NAME = "Cube";

    private long id;
    private Point[] points;
    private ShapeObserver observer;

    public Cube() {
        this.id = IdGenerator.getId();
    }
    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public Point[] getPoints() {
        return points;
    }

    public void setPoints(Point[] points) {
        this.points = points;
        notifyObservers();
    }

    public void setObserver(ShapeObserver observer) {
        this.observer = observer;
    }

    private void notifyObservers() {
        if (observer != null) {
            observer.handleEvent(new ShapeEvent(this));
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Cube cube = (Cube) object;
        return id == cube.id &&
                Arrays.equals(points, cube.points) &&
                Objects.equals(observer, cube.observer);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, observer);
        result = 31 * result + Arrays.hashCode(points);
        return result;
    }

    @Override
    public String toString() {
        return "Cube{" +
                "id=" + id +
                ", points=" + Arrays.toString(points) +
                Warehouse.getInstance().getMeasurements(id) +
                '}';
    }
}
