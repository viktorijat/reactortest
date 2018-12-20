import java.time.Duration;
import java.util.Arrays;
import org.junit.Test;
import reactor.core.publisher.Flux;

public class FluxTest {

    @Test
    public void firstFlux() {
        Flux.just("A", "B", "C").log().subscribe();
    }

    @Test
    public void fluxFromIterable() {
        Flux.fromIterable(Arrays.asList("A", "B", "C")).log().subscribe();
    }

    @Test
    public void fluxFromRange() {
        Flux.range(10, 5).log().subscribe();
    }

    @Test
    public void fluxFromInterval() {
        Flux.interval(Duration.ofSeconds(1)).log().subscribe();
    }
}


//https://blogg.kantega.no/webapp-with-create-react-app-and-spring-boot/