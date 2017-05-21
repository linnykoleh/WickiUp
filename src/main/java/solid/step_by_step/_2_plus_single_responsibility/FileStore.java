package solid.step_by_step._2_plus_single_responsibility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

/**
 * @author LinnykOleh
 */
public class FileStore {

    public void save(String path, String message) throws IOException {
        Files.write(Paths.get(path), message.getBytes());
    }

    public String read(String path) throws IOException {
        return Files.readAllLines(Paths.get(path)).stream().collect(Collectors.joining(","));
    }

    public String getFileInfo(int id, String workingDirectory) {
        return Paths.get(workingDirectory, id + ".txt").toString();
    }
}
