package engine.starsheep.space;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.gson.annotations.SerializedName;

import engine.starsheep.space.job.TraitDependency;

public class Choice {
    
    @SerializedName("id")
    private String id;
    
    @SerializedName("name")
    private String name;
    
    @SerializedName("description")
    private String description;
    
    @SerializedName("children")
    private List<String> children = new ArrayList<>();
    
    @SerializedName("trait")
    private List<TraitDependency> traitDependencies = new ArrayList<>();
    
    @SerializedName("stamina-cost")
    private Double staminaCost = 0.0;

    public String getID() {
        return this.id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public List<TraitDependency> getTraitDependencies() {
        return Collections.unmodifiableList(this.traitDependencies);
    }

    public List<String> getChildrenChoicesIds() {
        return this.children;
    }

    public double getStaminaCost() {
        return this.staminaCost;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
