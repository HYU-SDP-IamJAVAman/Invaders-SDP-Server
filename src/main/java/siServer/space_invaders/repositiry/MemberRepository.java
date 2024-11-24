package siServer.space_invaders.repositiry;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import siServer.space_invaders.model.Member;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    @PersistenceContext
    private final EntityManager em;

    public int save(Member member) {
        em.persist(member);
        return member.getId();
    }

    public Optional<Member> findById(int id) {
        return Optional.ofNullable(em.find(Member.class, id));
    }
}
