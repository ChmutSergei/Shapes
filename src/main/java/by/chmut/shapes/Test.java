package by.chmut.shapes;

import by.chmut.shapes.action.Service;
import by.chmut.shapes.action.ServiceFactory;
import by.chmut.shapes.creator.CubeCreator;
import by.chmut.shapes.creator.ShapeCreator;
import by.chmut.shapes.entity.Cube;
import by.chmut.shapes.entity.Point;
import by.chmut.shapes.entity.Shape;
import by.chmut.shapes.entity.SomeAnotherShape;
import by.chmut.shapes.exception.DataException;
import by.chmut.shapes.parser.DataParser;
import by.chmut.shapes.reader.DataReader;
import by.chmut.shapes.repository.Repository;
import by.chmut.shapes.repository.ShapeRepository;
import by.chmut.shapes.specification.ById;
import by.chmut.shapes.specification.Specification;

import java.util.*;

class Test {

    public static void main(String[] args) throws DataException {
        double[] numbers = {-21.2, -10.7, -18.3, -21.2, 54.3, -18.3, 43.8, 54.3, -18.3, 43.8, -10.7, -18.3, -21.2, -10.7,
                46.7, -21.2, 54.3, 46.7, 43.8, 54.3, 46.7, 43.8, -10.7, 46.7};
        ShapeCreator creator = new CubeCreator();
        Shape shape = creator.create(numbers);
        Service service = ServiceFactory.getInstance().getService(shape);
        System.out.println(service.isOnCartesianPlane(shape));
    }
    public static void main2(String[] args) {
        List<String> d = Arrays.asList("");
        DataReader reader = new DataReader();
        List<String> list = reader.read("/emptyTest.txt");
        DataParser parser = new DataParser();
        double[][] numbers = parser.parse(list);
        for (double[] array:numbers) {
            System.out.println(Arrays.toString(array));
        }
    }
    public static void main1(String[] args) {

        DataReader reader = new DataReader();
        List<String> list = reader.read("/cubes.txt");
        DataParser parser = new DataParser();
        double[][] numbers = parser.parse(list);
        ShapeCreator<Cube> creator = new CubeCreator();
        List<Shape> shapes = new ArrayList<>();
        Repository<Shape> repository = ShapeRepository.getInstance();
        for (double[] nums : numbers) {
            Shape shape = null;
            try {
                shape = creator.create(nums);
                shapes.add(shape);
                repository.add(shape);
            } catch (DataException e) {
                System.out.println(e.getMessage());
            }
        }
        Specification<Shape> querry = new ById(10055);
        repository.add(new SomeAnotherShape());
        repository.add(new SomeAnotherShape());

        List<Shape> result = repository.query(querry);
        System.out.println("\n \n !!!!!!!! \n" + result);

        repository.sort((Comparator.comparing(Shape::getName)).thenComparing(Shape::getId).reversed());

        List<Shape> list1 = repository.getAll();
        for (Shape shape:list1 ) {
            System.out.println(shape);
        }

//        changePosit(cube);
//        System.out.println("!!!!" + Validator.isCube(cube.getPoints()) + "!!!!!!");
//        for (int i = 0; i < 30; i++) {
//            cube = changeCube(cube);
//            Point[] points = cube.getPoints();
//            for (Point point : points) {
//                System.out.print(point.getX() + " " + point.getY() + " " + point.getZ() + " ");
//            }
//            System.out.print("\n");
//        }


    }

    private static Cube changePosit(Cube cube) {
        Point[] points = cube.getPoints();
        for (Point point : points) {
            point.setX(point.getX() - 21.2);
            point.setY(point.getY() - 10.7);
            point.setZ(point.getZ() - 18.3);
        }
        cube.setPoints(points);
        return cube;
    }

    private static Cube changeCube(Cube cube) {
        Point[] points = cube.getPoints();
        points[1].setY(points[1].getY() + 2);
        points[3].setX(points[3].getX() + 2);
        points[2].setY(points[2].getY() + 2);
        points[2].setX(points[2].getX() + 2);
        points[4].setZ(points[4].getZ() + 2);
        points[5].setY(points[5].getY() + 2);
        points[5].setZ(points[5].getZ() + 2);
        points[6].setX(points[6].getX() + 2);
        points[6].setY(points[6].getY() + 2);
        points[6].setZ(points[6].getZ() + 2);
        points[7].setX(points[7].getX() + 2);
        points[7].setZ(points[7].getZ() + 2);
        cube.setPoints(points);
        return cube;
    }

}
interface C{}
interface D extends C{}