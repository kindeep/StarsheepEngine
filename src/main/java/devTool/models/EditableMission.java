package devTool.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.jgoodies.common.collect.ArrayListModel;

/**
 * An EditableMission is an extension of Mission that allows for the ability to
 * change Mission variables.
 * 
 * @author peakyDicers
 *
 */

@XmlRootElement(name = "mission")
public class EditableMission {

	@XmlElement(name = "name")
	public String title;

	@XmlElement(name = "description")
	public String description;

	@XmlElement(name = "id")
	public String id;

	@XmlElement(name = "stamina-cost")
	public String staminaCost;

	@XmlElementWrapper(name = "jobs")
	@XmlElement(name = "job")
	public ArrayListModel<EditableJobFlyer> jobFlyers;

	public EditableMission() {
		jobFlyers = new ArrayListModel<EditableJobFlyer>();
	}

	public void addJobFlyer(EditableJobFlyer flyer) {
		this.jobFlyers.add(flyer);
	}

	@Override
	public String toString() {
		return this.title;
	}
}
