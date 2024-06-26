package hello.advanced.trace.strategy.code.strategy;

import lombok.extern.slf4j.Slf4j;

/**
 * 필드에 전략을 보관하는 방식
 */
@Slf4j
public class ContextV1 { // 변하지 않는 로직을 가지고 있는 템플릿 역할을 하는 코드.
    private Strategy strategy; // context는 Strategy 인터페이스에만 의존하고 있다.
                                // 때문에, Strategy 구현체를 변경하거나 새로 만들어도 Context 코드에는 영향을 주지 않는다.

    public ContextV1(Strategy strategy) {
        this.strategy = strategy;
    }

    public void execute() {
        long startTime = System.currentTimeMillis();
        //비즈니스 로직 실행
        strategy.call(); // 위임
        //비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }
}
