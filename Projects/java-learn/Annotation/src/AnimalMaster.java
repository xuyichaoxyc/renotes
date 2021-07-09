import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface AnimalMaster {
    int id() default -1;

    String name() default "";

    String address() default "";
}
