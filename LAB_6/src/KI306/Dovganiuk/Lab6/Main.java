package KI306.Dovganiuk.Lab6;

/**
 * Driver class.
 */
public class Main {
    public static void main(String[] args) {
        Class1 class1 = new Class1();
        Class2 class2 = new Class2();
        class1.AddItem(1);
        class2.AddItem("AALemon");
        class2.RemoveItem("AALemon");

        System.out.println(class2.Count());
        System.out.println("Minimum in Class1: " + class1.getWardrobe().findMin());
        System.out.println("Minimum in Class2: " + class2.getWardrobe().findMin());
    }
}