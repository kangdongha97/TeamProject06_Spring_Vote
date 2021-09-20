package Pack01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class Check {
	
	@RequestMapping("/checkInfo")
	public String checInfo(Model model, User user) {

		model.addAttribute("user", user);
		Dao dao = new Dao();
		System.out.println("체크인포"+user.uname);
		String result = dao.userCheck(user.uname, user.utel);
		
		// 신원 확인 안 되거나 투표 이력 있으면 첫 화면으로
		return (result.equals("1")) ? "VoteView" : "Fail" ;
	}
	
	@RequestMapping("/voting")
	public String voting(Model model, User user) {
		model.addAttribute("user", user);
		Dao dao = new Dao();
		dao.vote(user.uname, user.utel, user.num);
		System.out.println(user.uname+" "+user.num);
		return "Success";
	}
}
