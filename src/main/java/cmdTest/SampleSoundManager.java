package cmdTest;

import engine.starsheep.space.GameSound;
import engine.starsheep.space.GameSoundManager;

/**
 * Just trigger the system SoundManager from this class.
 */
public class SampleSoundManager implements GameSoundManager {

    @Override
    public void loopInBackground(GameSound sound) {
        System.out.println(sound);
    }

    @Override
    public void makeSound(GameSound sound) {
        System.out.println(sound);
    }
}
