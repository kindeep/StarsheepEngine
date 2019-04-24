package engine.starsheep.space.job;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

import engine.starsheep.space.Choice;

public class Job {
    
    @SerializedName("job")
    protected String name;
    
    @SerializedName("job")
    protected String description;
    
    @SerializedName("image-id")
    protected String imageID;
    
    @SerializedName("id")
    protected String id;
    
    protected  HashMap<String, Choice> choices = new HashMap<>();
    
    @SerializedName("choices")
    private List<Choice> choices_readOnly;
    
    @SerializedName("head-id")
    protected String headId;

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
        return Collections.unmodifiableMap(choices);
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
