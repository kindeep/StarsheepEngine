package devApp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import engine.starsheep.space.StarFileManager;

public class AppFileManager implements StarFileManager {

	private static AppFileManager instance;
	private File baseDirectory;
	
	private AppFileManager() {
	}
	
	public static AppFileManager getInstance() {
		if (instance == null)
			instance = new AppFileManager();
		return instance;
	}
	
	private InputStream getResourceStream(String resPath) {
		try {
			return new FileInputStream(resPath);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void setBaseDirectory(File baseDir) {
		this.baseDirectory = baseDir;
	}

	public File getBaseDirectory() {
		return this.baseDirectory;
	}

	@Override
	public InputStream getMissionsStream() {
		return getResourceStream(baseDirectory + "/missions.json");
	}

	@Override
	public InputStream getTraitsStream() {
		return getResourceStream(baseDirectory + "/traits.json");
	}

	@Override
	public InputStream getItemsStream() {
		return getResourceStream(baseDirectory + "/items.json");
	}

	@Override
	public InputStream getJobStream(String jobId) {
		return getResourceStream(baseDirectory + "/jobs/j_" + jobId + ".json");
	}
}
