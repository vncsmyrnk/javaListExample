import java.util.*;

public class ListInteractive {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        List<String> l = new List<String>();
        String line = "", item, removedItem;
        int position;
        boolean exit = false;

        clearScreen();

        while (!line.equals("E")) {
            System.out.println(
                "-- List --\n- (C)reate \n- (D)elete by position\n- (L)delete by element\n- (P)rint\n- (E)xit"
            );

            line = s.nextLine();

            switch(line) {
                case "c":
                case "C":
                    System.out.println("Enter element: ");
                    item = s.nextLine();
                    System.out.println("Enter postion: ");
                    position = s.nextInt();
                    l.add(item, position);
                    break;
                case "d":
                case "D":
                    System.out.println("Enter position: ");
                    position = Integer.parseInt(s.nextLine());
                    try {
                        removedItem = l.remove(position);
                        System.out.println("Item removed: " + removedItem);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    } finally {
                        s.nextLine();
                    }
                    break;
                case "l":
                case "L":
                        System.out.println("Enter element: ");
                        item = s.nextLine();
                        try {
                            removedItem = l.remove(item);
                            System.out.println("Item removed: " + removedItem);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        } finally {
                            s.nextLine();
                        }
                        break;
                case "p":
                case "P":
                    l.print();
                    s.nextLine();
                    break;
                case "e":
                case "E":
                    exit = true;
                    break;
            }

            if (exit) {
                break;
            }

            clearScreen();
        }
    }

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  
}
