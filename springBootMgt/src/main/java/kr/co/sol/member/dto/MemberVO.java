package kr.co.sol.member.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberVO {

	private int rr   ;
	private String memid   ;
	private int  memseq    ;
	private String passwd  ;
	private String memname ;
	private String memtel  ;
	private String membirth;
	private String regdate ;
	private String mememail;
	private char memgender ;
	
}
