package com.kh.team.domain;

public class LshBoardDto {
	private String type = "PL";

	private int page = 1;
	private int perPage = 15;
	private int startRow = 1;
	private int endRow = 15;
	private int totalCount;
	private int totalPage;
	private int startPage;
	private int endPage;
	private final int PAGE_BOLOCK = 5;

	private String p_main;
	private String p_serve;

	public void setPageInfo() {
		this.endRow = page * perPage;
		this.startRow = this.endRow - this.perPage + 1;
		
		this.endPage = (int) Math.ceil((double)page / PAGE_BOLOCK) * 5;
		this.startPage = this.endPage - PAGE_BOLOCK + 1;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		
		this.totalPage = (int) Math.ceil((double)totalCount / perPage);
		
		if(endPage > totalPage) {
			endPage = totalPage;
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

	public String getP_main() {
		return p_main;
	}

	public void setP_main(String p_main) {
		this.p_main = p_main;
	}

	public String getP_serve() {
		return p_serve;
	}

	public void setP_serve(String p_serve) {
		this.p_serve = p_serve;
	}

	public int getPAGE_BOLOCK() {
		return PAGE_BOLOCK;
	}

	@Override
	public String toString() {
		return "LshBoardDto [type=" + type + ", page=" + page + ", perPage=" + perPage + ", startRow=" + startRow
				+ ", endRow=" + endRow + ", totalCount=" + totalCount + ", totalPage=" + totalPage + ", startPage="
				+ startPage + ", endPage=" + endPage + ", PAGE_BOLOCK=" + PAGE_BOLOCK + ", p_main=" + p_main
				+ ", p_serve=" + p_serve + "]";
	}

}
