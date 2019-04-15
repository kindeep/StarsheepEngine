package devTool.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.jgoodies.common.collect.ArrayListModel;

@XmlRootElement(name = "traits")
public class TraitsModel {

	@XmlElement(name = "trait")
	public ArrayListModel<EditableTrait> traits;

	public TraitsModel() {
		traits = new ArrayListModel<EditableTrait>();
	}
}
