package siServer.space_invaders.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;
import siServer.space_invaders.model.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    Optional<Member> findByUsername(String username);

}
