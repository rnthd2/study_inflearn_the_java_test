package me.rnthd2.study_inflearn_the_java_test;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Target(ElementType.METHOD)
 * 사용 가능한 곳
 *
 * @Retention(RetentionPolicy.RUNTIME)
 * 이 애노테이션을 사용한 코드가 이 애노테이션 정보를 런타임까지 유지해야된다
 *
 * @Tag("fast")
 * @FastTest로 사용할 수 있고 @Tag("fast")로 사용할 수 있으나
 * @Tag는 type safe하지 않기 때문에 되도록 전자를 사용한다
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Test
@Tag("fast")
public @interface FastTest {
}
