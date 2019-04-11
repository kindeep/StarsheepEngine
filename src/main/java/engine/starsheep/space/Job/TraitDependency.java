package engine.starsheep.space.Job;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "trait-dependency")
public class TraitDependency {
	protected String name;
	protected int weight; 
	
	//no-arg constructor required for XML marshalling.
	public TraitDependency() {}
	
	public TraitDependency(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}
	
	@XmlAttribute(name = "name")
	public String getName() {
		return this.name;
	}
	
	@XmlAttribute(name = "weight")
	public int getWeight() {
		return this.weight;
	}
}
