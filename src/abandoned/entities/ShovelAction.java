package abandoned.entities;

import abandoned.game.Print;
import abandoned.house.Container;
import abandoned.house.Room;
import abandoned.house.Wall;


/**
 * Class to model a shovel's action when used.
 * 
 * @author hils124
 */
public class ShovelAction implements EntityAction {
  
  @Override
  public boolean use(Item item, Room curRoom, Wall curWall) {
    if (item.getUseType().getWall().equals(curWall.getName())) {
      Print.printString("You use the shovel to scoop away the dirt. You unearth another golden,"
          + " triangular \u001B[36martifact\u001B[0m.\n\n", true); 
      Container mound = curWall.getContainer("mound");
      mound.setInspectDescript("");
      mound.addItem(new Item("artifact",
          "There is a golden, triangular \u001B[36martifact\u001B[0m lying in the dirt.", 
          EntityUseType.ARTIFACT, true)); 
      return true;
    }
    return false;
  }
}