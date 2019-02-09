package by.chmut.shapes.entity;

import by.chmut.shapes.observer.ShapeEvent;
import by.chmut.shapes.observer.ShapeObserver;
import by.chmut.shapes.util.IdGenerator;

import java.util.Arrays;

public class Cube implements Shape {

    private long id;
    private Point[] points;
    private ShapeObserver observer;

    public Cube() {
        this.id = IdGenerator.generateId();
    }

    public long getId() {
        return id;
    }

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
                Arrays.equals(points, cube.points);
    }

    @Override
    public int hashCode() {
        int result = (int)(id^(id>>>32));
        result = 31 * result + Arrays.hashCode(points);
        return result;
    }

    @Override
    public String toString() {
        return "Cube{" +
                "id=" + id +
                ", points=" + Arrays.toString(points) +
                '}';
    }
}
