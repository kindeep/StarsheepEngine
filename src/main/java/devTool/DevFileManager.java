package devTool;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import engine.starsheep.space.StarFileManager;

public class DevFileManager extends StarFileManager {
	File baseDir;

	public DevFileManager(File baseDir) {
		this.baseDir = baseDir;
	}

	@Override
	public InputStream getMissionsStream() {
		File missionsFile = new File(this.baseDir.getAbsolutePath() + "/missions.xml");
		try {
			InputStream stream = new FileInputStream(missionsFile);
			return stream;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public InputStream getJobStreamEdit(String jobId) {
		File missionsFile = new File(this.baseDir.getAbsolutePath() + "/jobs/j_" + jobId + ".xml");
		try {
			InputStream stream = new FileInputStream(missionsFile);
			return stream;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
