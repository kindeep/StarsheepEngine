package engine.starsheep.space.item;

import java.util.Collections;
import java.util.List;

class EquipableItem extends Item {
	private String name;
	private String description;
	private String imageId;
	private String id;
	private int cost;
	private List<TraitBoost> traitBoosts;


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
	public String getId() {
		return this.id;
	}
	
	public List<TraitBoost> getTraitBoosts() {
		return Collections.unmodifiableList(this.traitBoosts);
	}
}
