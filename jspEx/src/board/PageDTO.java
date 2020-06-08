package board;

public class PageDTO {
	int currentPage; 			// 현재 페이지 
	int linePerPage = 10; 		// 페이지당 게시글 수 
	int allCount; 				// 
	int allPage; 				// 전체 페이지 수 
	int pageBlock = 5;			//
	int currPageBlock;			//
	
	int startPage;				//
	int endPage;				//
	
	
	public int getCurrPageBlock() {
		return currPageBlock;
	}
	public void setCurrPageBlock(int currPageBlock) {
		this.currPageBlock = currPageBlock;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getLinePerPage() {
		return linePerPage;
	}
	public void setLinePerPage(int linePerPage) {
		this.linePerPage = linePerPage;
	}
	public int getAllCount() {
		return allCount;
	}
	public void setAllCount(int allCount) {
		this.allCount = allCount;
	}
	public int getAllPage() {
		return allPage;
	}
	public void setAllPage(int allPage) {
		this.allPage = allPage;
	}
	public int getPageBlock() {
		return pageBlock;
	}
	public void setPageBlock(int pageBlock) {
		this.pageBlock = pageBlock;
	}
}
