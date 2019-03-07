package Engine;

public class TraitDependency {
	String name;
	int weight;
	
	public TraitDependency(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getWeight() {
		return this.weight;
	}
}
