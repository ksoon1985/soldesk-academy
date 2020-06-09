package model2.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import board.BoardDAO;
import board.BoardDTO;
import board.PageDTO;

public class WriteProAction implements CommandAction {

   @Override
   public String requestPro(HttpServletRequest req, HttpServletResponse res) throws Throwable {
      // 한글 확입얼을 위해 utf-8로 전환
      // req.setCharacterEncoding("UTF-8");
      
	  MultipartRequest multi = new MultipartRequest(req,"C:/study/upload",
				5*1024*1024,"utf-8" // 5mb
				,new DefaultFileRenamePolicy());
	   
	  // 현재 페이지
	  int currentPage = 0;
	  if(req.getParameter("currentPage") == null)
		  currentPage = 1;
	  else
		  currentPage = Integer.parseInt(req.getParameter("currentPage"));
				
	  // 현재 페이지 블럭 
	  int currPageBlock = 0;
	  if(req.getParameter("currPageBlock") == null)
		  currPageBlock = 1;
	  else
	  currPageBlock = Integer.parseInt(req.getParameter("currPageBlock"));
				
				
	  PageDTO pdto = new PageDTO();
	  pdto.setCurrentPage(currentPage);
	  pdto.setCurrPageBlock(currPageBlock);
	  
      // writeForm에서 보내준 데이터 모두 받기
      BoardDTO dto = new BoardDTO();
      
      //num, ref, re_step, re_level, readcnt(readcount) 이 있으면 받아야함
      //writer, subject, content, passwd, email, attachNm
      dto.setNum(Integer.parseInt(req.getParameter("num")));
      dto.setRef(Integer.parseInt(req.getParameter("ref")));
      dto.setRe_step(Integer.parseInt(req.getParameter("re_step")));
      dto.setRe_level(Integer.parseInt(req.getParameter("re_level")));
      dto.setWriter(req.getParameter("writer"));
      dto.setSubject(req.getParameter("subject"));
      dto.setContent(req.getParameter("content"));
      dto.setEmail(req.getParameter("email"));
      dto.setPasswd(req.getParameter("passwd"));

      
      if(req.getParameter("attachNm")!=null)
      {
    	  dto.setAttachNm(req.getParameter("attachNm"));
    	  String at = req.getParameter("attachNm");
    	  System.out.println(at);
      }
      else
      {
    	  dto.setAttachNm("");
      }
      
      //DAO를 통해서 받은 데이터 저장하기
         //DAO에 대한 인스턴스 받아오기
      BoardDAO dao = BoardDAO.getInstance();
      int r = dao.boardWrite(dto);
      req.setAttribute("pdto", pdto);
      
      return "/board2/writePro.jsp";
   }

}