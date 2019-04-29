package devTool;

import java.io.InputStreamReader;

import com.google.gson.Gson;

import devTool.models.EditableJob;
import devTool.models.MissionsModel;
import devTool.models.TraitsModel;
import devTool.models.item.ItemsModel;
import engine.starsheep.space.json.StarReader;

public class DevStarReader extends StarReader {
    
    /**
     * Reads the items.json file and returns an ItemsModel.
     */
    public static ItemsModel readEditableItems() {
        try {
            if (fileManager == null)
                throw new Exception("Star file manager cannot be null in StarReader.");

			InputStreamReader reader = new InputStreamReader(fileManager.getItemsStream());
			Gson gson = new Gson();
            return gson.fromJson(reader, ItemsModel.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ItemsModel();
    }
    
	/**
	 * Reads the traits.json file and returns a TraitsModel.
	 */
	public static TraitsModel readEditableTraits() {
		try {
			if (fileManager == null)
				throw new Exception("Star file manager cannot be null in StarReader.");

			InputStreamReader reader = new InputStreamReader(fileManager.getTraitsStream());
			Gson gson = new Gson();
			return gson.fromJson(reader, TraitsModel.class);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Reads the missions.json file and returns a MissionsModel.
	 */
	public static MissionsModel readEditableMissions() {
		try {
			if (fileManager == null)
				throw new Exception("Star file manager cannot be null in StarReader.");

			InputStreamReader reader = new InputStreamReader(fileManager.getMissionsStream());
			Gson gson = new Gson();
			return gson.fromJson(reader, MissionsModel.class);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Reads the job_jobid.json file and returns an EditableJob.
	 */
	public static EditableJob readEditableJob(String jobId) {
		try {
			if (fileManager == null)
				throw new Exception("Star file manager cannot be null in StarReader.");

			InputStreamReader reader = new InputStreamReader(fileManager.getJobStream(jobId));

			Gson gson = new Gson();
			return gson.fromJson(reader, EditableJob.class);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
