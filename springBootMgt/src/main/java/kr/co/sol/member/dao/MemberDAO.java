package kr.co.sol.member.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.sol.member.dto.MemberVO;

@Mapper
public interface MemberDAO {
	
    public int joinMember(MemberVO mdto) ;
    public List<MemberVO> memberList(MemberVO mdto);
	public int allCount();
    public int idCheck(String userid);
//    public MemberVO memInfo(MemberVO mdto);
    public void memDelete(MemberVO mdto);
	
}
