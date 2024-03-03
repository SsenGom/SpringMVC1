package hello.servlet.web.springmvc.v3;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {

    @RequestMapping(value = "/new-form", method = RequestMethod.GET)
    @GetMapping("/new-form") // < 요렇게 주로 사용
    public String newform() {
        return "new-form";
    }

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @RequestMapping(method = RequestMethod.GET)
    @GetMapping //< 요렇게 주로 사용
    public String members(Model model) {

        List<Member> members = memberRepository.findAll();

        model.addAttribute("members",members);
        return "members";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @PostMapping("/save") // < 요렇게 주로 사용
    public String save(@RequestParam("username") String username,
                      @RequestParam("age") int age,
                      Model Model) {

        Member member = new Member(username, age);
        memberRepository.save(member);

        Model.addAttribute("member", member);
        return "save-result";
    }
}
