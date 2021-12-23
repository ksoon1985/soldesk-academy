package kr.or.sol.memmgt.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.or.sol.memmgt.dto.MemDTO;

@Repository(value="memberDao")
public class MemDAO {
	// database 연결 위해 DI 필요
	
	@Resource 
	private SqlSession sqlsession; // connection pool의 커넥션 정보 
	
	private String namespace = "model2.memmgt."; // boardMapper 의 mapping namespace 
	
	public int signUpMember(MemDTO mdto)
	{
		return sqlsession.insert(namespace+"signUpMember",mdto);
	}
	
	public int idCheck(MemDTO mdto)
	{
		return sqlsession.selectOne(namespace+"idCheck",mdto);
	}
	
	public int idCheck2(String userid)
	{
		return sqlsession.selectOne(namespace+"idCheck2",userid);
	}
	
	public List<MemDTO> memberList(MemDTO mdto)
	{
		/*
		 	<if test="start!=null and start !=0">
				where a.rr between #{start} and #{end}
			</if> 
		*/
		return sqlsession.selectList(namespace+"memList",mdto);
	}
	
	public MemDTO memberInfo(MemDTO mdto)
	{
		return sqlsession.selectOne(namespace+"memInfo",mdto);
	}
	
	public int allCount()
	{
		return sqlsession.selectOne(namespace+"allCount");
	}
	
	public int updateMember(MemDTO mdto)
	{	
		return sqlsession.update(namespace+"updateMember",mdto);
	}
	
	public int deleteMember(MemDTO mdto)
	{
		return sqlsession.delete(namespace+"deleteMember",mdto);
	}
}
