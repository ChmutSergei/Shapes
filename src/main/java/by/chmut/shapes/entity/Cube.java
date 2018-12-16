package by.chmut.shapes.entity;


import by.chmut.shapes.observer.ShapeEvent;
import by.chmut.shapes.observer.Warehouse;
import by.chmut.shapes.util.IdGenerator;

import java.util.Arrays;
import java.util.Objects;

public class Cube implements Shape {

    private static final String NAME = "Cube";

    private long id;
    private Point[] points;
    private Warehouse warehouse;

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

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    private void notifyObservers() {
        if (warehouse != null) {
            warehouse.handleEvent(new ShapeEvent(this));
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Cube cube = (Cube) object;
        return id == cube.id &&
                Arrays.equals(points, cube.points) &&
                Objects.equals(warehouse, cube.warehouse);
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(id, warehouse);
        result = 31 * result + Arrays.hashCode(points);
        return result;
    }

    @Override
    public String toString() {
        return "Cube{" +
                "id=" + id +
                ", points=" + Arrays.toString(points) +
                warehouse.getParameters().get(id) +
                '}';
    }
}
