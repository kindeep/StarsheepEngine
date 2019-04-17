package devTool.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "choice")
public class TraitDependencyModel {

	@XmlAttribute(name = "name")
	private String name;

	@XmlAttribute(name = "weight")
	private Integer weight;
}
