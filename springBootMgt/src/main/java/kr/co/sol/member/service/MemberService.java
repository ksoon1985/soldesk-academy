package kr.co.sol.member.service;

import java.util.Map;

import kr.co.sol.member.dto.MemberVO;
import kr.co.sol.member.dto.PageVO;

public interface MemberService {
   public int joinMember(MemberVO mdto, PageVO pdto);
   public Map<String, Object> memberList(MemberVO mdto, PageVO pdto);
   public int idCheck(String userid);//
   public MemberVO memInfo(MemberVO mdto);
   public void memDelete(MemberVO mdto);
}
