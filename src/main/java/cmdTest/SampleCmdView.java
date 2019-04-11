package cmdTest;

import engine.starsheep.space.StarGameView;
import engine.starsheep.space.StarTab;

class SampleCmdView extends StarGameView implements Runnable {

    @Override
    public void run() {
        new SampleCmdView();
    }

    public void log(Object o) {
        System.out.println(o);
    }

    public void display() {

        String home = "" +
                "+---------------------------------------------+\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "+-------------------------------+-------------+\n" +
                "|XXXXXXXXXXXXX|                 |             |\n" +
                "|XXXXHomeXXXXX|    Inventory    |    Shop     |\n" +
                "|XXXXXXXXXXXXX|                 |             |\n" +
                "+-------------------------------+-------------+\n" +
                "\n";

        String inventory = "" +
                "+---------------------------------------------+\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "+---------------------------------------------+\n" +
                "|             |XXXXXXXXXXXXXXXXX|             |\n" +
                "|    Home     |XXXXInventoryXXXX|    Shop     |\n" +
                "|             |XXXXXXXXXXXXXXXXX|             |\n" +
                "+---------------------------------------------+\n" +
                "\n";
        String shop = "" +
                "+---------------------------------------------+\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "|                                             |\n" +
                "+-------------+-------------------------------+\n" +
                "|             |                 |XXXXXXXXXXXXX|\n" +
                "|    Home     |    Inventory    |XXX Shop XXXX|\n" +
                "|             |                 |XXXXXXXXXXXXX|\n" +
                "+-------------+-------------------------------+\n" +
                "\n";

        log("Current tab: " + getCurrentTab());
        switch (getCurrentTab()) {
            case HOME: {
                log(home);
                break;
            }
            case SHOP: {
                log(shop);
                break;
            }
            case INVENTORY: {
                log(inventory);
                break;
            }
        }

    }

}
