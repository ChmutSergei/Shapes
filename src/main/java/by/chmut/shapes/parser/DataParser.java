package by.chmut.shapes.parser;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataParser {

    private static final Logger logger = LogManager.getLogger();
    private static final String DELIMITER = "\\p{Blank}";

    public double[][] parse(List<String> data) {
        List<double[]> numbers = new ArrayList<double[]>();
        for (String line : data) {
            try {
                double[] params = Arrays.stream(line.split(DELIMITER))
                        .mapToDouble(Double::parseDouble)
                        .toArray();
                numbers.add(params);
            } catch (NumberFormatException e) {
                logger.warn("Incorrect data string : " + line, e);
            }
        }
        if (numbers.isEmpty()) {
            return new double[0][0];
        }
        double[][] result = new double[numbers.size()][numbers.get(0).length];
        for (int i = 0; i < numbers.size(); i++) {
            result[i] = numbers.get(i);
        }
        return result;
    }
}
