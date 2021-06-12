package kr.co.sol.admin.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProcutMgrController {

	 @RequestMapping("/productMgr")
	 public String productMgr() {
		return "admin/ProductMgr";
		 
	 }
	 
	 @RequestMapping("/productInsert")
	 public String productInsert() {
		 return "admin/ProductInsert";
	 }
}
