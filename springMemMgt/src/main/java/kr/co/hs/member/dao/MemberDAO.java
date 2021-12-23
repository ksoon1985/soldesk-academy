package kr.co.hs.member.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.hs.member.dto.MemberDTO;

@Repository(value="memberDAO")
public class MemberDAO {

	@Resource
	private SqlSession sqlsession;
	
	private String namespace="member.";
	
	public int joinMember(MemberDTO mdto) {
	  return sqlsession.insert(namespace+"joinMember",mdto);
   }

	public List<MemberDTO> memberList(MemberDTO mdto) {
		return sqlsession.selectList(namespace+"meberList", mdto);
	}

	public int allCount() {
		return sqlsession.selectOne(namespace+"allCount");
	}

	public int idCheck(String userid) {
		return sqlsession.selectOne(namespace+"idCheck",userid);
	}//

	public MemberDTO memInfo(MemberDTO mdto) {
		return sqlsession.selectOne(namespace+"meberList", mdto);
	}

	public void memDelete(MemberDTO mdto) {
		sqlsession.delete(namespace+"memDelete",mdto);
	}

	/*
	public  Map<String, Object> memberList(MemberDTO mdto) {
	     List<MemberDTO> list= sqlsession.selectList(namespace+"meberList", mdto);
	     int allCnt= sqlsession.selectOne(namespace+"allCont")
	      Map<String, Object> map =new HashMap<String, Object>();
	      map.put("list",list);
	      map.put("allCnt",allCnt);
		return map;
	}
    오직 select로만 이루진 경우
	*/
	
	
}
