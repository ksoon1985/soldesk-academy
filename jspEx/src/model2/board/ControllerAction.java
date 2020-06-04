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
     
   //서블릿(Servlet)이 실행되기 전에 초기화 과정
   public void init(ServletConfig config) {
       //필요한 Action--비지니스로직이 있음 미리 올려놓고 시작
       //웹 메모리에 올리면서 서버가 실행
//      System.out.println(config);
	   
      String props = config.getInitParameter("configProperty");
//      String props = "Command.properties";
     
      Properties pr = new Properties();
      
      FileInputStream f = null;
      try {
         //파일로 오픈
         f = new FileInputStream(props);
         //그 파일은 특별히 프로퍼티스 임 (=을 기준으로 왼쪽은 키, 오른쪽은 값)
         pr.load(f);
         //프로퍼티를 읽어서
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
         String command = (String) key.next();
         String className = pr.getProperty(command);
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
      
   }
   
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