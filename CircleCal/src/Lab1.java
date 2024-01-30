import java.util.*;
//test
public class Lab1 {

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

    public static void main(String[] args) {
        List<Integer> myList = createArrayList();
        
        Integer[] Utga = {3, 7, 1, 5, 3, 7};
        
        addElementsToList(myList, Utga);

        System.out.println("Эхний жагсаалт: " + myList);

        removeDuplicates(myList);
        System.out.println("Давхардал арилгасан жагсаалт: " + myList);

        sortList(myList);
        System.out.println("Сорт хийсэн жагсаалт: " + myList);

        System.out.println("Жагсаалт 5 агуулсан эсэх: " + containsElement(myList, 5));
        System.out.println("Жагсаалт 10 агуулсан эсэх: " + containsElement(myList, 10));

        System.out.println("Жагсаалтын нийлбэр: " + calculateSum(myList));

        Map<String, Integer> oddEvenCount = calculateOddEven(myList);
        System.out.println("Нийт сонгдгой элемент: " + oddEvenCount.get("odd"));
        System.out.println("Count of even элемент: " + oddEvenCount.get("even"));
    }
}
