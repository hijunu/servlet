package hello.servlet.domain.member;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MemberRepositoryTest {
    MemberRepository memberRepository = MemberRepository.getInstance();

    @BeforeEach
    public void setup() {
        //memberRepository.clear();
    }

    @Test
    @Order(2)
    public void save() {
        //given
        Member member = new Member("hello", 20);

        //when
        Member savedMember = memberRepository.save(member);

        //then
        Member findMember = memberRepository.findById(savedMember.getId());
        assertThat(findMember).isEqualTo(savedMember);
    }

    @Test
    @Order(1)
    public void findAll() {
        //given
        Member member1 = new Member("hell1o", 20);
        Member member2 = new Member("hello2", 30);

        memberRepository.save(member1);
        memberRepository.save(member2);

        //when
        List<Member> allMember = memberRepository.findAll();

        //then
        assertThat(allMember.size()).isEqualTo(2);
        assertThat(allMember.get(0)).isEqualTo(member1);
        assertThat(allMember.get(1)).isEqualTo(member2);
    }
}
