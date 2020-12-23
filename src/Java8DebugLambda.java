import java.util.Arrays;
import java.util.List;

public class Java8DebugLambda {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 5, 8, 9);

        list.stream()
                .peek(n -> System.out.println(n + "Hi!"))
                .filter(n -> n % 2 == 0)
                .peek(n -> System.out.println(n + "Hello!"))
//      .filter(n -> n % 2 == 0)
//      .filter(n -> n % 2 == 0)
//      .map(..)
                .forEach(System.out::println);

    }

    private static StringBuilder convertToStringBuilder(Integer n) {
        StringBuilder builder = new StringBuilder();
        builder.append(n);
        builder.append("s");
        builder.append("a");
        return builder;
    }
}
