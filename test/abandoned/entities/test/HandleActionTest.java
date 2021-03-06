package abandoned.entities.test;

import abandoned.entities.EntityUseType;
import abandoned.entities.Item;
import abandoned.game.test.AbandonedTest;
import abandoned.house.Container;
import abandoned.house.Room;
import abandoned.house.Wall;

import org.junit.Assert;
import org.junit.Test;


public class HandleActionTest extends AbandonedTest {
  
  private static Item handle;
  
  static {
    handle = new Item("handle", "You see a handle.", EntityUseType.HANDLE,
        true);
  }

  @Test
  public void testIncorrectActionRoom() {
    player.addItem(handle);
    Room curRoom = house.getRoom("library");
    player.setCurrentRoom(curRoom);
    player.setCurrentWall(curRoom.getEastWall());
    player.useItem(handle);
    Assert.assertNotNull(player.getItem("handle"));
    player.removeItem(handle);
  }
  
  @Test
  public void testIncorrectActionWall() {
    player.addItem(handle);
    Room curRoom = house.getRoom("kitchen");
    player.setCurrentRoom(curRoom);
    player.setCurrentWall(curRoom.getWestWall());
    player.useItem(handle);
    Assert.assertNotNull(player.getItem("handle"));
    player.removeItem(handle);
  }
  
  @Test
  public void testCorrectActionWall() {
    player.addItem(handle);
    Room curRoom = house.getRoom("kitchen");
    Wall curWall = curRoom.getEastWall();
    player.setCurrentRoom(curRoom);
    player.setCurrentWall(curWall);
    player.useItem(handle);
    Assert.assertNull(player.getItem("handle"));
    Container cabinet = curWall.getContainer("cabinet");
    Assert.assertNotNull(cabinet.getItem("knife"));
  }
}
