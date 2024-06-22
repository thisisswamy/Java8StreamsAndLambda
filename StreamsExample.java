import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsExample {


    //Reverse each word of sentence
    static void reverseWordsInSentence() {
        String input ="abc pqr xyz";
        Stream.of(input.split(" ")).map(x->new StringBuffer(x).reverse().toString()).forEach(x->System.out.print(x +" "));
    }

    //Removing the duplicates from list;
    static void removeDuplicatesNumbers() {
        Stream.of(1,2,3,4,4,2).distinct().forEach(System.out::print);
        Stream.of("swamy","swamu","swamy").distinct().toList().forEach(System.out::print);

    }

    //Reduce function sum of numbers
    static void reducerFunction() {
//        int reduce = IntStream.range(1, 10).reduce(0, (int acc, int curr) -> acc + curr);
        int sum = IntStream.range(1, 10).sum();
        System.out.println("sum of list : " +sum);
    }

    static Map<String, Long> getMaxRepeatedChars() {
        Map<String, Long> collect = Stream.of("swamy swamy ayyappa".split(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Optional<Long> max = collect.values().stream().max(Long::compare);
        Map<String, Long> collect1 = collect.entrySet().stream().filter((e) -> e.getValue().equals(max.orElse(0L))).collect(Collectors.toMap(
                entry -> entry.getKey(),
                entry -> entry.getValue()

        ));
        return collect1;
    }

    static Map<Character, Long> countCharsByGroupBy() {
        Map<Character, Long> collect = Stream.of('a', 'b', 'a', 'a', 'w')
                                                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return collect;
    }

    static Map<Character, Integer> countCharsByToMap() {
        Map<Character, Integer> collect = Stream.of('a', 'b','a','a','w').collect(Collectors.toMap(
                                                                            key -> key,
                                                                            value -> 1,
                                                                            (existingValue, currentValue) -> existingValue + currentValue,
                                                                            () -> new HashMap<>()
                                                                    ));
        return collect;
    }

    static void printMap(Map<String, Long> collect) {
        for(Map.Entry<String,Long> entry: collect.entrySet()){
            System.out.println(entry.getKey()+ " : "+entry.getValue());
        }
    }


    public static void main(String[] args) {

//        reverseWordsInSentence();
        removeDuplicatesNumbers();
//        reducerFunction();

//        HashMap<Character, Integer> collect = countCharsMap();
//        Map<Character, Long> collect = countCharsByGroupBy();
//        Map<String, Long> collect1 = getMaxRepeatedChars();
//        printMap(collect1);


    }


}
