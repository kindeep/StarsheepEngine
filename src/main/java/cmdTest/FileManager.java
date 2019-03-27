package cmdTest;

import engine.starsheep.space.StarSaveFilesReader;

import java.io.File;
import java.io.InputStream;

public class FileManager extends StarSaveFilesReader {

    @Override
    public InputStream getMissionsStream() {
        return null;
    }

    @Override
    public InputStream getJobsStream() {
        return null;
    }
}
