package by.chmut.shapes.entity;


import by.chmut.shapes.action.Service;
import by.chmut.shapes.util.IdGenerator;

import java.util.Objects;

public class SomeAnotherShape implements Shape{

    private long id;
    private String name = "SomeShape";
    private Service<SomeAnotherShape> service;

    public SomeAnotherShape() {
        this.id = IdGenerator.getId();
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Point[] getPoints() {
        return new Point[0];
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        SomeAnotherShape that = (SomeAnotherShape) object;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(service, that.service);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, service);
    }

    @Override
    public String toString() {
        return "SomeAnotherShape{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", service=" + service +
                '}';
    }
}
