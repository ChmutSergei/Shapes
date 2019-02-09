package by.chmut.shapes.action;

import by.chmut.shapes.entity.Shape;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ServiceFactory {

    private final Logger logger = LogManager.getLogger();
    private static ServiceFactory instance;

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        if (instance == null) {
            instance = new ServiceFactory();
        }
        return instance;
    }

    public Service getService(Shape shape) {
        String name = shape.getClass().getSimpleName();
        switch (name) {
            case "Cube":
                return new CubeService();
            default:
                logger.fatal("Shape has no type name");
                throw new RuntimeException("Incorrect shape!");
        }
    }

}
