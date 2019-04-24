package devApp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import engine.starsheep.space.StarFileManager;

public class AppFileManager extends StarFileManager {

	private static AppFileManager instance;
	private File baseDirectory;

	private AppFileManager() {
	}

	public static AppFileManager getInstance() {
		if (instance == null)
			instance = new AppFileManager();
		return instance;
	}

	public void setBaseDirectory(File baseDir) {
		this.baseDirectory = baseDir;
	}

	@Override
	public File getBaseDirectory() {
		return instance.baseDirectory;
	}

	@Override
	public InputStream getMissionsStream() {
		try {
			File missionsFile = new File(instance.baseDirectory.getAbsolutePath() + "/missions.json");
			InputStream stream = new FileInputStream(missionsFile);
			return stream;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public InputStream getJobStreamEdit(String jobId) {
		try {
			File missionsFile = new File(instance.baseDirectory.getAbsolutePath() + "/jobs/j_" + jobId + ".json");
			InputStream stream = new FileInputStream(missionsFile);
			return stream;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
