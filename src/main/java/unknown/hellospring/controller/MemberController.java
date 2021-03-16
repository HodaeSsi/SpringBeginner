package unknown.hellospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import unknown.hellospring.domain.Member;
import unknown.hellospring.service.MemberService;

import java.util.List;

@Controller//컨트롤러 = 스프링이 관리(스프링 컨테이너에 들어감)
public class MemberController {

    //private final MemberService memberService = new MemberService();
    //멤버서비스는 여러곳에서 (같은인스턴스를)가져다 쓸 수 있기때문에 new키워드 X
    private final MemberService memberService;

    @Autowired //컨트롤러 > 서비스 > 레퍼지토리리
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    } //Autowired가 spring이 관리하는(spring컨테이너에 들어있는) 컨트롤러를 자동으로 연결해준다.

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
