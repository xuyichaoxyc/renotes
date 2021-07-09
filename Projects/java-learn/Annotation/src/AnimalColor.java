import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AnimalColor {
    /**
     * 颜色枚举
     */
    public enum Color{黑色, 白色, 灰色, 杂色};

    Color animalColor() default Color.白色;
}
