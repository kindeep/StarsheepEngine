package engine.starsheep.space;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public abstract class StarSaveFilesReader {

    public final String JOBS = "xml/jobs.xml";
    public final String MISSIONS = "xml/missions.xml";

    public StarSaveFilesReader() {

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

    public InputStream getDefaultJobStream() {
        try {
            InputStream saved = getMissionsStream();
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


    public abstract InputStream getJobsStream();
}
