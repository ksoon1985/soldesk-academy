package kr.co.hs.member.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.hs.member.dao.MemberDAO;
import kr.co.hs.member.dto.MemberDTO;
import kr.co.hs.member.dto.PageDTO;
import kr.co.hs.member.service.MemberService;
@Service(value="memberService")
public class MemberServiceImpl implements MemberService {
	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	@Autowired
	private MemberDAO memberDAO;
	@Override
	public int joinMember(MemberDTO mdto, PageDTO pdto) {
		return memberDAO.joinMember(mdto);
	}
	@Override
	public Map<String, Object> memberList(MemberDTO mdto, PageDTO pdto) {
		int allCnt = memberDAO.allCount();
		List<MemberDTO> list = memberDAO.memberList(mdto);
		Map<String, Object> map= new HashMap<String, Object>();
		map.put("list", list);
		map.put("allCnt", allCnt);
		return map;
	}
//	public List<Object> memberList(MemberDTO mdto, PageDTO pdto) {
//		int allCnt = memberDAO.allCount();
//		List<Object> list = memberDAO.memberList(mdto);
//		list.add(allCnt);
//		/*  Controller에서 꺼낼 때
//		 * List<MemberDTO> list= (MemberDTO)list.get(0) 
//		 * int allCnt = (int)list.get(1);
//		 */
//		return list;
//	}
	//메소드 2개 만들어서 Controller에서 2번 호출(allCount 호출, memberList 호출)
	@Override
	public int idCheck(String userid) {
		return memberDAO.idCheck(userid);
	}
	@Override
	public MemberDTO memInfo(MemberDTO mdto) {
		return memberDAO.memInfo(mdto);
	}
	@Override
	public void memDelete(MemberDTO mdto) {
	    memberDAO.memDelete(mdto);
	}

	
	
}
