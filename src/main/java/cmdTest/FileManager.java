package cmdTest;

import engine.starsheep.space.StarFileManager;

import java.io.File;
import java.io.InputStream;

public class FileManager extends StarFileManager {

    @Override
    public InputStream getMissionsStream() {
        return null;
    }

    public InputStream getJobsStream() {
        return null;
    }

	@Override
	public InputStream getJobStreamEdit(String jobId) {
		return null;
	}
}
