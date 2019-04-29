package devTool;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import engine.starsheep.space.StarFileManager;

public class DevFileManager implements StarFileManager {
	private static DevFileManager instance;
	private File baseDirectory;

	private DevFileManager() {
	}

	public static DevFileManager getInstance() {
		if (instance == null)
			instance = new DevFileManager();
		return instance;
	}

	public void setBaseDirectory(File baseDir) {
		this.baseDirectory = baseDir;
	}

	public File getBaseDirectory() {
		return this.baseDirectory;
	}
	
	private InputStream getResourceStream(String resPath) {
		try {
			return new FileInputStream(resPath);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public InputStream getMissionsStream() {
		return getResourceStream(baseDirectory.getAbsolutePath() + "/missions.json");
	}

	@Override
	public InputStream getTraitsStream() {
		return getResourceStream(baseDirectory.getAbsolutePath() + "/traits.json");
	}

	@Override
	public InputStream getItemsStream() {
		return getResourceStream(baseDirectory.getAbsolutePath() + "/items.json");
	}

	@Override
	public InputStream getJobStream(String jobId) {
		return getResourceStream(baseDirectory.getAbsolutePath() + "/jobs/j_" + jobId + ".json");
	}
}
