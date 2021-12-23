package kr.co.sol.board.service;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.sol.board.dto.BoardVO;
import kr.co.sol.board.dto.PageVO;

public interface BoardWriteService {
	public PageVO writeArticle(PageVO pdto);
	public void writeProArticle(BoardVO bdto,
			MultipartHttpServletRequest mpRequest);
	public void updatePro(PageVO pdto, BoardVO bdto,
			MultipartHttpServletRequest mpRequest);
	public PageVO deletePro(PageVO pdto, int num);
	
}
