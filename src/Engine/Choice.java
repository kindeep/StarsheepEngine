package Engine;

import java.util.List;

public interface Choice {

    List<Choice> getChildrenChoices();

    Double getStaminaCost();

    /**
     * Returns a list with the weights for choice/traitList
     *
     * @return Integer[] weights
     */
    Integer[] getTraitWeights();

    /**
     * Uses trait weights and information from the stamina
     *
     * @return if the choice can be made
     */
    boolean canMakeChoice(Player player);


}
