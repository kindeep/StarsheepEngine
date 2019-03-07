package Engine;

/** To manage game sounds.
 *
 *
 */
public interface GameSoundManager {

    /**
     * Loops the supplied sound in the background
     */
    void loopInBackground(GameSound sound);

    /**
     * Makes the given sound as an alert.
     */
    void makeSound(GameSound sound);
}
