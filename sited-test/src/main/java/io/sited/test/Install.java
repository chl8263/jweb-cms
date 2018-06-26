package io.sited.test;

import io.sited.AbstractModule;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author chi
 */
@Target(TYPE)
@Retention(RUNTIME)
public @interface Install {
    Class<? extends AbstractModule>[] value() default {};
}
