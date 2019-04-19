package engine.starsheep.space.job;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import engine.starsheep.space.Choice;

public class Job {
    protected String headId;
    protected HashMap<String, Choice> choices = new HashMap<>();
    protected String name;
    protected String description;
    protected String imageID;
    protected String id;

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
