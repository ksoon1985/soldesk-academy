package model2.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDAO;
import board.BoardDTO;

public class UpdateProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest req, HttpServletResponse res) throws Throwable {
		// TODO Auto-generated method stub
		
		req.setCharacterEncoding("utf-8");
		
		//DAO에 대한 인스턴스 받아오기 	
		BoardDAO dao =BoardDAO.getInstance(); 
		//DAO에 해당 데이터 저장하는 로직을 만들고 
		// 그 로직을 사용한 후 다음페이지로 이동시킴
		 BoardDTO dto = new BoardDTO();
		 
	     dto.setNum(Integer.parseInt(req.getParameter("num")));
	     dto.setSubject(req.getParameter("subject"));
	     dto.setContent(req.getParameter("content"));
	     dto.setEmail(req.getParameter("email"));
	     dto.setPasswd(req.getParameter("passwd"));
	     dto.setAttachNm(req.getParameter("attachNm"));
		
		 dao.boardUpdate(dto);	
		
		return "/board2/updatePro.jsp";
	}

}
