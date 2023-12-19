package KI306.Dovganiuk.Lab6;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Class that implements the domain area of a Wardrobe.
 */
public class Wardrobe<T extends Comparable<T>> {
    private ArrayList<T> items;

    public Wardrobe() {
        items = new ArrayList<>();
    }

    /**
     * Method to add an item.
     * @param item The item to be added.
     */
    public void addItem(T item) {
        items.add(item);
    }

    /**
     * Method to remove an item.
     * @param item The item to be removed.
     */
    public void removeItem(T item) {
        items.remove(item);
    }

    /**
     * Method to find the minimum item.
     * @return The minimum item, or null if the wardrobe is empty.
     */
    public T findMin() {
        if (items.isEmpty()) {
            return null;
        }
        return Collections.min(items);
    }

    /**
     * Method to get all items.
     * @return An ArrayList of all items.
     */
    public ArrayList<T> getItems() {
        return items;
    }
}