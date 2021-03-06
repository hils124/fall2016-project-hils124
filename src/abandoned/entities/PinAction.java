package abandoned.entities;

import abandoned.game.Ansi;
import abandoned.game.Print;
import abandoned.house.Container;
import abandoned.house.Room;
import abandoned.house.Wall;


/**
 * Class to model a handle's action when used.
 * 
 * @author hils124
 */
public class PinAction implements EntityAction {
  
  @Override
  public boolean use(Item item, Room curRoom, Wall curWall) {
    if (item.getUseType().getWall().equals(curWall.getName())) {
      Print.printString(
          "You jiggle the desk drawer with the bobby pin and after a few tries, "
          + "it satisfyingly clicks open.\n\n",
          true);
      Container desk = curWall.getContainer("desk");
      desk.setInspectDescript("");
      desk.addItem(new Item("matches",
          "There is a small box of " + Ansi.ITEM + "matches" + Ansi.RESET + " inside "
              + "the unlocked desk drawer. ", EntityUseType.MATCHES, true));
      desk.addItem(new Item("scissors",
          "You reach your hand to the back of the desk drawer and find a pair of "
          + "" + Ansi.ITEM + "scissors" + Ansi.RESET + ".", EntityUseType.SCISSORS, true));
      return true;
    }
    return false;
  }
}