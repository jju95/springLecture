package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10 퍼센트 할인 입니다. ")
    void vio_o(){
        // given
        Long memberId = 1L;
        Member member = new Member(memberId,"memberVIP", Grade.VIP);

        // when
        int discount = discountPolicy.discount(member, 10000);

        //then
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니라면 할인이 적용이 되지 말아야 합니다. ")
    void vip_x(){
        // given
        Long memberId = 2L;
        Member member = new Member(memberId,"memberBASIC", Grade.BASIC);

        // when
        int discount = discountPolicy.discount(member, 10000);

        //then
        assertThat(discount).isEqualTo(0);

    }

}