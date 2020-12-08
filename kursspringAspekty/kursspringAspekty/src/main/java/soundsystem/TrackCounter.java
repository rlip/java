package soundsystem;

import org.springframework.scheduling.annotation.Scheduled;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class TrackCounter {

    private Map<Integer, Integer> trackCounts = new HashMap<>();

    public void countTrack(int trackNumber) {
        int currentCount = getPlayCount(trackNumber);
        trackCounts.put(trackNumber, currentCount + 1);

    }

    public int getPlayCount(int trackNumber) {
        return trackCounts.getOrDefault(trackNumber, 0);
    }

    @Scheduled(fixedRate  = 10000)
    public void showTrackPlayedStats(){
        System.out.println("--------------------------------------");
        System.out.println("STATYSTYKA");
        System.out.println("--------------------------------------");
        trackCounts.forEach(
                (integer, integer2) -> System.out.println("Utwór: " + integer + " Odtworzeń: " + integer2)
        );
        System.out.println("--------------------------------------");
    }
}
