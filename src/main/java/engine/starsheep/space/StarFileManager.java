package engine.starsheep.space;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * @author Kindeep Singh Kargil
 * <p>
 * Class to access all game resources such as xml files, to read as well as manipulate those files.
 * <p>
 * The idea with this is to be able to initialize from either save files or the default files depending on if the
 * save files exist.
 * <p>
 * We can't rely on "GetBaseDirectory" I don't think, android's file system might not want to work that way.
 * <p>
 * need to abstract the 'File System' out.
 * <p>
 * the loading of save files needs to be implemented by the user.
 * <p>
 * So all resources should be accessed from here.
 * <p>
 * It might be more effitient to get a stream? idk.
 */
public class StarFileManager {

    public static final String JOBS = "xml/jobs.json";
    public static final String MISSIONS = "xml/missions.json";

    public StarFileManager() {

    }

    /**
     * Gets a resource from the resource directory.
     *
     * @param resPath relative path wrt resources directory of the resource.
     * @return
     */
    public URL openResource(String resPath) {
        return ClassLoader.getSystemClassLoader().getResource(resPath);
    }

    public InputStream getResourceStream(String resPath) {
        try {
            return openResource(resPath).openStream();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @return
     */
    public InputStream getMissionsStream() {
        return getResourceStream("sample_game/missions.json");
    }

    /**
     * @return
     */
    public InputStream getTraitsStream() {
        return getResourceStream("sample_game/traits.json");
    }

    /**
     * @param jobId
     * @return
     */
    public InputStream getJobStream(String jobId) {
        return getResourceStream("sample_game/jobs/j_" + jobId + ".json");
    }
}
