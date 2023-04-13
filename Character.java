/**
* This class represents a character with methods that allow the character do specific actions.  
*/
import java.util.Scanner;
import java.util.ArrayList;

public class Character implements Contract{

   private String charName;
   private ArrayList<String> backpack;
   private ArrayList<String> hands;
   ArrayList<String> itemUsing;
   private int xPos;
   private int yPos;
   private int size;
   ArrayList<String> removed;

    /* Constructors */

    public Character(String charName) {
        this.charName = charName;
        this.xPos = 0;
        this.yPos = 0;
        this.size = 10;
        this.itemUsing = new ArrayList<String>();
        this.hands = new ArrayList<String>();
        this.backpack = new ArrayList<String>();
        this.removed = new ArrayList<String>();
        System.out.println("Character " + charName + " created.");
    }

    /** Accessors */

    public String getName() {
        return this.charName;
    }

    public ArrayList<String> getBackpack() {
        return this.backpack;
    }

    public ArrayList<String> getHands() {
        return this.hands;
    }

   
    public int get_xPos() {
        return this.xPos;
    }

    public int get_yPos() {
        return this.yPos;
    }

    public int getSize() {
        return this.size;
    }
    /**
   * Adds an item to a backpack(an arraylist)
   * @param item
   */
    public void grab(String item){
    this.backpack.add(item);
    System.out.println(item + "has been added to your backpack");
    }

    /**
   * Notifies the user that an item has been 
   * dropped as well as drops them from the character's hands or backpack
   * @param item
   * @return item + "has been dropped" 
   */
    public String drop(String item){
        if (this.backpack.contains(item)){
            this.backpack.remove(item);
            
            removed.add(item);
        } 
        if (this.hands.contains(item)){
            this.hands.remove(item);
        }
    return item + "has been dropped";
    }

    /**
   * Adds an item to character hands(an arraylist); Only examines one object at once
   * @param item
   */
    public void examine(String item){
        if (this.hands.size() < 1){
            this.hands.add(item);
            System.out.println(item + " is being examined.");
        }else{
            System.out.println("You are already examining" + this.hands.get(0));
        }
    }

    /**
   * Allows the character to use a found item.
   * @param item
   */
    public void use(String item){
        if (this.itemUsing.contains(item)){
        System.out.println(item + " is being used already.");
        } else {
        this.itemUsing.add(item);
        System.out.println(item + " is being used.");
        }
    }

    /**
   * Returns the boolean that idicates that the chracter is walking 
   * and the direction the character is going and changes their x and y position by 5.
   * @param direction
   * @return isWalking
   */
    public boolean walk(String direction){
        boolean isWalking = direction.equalsIgnoreCase("east");
        if (isWalking){
            System.out.println("You are going: " + direction.toUpperCase());
            this.xPos = this.xPos + 5;
            return isWalking;
        }

        isWalking = direction.equalsIgnoreCase("west");
        if (isWalking){
            System.out.println("You are going: " + direction.toUpperCase());
            this.xPos = this.xPos - 5;
            return isWalking;
        }

        isWalking = direction.equalsIgnoreCase("north");
        if (isWalking){
            System.out.println("You are going: " + direction.toUpperCase());
            this.yPos = this.yPos + 5;
            return isWalking;
        } 

        isWalking = direction.equalsIgnoreCase("south");
        if (isWalking){
            System.out.println("You are going: " + direction.toUpperCase());
            this.yPos = this.yPos - 5;
            return isWalking;
        }
        else {
            throw new RuntimeException("This is not a direction. Enter a direction.");
        }
    
    }

    /**
   * Allows a person to flying or not based on their coordinates, (x, y)
   * @param x
   * @param y
   * @return the person has flown
   */
    public boolean fly(int x, int y){
        boolean flown = y > 0;

        if ((x > 0) && flown){
            this.xPos = x + this.xPos;
            this.yPos = y + this.yPos;
            System.out.println("You are flying eastward to the coordinates: " + this.xPos + ", " + this.yPos);
            return flown;
        } 

        if ((x < 0) && flown){
            this.xPos = x + this.xPos;
            this.yPos = y + this.yPos;
            System.out.println("You are flying westward to the coordinates: " + this.xPos + ", " + this.yPos);
            return flown;
        } 
        else {
            throw new RuntimeException("You cannot fly to those coordinates.");
        }
    }

   /**
   * Decreases the character size by 5
   * @return this.size
   */
    public Number shrink(){
        this.size = this.size - 5;
        System.out.println("You have shrunk to size:");
        return this.size;
    }

    /**
   * Increases the character size by 5
   * @return this.size
   */
    public Number grow(){
        this.size = this.size + 5;
        System.out.println("You have grown to size:");
        return this.size;
    }

    /**
   * Outputs that the character is resting
   */
    public void rest(){
        System.out.println("Resting!");
    }

    /**
   * Outputs that an action should be undone
   */

    public void undo(){
    Scanner input = new Scanner(System.in);
    System.out.println("What would you like to undo?");
    String undoMethod = input.nextLine();

    if (undoMethod.equalsIgnoreCase("grab")){
        String itemGrabbed = this.backpack.get(-1);
        this.backpack.remove(itemGrabbed);
        System.out.println("Grab undone");
    }
    if (undoMethod.equalsIgnoreCase("drop")){
        String itemDropped = this.removed.get(-1);
        this.backpack.add(itemDropped);
        System.out.println("Drop undone");
      
    }
    if (undoMethod.equalsIgnoreCase("examine")){
        String itemExamined = this.hands.get(-1);
        this.hands.remove(itemExamined);
        System.out.println("Examine undone");
    }
    if (undoMethod.equalsIgnoreCase("use")){
        String itemUsed = this.itemUsing.get(-1);
        this.hands.remove(itemUsed);
        System.out.println("Use undone");
    }
    if (undoMethod.equalsIgnoreCase("walk")){
        System.out.println("What direction did oyou go?");
        String undoDirt = input.nextLine();
        if (undoDirt.equalsIgnoreCase("East")){
            this.xPos = this.xPos - 5;
        }
        if (undoDirt.equalsIgnoreCase("West")){
            this.xPos = this.xPos + 5;
        }
        if (undoDirt.equalsIgnoreCase("South")){
            this.yPos = this.yPos + 5;
        }
        if (undoDirt.equalsIgnoreCase("North")){
            this.yPos = this.yPos - 5;
        }
        System.out.println("Walk undone");
    }
    if (undoMethod.equalsIgnoreCase("fly")){
        
    }
    if (undoMethod.equalsIgnoreCase("shrink")){
        this.size = this.size + 5;
        System.out.println("Shrink undone");
    }
    if (undoMethod.equalsIgnoreCase("grow")){
        this.size = this.size - 5;
        System.out.println("Grow undone");
    }
    if (undoMethod.equalsIgnoreCase("rest ")){
        System.out.println("Rest undone");
    }
    input.close();
  
System.out.println("Action Undone");
    }

    public static void main(String[] args) {
       Character Bob = new Character("Bob");
       Bob.walk("East");
       System.out.println( Bob.shrink());
      
      
    
       
}

}
