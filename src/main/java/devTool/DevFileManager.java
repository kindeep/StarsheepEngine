package devTool;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import engine.starsheep.space.StarFileManager;

public class DevFileManager extends StarFileManager {
	
	private static DevFileManager instance;
	private File baseDirectory;
	
	private DevFileManager() {}
	
	public static DevFileManager getInstance() {
		if (instance == null)
			instance = new DevFileManager();
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
			File missionsFile = new File(instance.baseDirectory.getAbsolutePath() + "/missions.xml");
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
			File missionsFile = new File(instance.baseDirectory.getAbsolutePath() + "/jobs/j_" + jobId + ".xml");
			InputStream stream = new FileInputStream(missionsFile);
			return stream;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
