package abandoned.entities;

import abandoned.game.Ansi;
import abandoned.game.Print;
import abandoned.house.Container;
import abandoned.house.Room;
import abandoned.house.Wall;


/**
 * Class to model a mirror's action when used.
 * 
 * @author hils124
 */
public class MirrorAction implements EntityAction {
  
  @Override
  public boolean use(Item item, Room curRoom, Wall curWall) {
    if (item.getUseType().getWall().equals(curWall.getName())) {
      Print.printString("You catch the light with the mirror and direct the shine into the "
          + "eyes of the snake. Annoyed, the snake slithers away into a bush, leaving the mound "
          + "of dirt empty.\n\n", true);
      Container mound = curWall.getContainer("snake");
      mound.setName("mound");
      mound.setInspectDescript("It looks as though something has been buried in there. Maybe "
              + "you have something to dig it up with.");
      mound.setDescription("You see a " + Ansi.BIN + "mound" + Ansi.RESET + " of dirt."); 
      return true;
    }
    return false;
  }
}
