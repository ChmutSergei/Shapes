package by.chmut.shapes.repository;

import by.chmut.shapes.action.Service;
import by.chmut.shapes.action.ServiceFactory;
import by.chmut.shapes.entity.Cube;
import by.chmut.shapes.entity.Shape;
import by.chmut.shapes.specification.ByIdSpecification;
import by.chmut.shapes.specification.Specification;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ShapeRepositoryTest {

    private Shape shape;
    private Service<Shape> service;
    private ShapeRepository repository = ShapeRepository.getInstance();
    private Specification specification;

    @BeforeMethod
    public void setUp() {
        shape = new Cube();
        service = ServiceFactory.getInstance().getService(shape);
    }

    @AfterMethod
    public void tearDown() {
        shape = null;
        service = null;
    }

    @Test(priority = 0)
    public void addTest() {
        int sizeRepositoryBeforeAdding = repository.findAll().size();
        repository.add(shape);
        int actual = repository.findAll().size();
        int expected = sizeRepositoryBeforeAdding + 1;
        Assert.assertEquals(actual, expected);
    }

    @Test(priority = 1)
    public void removeTest() {
        repository.add(shape);
        int sizeRepositoryAfterAdding = repository.findAll().size();
        repository.remove(shape);
        int actual = repository.findAll().size();
        int expected = sizeRepositoryAfterAdding - 1;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void updateTestShapeNotExist() {
        int sizeRepositoryBeforeAdding = repository.findAll().size();
        repository.update(shape);
        int actual = repository.findAll().size();
        int expected = sizeRepositoryBeforeAdding + 1;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void updateTestShapeExist() {
        repository.add(shape);
        int sizeRepositoryBeforeAdding = repository.findAll().size();
        repository.update(shape);
        int actual = repository.findAll().size();
        int expected = sizeRepositoryBeforeAdding;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void sortTest() {
        int index = 0;
        repository.add(shape);
        repository.add(new Cube());
        Shape actual = repository.findAll().get(index);
        repository.sort((o1, o2) -> (int)service.getId(o2) - (int)service.getId(o1));
        Shape expected = repository.findAll().get(index);
        Assert.assertNotEquals(actual, expected);
    }

    @Test
    public void queryTest() {
        Shape expected = new Cube();
        repository.add(expected);
        long id = service.getId(expected);
        specification = new ByIdSpecification(id);
        List<Shape> list = repository.query(specification);
        Shape actual = list.get(0);
        Assert.assertEquals(actual, expected);
    }
}
