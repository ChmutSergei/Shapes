package by.chmut.shapes.repository;

import by.chmut.shapes.entity.Cube;
import by.chmut.shapes.entity.Shape;
import by.chmut.shapes.specification.ById;
import by.chmut.shapes.specification.Specification;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ShapeRepositoryTest {

    private Shape shape;
    private ShapeRepository repository = ShapeRepository.getInstance();
    private Specification specification;

    @BeforeMethod
    public void setUp() {
        shape = new Cube();
    }

    @AfterMethod
    public void tearDown() {
        shape = null;
    }

    @Test(priority = 0)
    public void addTest() {
        int sizeRepositoryBeforeAdding = repository.getAll().size();
        repository.add(shape);
        int actual = repository.getAll().size();
        int expected = sizeRepositoryBeforeAdding + 1;
        Assert.assertEquals(actual, expected);
    }

    @Test(priority = 1)
    public void removeTest() {
        repository.add(shape);
        int sizeRepositoryAfterAdding = repository.getAll().size();
        repository.remove(shape);
        int actual = repository.getAll().size();
        int expected = sizeRepositoryAfterAdding - 1;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void updateTestShapeNotExist() {
        int sizeRepositoryBeforeAdding = repository.getAll().size();
        repository.update(shape);
        int actual = repository.getAll().size();
        int expected = sizeRepositoryBeforeAdding + 1;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void updateTestShapeExist() {
        repository.add(shape);
        int sizeRepositoryBeforeAdding = repository.getAll().size();
        repository.update(shape);
        int actual = repository.getAll().size();
        int expected = sizeRepositoryBeforeAdding;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void sortTest() {
        int index = 0;
        repository.add(shape);
        repository.add(new Cube());
        Shape actual = repository.getAll().get(index);
        repository.sort(Comparator.comparingLong(Shape::getId).reversed());
        Shape expected = repository.getAll().get(index);
        Assert.assertNotEquals(actual, expected);
    }

    @Test
    public void queryTest() {
        Shape expected = new Cube();
        repository.add(expected);
        specification = new ById(expected.getId());
        List<Shape> list = repository.query(specification);
        Shape actual = list.get(0);
        Assert.assertEquals(actual, expected);
    }
}
