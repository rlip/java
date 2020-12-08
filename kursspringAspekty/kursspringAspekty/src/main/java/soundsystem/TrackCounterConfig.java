package soundsystem;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:config/TrackConfig.xml")
@EnableAspectJAutoProxy
public class TrackCounterConfig {

//
//    @Bean
//    public BlankDisc sgtPeppers() {
//        BlankDisc cd = new BlankDisc();
//        cd.setTitle("Sgt. Pepper's Lonely Hearts Club Band");
//        cd.setArtist("The Beatles");
//
//        List<String> tracks = new ArrayList<>();
//        tracks.add("Sgt. Pepper's Lonely Hearts Club Band");
//        tracks.add("With a Little Help from My Friends");
//        tracks.add("Lucy in the Sky with Diamonds");
//        tracks.add("Getting Better");
//        tracks.add("Fixing a Hole");
//        cd.setTracks(tracks);
//        return cd;
//    }
//    @Bean
//    public TrackCounter trackCounter() {
//        return new TrackCounter();
//    }

}
