package board.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.dao.BoardDAO;

public class BoardWriteAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		
		String id = "admin";
		String name = "mvc";
		String email = "mvc@mvc.com";
		
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("name", name);
		map.put("email", email);
		map.put("subject", subject);
		map.put("content", content);
		
		BoardDAO boardDAO = BoardDAO.getInstance();
		int su = boardDAO.writeBoard(map);
		
		
		return "/board/boardWrite.jsp";
	}
	
}
