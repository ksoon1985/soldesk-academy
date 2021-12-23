package kr.co.hs.member.service;

import java.util.Map;

import kr.co.hs.member.dto.MemberDTO;
import kr.co.hs.member.dto.PageDTO;

public interface MemberService {
   public int joinMember(MemberDTO mdto, PageDTO pdto);
   public Map<String, Object> memberList(MemberDTO mdto, PageDTO pdto);
   public int idCheck(String userid);//
   public MemberDTO memInfo(MemberDTO mdto);
   public void memDelete(MemberDTO mdto);
}
