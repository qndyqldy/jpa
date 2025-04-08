package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {
    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void 회원가입() throws Exception {
        // given
        Member member = new Member();
        member.setName("yim");

        // when
        Long memberId = memberService.join(member);

        // then
        Assertions.assertThat(member.getId()).isEqualTo(memberId);
        assertEquals(member, memberRepository.findOne(memberId));
    }
    
    @Test
    public void 중복_회원_예외() throws Exception {
        // given
        Member member1 = new Member();
        member1.setName("yim");

        Member member2 = new Member();
        member2.setName("yim");
        
        // when
        memberService.join(member1);

        try {
            memberService.join(member2); // 예외 발생해야 한다.
        } catch (IllegalStateException e) {
            return;
        }

        // then
        fail("예외가 발생해야 한다.");
    }
}