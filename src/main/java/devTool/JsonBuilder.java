package devTool;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import devTool.models.EditableJob;
import devTool.models.GameDataManager;
import devTool.models.GameModel;
import devTool.models.MissionsModel;
import devTool.models.TraitsModel;


public class JsonBuilder {
    private static JsonBuilder instance;
    private String baseDir;
    private static Gson gson;
    
    final String MISSIONS_SUFFIX = "/missions.json";
    final String TRAITS_SUFFIX = "/traits.json";
    final String GAME_SUFFIX = "/game.json";
    final String ITEMS_SUFFIX = "/items.json";

    private JsonBuilder() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public static JsonBuilder getInstance() {
        if (instance == null)
            instance = new JsonBuilder();
        return instance;
    }

    public void setBaseDir(File f) {
        this.baseDir = f.getAbsolutePath() + "/";
        validateFiles();
    }
    
    /*
     * Check to make sure all files exist, if not created them.
     */
    private void validateFiles() {
        List<File> toWrite = new ArrayList<>();
        
        File file = new File(this.baseDir + this.MISSIONS_SUFFIX);
        
        if (!file.exists())
            toWrite.add(file);
        
        file = new File(this.baseDir + this.TRAITS_SUFFIX);
        if (!file.exists())
            toWrite.add(file);
        
        file = new File(this.baseDir + this.GAME_SUFFIX);
        if (!file.exists())
            toWrite.add(file);
        
        file = new File(this.baseDir + this.ITEMS_SUFFIX);
        if (!file.exists())
            toWrite.add(file);
        
        FileWriter writer;
        for (File f: toWrite) {
           try {
            writer = new FileWriter(f);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
    }

    public boolean deleteJobFile(String id) {
        File f = new File(baseDir + "jobs/j_" + id + ".json");
        return f.delete();
    }

    public void buildGameModelData(GameModel gm) throws Exception {
        
    }

    public void buildJobFile(EditableJob job) {
        try {
            String fileName = "j_" + job.id + ".json";
            FileWriter writer = new FileWriter(this.baseDir + "/jobs/" + fileName);
            gson.toJson(job, writer);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void buildMissionsFile() throws Exception {
        MissionsModel mm = GameDataManager.getInstance().getMissionsModel();
        FileWriter writer = new FileWriter(this.baseDir + this.MISSIONS_SUFFIX);
        
        gson.toJson(mm, writer);
        writer.close();
    }

    public void buildTraitsFile() throws Exception {
        TraitsModel traitsModel = GameDataManager.getInstance().getTraitsModel();
        FileWriter writer = new FileWriter(this.baseDir + this.TRAITS_SUFFIX);
        gson.toJson(traitsModel, writer);
        writer.close();
    }
}
