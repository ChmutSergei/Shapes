package by.chmut.shapes.repository;

import by.chmut.shapes.specification.Specification;
import java.util.Comparator;
import java.util.List;

public interface Repository<T> {

    void add(T t);
    void remove(T t);
    void update(T t);
    List<T> getAll ();
    void sort(Comparator<T> comparator);
    List<T> query(Specification specification);

}