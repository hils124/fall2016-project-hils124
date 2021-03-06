package abandoned.entities;

import abandoned.game.Ansi;
import abandoned.game.Print;
import abandoned.house.Container;
import abandoned.house.Room;
import abandoned.house.Wall;

/**
 * Class to model a letter's action when used.
 * 
 * @author hils124
 */
public class LetterAction implements EntityAction {
  
  @Override
  public boolean use(Item item, Room curRoom, Wall curWall) {
    if (item.getUseType().getWall().equals(curWall.getName())) {
      Print.printString(
          "You slowly plunk the notes that match the uppercase letters in the letter you read. "
          + "When you hit the last 'E' key, you hear the house groan as the wall to your left "
          + "starts to move.\n\n", true);
      Wall eastWall = curRoom.getEastWall();
      Container fireplace = eastWall.getContainer("fireplace");
      fireplace.setDescription("You see a " + Ansi.BIN + "fireplace" + Ansi.RESET + " with a gray "
          + "brick border. The back wall of the fireplace seems to have moved.");
      fireplace.setInspectDescript("You peer into the fireplace and notice a dark passageway "
          + "where the wall used to be. If it wasn't so dark in there, you might be able to "
          + "explore it.");
      fireplace.addItem(new Item("passage", "", null, false));
      return true;
    }
    return false;
  }
}