package study.spring.aop.proxyvs;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;
import study.spring.aop.member.MemberService;
import study.spring.aop.member.MemberServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
public class ProxyCastingTest {

    @Test
    void jdkProxy() {

        MemberServiceImpl target = new MemberServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.setProxyTargetClass(false); //JDK 동적 프록시

        //프록시를 인터페이스로 캐스팅 성공
        MemberService memberServiceProxy = (MemberService) proxyFactory.getProxy();

        //JDK 동적 프록시를 구형 클래스로 캐스팅 시도 실패, ClassCastException 예외 발생
        //MemberServiceImpl castingMemberService = (MemberServiceImpl) memberServiceProxy;
        assertThrows(ClassCastException.class, () -> {
            MemberServiceImpl castingMemberService = (MemberServiceImpl) memberServiceProxy;
        });
    }

    @Test
    void cglibProxy() {

        MemberServiceImpl target = new MemberServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.setProxyTargetClass(true); //CGLIB 동적 프록시

        //프록시를 인터페이스로 캐스팅 성공
        MemberService memberServiceProxy = (MemberService) proxyFactory.getProxy();

        //CGLIB 동적 프록시를 구형 클래스로 캐스팅 시도 성공
        MemberServiceImpl castingMemberService = (MemberServiceImpl) memberServiceProxy;
    }


}
