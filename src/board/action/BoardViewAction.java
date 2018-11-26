package board.action;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthSplitPaneUI;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.bean.CommentDTO;
import board.dao.BoardDAO;

public class BoardViewAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		String id = "admin";
		
		

		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		BoardDAO boardDAO = BoardDAO.getInstance();
		
		Cookie[] ar = request.getCookies();		//��Ű�޾ƿ�
		Cookie cookie = null;							//��Ű�������� ����
		
		if(ar != null){							//�޾ƿ� ��Ű�� �ִٸ� (�̹� ���� �Խñ��� �ٽ� ���������)
			for(int i = 0; i < ar.length; i++){		//�޾ƿ� ��Ű�迭 for��
				//if(cookies[i].getValue().equals(seq+"") && cookies[i].getComment().equals(id)){	//�ϳ��ϳ� ���ϴٰ� ��Ű�̸��� �۹�ȣseq �ϰ��
				//}
				if(ar[i].getName().equals(id+seq+"")){
					cookie = ar[i];					//��Ű ���� ����
					System.out.println(cookie.getName());
					break;
				}
			}
		}
		
		if(cookie == null){								//�޴ٿ� ��Ű�� ���ٸ� (ó�� ��ȸ�� ���)
			//cookie = new Cookie("hit", seq+"");			//
			cookie = new Cookie(id+seq+"", id);
			cookie.setMaxAge(60*60);
			response.addCookie(cookie);
			boardDAO.hitUpdate(seq);
		}
		
		BoardDTO boardDTO = boardDAO.boardView(seq);
		
		ArrayList<CommentDTO> comment_list = boardDAO.getCommentList(seq);
		
		request.setAttribute("boardDTO", boardDTO);
		request.setAttribute("pg", pg);
		request.setAttribute("id", id);
		request.setAttribute("comment_list", comment_list);
		
		return "/board/boardView.jsp";
	}

}
