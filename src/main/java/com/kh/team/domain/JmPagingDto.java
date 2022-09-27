package com.kh.team.domain;

public class JmPagingDto {

	
	private int page = 1; //페이지 수
	private int perPage = 10;//한페이지 안에서 나오는 게시물 수 시작행
	private int startRow = 1;// 페이지 처음 번호//게시물수6		끝행
	private int endRow = 10;// 페이지 끝 번호//게시물수10
	private String searchType;
	private String keyword;
	private int totalCount;//게시물 갯수
	private int totalPage;// 총 페이지 수
	private int startPage;//시작페이지
	private int endPage; //끝페이지
	private final int PAGE_BLOAK =10;
	
	
	public void setPageInfo() {
		this.endRow = page*perPage;   //15 *10    150
		this.startRow = this.endRow - this.perPage+1;  //141
							
							//소수점 이하 올림(ceil) ceil(15/10)*10 =20
		this.endPage=(int)Math.ceil((double)page/PAGE_BLOAK)*PAGE_BLOAK;
		this.startPage = this.endPage -PAGE_BLOAK +1;   //11
		
		
	}


	public JmPagingDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getPage() {
		return page;
	}


	public void setPage(int page) {
		this.page = page;
	}


	public int getPerPage() {
		return perPage;
	}


	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}


	public int getStartRow() {
		return startRow;
	}


	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}


	public int getEndRow() {
		return endRow;
	}


	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}


	public String getSearchType() {
		return searchType;
	}


	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}


	public String getKeyword() {
		return keyword;
	}


	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}


	public int getTotalCount() {
		return totalCount;
	}


	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		
		//총 페이지								ceil(152/10) = 16
		this.totalPage=(int)Math.ceil((double)totalCount/perPage);
		
		if(endPage>totalPage) {
			endPage=totalPage;
		}
		
	}


	public int getTotalPage() {
		return totalPage;
	}


	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}


	public int getStartPage() {
		return startPage;
	}


	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}


	public int getEndPage() {
		return endPage;
	}


	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}


	public int getPAGE_BLOAK() {
		return PAGE_BLOAK;
	}


	@Override
	public String toString() {
		return "JmPagingDto [page=" + page + ", perPage=" + perPage + ", startRow=" + startRow + ", endRow=" + endRow
				+ ", searchType=" + searchType + ", keyword=" + keyword + ", totalCount=" + totalCount + ", totalPage="
				+ totalPage + ", startPage=" + startPage + ", endPage=" + endPage + ", PAGE_BLOAK=" + PAGE_BLOAK + "]";
	}
	
	
	
	
	
	
	
	
}
