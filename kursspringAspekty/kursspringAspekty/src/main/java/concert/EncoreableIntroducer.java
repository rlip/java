package concert;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class EncoreableIntroducer {
    //value - typ komponentów, które mają implementować interfejs, znak plusa na końcu oznacza,
    // że chodzi o podtyp Performance, a nie o interfejs sam w sobie
    //defaultImpl - identyfikuje klasy, które dostarczą implementacji dla wprowadzenia,
    // może tu też być delegate-ref - wtedy podajemy nazwę sprinowego beana
    //Statyczna właściwość opatrzona adnotacją @DeclareParents określa wprowadzany interfejs
    @DeclareParents(value="concert.Performance+", defaultImpl=EncoreableImpl.class)
    public static Encoreable encoreable;
}
