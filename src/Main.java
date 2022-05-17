import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose from the following options:\n" +
                "f: FileDetails\n" +
                "h: Hamburgers");
        String choice = scanner.nextLine();
        if (choice.equals("f")){
            fileMenu(scanner);
        }
        if (choice.equals("h")){
            hamburgerMenu(scanner);
        }
    }
    public static FileDetails readFileDetails(String path) throws IOException {
        Map<String, FileDetails> files = new HashMap();
        DirectoryDetails root=new DirectoryDetails(null, "root");
        files.put("", root);
        Files.lines(Paths.get(path))
                .map(str -> FileDetailsFactory.getFileDetails(str))
                .peek(f -> files.put(f.getFullName(),f))
                .peek(f -> ((DirectoryDetails)files.get(f.getPath())).addFile(f))
                .collect(Collectors.toList());
        return root;
    }
    public static void fileMenu(Scanner scanner) throws IOException {
        String path="files.txt";
        FileDetails root= readFileDetails(path);
        System.out.println("Choose from the following options:\n" +
                "q: quit\n" +
                "c: countFiles\n" +
                "st: statistics\n" +
                "sh: short\n" +
                "sz: size");
        String myString;
        while (!(myString = scanner.nextLine()).equals("q")){
            switch (myString){
                case "c":
                    fileCount  a = new fileCount();
                    root.accept(a);
                    int sum = a.getCount();
                    System.out.println("Found "+ sum+" files");
                    break;
                case "sz":
                    sizeCalculator fileSizeCalculator = new sizeCalculator();
                    root.accept(fileSizeCalculator);
                    int sumSizes = fileSizeCalculator.getCount();
                    System.out.println("the total size is " + sumSizes + " bytes");
                    break;
                case "st":
                    statistics fileStatistics = new statistics();
                    root.accept(fileStatistics);
                    break;
                case "sh":
                     ShortPrint fileShort = new ShortPrint();
                     root.accept(fileShort);


            }
        }
    }

    public static void hamburgerMenu(Scanner scanner){
        System.out.println("Choose from the following hamburgers:\n" +
                "cl: classic\n" +
                "sp: spicy\n" +
                "la: lamb\n" +
                "hm: homemade");


        HamburgerFactory hamburgerFactory = new HamburgerFactory();

        Hamburger hamburger = hamburgerFactory.createHamburger(scanner.nextLine());//choice hamburger by the user

        String choice="";
        while (!choice.equals("s")) {
            System.out.println("Choose from the following options:\n" +
                    "a: add topping\n" +
                    "s: serve");
            choice = scanner.nextLine();
            if (choice.equals("a")) {
                hamburger = toppingMenu(scanner, hamburger);
            }
            if (choice.equals("s")) {
                System.out.println(hamburger.serve());

            }
        }
    }
    public static Hamburger toppingMenu(Scanner scanner, Hamburger hamburger){
        System.out.println("Choose from the following toppings:\n" +
                "ch: chips\n" +
                "or: onion rings\n" +
                "sa: salad\n" +
                "fe: fried egg");

        HamburgerToppingFactory hamburgerToppingFactory = new HamburgerToppingFactory();
        return hamburgerToppingFactory.GetTopping(scanner.nextLine(),hamburger);
    }
}
