package me.khunsan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    //slect * from memer where name = ?
    public Optional<Member> findByName(String name);
}
