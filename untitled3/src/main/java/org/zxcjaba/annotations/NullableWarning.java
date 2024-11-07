package org.zxcjaba.annotations;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface NullableWarning {

    String message() default "Variable is null";

}
