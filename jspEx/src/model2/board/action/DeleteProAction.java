package model2.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDAO;
import board.BoardDTO;

public class DeleteProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest req, HttpServletResponse res) throws Throwable {
		// TODO Auto-generated method stub

		int num = Integer.parseInt(req.getParameter("num"));
		
		//DAO에 대한 인스턴스 받아오기 	
		BoardDAO dao =BoardDAO.getInstance(); 

		BoardDTO dto = dao.getArticle(num);
		
		dao.boardDelete(dto);	
		
		return "/board2/deletePro.jsp";
	}

}
