package KI306.Dovganiuk.Lab6;

import java.util.ArrayList;

/**
 * Class that uses Wardrobe.
 */
public class Class2 {
    private Wardrobe<String> wardrobe;
    static int count = 0;
    static int maxLength = 0;

    public Class2() {
        wardrobe = new Wardrobe<>();
        wardrobe.addItem("Apple");
        wardrobe.addItem("Banana");
        wardrobe.addItem("Cherry");
    }

    /**
     * Method to add an item to the wardrobe.
     * @param str The item to be added.
     */
    public void AddItem(String str){
        wardrobe.addItem(str);
    }

    /**
     * Method to remove an item from the wardrobe.
     * @param str The item to be removed.
     */
    public void RemoveItem(String str){
        wardrobe.removeItem(str);
    }

    /**
     * Method to count the number of items in the wardrobe with the maximum length.
     * @return The count of items with the maximum length.
     */
    public int Count(){
        for(String s : wardrobe.getItems()){
            if(s.length() > maxLength){
                maxLength = s.length();
                count = 1;
            }
            else if(s.length() == maxLength){
                count++;
            }
        }
        return count;
    }

    /**
     * Method to get the wardrobe.
     * @return The wardrobe.
     */
    public Wardrobe<String> getWardrobe() {
        return wardrobe;
    }
}