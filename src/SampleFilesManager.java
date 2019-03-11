import engine.starsheep.space.StarFileManager;

import java.io.File;

public class SampleFilesManager implements StarFileManager {

    private File jobs;
    private File missions;

    public SampleFilesManager() {
        missions = new File("sample_config/Missions.xml");
        jobs = new File("sample_config/Job.xml");
    }

    @Override
    public File getJobFile() {
//        return new File("sample_config/Job.xml");
        return jobs;
//        return null;
    }

    @Override
    public File getMissionsFile() {
//        return new File("sample_config/Missions.xml");
//        return null;

        return missions;
    }
}
