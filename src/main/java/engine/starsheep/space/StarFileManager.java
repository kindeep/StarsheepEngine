package engine.starsheep.space;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public abstract class StarFileManager {
	
	//TODO: this class needs comments.

    public final String JOBS = "xml/jobs.xml";
    public final String MISSIONS = "xml/missions.xml";

    public StarFileManager() {

    }

    public InputStream getDefaultMissionsStream() {
        try {
            InputStream saved = getMissionsStream();
            if (saved != null) {
                return saved;
            } else return openResource(this.MISSIONS).openStream();
        } catch (IOException e) {
            return null;
        }
    }

    public InputStream getJobStream(String jobId) {
        try {
            InputStream saved = getJobStreamEdit(jobId);
            if (saved != null) {
                return saved;
            } else
                return openResource(this.JOBS).openStream();
        } catch (IOException e) {
            return null;
        }
    }

    public static InputStream getResourceStream(String path) {
        try {
            return openResource(path).openStream();
        } catch (IOException e) {
            return null;
        }
    }

    public static URL openResource(String resPath) {
        return ClassLoader.getSystemClassLoader().getResource(resPath);
    }

    public abstract InputStream getMissionsStream();


    public abstract InputStream getJobStreamEdit(String jobId);
}
