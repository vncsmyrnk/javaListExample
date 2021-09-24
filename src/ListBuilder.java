public class ListBuilder {
    public static void main(String[] args) {
        List<String> l = new List<String>();
        System.out.println("l.addItem(\"Teste1\", 0);");
        l.addItem("Teste1", 0);
        System.out.println("l.addItem(\"Teste2\", 1);");
        l.addItem("Teste2", 1);
        System.out.println("l.addItem(\"Teste3\", 2);");
        l.addItem("Teste3", 2);
        System.out.println("l.addItem(\"Teste4\", 3);");
        l.addItem("Teste4", 3);
        System.out.println("l.addItem(\"Teste5\", 4);");
        l.addItem("Teste5", 4);
        System.out.println("l.addItem(\"Teste6\", 5);");
        l.addItem("Teste6", 5);
        System.out.println("l.removeItem(2);");
        l.removeItem(2);
        System.out.println("l.removeItem(3);");
        l.removeItem(3);
        System.out.println("l.addItem(\"Teste7\", 1);");
        l.addItem("Teste7", 1);
        System.out.println("l.addItem(\"Teste8\", 0);");
        l.addItem("Teste8", 0);
        System.out.println("l.removeItem(4);");
        l.removeItem(4);
        System.out.println("l.addItem(\"Teste9\", 10);");
        l.addItem("Teste9", 10);
        System.out.println("l.removeItem(1);");
        l.removeItem(1);
        System.out.println("l.removeItem(3);");
        l.removeItem(3);
        System.out.println("l.removeItem(23);");
        l.removeItem(23);
        System.out.println("l.addItem(\"Teste10\", 2);");
        l.addItem("Teste10", 2);
        System.out.println("l.removeItem(3);");
        l.removeItem(3);
        System.out.println("l.removeItem(4);");
        l.removeItem(4);
        // System.out.println("l.addItem(\"Teste11\", 2);");
        // l.addItem("Teste11", 2);
        System.out.println("l.removeItem(5);");
        l.removeItem(5);
        System.out.println("l.removeItem(1);");
        l.removeItem(1);
        System.out.println("l.removeItem(2);");
        l.removeItem(2);
    }
}
