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
	// ȸ������
	// - ȸ������ , idCheck �ؼ� ���� ���̵� �ȵŰ� �� ����(ajax)
	
	// ȸ�� ���̺� member �����ؼ� Ű�� ��ȣ(���ʴ�� ���ϴ� ��ȣ) , id �� ����Ű 
	// �̸�, ��ȭ��ȣ, ����, ������� , ������ 
	// ȸ������ , idcheck�ؼ� �������̵� �ȵǰ� �Ұ���
	// ȸ��Ż��
	// ȸ������ 
	// �����ڰ� ȸ������ - ȸ������Ʈ(������ ����)
	// ���߿� �޴�ȭ�� , �α����ϸ� -> ���� �����ϰ� �ڽ��� ���� Ȯ�� 
	
	private static final Logger logger = LoggerFactory.getLogger(MemberMgtController.class);
	
	@Autowired
	private MemberService memberService;
	
	// ȸ������ ��
	@RequestMapping(value = "/signUpForm.sp")
	public String signUpForm(HttpServletRequest request,
			HttpServletResponse response) {
		
		return "member/signUpForm";
	}
	
	// ȸ������ ó��
	@RequestMapping(value = "/signUpPro.sp")
	public String signUpFormPro(HttpServletRequest request,
			HttpServletResponse response , Model model,MemDTO mdto){
		
		int r = memberService.signUpMemberPro(mdto);
		if(r > 0)
		{
			model.addAttribute("message","ȸ�������� �����Ͽ����ϴ�. ");
			
		}else{
			model.addAttribute("message","ȸ�������� �����Ͽ����ϴ�. ");
			
		}
		
		return "member/signUpPro";
	}
	
	// ��ü ȸ�� �� 
	@RequestMapping(value = "/memberList.sp")
	public String memberList(HttpServletRequest request,
			HttpServletResponse response , Model model,MemDTO mdto,PageDTO pdto){
		
		Map<String,Object> map = memberService.memberList(mdto, pdto);
		
		//List<MemDTO> list = (List<MemDTO>)map.get("list");
		
		model.addAttribute("list", (List<MemDTO>)map.get("list"));
		model.addAttribute("allCnt",(int)map.get("allCnt"));
		
		return "member/memberList";
	}
	
	// ȸ�� ���� ����
	@RequestMapping(value = "/memberInfo.sp")
	public String memberForm(HttpServletRequest request,
			HttpServletResponse response , Model model,MemDTO mdto,PageDTO pdto) {
		
		MemDTO mdto2 = memberService.memberInfo(mdto,pdto);
		model.addAttribute("mdto", mdto2);
		
		return "member/memberInfo";
	}
	
	// ȸ�� ������Ʈ ��
	@RequestMapping(value = "/updateForm.sp")
	public String updateForm(HttpServletRequest request,
			HttpServletResponse response , Model model,MemDTO mdto,PageDTO pdto){
		
		MemDTO mdto2 = memberService.memberInfo(mdto,pdto);
		model.addAttribute("mdto", mdto2);
		
		return "member/updateForm";
	}
	
	// ȸ�� ������Ʈ ó��
	@RequestMapping(value = "/updatePro.sp")
	public String updatePro(HttpServletRequest request,
			HttpServletResponse response , Model model,MemDTO mdto){
		
		
		int r = memberService.updatePro(mdto);
		if(r > 0)
		{ 
			model.addAttribute("message","������ �����Ͽ����ϴ�. ");
			
		}else
		{
			model.addAttribute("message","������ �����Ͽ����ϴ�. ");
			
		}
		
		return "member/updatePro";
	}
	
	// ȸ�� ���� 
	@RequestMapping(value = "/deletePro.sp")
	public String deletePro(HttpServletRequest request,
			HttpServletResponse response , Model model,MemDTO mdto,PageDTO pdto){
		
		int r = memberService.deletePro(mdto);
		if(r > 0)
		{ 
			model.addAttribute("message","������ �����Ͽ����ϴ�. ");
			
		}else
		{
			model.addAttribute("message","������ �����Ͽ����ϴ�. ");
			
		}
		return "member/deletePro";
	}
	
	// ��й�ȣ üũ ��
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
