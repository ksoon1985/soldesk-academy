package kr.co.sol.board.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.sol.board.dao.BoardDAO;
import kr.co.sol.board.dto.BoardVO;
import kr.co.sol.board.dto.PageVO;
import kr.co.sol.board.service.BoardWriteService;
import kr.co.sol.common.ServletUpload;

@Service
public class BoardWriteServiceImpl implements BoardWriteService {
	private static final Logger logger = LoggerFactory.getLogger(BoardWriteServiceImpl.class);
	
	@Autowired
	BoardDAO  boardDao;
	
	@Resource(name="fileUtils")
	private ServletUpload fileUtils;
	
	//writFrom에 해당, DAO 필요 없음
	@Override
	public PageVO writeArticle(PageVO pdto) {
		 if(pdto.getCurrentPage()==0) {
			 pdto.setCurrentPage(1); 
		   }
		 if(pdto.getCurrPageBlock()==0) {
			 pdto.setCurrPageBlock(1);
		   }
		return pdto;
	}
	//writPro에 해당, DAO 필요

	@Override
	public void writeProArticle(BoardVO bdto,
			MultipartHttpServletRequest mpRequest) {
//	  Map<String, Object> mutlDTO = 
//			   ServletUpload.uploadEx(req, res);
	       //DAO를 통해서 받은데이터저장하기
//		    dao.boardWrite((BoardVO)mutlDTO.get("dto"));
//		    req.setAttribute("pdto", 
//		    		(PageDTO)mutlDTO.get("pdto"));
		//number구하기 (새로운 num)
		//int number = boardDao.getNewNum();
		//num ==0--제목글
		//num이 0이 아니면 답글
		if(bdto.getNum()==0) {
			//bdto.setNum(number); 
			//bdto.setRef(number);
			bdto.setRe_level(1);
			bdto.setRe_step(1);
		}else {
			//bdto.setNum(number); 
			bdto.setRe_level(bdto.getRe_level()+1);
			bdto.setRe_step(bdto.getRe_step()+1);
		}
		Map<String, Object> fileMap = null;
		 try {
			  fileMap = fileUtils.parseInsertFileInfo(bdto, mpRequest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		 if(fileMap!=null)
		 {
			 bdto.setFileNo((int) fileMap.get("fileNo"));
			 bdto.setFileSize((long) fileMap.get("fileSize"));
			 bdto.setAttachNm((String) fileMap.get("stored_file_name"));
			 bdto.setOrgFileNm((String) fileMap.get("org_file_name"));
			 logger.info((String) fileMap.get("org_file_name"));
			 logger.info("fileno: "+bdto.getFileNo());
			 logger.info("fileSize: "+bdto.getFileSize());
			 logger.info("setAttachNm: "+bdto.getAttachNm());
		 }
		 boardDao.boardWrite(bdto);
	}

	@Override
	public void updatePro(PageVO pdto, BoardVO bdto, MultipartHttpServletRequest mpRequest) {
	 Map<String, Object> fileMap = null;
	 try {
		  fileMap = fileUtils.parseInsertFileInfo(bdto,  mpRequest);
	} catch (Exception e) {
		e.printStackTrace();
	}
	 if(fileMap!=null)
	 {    logger.info((String) fileMap.get("org_file_name"));
	      logger.info("fileno: "+bdto.getFileNo());
	      logger.info("fileSize: "+bdto.getFileSize());
	      logger.info("setAttachNm: "+bdto.getAttachNm());
		 bdto.setFileNo((int) fileMap.get("fileNo"));
		 bdto.setFileSize((long) fileMap.get("fileSize"));
		 bdto.setAttachNm((String) fileMap.get("stored_file_name"));
		 bdto.setOrgFileNm((String) fileMap.get("org_file_name"));
	 }
	 
	  boardDao.boardUpdate(bdto);
	}

	@Override
	public PageVO deletePro(PageVO pdto, int num) {
		if(pdto.getCurrentPage()==0) {
			 pdto.setCurrentPage(1); 
		   }
		 if(pdto.getCurrPageBlock()==0) {
			 pdto.setCurrPageBlock(1);
		   }	
		 logger.info("bard:"+pdto.getCurrentPage());
		 
		  boardDao.deleteArticle(num);
		  return pdto;
	}
	
	
	
}
