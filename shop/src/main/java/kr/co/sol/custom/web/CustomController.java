package kr.co.sol.custom.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.sol.custom.dto.MemberDTO;
import kr.co.sol.custom.service.MemberService;

@Controller
public class CustomController {
	private static final Logger logger = LoggerFactory.getLogger(CustomController.class);

	@Autowired
	 MemberService memberService;
	
	@GetMapping("/")
	public String index(HttpServletRequest request, Model model, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String idKey = (String)session.getAttribute("idKey");
        session.setAttribute("idKye", idKey);
		return "Index";
	}

	@GetMapping("/register")
	public String register(HttpServletRequest request, Model model, HttpServletResponse response) {
		return "Register";
	}
	
	
	 @RequestMapping(value = "/idcheck")
	  @ResponseBody
	  public int idCheck(MemberDTO mdto, HttpServletRequest request, HttpServletResponse response,Model model ) {
		  int cnt = 0;
		  String id = mdto.getMem_id();
		  if(mdto.getMem_id()!=null) {
	 	  cnt = memberService.idCheck(id);
		  }
		  return cnt;
	  }
	 
	  @RequestMapping(value="/registerProc")
		 public String registerProc(MemberDTO mdto, 
				  HttpServletRequest request, 
				  HttpServletResponse response,
				  Model model ) {
			  //memberJoin
			//  logger.info("멤버: "+mdto.toString());
			  int r = memberService.memberJoin(mdto);
			  if(r>0)
			  model.addAttribute("msg", "회원가입 성공");//저장결과 등을 확인
			  else
			  model.addAttribute("msg", "회원가입 실패");//저장결과 등을 확인
			return "MsgPage"; 
		 }

	  @RequestMapping(value="/login")
	  public String login() {
		  return "Login"; 
	  }
	  
	  @RequestMapping(value="/loginProc")
		 public String loginProc(MemberDTO mdto, 
				  HttpServletRequest request, 
				  HttpServletResponse response,
				  Model model ) {
//		  logger.info("멤버: "+mdto.toString());
//		  String id=memberService.logonProc(mdto);
	      mdto=memberService.logonProc(mdto);

	      HttpSession session = request.getSession();
		  String mem_id= null;
		  String url="/";
		  if(mdto!=null) {
			  mem_id= mdto.getMem_id();
		    if(mdto.getM_roll()!=null) {
		    	//해당 롤에 해당 메뉴로 갖고 온다
		    	url="/admin/index";
			  }
		   }
		  if(mem_id==null) 
			  model.addAttribute("msg", "id 또는 password 오류 입니다.");
		  if(mem_id!=null) {
		   // 회원정보	  
		  session.setAttribute("mdto", mdto);
		  //세션객체
		  session.setAttribute("idKey", mem_id);
		  }
		  session.setAttribute("url", url);
		  return "MsgPage";
		 }

	  @RequestMapping(value="/logout")
	  public String logout( HttpServletRequest request) {
		  HttpSession session = request.getSession();
		  session.removeAttribute("idKey");
		  session.invalidate();
		  return "redirect:/"; 
	  }

	  
	  @RequestMapping(value="/memberUpdate")
	  public String memberUpdate( MemberDTO mdto, 
			  HttpServletRequest request, 
			  HttpServletResponse response,
			  Model model) {
		  HttpSession session = request.getSession();
		  String id = (String) session.getAttribute("idKey");
		  mdto.setMem_id(id);
		  //service 호출
		   mdto = memberService.memberSelect(mdto);
		   // 받은 정보 저장하고 (모델)
		   model.addAttribute("mdto",mdto);
		  return "Update"; 
	  }
	  
	  @RequestMapping(value="/memberUpdateProc")
	  public String memberUpdateProc( MemberDTO mdto, 
			  HttpServletRequest request, 
			  HttpServletResponse response,
			  Model model) {
		  //service 호출
		  // 받은 정보 DB저장
		  int r= memberService.memberUpdate(mdto);
		  //메시지 저장, 이동할 페이지 저장해서 
		   if(r>0) {model.addAttribute("msg", "회원정보수정완료");
		   }else {
			   model.addAttribute("msg", "회원정보수정실패");
		   }
		   model.addAttribute("url","/");
		  return "MsgPage"; 
	  } 
	  
}
