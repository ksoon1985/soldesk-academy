package kr.co.sol.board.service;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.sol.board.dto.BoardVO;
import kr.co.sol.board.dto.PageVO;

public interface BoardWriteService {
	
	public PageVO writeArticle(PageVO pvo); 
	
	public void writeProArticle(BoardVO bvo,MultipartHttpServletRequest mpRequest);
	
	public PageVO updatePro(PageVO pvo, BoardVO bvo,MultipartHttpServletRequest mpRequest);
	
	public PageVO deletePro(PageVO pvo, int num);
}
