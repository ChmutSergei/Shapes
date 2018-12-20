package by.chmut.shapes.repository;

import by.chmut.shapes.entity.Shape;
import by.chmut.shapes.specification.Specification;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ShapeRepository implements Repository<Shape> {

    private static ShapeRepository instance;
    private static List<Shape> repository;

    private ShapeRepository() {
        repository = new ArrayList<>();
    }

    public static synchronized ShapeRepository getInstance() {
        if (instance == null) {
            instance = new ShapeRepository();
        }
        return instance;
    }

    @Override
    public void add(Shape shape) {
        repository.add(shape);
    }

    @Override
    public void remove(Shape shape) {
        repository.remove(shape);
    }

    @Override
    public void update(Shape shape) {
        if (!repository.contains(shape)) {
            repository.add(shape);
        }
    }

    @Override
    public List<Shape> getAll() {
        return Collections.unmodifiableList(repository);
    }

    @Override
    public void sort(Comparator<Shape> comparator) {
        repository.sort(comparator);
    }

    @Override
    public List<Shape> query(Specification specification) {
        List<Shape> result = new ArrayList<>();
        for (Shape shape : repository) {
            if (specification.specify(shape)) {
                result.add(shape);
            }
        }
        return result;
    }
}
