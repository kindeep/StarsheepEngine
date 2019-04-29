package cmdTest;

import engine.starsheep.space.StarFileManager;

import java.io.InputStream;

public class FileManager implements StarFileManager {

    @Override
    public InputStream getMissionsStream() {
        return null;
    }

	@Override
	public InputStream getTraitsStream() {
		return null;
	}

	@Override
	public InputStream getItemsStream() {
		return null;
	}

	@Override
	public InputStream getJobStream(String jobId) {
		return null;
	}
}
