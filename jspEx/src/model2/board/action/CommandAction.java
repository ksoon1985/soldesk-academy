package model2.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandAction {
	// 반환 값이 jsp 페이지 호출... string
	public String requestPro(HttpServletRequest req , HttpServletResponse res)
		throws Throwable;
}
