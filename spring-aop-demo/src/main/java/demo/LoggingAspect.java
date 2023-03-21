package demo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* demo.ShoppingCart.checkout(..))")
    public void beforeLogger(JoinPoint joinPoint){
        System.out.println("Before Logger");
        Object[] signatureArgs = joinPoint.getArgs();
        for (Object signatureArg: signatureArgs) {
            System.out.println("Arg: " + signatureArg);
        }

    }

    @After("execution(* *.*.checkout(..))")
    public void afterLogger(){
        System.out.println("After Logger");
    }
}
