package tls.study.common.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import lombok.Data;
@Data
public class Paging {
	private int totalRecord;
	private int pageSize =10;
	private int blockSize = 10;
	private int totalPage;
	private int currentPage = 1;
	private int firstpage;
	private int lastpage;
	private int curPos;
	private int num;
	
	public void init(List list,HttpServletRequest request) {
		totalRecord = list.size();
		totalPage = (int)Math.ceil((double)totalRecord/pageSize);
		if(request.getParameter("currentPage") != null) {
			currentPage= Integer.parseInt(request.getParameter("currentPage"));
		}
		firstpage = currentPage - (currentPage - 1)%blockSize;
		lastpage = firstpage + blockSize -1;
		curPos = (currentPage-1) * 10;
		num = totalRecord - curPos;
	}
}
