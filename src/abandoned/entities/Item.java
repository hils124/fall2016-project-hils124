package abandoned.entities;

import abandoned.house.Room;
import abandoned.house.Wall;


/**
 * Class to model an item.
 * @author hils124
 */
public class Item {
  
  private String name;
  private String description;
  private EntityUseType useType;
  private boolean isTakeable;

  /**
   * Empty constructor for JSON serializing.
   */
  public Item() {
    //for JSON serializing
  }

  /**
   * public Item constructor.
   * @param name - item name
   * @param description - item description
   * @param useType - type of item use
   * @param isTakeable - item can be picked up
   */
  public Item(String name, String description, EntityUseType useType, boolean isTakeable) {
    this.name = name;
    this.description = description;
    this.useType = useType;
    this.isTakeable = isTakeable;
  }

  public String getName() {
    return this.name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getDescription() {
    return this.description;
  }
  
  public void setDescription(String description) {
    this.description = description;
  }
  
  public EntityUseType getUseType() {
    return this.useType;
  }
  
  public boolean getIsTakeable() {
    return this.isTakeable;
  }
  
  /**
   * Called when player uses an item.
   * @param curRoom - current room the player is in
   * @param curWall - current wall the player is facing
   * @return item use success
   * 
   */
  public boolean use(Room curRoom, Wall curWall) {
    if (this.useType != null) {
      return this.useType.getAction().use(this, curRoom, curWall);  
    }
    return false;
  }
}
