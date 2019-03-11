package cmdTest;

import engine.starsheep.space.*;

public class SampleCmdView implements StarGameView {

    @Override
    public void log(Object toPrint) {
        System.out.println(toPrint);
    }
}
