package devTool.models.item;

import com.google.gson.annotations.SerializedName;
import com.jgoodies.common.collect.ArrayListModel;

public class ItemsModel {
    
    @SerializedName("items")
    public ArrayListModel<EditableItem> items = new ArrayListModel<>();
}
