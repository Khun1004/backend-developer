package me.khunsan;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Sql("/insert-members.sql")
    @DisplayName("MemberRepository를 통해 member 텡블의 모든 레코드(3개) 가져오기.")
    @Test
    public void getAllMembers() {

        //준비 given


        //실행 when
        List<Member> members = memberRepository.findAll(); //select * from member;

        // 검증 then
        assertThat(members.size()).isEqualTo(3);

    }

    @Sql("/insert-members.sql")
    @DisplayName("MemberRepository를 통해 이름이 'C'인 레코드 가져오기.")
    @Test
    public void getMemberByName() {
        //준비 given

        //실행 when
        Optional<Member> optMember = memberRepository.findByName("C");
        Member member = optMember.get();

        // 검증 then
        assertThat(member.getId()).isEqualTo(3);
    }

    @Sql("/insert-members.sql")
    @DisplayName("MemberRepository를 통해 Id가 2인 레코드 가져오기.")
    @Test
    public void getMemberById() {
        //준비 given

        //실행 when
        Member member = memberRepository.findById(2L).get();

        // 검증 then
        assertThat(member.getId()).isEqualTo("B");
    }

    @DisplayName("MemberRepository를 통해 이름이 '쿤산웨이'인 레코드 추가하기")
    @Test
    public void saveMember() {
        //준비 given
        Member member = new Member("쿤산웨이");

        //실행 when
        memberRepository.save(member);

        // 검증 then
        //member 테이블에서ㅓ 모든 레코드를 select 했을 때 레코드의 수가 1이고
        // 그 레코드의 name 캄럼 값이 '쿤산웨이'인
        List<Member> result = memberRepository.findAll();
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).getName()).isEqualTo("쿤산웨이");
    }

    @Sql("/insert-members.sql")
    @DisplayName("테이블 member에서 id가 3인 레코드 삭제하기")
    @Test
    public void deleteById3() {
        //준비 given

        //실행 when
        memberRepository.deleteById(3L);

        // 검증 then
        List<Member> members = memberRepository.findAll();
        assertThat(members.size()).isEqualTo(2);
    }

    @Sql("/insert-members.sql")
    @DisplayName("테이블 member 모든 레코드 삭제하기")
    @Test
    public void deleteAll() {
        //준비 given
//        List<Member> members = memberRepository.findAll();
//        assertThat(members.size()).isEqualTo(2);

        //실행 when
        memberRepository.deleteAll();

        // 검증 then
        List<Member> members = memberRepository.findAll();
        assertThat(members.size()).isZero();
    }

    @Sql("/insert-members.sql")
    @DisplayName("테이블 member name이 'A', 'B'인 레코드를 한 번에 삽입하기")
    @Test
    public void saveMembers() {
        //준비 given
        // 두 개의 member 객체를 샐성해서 List에 넣는다.
        List<Member> members = List.of(new Member("A"), new Member("B"));

        //실행 when
        memberRepository.saveAll(members);

        // 검증 then
//        assertThat(memberRepository.findAll().size()).isEqualTo(2);

        members = memberRepository.findAll();
        assertThat(members.size()).isEqualTo(2);
    }

    @Sql("/insert-members.sql")
    @DisplayName("변경감지 기능을 통해 Id가 2인 레코드의 이름을 'B', 'BB'로 변경하기")
    @Test
    public void update() {
        //준비 given
        Member member = memberRepository.findById(2L).get();

        //실행 when
        member.setName("BB");

        // 검증 then
        member = memberRepository.findById(2L).get();
        assertThat(member.getName()).isEqualTo("BB");
    }

}
