import java.util.*;
import java.util.stream.Collectors;

public class Java8LambdaStream {
    public static void main(String[] args) {
        //JAVA 8: FUNÇÕES LAMBDAS[

        //API STREAM

        //stream - fluxo de dados

        List<Integer> list = Arrays.asList(1,5,8,9,1,4,7,6,6,9,9);
        list.stream()
                .skip(2)
                .limit(3)
                .distinct()
                .map(e -> e * 2)
                .forEach((e) -> System.out.println(e));

        long count = list.stream()
                .limit(12)
                .count();
        System.out.println(count);

        Optional<Integer> min = list.stream()
                .min(Comparator.naturalOrder());
        System.out.println(min.get());

        Optional<Integer> max = list.stream()
                .max(Comparator.naturalOrder());
        System.out.println(max.get());

        List<Integer> newList = list.stream()
                .filter(e -> e % 2 ==0)
                .collect(Collectors.toList());
        System.out.println(newList);

        Map<Integer, List<Integer>> collect = list.stream()
                .collect(Collectors.groupingBy(e -> e * 3));
        System.out.println(collect);

        String s = list.stream()
                .map(e -> String.valueOf(e))
                .collect(Collectors.joining(";"));
    }
}
