package hello.advanced.trace.strategy.code.strategy;

import lombok.extern.slf4j.Slf4j;

/**
 * 전략을 파라미터로 전달 받는 방식
 */
@Slf4j
public class ContextV2 {
    // 전략을 필드로 가지지 않는다.
    public void execute(Strategy strategy) { // 대신 execute를 호출할 때마다, 파라미터로 전달 받는다.
        long startTime = System.currentTimeMillis();
        //비즈니스 로직 실행
        strategy.call(); // 위임
        //비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }
}
