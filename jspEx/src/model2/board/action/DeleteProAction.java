package model2.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDAO;
import board.BoardDTO;
import board.PageDTO;

public class DeleteProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest req, HttpServletResponse res) throws Throwable {
		// TODO Auto-generated method stub

		// 현재 페이지
		int currentPage = 0;
		if (req.getParameter("currentPage") == null)
			currentPage = 1;
		else
			currentPage = Integer.parseInt(req.getParameter("currentPage"));

		// 현재 페이지 블럭
		int currPageBlock = 0;
		if (req.getParameter("currPageBlock") == null)
			currPageBlock = 1;
		else
			currPageBlock = Integer.parseInt(req.getParameter("currPageBlock"));

		PageDTO pdto = new PageDTO();
		pdto.setCurrentPage(currentPage);
		pdto.setCurrPageBlock(currPageBlock);

		int num = Integer.parseInt(req.getParameter("num"));

		// DAO에 대한 인스턴스 받아오기
		BoardDAO dao = BoardDAO.getInstance();

		BoardDTO dto = dao.getArticle(num);

		dao.boardDelete(dto);	
		
		req.setAttribute("pdto", pdto);
		
		return "/board2/deletePro.jsp";
	}

}
