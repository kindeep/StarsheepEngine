package engine.starsheep.space;

import java.io.InputStream;

/**
 * @author Kindeep Singh Kargil
 * 
 * This interface gives the Engine access to the StarSheep data files.
 */
public interface StarFileManager {

    public InputStream getMissionsStream();

    public InputStream getTraitsStream();

    public InputStream getItemsStream();

    public InputStream getJobStream(String jobId);
}
