import java.util.Arrays;
import java.util.List;

public class Java8LambdaStream {
    public static void main(String[] args) {
        //JAVA 8: FUNÇÕES LAMBDAS[

        //API STREAM

        //stream - fluxo de dados

        List<Integer> aslist = Arrays.asList(1,2,3,4,5);
        aslist.stream()
                .filter(e -> e % 2 == 0)
                .forEach((e) -> System.out.println(e));
    }
}
