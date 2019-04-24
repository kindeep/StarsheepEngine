package devTool;

import java.io.FileReader;


import com.google.gson.Gson;

import devTool.models.EditableJob;
import devTool.models.MissionsModel;
import devTool.models.TraitsModel;
import devTool.models.item.ItemsModel;
import engine.starsheep.space.xml.StarReader;

public class DevStarReader extends StarReader {
    
    /**
     * Reads the items.xml file and returns an ItemsModel.
     * 
     * @return The unmarshalled items xml file.
     */
    public static ItemsModel readEditableItems() {
        try {
            if (fileManager == null)
                throw new Exception("Star file manager cannot be null in StarReader.");

            String path = fileManager.getBaseDirectory().toString() + "/items.json";
            FileReader reader = new FileReader(path);

            Gson gson = new Gson();
            return gson.fromJson(reader, ItemsModel.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
	/**
	 * Reads the traits.xml file and returns a Traitsmodel.
	 * 
	 * @return The unmarshalled traits model.
	 */
	public static TraitsModel readEditableTraits() {
		try {
			if (fileManager == null)
				throw new Exception("Star file manager cannot be null in StarReader.");

			String path = fileManager.getBaseDirectory().toString() + "/traits.json";
			FileReader reader = new FileReader(path);
			Gson gson = new Gson();
			
			return gson.fromJson(reader, TraitsModel.class);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Reads the missions.xml file and returns a MissionsModel.
	 * 
	 * @return The unmarshalled mission model.
	 */
	public static MissionsModel readEditableMissions() {
		try {
			if (fileManager == null)
				throw new Exception("Star file manager cannot be null in StarReader.");

			String path = fileManager.getBaseDirectory().toString() + "/missions.json";
			FileReader reader = new FileReader(path);
			Gson gson = new Gson();
			
			return gson.fromJson(reader, MissionsModel.class);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Reads the job_<jobid>.xml file and returns an EditableJob.
	 * 
	 * @param jobId
	 * @return
	 */
	public static EditableJob readEditableJob(String jobId) {
		try {
			if (fileManager == null)
				throw new Exception("Star file manager cannot be null in StarReader.");

			String path = fileManager.getBaseDirectory().toString() + "/jobs/j_" + jobId + ".json";
			FileReader reader = new FileReader(path);
			
			Gson gson = new Gson();
			return gson.fromJson(reader, EditableJob.class);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
