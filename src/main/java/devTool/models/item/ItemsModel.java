package devTool.models.item;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.jgoodies.common.collect.ArrayListModel;

@XmlRootElement(name = "items")
public class ItemsModel {
    
    @XmlElement(name = "item")
    public ArrayListModel<EditableItem> items = new ArrayListModel<>();
}
