package soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Starter {

    @Autowired
    CompactDisc compactDisc;

    @Scheduled(fixedRate  = 2000)
    public void run() {
        new Random()
                .ints(1, 1, 5)
                .forEach(compactDisc::playTrack);

    }

}
