package model2.board.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import board.BoardDAO;
import board.BoardDTO;

public class ListAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest req, HttpServletResponse res) throws Throwable {
		// TODO Auto-generated method stub
		
		BoardDAO dao = BoardDAO.getInstance();
		// 게시글 리스트 갖고와서 저장 DAO  
		int sRow =1;
		int pageSize = 20;
		List<BoardDTO> list = dao.getArticles(sRow,pageSize);
		req.setAttribute("list",list); // 실제 리스트에 접근하기 위해 "list"속성 추가 
		
		return "/board2/boardList.jsp";
	}
	
	
}
