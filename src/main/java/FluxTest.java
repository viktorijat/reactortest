import java.time.Duration;
import java.util.Arrays;
import org.junit.Test;
import reactor.core.publisher.Flux;

public class FluxTest {

    @Test
    public void firstFlux() {
        Flux.just("A", "B", "C")
                .log()
                .subscribe();
    }

    @Test
    public void fluxFromIterable() {
        Flux.fromIterable(Arrays.asList("A", "B", "C"))
                .log()
                .subscribe();
    }

    @Test
    public void fluxFromRange() {
        Flux.range(10, 5)
                .log()
                .subscribe();
    }

    @Test
    public void fluxFromInterval() throws InterruptedException {
        Flux.interval(Duration.ofSeconds(1))
                .log()
                .take(2)
                .subscribe();
        Thread.sleep(5000);
    }

    @Test
    public void fluxRequest() {
        Flux.range(1, 5)
                .log()
                .subscribe(null, null, null, s -> s.request(3));
    }


}


//https://blogg.kantega.no/webapp-with-create-react-app-and-spring-boot/