package Engine.Item;

import java.util.Collections;
import java.util.List;

class ItemBuilder {
	private String name;
	private String description;
	private String imageId;
	private String id;
	private int cost;
	private List<TraitBoost> traitBoosts;
	private String itemType;

	// build Item
	public Item build() {
		if (this.itemType.equals("Equipable")) {
			return new EquipableItem(this);
		} else if (this.itemType.equals("Consumable")) {
			return new ConsumableItem(this);
		} else {
			return null;
		}
	}
	
	//helpers.
	public void addTraitBoost(String name, int boost) {
		traitBoosts.add(new TraitBoost(name, boost));
	}

	// getters.
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getImageId() {
		return imageId;
	}

	public String getId() {
		return id;
	}

	public int getCost() {
		return cost;
	}

	public List<TraitBoost> getTraitBoosts() {
		return Collections.unmodifiableList(this.traitBoosts);
	}

	// setters
	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public void setTraitBoosts(List<TraitBoost> traitBoosts) {
		this.traitBoosts = traitBoosts;
	}

	/**
	 * 
	 * @param itemType - Must be one of "Equipable" or "Consumable"
	 */
	public void setItemType(String itemType) {
		if (itemType.equals("Equipable") || itemType.equals("Consumable"))
			this.itemType = itemType;
		else
			this.itemType = null;
	}

}
