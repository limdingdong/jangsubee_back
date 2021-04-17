package jangsubee.domain.member.service;

import jangsubee.domain.member.entity.Member;
import jangsubee.domain.member.entity.enums.MemberTypeEnum;
import jangsubee.domain.member.service.dto.MemberJoinIn;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Test
    @DisplayName("멤버등록 테스트")
    void register() {
        // given
        MemberJoinIn memberJoinIn = new MemberJoinIn("STAFF17", "실습멤버", MemberTypeEnum.MANAGER, "20210417", "99991231", "1234");

        // when
        String createdMemberId = memberService.join(memberJoinIn);
        Member member = memberService.findMember(createdMemberId);

        // then
        Assertions.assertThat(member.getId()).isEqualTo(memberJoinIn.getId());
    }

}