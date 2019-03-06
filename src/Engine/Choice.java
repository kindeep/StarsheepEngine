package Engine;

import java.util.List;

public interface Choice {

    List<Choice> getChildrenChoices();

    Double getStaminaCost();

    Integer[] getTraitWeights();



}
