package model2.board;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model2.board.action.CommandAction;

/**
 * Servlet implementation class ControllerAction
 */

//@WebServlet("*.do")
public class ControllerAction extends HttpServlet {
   
   private static final long serialVersionUID = 1L;
   
   //명령과 클래스가 들어가있는 Map 선언 HashMap();
   private HashMap<String, Object> commandMap = new HashMap<String,Object>();
     
   /* 
     	서블릿(Servlet)이 실행되기 전에 초기화 과정(단 한번 만 실행)
   		ServletConfig는 서블릿당 하나가 생성되며 web.xml에서 우리가 필요에 따라 입력한 파라미터 값들을 담고 있음
   		ServletConfig 로 서블릿을 초기화 시키면 유지보수 성이 높아짐 
   */ 
   public void init(ServletConfig config) {
       //필요한 Action--비지니스로직이 있음 미리 올려놓고 시작
       //웹 메모리에 올리면서 서버가 실행
//      System.out.println(config);
	   
	  // web.xml에서 init-param param-name 이 configProperty인 값을 가져옴  
	  // configProperty 엔 C:/study/workspace/jspEx/src/model2/board/Command.properties이 들어있음 
      String props = config.getInitParameter("configProperty");
     
      /*
       		Properties 클래스
       		- Map 계열의 컬렉션 프레임워크와 비슷하게 동작
       		- Key = Value 형태로 된  파일이름.properties 파일 또는 xml 
       		- key 를 주면 value를 반환하는 기능을 가짐
       		- DB의 연결정보 등을 저장해두는 용도로 사용 
       */
      Properties pr = new Properties();
      
      FileInputStream f = null;
      try {
         //Command.properties 파일 연결 
         f = new FileInputStream(props);
         //그 파일은 특별히 프로퍼티스 임 (=을 기준으로 왼쪽은 키, 오른쪽은 값)
         
         pr.load(f);
         //스트림으로 열린 properties파일 객체(Command.properties)를 로드함 
         //키를 명령에 저장하고, value 있는것을 파일로 오픈해서 읽게 하기
         //해당되는 클래스는 공통에 메소드가 있어서 그걸 처리하는 명령
      }catch(IOException e) {
         e.printStackTrace();
      }finally {
         if(f!=null)
            try {
               f.close();
            } catch (IOException e) {
               e.printStackTrace();
            }
      }
      //프로퍼티를 읽어서
      Iterator<Object> key = pr.keySet().iterator();
      //키를 명령에 저장하고, value있는것을 파일로 오픈해서 읽게 하기
      //해당되는 클래스는 공통에 메소드가 있어서 그걸 처리하는 명령
      while(key.hasNext()) {
         String command = (String) key.next(); // 		/list.do , /writeForm.do ...
         String className = pr.getProperty(command); //  model2.board.action.ListAction
         try {
        	 
            Class commandClass = Class.forName(className);
            
            Object commandInstance = commandClass.newInstance();
            
            //해당 키와 인스턴스를 저장해서 Web상에서 불러서 사용할
            commandMap.put(command, commandInstance);
            
         } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }
      
   }//init
   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAction() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //response.getWriter().append("Served at: ").append(request.getContextPath());
      requestPro(request, response);
   }


   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
   
   private void requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //ListAction 등 모든 클래스를 실행 다형성을 이용해서
      
      String view = null;
      CommandAction com=null; //다형성을 하기위해
      
      try {
    	  
          String command = request.getRequestURI();
//          System.out.println(command);
//          System.out.println(request.getContextPath());
          
          if(command.indexOf(request.getContextPath())==0) {
             command = command.substring(request.getContextPath().length());
             System.out.println(command);
          }

          com = (CommandAction)commandMap.get(command);
          
          // forword view로
          // Action 들의 requestPro 호출 
          view = com.requestPro(request, response);
          
      } catch (Throwable e) {
         e.printStackTrace();
      }
      
      	 
          RequestDispatcher dispatcher = request.getRequestDispatcher(view);          
          dispatcher.forward(request, response);
          
   }

	/*
	  	private RequestDispatcher getRequestDispatcher(String view) { // TODO
	  	Auto-generated method stub return null; }
	 */

}