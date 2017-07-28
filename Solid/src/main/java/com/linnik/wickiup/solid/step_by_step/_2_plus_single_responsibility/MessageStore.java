package com.linnik.wickiup.solid.step_by_step._2_plus_single_responsibility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

/**
 * @author LinnykOleh
 */
public class MessageStore {

    private StoreCache cache;
    private StoreLogger log;
    private FileStore fileStore;

    private String workingDirectory;

    /**
     *  Refactored version of `FileStore` with applying `Single responsibility principle`
     *
     *      1. `FileStore` from _1_problem renamed to `MessageStore`
     *      2. Added `StoreCache`
     *      3. Added `FileStore`
     *      3. Added `StoreLogger`
     *
     *
     *                                  *-------------*
     *                |-----------------| MessageStore |---------------|
     *                |                 *-------------*                |
     *                |                        |                       |
     *                |                        |                       |
     *                |                        |                       |
     *                |                        |                       |
     *         *------------*           *------------*           *-------------*
     *         | FileStore  |           | StoreCache |           | StoreLogger |
     *         *------------*           *------------*           *-------------*
     */
    public MessageStore(String workingDirectory) {
        if (workingDirectory == null)
            throw new NullPointerException("workingDirectory");

        this.workingDirectory = workingDirectory;

        this.cache = new StoreCache();
        this.log = new StoreLogger(MessageStore.class);
        this.fileStore = new FileStore();
    }

    public void save(int id, String message) {
        this.log.saving(id);
        try {
            String path = this.getFileInfo(id);
            this.fileStore.save(path, message);
            this.cache.putMessage(id, message);
        }catch (IOException ex){
            this.log.didNotFind(id);
        }
        this.log.saved(id);
    }

    public String read(int id) {
        this.log.reading(id);
        try {
            String path = this.getFileInfo(id);
            if (!Files.exists(Paths.get(path)))
                return "";
            this.log.returning(id);
            return this.cache.getMessage(id, Files.readAllLines(Paths.get(path)).stream().collect(Collectors.joining(",")));
        }catch (IOException ex){
            this.log.didNotFind(id);
        }
        return "";
    }

    public String getFileInfo(int id) {
        return Paths.get(this.workingDirectory, id + ".txt").toString();
    }

    public String getWorkingDirectory() {
        return workingDirectory;
    }

    private void setWorkingDirectory(String workingDirectory) {
        this.workingDirectory = workingDirectory;
    }
}
