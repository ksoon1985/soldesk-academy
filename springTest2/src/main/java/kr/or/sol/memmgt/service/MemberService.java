package kr.or.sol.memmgt.service;

import java.util.Map;

import kr.or.sol.memmgt.dto.MemDTO;
import kr.or.sol.memmgt.dto.PageDTO;

public interface MemberService {
	public int signUpMemberPro(MemDTO mdto);
	public Map<String,Object> memberList(MemDTO mdto, PageDTO pdto);
	public MemDTO memberInfo(MemDTO mdto, PageDTO pdto);
	public int updatePro(MemDTO mdto);
	public int deletePro(MemDTO mdto);
	public int idCheck2(String userId);
}
