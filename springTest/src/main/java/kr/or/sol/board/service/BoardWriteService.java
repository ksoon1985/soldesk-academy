package kr.or.sol.board.service;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.or.sol.board.dto.BoardDTO;
import kr.or.sol.board.dto.PageDTO;

public interface BoardWriteService {
	public PageDTO writeArticle(PageDTO pdto);
	public void writeProArticle(BoardDTO bdto,
			MultipartHttpServletRequest mpRequest);
	public PageDTO updatePro(PageDTO pdto, BoardDTO bdto,
			MultipartHttpServletRequest mpRequest);
	public PageDTO deletePro(PageDTO pdto, int num);
	
}
