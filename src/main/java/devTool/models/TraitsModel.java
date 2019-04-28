package devTool.models;

import com.jgoodies.common.collect.ArrayListModel;

public class TraitsModel {
	public ArrayListModel<EditableTrait> traits;

	public TraitsModel() {
		traits = new ArrayListModel<EditableTrait>();
	}
}
