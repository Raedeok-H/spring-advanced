package hello.advanced.trace.helloTraceV1;

import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloTraceV1Test {
    // Assertions를 사용하지 않고 눈으로 확인하는 테스트 코드는 올바른 작성법이 아님.
    // 응답값이 없는 경우를 자동으로 검증하려면 여러가지 테스트 기법이 필요
    // 하지만, 예제를 최대한 단순화 하기 위해 검증 테스트를 생략
    @Test
    void begin_end() {
        HelloTraceV1 trace = new HelloTraceV1();
        TraceStatus status = trace.begin("hello");
        trace.end(status);
    }

    @Test
    void begin_exception() {
        HelloTraceV1 trace = new HelloTraceV1();
        TraceStatus status = trace.begin("hello");
        trace.exception(status, new IllegalStateException());
    }

}