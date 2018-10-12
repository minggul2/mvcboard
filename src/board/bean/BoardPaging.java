package board.bean;

import lombok.Data;

@Data
public class BoardPaging {
	//����¡ ó�� ���� Ŭ����
	//������ ó���ϰ������ �� Ŭ���� new �ϸ��
	
	private int currentPage;	//����������
	private int pageBlock;		//[����][1][2][3][����]
	private int pageSize;		//1�������� 5����
	private int totalA;			//�ѱۼ�
	private StringBuffer pagingHTML;

	public void makePagingHTML() {
		pagingHTML = new StringBuffer();
		
		
		int totalP = (totalA+pageSize-1)/pageSize;	//�� ��������
		
		int startPage = (currentPage-1)/pageBlock*pageBlock+1;
		int endPage = startPage+pageBlock-1;
		if(endPage > totalP) endPage = totalP;
		
		if(startPage > pageBlock) {
			pagingHTML.append("[<a id = 'paging' href = 'boardList.do?pg="+(startPage-1)+"'>����</a>]");
		}
		
		for(int i = startPage; i <= endPage; i++) {
			if(currentPage == i) {
				pagingHTML.append("[<a id = 'currentPage' href = 'boardList.do?pg="+i+"'>"+i+"</a>]");
			}else {
				pagingHTML.append("[<a id = 'paging' href = 'boardList.do?pg="+i+"'>"+i+"</a>]");
			}
		}
		
		if(endPage < totalP) {
			pagingHTML.append("[<a id = 'paging' href = 'boardList.do?pg="+(endPage+1)+"'>����</a>]");
		}
		
		
		
		
	}
}

//		 [1][2][3][����]
//	[����][4][5][6][����]

//  pagingHTML �� ������ ��
