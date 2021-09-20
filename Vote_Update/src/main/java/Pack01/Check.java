package Pack01;

import java.sql.ResultSet;
import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Check {
	
	@RequestMapping("/checkInfo")
	public String checkInfo(Model model, User user) {
		// 다오 객체 생성
		//Dao dao = new Dao();
		// return 값 if 문 조건에 넣기 
		//Boolean r = false;
		//Boolean check = true;
		//if (!r) {
		//	check = false;
		//	return check;
		//}
		
		String uname = user.getUname();
		String utel = user.getUtel();
		System.out.println(uname);
		System.out.println(utel);
		
		model.addAttribute("user", user);
		
		return "VoteView";
	}
	
	
	
	@RequestMapping("/voting")
	public String voting(Model model, User user) {
		
//		String uname = user.getUname();
//		String utel = user.getUtel();
//		System.out.println(uname);
//		System.out.println(utel);
		
		String candi = user.getCandi();
		System.out.println(candi);
		System.out.println("----------------------------");
		Dao dao = new Dao();
		
		dao.vote(user);
		//ResultSet rs = dao.result();
		LinkedList<String> mm = new LinkedList<String>();
		mm = dao.result();
		System.out.println("rrr");
		model.addAttribute("mm", mm);
		
		return "Success";
	}
	
	
	
}
