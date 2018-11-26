package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.bean.CommentDTO;
import board.dao.BoardDAO;

public class CommentWriteAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		String id = "admin";//request.getParameter("id");
		String content = request.getParameter("content");
		
		CommentDTO commentDTO = new CommentDTO();
		commentDTO.setId(id);
		commentDTO.setContent(content);
		commentDTO.setRef(seq);
		
		BoardDAO.getInstance().writeComment(commentDTO);
		
		request.setAttribute("seq", seq);
		request.setAttribute("pg", pg);
		
		return "/board/commentWrite.jsp";
	}

}
