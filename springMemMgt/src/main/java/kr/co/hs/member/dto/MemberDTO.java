package kr.co.hs.member.dto;

public class MemberDTO {

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
	
	
	public int getRr() {
		return rr;
	}
	public void setRr(int rr) {
		this.rr = rr;
	}
	public String getMemid() {
		return memid;
	}
	public void setMemid(String memid) {
		this.memid = memid;
	}
	public int getMemseq() {
		return memseq;
	}
	public void setMemseq(int memseq) {
		this.memseq = memseq;
	}
	public String getMemname() {
		return memname;
	}
	public void setMemname(String memname) {
		this.memname = memname;
	}
	
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getMemtel() {
		return memtel;
	}
	public void setMemtel(String memtel) {
		this.memtel = memtel;
	}
	public String getMembirth() {
		return membirth;
	}
	public void setMembirth(String membirth) {
		this.membirth = membirth;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getMememail() {
		return mememail;
	}
	public void setMememail(String mememail) {
		this.mememail = mememail;
	}
	public char getMemgender() {
		return memgender;
	}
	public void setMemgender(char memgender) {
		this.memgender = memgender;
	}
	
	
}
