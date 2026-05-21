import java.util.stream.Collectors;
import java.util.List;

public class Practice {
    public static void main(String[] args) {

        // List<Integer> ans = list.stream().filter(x ->
        // x%2==0).collect(Collectors.toList());
        // List<String> names =
        // employees.stream().map(Employee::getName).collect(Collectors.toList());
        // HashMap<String, List<Employee>> map =
        // employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        // Map<String, Long> map =
        // employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
        // Collectors.counting()));
        // List<Product> lis =
        // products.stream().sorted(Comparator.comparingDouble(Product::getPrice)).thenComparing(Comparator.comparingInt(Product::getStock)).collect(Collectors.toList());
        List<String> words = List.of("java", "hello", "world");
        String result = words.stream().collect(Collectors.joining(", "));
        System.out.println(result);
    }

}
