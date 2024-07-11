import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Supermarket {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        LinkedList<ArrayList<String>> orders = new LinkedList<>();

        Scanner input = new Scanner(System.in);

        boolean loop = true;

        while (loop) {
            System.out.println("What would you like to do?");
            System.out.println("1. Enqueue");
            System.out.println("2. Serve");
            System.out.println("3. Output orders");
            System.out.println("4. Exit");

            int option = input.nextInt();
            input.nextLine(); // Clear the input buffer

            switch (option) {
                case 1:
                    System.out.printf("Input name: ");
                    String name = input.nextLine();
                    queue.add(name);
                    break;

                case 2:
                String customer = queue.poll();
                ArrayList<String> customerOrders = new ArrayList<>();

                System.out.printf("Serving %s\n", customer);
                boolean orderLoop = true;
                while (orderLoop) {
                    System.out.println("Add item to order (type 'done' when finished): ");
                    String item = input.nextLine();
                    if (item.equalsIgnoreCase("done")) {
                        orderLoop = false;
                    } else {
                        customerOrders.add(item);
                    }
                }

                orders.add(customerOrders);
                    break;

                case 3:
                System.out.println("Orders: ");
                    for (ArrayList<String> order : orders) {
                        System.out.println(order);
                    }
                    break;
                case 4:
                    loop = false;
                    break;

                default:
                    break;
            }
        }

        input.close();
    }
}