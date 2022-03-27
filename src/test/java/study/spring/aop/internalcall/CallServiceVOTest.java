package study.spring.aop.internalcall;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import study.spring.aop.internalcall.aop.CallLogAspect;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@Import(CallLogAspect.class)
@SpringBootTest
class CallServiceVOTest {

    @Autowired
    CallServiceVO callServiceVO;

    @Test
    void external() {
        //log.info("target={}", callServiceVO.getClass());
        callServiceVO.external();
    }

    @Test
    void internal() {
        callServiceVO.internal();
    }
}