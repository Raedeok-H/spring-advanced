package hello.advanced.trace;

import java.util.UUID;

public class TraceId {
    private String id;
    private int level;

    public TraceId() {
        this.id = createId();
        this.level = 0;
    }

    private TraceId(String id, int level) {
        this.id = id;
        this.level = level;
    }

    private String createId() {
        //ab99e16f-3cde-4d24-8241-256108c203a2 //생성된 UUID ab99e16f
        return UUID.randomUUID().toString().substring(0, 8);//앞 8자리만 사용
    }

    public TraceId createNextId() {
        return new TraceId(id, level + 1);  // 트랜잭션 ID가 같다. 깊이는 하나 증가한다
    }
    public TraceId createPreviousNextId() {
        return new TraceId(id, level - 1);  //트랜잭션 ID가 같다. 깊이는 하나 감소한다
    } 

    public boolean isFirstLevel() {
        return level == 0;
    }

    public String getId() {
        return id;
    }

    public int getLevel() {
        return level;
    }
}
