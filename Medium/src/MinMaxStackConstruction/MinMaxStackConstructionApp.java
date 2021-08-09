package MinMaxStackConstruction;

public class MinMaxStackConstructionApp
{
    public static void main(String[] args) {
        MinMaxStack minMaxStack = new MinMaxStack();

        minMaxStack.push(5);
        System.out.println("Min: " + minMaxStack.getMin());
        System.out.println("Max: " + minMaxStack.getMax());
        System.out.println("Peek: " + minMaxStack.peek());

        minMaxStack.push(7);
        System.out.println("Min: " + minMaxStack.getMin());
        System.out.println("Max: " + minMaxStack.getMax());
        System.out.println("Peek: " + minMaxStack.peek());

        minMaxStack.push(2);
        System.out.println("Min: " + minMaxStack.getMin());
        System.out.println("Max: " + minMaxStack.getMax());
        System.out.println("Peek: " + minMaxStack.peek());

        System.out.println("Pop: " + minMaxStack.pop());
        System.out.println("Pop: " + minMaxStack.pop());

        System.out.println("Min: " + minMaxStack.getMin());
        System.out.println("Max: " + minMaxStack.getMax());
        System.out.println("Peek: " + minMaxStack.peek());

        minMaxStack.printStack();
    }
}
