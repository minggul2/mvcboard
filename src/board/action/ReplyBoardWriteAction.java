package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class ReplyBoardWriteAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//�Խ��� ����ް�
		
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		String id = "newAdmin"; //String id = request.getSession().getAttribute("memId");
		
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setContent(content);
		boardDTO.setSubject(subject);
		boardDTO.setRef(seq);
		
		
		//DB����
		
		BoardDAO.getInstance().replyBoardWirte(boardDTO);
		//����
		
		
		
		return "/board/replyBoardWrite.jsp";
	}

}
