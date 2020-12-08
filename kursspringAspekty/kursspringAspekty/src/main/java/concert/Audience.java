package concert;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;


@Aspect
public class Audience {
 /*
    @Before("execution(* concert.Performance.perform(..))")
    public void silenceCellPhones() {
        System.out.println("Widzowie wyciszają telefony komórkowe");
    }
    @Before("execution(* concert.Performance.perform(..))")
    public void takeSeats() {
        System.out.println("Widzowie zajmują miejsca");
    }
    @AfterReturning("execution(* concert.Performance.perform(..))")
    public void applause() {
        System.out.println("Brawooo! Oklaski!");
    }
    @AfterThrowing("execution(* concert.Performance.perform(..))")
    public void demandRefund() {
        System.out.println("Buu! Oddajcie pieniądze za bilety!");
    }
    */
    // Żeby było bez powtórzeń kodu to można tak:

//    @Pointcut("execution(* concert.Performance.perform(..))")
//    public void performance() {
//    }
//
//    @Before("performance()")
//    public void silenceCellPhones() {
//        System.out.println("Widzowie wyciszają telefony komórkowe");
//    }
//
//    @Before("performance()")
//    public void takeSeats() {
//        System.out.println("Widzowie zajmują miejsca");
//    }
//
//    @AfterReturning("performance()")
//    public void applause() {
//        System.out.println("Brawooo! Oklaski!");
//    }
//
//    @AfterThrowing("performance()")
//    public void demandRefund() {
//        System.out.println("Buu! Oddajcie pieniądze za bilety!");
//    }

    @Around("execution(* concert.Performance.perform(..))")
    public void watchPerformance(ProceedingJoinPoint jp) {
        try {
            System.out.println("Widzowie wyciszają telefony komórkowe.");
            System.out.println("Widzowie zajmują miejsca.");
            jp.proceed();
            System.out.println("Brawooo! Oklaski!");
        } catch (Throwable t) {
            System.out.println("Buu! Oddajcie pieniądze za bilety!");
        }
    }
}
