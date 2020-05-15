package silverit.deliverables.sample;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class HelloController {

//    @Autowired
    private final MemberRepository memberRepository;

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!!");

        //given
        Member member = new Member();
        member.setUsername("memberA");

        memberRepository.save(member);
        memberRepository.flush();

        Optional<Member> member1 = memberRepository.findById(Long.valueOf(1));

        Member member2 = new Member();
        member2.setUsername("memberAB");

        memberRepository.flush();
        //when
//        Long savedId = memberRepository.save(member);
//        Member findMember = memberRepository.find(savedId);

        //then
//        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
//        Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
//        Assertions.assertThat(findMember).isEqualTo(member);


        return "hello";
    }
}
