package KI306.Dovganiuk.Lab6;

/**
 * Class that uses Wardrobe.
 */
public class Class1 {
    private Wardrobe<Integer> wardrobe;

    public Class1() {
        wardrobe = new Wardrobe<>();
        wardrobe.addItem(10);
        wardrobe.addItem(20);
        wardrobe.addItem(30);
    }

    /**
     * Method to add an item to the wardrobe.
     * @param n The item to be added.
     */
    public void AddItem(int n){
        wardrobe.addItem(n);
    }

    /**
     * Method to remove an item from the wardrobe.
     * @param n The item to be removed.
     */
    public void RemoveItem(int n){
        wardrobe.removeItem(n);
    }

    /**
     * Method to get the wardrobe.
     * @return The wardrobe.
     */
    public Wardrobe<Integer> getWardrobe() {
        return wardrobe;
    }
}