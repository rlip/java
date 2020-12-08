package concert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Starter implements CommandLineRunner {
    @Autowired
    Performance performance;
    @Override
    public void run(String... strings) {
        performance.perform();
        ((Encoreable) performance).makeBis();
    }
}
