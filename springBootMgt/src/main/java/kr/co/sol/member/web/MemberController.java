package kr.co.sol.member.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.sol.member.dto.MemberVO;
import kr.co.sol.member.dto.PageVO;
import kr.co.sol.member.service.MemberService;

@Controller
public class MemberController {

  private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
  @Autowired
  private MemberService memberService;
  
  @RequestMapping(value="memberForm.mg")
  public String memberForm(HttpServletRequest request,
			HttpServletResponse response) {
	  
	  return "member/memberForm";
  }
  
  @RequestMapping(value="/joinPro.mg")
  public String joinPro(HttpServletRequest request,
		  HttpServletResponse response, MemberVO mdto, 
		             PageVO pdto, Model model) {
	  int r= memberService.joinMember(mdto, pdto);
	  if(r>0) {
		 model.addAttribute("message", "회원가입이 성공하였습니다.");
	  }else {
		 model.addAttribute("message", "회원가입이 실패하였습니다.");
	  }
	  return "member/joinPro";
  }
  
  @RequestMapping(value="/memberList.mg")
  public String memberList(HttpServletRequest request,
		  HttpServletResponse response, MemberVO mdto, 
		  PageVO pdto, Model model) {
	    Map<String, Object> map 
	          = memberService.memberList(mdto, pdto);
	    List<MemberVO> list = (List<MemberVO>) map.get("list");
	    model.addAttribute("list", list );
	    model.addAttribute("allCnt", (int)map.get("allCnt"));
	  return "member/memberList";
  }
  
  @RequestMapping(value="memInfo.mg")
  public String memInfo(HttpServletRequest request,
		  HttpServletResponse response, MemberVO mdto, 
		  PageVO pdto, Model model) {
	  //service 호출
	   mdto= memberService.memInfo(mdto);
	  //받아온 결과를 model에 저장
	   model.addAttribute("mdto", mdto);
	  return "member/memberInfo";
  }
  
  @RequestMapping(value="memInfoUpdate.mg")
  public String memInfoUpdate(HttpServletRequest request,
		  HttpServletResponse response, MemberVO mdto, 
		  PageVO pdto, Model model) {
	  //service 호출
	  mdto= memberService.memInfo(mdto);
	  //받아온 결과를 model에 저장
	  model.addAttribute("mdto", mdto);
	  return "member/memInfoUpdate";
  }
  
  @RequestMapping(value="memberDelete.mg")
  public String memberDelete(HttpServletRequest request,
		  HttpServletResponse response, MemberVO mdto, 
		  PageVO pdto, Model model) {
	  //service 호출
	   memberService.memDelete(mdto);
	  return "redirect:member/memberList";
  }
  
	@RequestMapping(value="pwCheck.mg")
	public String idCheck() {
		return "member/pwCheck";
	}
  
  
  @RequestMapping(value = "/idcheck.mg")
  @ResponseBody
  public int idCheck(MemberVO mdto,
              HttpServletRequest request,
		  HttpServletResponse response) {
	 // System.out.println(mdto.getMemid());
	  int cnt = 0;
	  String id = mdto.getMemid();
	  if(mdto.getMemid()!=null) {
 	  cnt = memberService.idCheck(id);
	  }
	  return cnt;
  }


}
