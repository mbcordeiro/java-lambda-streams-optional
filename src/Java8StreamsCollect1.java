import java.util.*;
import java.util.stream.Collectors;

public class Java8StreamsCollect1 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

        Set<Integer> collect = list.stream()
                .collect(() -> new HashSet<>(), (l, e) -> l.add(e), (l1, l2) -> l1.addAll(l2));

        System.out.println(list);
        System.out.println(collect);

        //toList
        List<Integer> toList = list.stream()
                .filter((n) -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(toList);

        //toCollection
        Deque<Integer> toCollection = list.stream()
                .filter((n) -> n % 2 == 0)
                .collect(Collectors.toCollection(() -> new ArrayDeque<Integer>()));
        System.out.println(toCollection);

        //joining
        String join = list.stream()
                .map((n) -> n.toString())
                .collect(Collectors.joining());
        System.out.println(join);

        //averaging
        Double media = list.stream()
                .collect(Collectors.averagingInt((n) -> n.intValue()));
        System.out.println(media);

        //summing
        Integer sum = list.stream()
                .collect(Collectors.summingInt((n) -> n.intValue()));
        System.out.println(sum);

        //summarizing
        IntSummaryStatistics stats = list.stream()
                .collect(Collectors.summarizingInt((n) -> n.intValue()));
        System.out.println(stats.getAverage());
        System.out.println(stats.getCount());
        System.out.println(stats.getMax());
        System.out.println(stats.getMin());
        System.out.println(stats.getSum());

        //counting
        Long count = list.stream()
                .filter((n) -> n % 2 == 0)
                .collect(Collectors.counting());
        System.out.println(count);

        //max,im
        list.stream()
                .collect(Collectors.maxBy(Comparator.naturalOrder()))
                .ifPresent(System.out::println);

        list.stream()
                .collect(Collectors.minBy(Comparator.naturalOrder()))
                .ifPresent(System.out::println);

        // groupingBy
        Map<Integer, List<Integer>> groupingBy = list.stream()
                .collect(Collectors.groupingBy((n) -> n % 3));
        System.out.println(groupingBy);

        // partitioningBy
        Map<Boolean, List<Integer>> partitioningBy = list.stream()
                .collect(Collectors.partitioningBy((n) -> n % 3 == 0));
        System.out.println(partitioningBy);

        //toMap
        Map<Integer, Integer> toMap = list.stream()
                .collect(Collectors.toMap(n -> n, n -> n * 2));
        System.out.println(toMap);

        Map<Integer, Double> toMap2 = list.stream()
                .collect(Collectors.toMap(n -> n, n -> Math.pow(n.doubleValue(), 5)));
        System.out.println(toMap2);
    }
}
