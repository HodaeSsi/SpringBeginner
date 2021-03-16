package unknown.hellospring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import unknown.hellospring.aop.TimeTraceAop;
import unknown.hellospring.repository.JpaMemberRepository;
import unknown.hellospring.repository.MemberRepository;
import unknown.hellospring.repository.MemoryMemberRepository;
import unknown.hellospring.service.MemberService;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {
//
//    private EntityManager em;
//
//    @Autowired
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    } //스프링데이터 레포지토리가 스스로 스프링 컨테이너에 등록하기 때문에 autowired만 해주면 된다.

    @Bean
//    public MemberService memberService() {
//        return new MemberService(memberRepository());
//    }
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JpaMemberRepository();
//    }

//    @Bean
//    public TimeTraceAop timeTraceAop() {
//        return new TimeTraceAop();
//    }
}
