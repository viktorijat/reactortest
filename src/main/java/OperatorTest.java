import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class OperatorTest {

    @Test
    public void map() {
        Flux.range(1, 5)
                .map(i -> i * 10)
                .subscribe(System.out::println);
    }

    @Test
    public void flatMap() {
        Flux.range(1, 5)
                .flatMap(i -> Flux.range(i * 10, 2))
                .subscribe(System.out::println);
    }

    @Test
    public void flatMapMany() {
        Mono.just(3)
                .flatMapMany(i -> Flux.range(1, i))
                .subscribe(System.out::println);
    }

    @Test
    public void zip() {
       Flux<Integer> oneToFive = Flux.range(1, 5);
       Flux<Integer> sixToTen = Flux.range(6, 10);

       Flux.zip(oneToFive, sixToTen,
               (item1, item2) -> item1 + ", " + item2)
               .subscribe(System.out::println);
    }

}
