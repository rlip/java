package concert;

import org.springframework.stereotype.Component;

@Component
public class EncoreableImpl implements Encoreable {
    @Override
    public void makeBis() {
        System.out.println("Robię BIS!!!");
    }
}
