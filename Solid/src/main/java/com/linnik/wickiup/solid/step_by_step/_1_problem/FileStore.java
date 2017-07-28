package com.linnik.wickiup.solid.step_by_step._1_problem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

/**
 * @author LinnykOleh
 */
public class FileStore {

    private final static Logger logger = Logger.getLogger(FileStore.class);
    private final Map<Integer, String> cache = new ConcurrentHashMap<>();

    private String workingDirectory;

    public FileStore(String workingDirectory) {
        if (workingDirectory == null)
            throw new NullPointerException("workingDirectory");

        this.workingDirectory = workingDirectory;
    }

    public void save(int id, String message) {
        logger.info("Saving message " + id);
        try {
            String path = this.getFileName(id);
            Files.write(Paths.get(path), message.getBytes());
            this.cache.put(id, message);
        }catch (IOException ex){
            logger.error("Error while saving message " + id);
        }
        logger.info("Saved message " + id);
    }

    public String read(int id) {
        logger.info("Reading message " + id);
        try {
            String path = this.getFileName(id);
            if (!Files.exists(Paths.get(path)))
                return "";
            logger.info("Returning message " + id);
            return this.cache.getOrDefault(id, Files.readAllLines(Paths.get(path)).stream().collect(Collectors.joining(",")));
        }catch (IOException ex){
            logger.error("Error while reading message " + id);
        }
        return "";
    }

    public String getFileName(int id) {
        return Paths.get(this.workingDirectory, id + ".txt").toString();
    }

    public String getWorkingDirectory() {
        return workingDirectory;
    }

    private void setWorkingDirectory(String workingDirectory) {
        this.workingDirectory = workingDirectory;
    }
}
