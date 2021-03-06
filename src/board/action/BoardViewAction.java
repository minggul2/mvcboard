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
		
		Cookie[] ar = request.getCookies();		//쿠키받아옴
		Cookie cookie = null;							//쿠키참조변수 만듬
		
		if(ar != null){							//받아온 쿠키가 있다면 (이미 누른 게시글을 다시 눌렀을경우)
			for(int i = 0; i < ar.length; i++){		//받아온 쿠키배열 for문
				//if(cookies[i].getValue().equals(seq+"") && cookies[i].getComment().equals(id)){	//하나하나 비교하다가 쿠키이름이 글번호seq 일경우
				//}
				if(ar[i].getName().equals(id+seq+"")){
					cookie = ar[i];					//쿠키 생성 방지
					System.out.println(cookie.getName());
					break;
				}
			}
		}
		
		if(cookie == null){								//받다온 쿠키가 없다면 (처음 조회할 경우)
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
