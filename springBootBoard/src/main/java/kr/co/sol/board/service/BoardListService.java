package kr.co.sol.board.service;

import java.util.List;
import java.util.Map;

import kr.co.sol.board.dto.BoardVO;
import kr.co.sol.board.dto.PageVO;

public interface BoardListService {
	public int getAllcount();
	public List<BoardVO> getArticles(PageVO pvo);
	public Map<String,Object> getArticles(BoardVO bvo2,PageVO pvo);
}
