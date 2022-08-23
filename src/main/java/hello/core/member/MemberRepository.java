package hello.core.member;

public interface MemberRepository {

    void save(Member id);

    Member findById(Long id);

}
