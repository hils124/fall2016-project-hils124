package abandoned.entities.test;

import abandoned.entities.EntityUseType;
import abandoned.entities.Item;
import abandoned.game.test.AbandonedTest;
import abandoned.house.Container;
import abandoned.house.Room;
import abandoned.house.Wall;

import org.junit.Assert;
import org.junit.Test;

public class KnifeActionTest extends AbandonedTest {
  
  private static Item knife;
  
  static {
    knife = new Item("knife", "You see knife.", EntityUseType.KNIFE,
        true);
    player.addItem(knife);
  }

  @Test
  public void testIncorrectActionRoom() {
    Room curRoom = house.getRoom("kitchen");
    player.setCurrentRoom(curRoom);
    player.setCurrentWall(curRoom.getNorthWall());
    player.useItem(knife);
    Assert.assertNotNull(player.getItem("knife"));
  }
  
  @Test
  public void testIncorrectActionWall() {
    Room curRoom = house.getRoom("bedroom");
    player.setCurrentRoom(curRoom);
    player.setCurrentWall(curRoom.getWestWall());
    player.useItem(knife);
    Assert.assertNotNull(player.getItem("knife"));
  }
  
  @Test
  public void testCorrectActionWall() {
    Room curRoom = house.getRoom("bedroom");
    player.setCurrentRoom(curRoom);
    player.setCurrentWall(curRoom.getNorthWall());
    Wall curWall = player.getCurrentWall();
    Assert.assertNull(curWall.getContainer("envelope"));
    player.useItem(knife);
    Assert.assertNull(player.getItem("knife"));
    Container envelope = curWall.getContainer("envelope");
    Assert.assertNotNull(envelope);
    Assert.assertNotNull(envelope.getItem("letter"));
    player.addItem(knife);
  }
}