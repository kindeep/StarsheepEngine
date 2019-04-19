package engine.starsheep.space;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import engine.starsheep.space.job.TraitDependency;

public class Choice {
    protected ArrayList<String> children = new ArrayList<>();
    protected ArrayList<TraitDependency> traitDependencies = new ArrayList<>();
    protected Double staminaCost = 0.0;
    protected String id;
    protected String description = "fake description here";
    protected String name;

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
