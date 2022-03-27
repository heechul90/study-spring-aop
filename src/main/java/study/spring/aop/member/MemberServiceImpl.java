package study.spring.aop.member;

import org.springframework.stereotype.Component;
import study.spring.aop.member.annotation.ClassAop;
import study.spring.aop.member.annotation.MethodAop;

@ClassAop
@Component
public class MemberServiceImpl implements MemberService {

    @Override
    @MethodAop(value = "test value")
    public String hello(String param) {
        return "ok";
    }

    public String internal(String param) {
        return "ok";
    }
}
