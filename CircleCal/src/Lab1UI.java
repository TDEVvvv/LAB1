import java.util.*;
import java.util.stream.Collectors;

public class Lab1UI {

    public static List<Integer> createArrayList() {
        return new ArrayList<>();
    }

    public static void addElementsToList(List<Integer> list, Integer[] elements) {
        list.addAll(Arrays.asList(elements));
    }

    public static void removeDuplicates(List<Integer> list) {
        Set<Integer> set = new LinkedHashSet<>(list);
        list.clear();
        list.addAll(set);
    }

    public static void sortList(List<Integer> list) {
        Collections.sort(list);
    }

    public static boolean containsElement(List<Integer> list, int element) {
        return list.contains(element);
    }

    public static int calculateSum(List<Integer> list) {
        int sum = 0;
        for (int num : list) {
            sum += num;
        }
        return sum;
    }

    public static Map<String, Integer> calculateOddEven(List<Integer> list) {
        Map<String, Integer> result = new HashMap<>();
        int oddCount = 0;
        int evenCount = 0;
        for (int num : list) {
            if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        result.put("odd", oddCount);
        result.put("even", evenCount);
        return result;
    }
    
    public static void addElement(List<Integer> list, int element) {
        list.add(element);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> myList = createArrayList();

        Integer[] Utga = {3, 7, 1, 5, 3, 7};
        addElementsToList(myList, Utga);

        boolean exit = false;
        while (!exit) {
            System.out.println("Choose an operation:");
            System.out.println("1. Add element");
            System.out.println("2. Remove duplicates");
            System.out.println("3. Sort list");
            System.out.println("4. Check if an element exists");
            System.out.println("5. Calculate sum");
            System.out.println("6. Calculate odd/even counts");
            System.out.println("7. Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter element to add:");
                    int elementToAdd = scanner.nextInt();
                    addElement(myList, elementToAdd);
                    System.out.println("Element added to list: " + myList);
                    break;
                case 2:
                    removeDuplicates(myList);
                    System.out.println("Duplicates removed from list: " + myList);
                    break;
                case 3:
                    sortList(myList);
                    System.out.println("List sorted: " + myList);
                    break;
                case 4:
                    System.out.println("Enter element to check:");
                    int elementToCheck = scanner.nextInt();
                    System.out.println("Element " + elementToCheck + " exists: " + containsElement(myList, elementToCheck));
                    break;
                case 5:
                    System.out.println("Sum of list: " + calculateSum(myList));
                    break;
                case 6:
                    Map<String, Integer> oddEvenCount = calculateOddEven(myList);
                    System.out.println("Odd count: " + oddEvenCount.get("odd") + ", Even count: " + oddEvenCount.get("even"));
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
        System.out.println("Exiting program.");
        scanner.close();
    }
}
