package Engine;

import java.util.List;


public interface Choice {

    /**
     * Returns a list with all children of the current choice
     *
     * @return a list of all children choices
     */
    List<Choice> getChildrenChoices();

    /**
     * Getter method for stamina
     *
     * @return Double stamina
     */
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
