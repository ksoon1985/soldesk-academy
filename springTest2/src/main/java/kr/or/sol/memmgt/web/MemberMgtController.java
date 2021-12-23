package kr.or.sol.memmgt.web;

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

import kr.or.sol.memmgt.dto.MemDTO;
import kr.or.sol.memmgt.dto.PageDTO;
import kr.or.sol.memmgt.service.MemberService;

@Controller
public class MemberMgtController {
	// 회원관리
	// - 회원가입 , idCheck 해서 같은 아이디 안돼게 할 것임(ajax)
	
	// 회원 테이블 member 수정해서 키는 번호(차례대로 변하는 번호) , id 가 복합키 
	// 이름, 전화번호, 성별, 생년월일 , 가입일 
	// 회원가입 , idcheck해서 같은아이디 안되게 할것임
	// 회원탈퇴
	// 회원수정 
	// 관리자가 회원정보 - 회원리스트(페이지 나옴)
	// 나중에 메뉴화면 , 로그인하면 -> 세션 유지하고 자신의 정보 확인 
	
	private static final Logger logger = LoggerFactory.getLogger(MemberMgtController.class);
	
	@Autowired
	private MemberService memberService;
	
	// 회원가입 폼
	@RequestMapping(value = "/signUpForm.sp")
	public String signUpForm(HttpServletRequest request,
			HttpServletResponse response) {
		
		return "member/signUpForm";
	}
	
	// 회원가입 처리
	@RequestMapping(value = "/signUpPro.sp")
	public String signUpFormPro(HttpServletRequest request,
			HttpServletResponse response , Model model,MemDTO mdto){
		
		int r = memberService.signUpMemberPro(mdto);
		if(r > 0)
		{
			model.addAttribute("message","회원가입이 성공하였습니다. ");
			
		}else{
			model.addAttribute("message","회원가입이 실패하였습니다. ");
			
		}
		
		return "member/signUpPro";
	}
	
	// 전체 회원 폼 
	@RequestMapping(value = "/memberList.sp")
	public String memberList(HttpServletRequest request,
			HttpServletResponse response , Model model,MemDTO mdto,PageDTO pdto){
		
		Map<String,Object> map = memberService.memberList(mdto, pdto);
		
		//List<MemDTO> list = (List<MemDTO>)map.get("list");
		
		model.addAttribute("list", (List<MemDTO>)map.get("list"));
		model.addAttribute("allCnt",(int)map.get("allCnt"));
		
		return "member/memberList";
	}
	
	// 회원 정보 보기
	@RequestMapping(value = "/memberInfo.sp")
	public String memberForm(HttpServletRequest request,
			HttpServletResponse response , Model model,MemDTO mdto,PageDTO pdto) {
		
		MemDTO mdto2 = memberService.memberInfo(mdto,pdto);
		model.addAttribute("mdto", mdto2);
		
		return "member/memberInfo";
	}
	
	// 회원 업데이트 폼
	@RequestMapping(value = "/updateForm.sp")
	public String updateForm(HttpServletRequest request,
			HttpServletResponse response , Model model,MemDTO mdto,PageDTO pdto){
		
		MemDTO mdto2 = memberService.memberInfo(mdto,pdto);
		model.addAttribute("mdto", mdto2);
		
		return "member/updateForm";
	}
	
	// 회원 업데이트 처리
	@RequestMapping(value = "/updatePro.sp")
	public String updatePro(HttpServletRequest request,
			HttpServletResponse response , Model model,MemDTO mdto){
		
		
		int r = memberService.updatePro(mdto);
		if(r > 0)
		{ 
			model.addAttribute("message","수정이 성공하였습니다. ");
			
		}else
		{
			model.addAttribute("message","수정이 실패하였습니다. ");
			
		}
		
		return "member/updatePro";
	}
	
	// 회원 삭제 
	@RequestMapping(value = "/deletePro.sp")
	public String deletePro(HttpServletRequest request,
			HttpServletResponse response , Model model,MemDTO mdto,PageDTO pdto){
		
		int r = memberService.deletePro(mdto);
		if(r > 0)
		{ 
			model.addAttribute("message","삭제가 성공하였습니다. ");
			
		}else
		{
			model.addAttribute("message","삭제가 실패하였습니다. ");
			
		}
		return "member/deletePro";
	}
	
	// 비밀번호 체크 폼
	@RequestMapping(value = "/passwdCheck.sp")
	public String passwdCheck(HttpServletRequest request,
			HttpServletResponse response , Model model,MemDTO mdto,PageDTO pdto){
		
		
		return "member/passwdCheck";
	}
	
	/*
	@RequestMapping(value = "/idcheck.sp")
	@ResponseBody
	public int idCheck(HttpServletRequest request,
			HttpServletResponse response , Model model,MemDTO mdto){
		
		int cnt = 0;
		String id = mdto.getMemid();
		if(mdto.getMemid() != null) {
			cnt = memberService.idCheck2(id);
		}
		
		return cnt;
	}
	*/
}
