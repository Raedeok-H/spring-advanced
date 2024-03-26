package hello.advanced.trace.template.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractTemplate {
    public void execute() { // 변하지 않는 부분인 시간 측정로직을 몰아둔 것을 확인할 수 있다.
        long startTime = System.currentTimeMillis();
        //비즈니스 로직 실행
        call(); //변하는 부분을 자식클래스로 해결한다. => 상속과 오버라이딩을 사용해서 처리한다.
        //비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }

    protected abstract void call();
}
