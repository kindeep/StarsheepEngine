package engine.starsheep.space.job;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

import engine.starsheep.space.Choice;

public class Job {
    
    private Map<String, Choice> choicesMap = new HashMap<>();
    
    @SerializedName("name")
    private String name;
    
    @SerializedName("description")
    private String description;
    
    @SerializedName("id")
    private String id;
    
    @SerializedName("image-id")
    private String imageID;
    
    @SerializedName("head-choice-id")
    private String headId;
    
    @SerializedName("choices")
    private List<Choice> choicesList;

    //moves all choices in List into the Map. 
    //to be called after reading in a Job.
    public void finalize() {
        for (Choice c : choicesList) {
            choicesMap.put(c.getID(), c);
        }
    }
    
    //setters and getters.
    public String getHeadId() {
        return headId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Choice> getChoices() {
        return Collections.unmodifiableMap(choicesMap);
    }

    public String getImageID() {
        return imageID;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
