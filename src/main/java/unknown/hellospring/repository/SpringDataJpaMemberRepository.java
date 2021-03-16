package unknown.hellospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unknown.hellospring.domain.Member;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository{
//(JpaRepository인터페이스를 통해)스프링 컨테이너에 스스로 구현체를 등록한다.
    @Override
    Optional<Member> findByName(String name);
}
