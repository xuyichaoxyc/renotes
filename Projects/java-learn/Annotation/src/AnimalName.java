import java.lang.annotation.*;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/7/6 10:16
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AnimalName {
    String value() default "";
}
