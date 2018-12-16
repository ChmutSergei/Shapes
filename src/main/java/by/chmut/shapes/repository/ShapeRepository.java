package by.chmut.shapes.repository;

import by.chmut.shapes.entity.Cube;
import by.chmut.shapes.entity.Shape;
import by.chmut.shapes.specification.Specification;

import java.util.*;
import java.util.stream.Collectors;

public class ShapeRepository implements Repository<Shape> {

    private static ShapeRepository instance;
    private static Map<Long, Shape> repository;

    private ShapeRepository() {
        repository = new LinkedHashMap<>();
    }

    public static synchronized ShapeRepository getInstance() {
        if (instance == null) {
            instance = new ShapeRepository();
        }
        return instance;
    }

    @Override
    public void add(Shape shape) {
        repository.put(shape.getId(), shape);
    }

    @Override
    public void remove(Shape shape) {
        repository.remove(shape.getId());
    }

    @Override
    public void update(Shape shape) {
        this.add(shape);
    }

    @Override
    public List<Shape> getAll() {
        return repository.entrySet().stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    @Override
    public void sort(Comparator<Shape> comparator) {
        repository  = repository.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(comparator))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

    @Override
    public List<Shape> query(Specification specification) {
        List<Shape> result = new ArrayList<>();
        for (Map.Entry entry : repository.entrySet()) {
            if (specification.specify(entry.getValue())) {
                result.add((Cube) entry.getValue());
            }
        }
        return result;
    }
}
