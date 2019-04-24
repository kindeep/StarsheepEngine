package engine.starsheep.space.xml;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.SerializedName;

import engine.starsheep.space.Mission;

/**
 * Mission model is the class that the missions.xml file is unmarshalled to.
 * 
 * @author peakyDicers
 */
public class MissionsModel {
    
    @SerializedName("missions")
    private ArrayList<Mission> missions;

    public MissionsModel() {
        missions = new ArrayList<>();
    }

    public List<Mission> getMissions() {
        return Collections.unmodifiableList(this.missions);
    }
}
