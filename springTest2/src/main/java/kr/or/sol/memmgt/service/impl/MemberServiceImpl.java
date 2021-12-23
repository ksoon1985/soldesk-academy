package kr.or.sol.memmgt.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.sol.memmgt.dao.MemDAO;
import kr.or.sol.memmgt.dto.MemDTO;
import kr.or.sol.memmgt.dto.PageDTO;
import kr.or.sol.memmgt.service.MemberService;


@Service("MemberService")
public class MemberServiceImpl implements MemberService {

	@Autowired//DI
	MemDAO memberDao;
	
	// 회원가입
	@Override
	public int signUpMemberPro(MemDTO mdto) {
		// TODO Auto-generated method stub
		
		int checkNum = memberDao.idCheck(mdto);
		
		if(checkNum < 1)
		{
			return memberDao.signUpMember(mdto);
			
		}else 
		{
			return 0;
		}
		
	}
	
	//모든 회원정보 출력  , 모든회원숫자 
	@Override
	public Map<String,Object> memberList(MemDTO mdto, PageDTO pdto){
		
		int allCnt = memberDao.allCount();
		
		List<MemDTO> list = memberDao.memberList(mdto);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("list",list);
		map.put("allCnt", allCnt);
		
		return map;
	}
	
	//회원정보 출력
	@Override
	public MemDTO memberInfo(MemDTO mdto, PageDTO pdto) {
		
		MemDTO mem = memberDao.memberInfo(mdto);
		
		return mem;
	}
	
	@Override
	public int updatePro(MemDTO mdto)
	{
		return memberDao.updateMember(mdto);
	}
	
	@Override
	public int deletePro(MemDTO mdto)
	{
		return memberDao.deleteMember(mdto);
	}
	
	@Override
	public int idCheck2(String userId)
	{
		return memberDao.idCheck2(userId);
	}
}
