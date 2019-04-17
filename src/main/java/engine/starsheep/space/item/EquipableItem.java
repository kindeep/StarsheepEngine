package engine.starsheep.space.item;

import java.util.Collections;
import java.util.List;

class EquipableItem implements Item {
	private String name;
	private String description;
	private String imageId;
	private String id;
	private int cost;
	private List<TraitBoost> traitBoosts;
	
	public EquipableItem(ItemBuilder builder) {
		this.name = builder.getName();
		this.description = builder.getDescription();
		this.imageId = builder.getImageId();
		this.id = builder.getId();
		this.cost = builder.getCost();
		this.traitBoosts = builder.getTraitBoosts();
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public String getImageId() {
		return this.imageId;
	}

	@Override
	public int getCost() {
		return this.cost;
	}

	@Override
	public String getId() {
		return this.id;
	}
	
	public List<TraitBoost> getTraitBoosts() {
		return Collections.unmodifiableList(this.traitBoosts);
	}
}
