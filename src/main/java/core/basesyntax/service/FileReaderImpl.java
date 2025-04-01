package core.basesyntax.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class FileReaderImpl implements core.basesyntax.service.FileReader {

    @Override
    public List<String[]> processFile(String filePath) throws IOException {
        List<String[]> data;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            data = DataConverter.convertLinesToData(reader);
        } catch (IOException e) {
            throw new IOException("Error reading file: " + filePath, e);
        }
        return data;
    }
}
