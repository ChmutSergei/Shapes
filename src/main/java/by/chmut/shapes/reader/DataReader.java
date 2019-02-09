package by.chmut.shapes.reader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class DataReader {

    private static final Logger logger = LogManager.getLogger();

    public List<String> read(String path) {
        List<String> result;
        try {
            Path realPath = Paths.get(this.getClass().getResource(path).toURI());
            result = Files.lines(realPath, StandardCharsets.UTF_8)
                    .collect(Collectors.toList());
        } catch (IOException|URISyntaxException e) {
            logger.fatal("File not found");
            throw new RuntimeException("Fatal Error \"File not found\"", e);
        }
        return result;
    }
}
