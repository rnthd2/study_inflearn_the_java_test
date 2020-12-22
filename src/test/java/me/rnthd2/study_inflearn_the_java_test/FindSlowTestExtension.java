package me.rnthd2.study_inflearn_the_java_test;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.lang.reflect.Method;

/**
 * 확장 모델
 *
 * 생성자로 threadhold 시간을 받아서 테스트 이전 시간을 start time 에 넣어놓고
 * 테스트 이후에 start time 과 현재 시간을 비교해서 duration을 가져와
 * threadhold 시간보다 더 길면 @SlowTest 라는 애노테이션을 붙이도록 권장한다
 * @SlowTest 애노테이션이 붙어 있으면 권장 문구를 노출하지 않는다.
 */
public class FindSlowTestExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback {

    private long THREADHOLD;

    public FindSlowTestExtension(long THREADHOLD) {
        this.THREADHOLD = THREADHOLD;
    }

    @Override
    public void beforeTestExecution(ExtensionContext extensionContext) throws Exception {
        ExtensionContext.Store store = getStore(extensionContext);
        store.put("START_TIME", System.currentTimeMillis());
    }

    private ExtensionContext.Store getStore(ExtensionContext extensionContext) {
        String testClassName = extensionContext.getRequiredTestClass().getName();
        String testMethodName = extensionContext.getRequiredTestMethod().getName();
        ExtensionContext.Store store = extensionContext.getStore(ExtensionContext.Namespace.create(testClassName, testMethodName));
        return store;
    }

    @Override
    public void afterTestExecution(ExtensionContext extensionContext) throws Exception {
        Method requiredTestMethod = extensionContext.getRequiredTestMethod();
        SlowTest annotation = requiredTestMethod.getAnnotation(SlowTest.class);
        String testMethodName = requiredTestMethod.getName();
        ExtensionContext.Store store = getStore(extensionContext);
        long start_time = store.remove("START_TIME", long.class);
        long duration = System.currentTimeMillis() - start_time;
        if(duration > THREADHOLD && annotation == null){
            System.out.printf("Please consider mark method [%s] with @SlowTest.\n",testMethodName);
        }

    }

}
