package com.kh.team.cjh.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.team.cjh.dao.CjhCartDao;
import com.kh.team.domain.CjhCartVo;
import com.kh.team.domain.CjhPagingDto;
import com.kh.team.domain.CjhUserVo;
import com.kh.team.domain.LshBoardVo;

@Service
public class CjhCartServiceImpl implements CjhCartService {
	
	@Inject
	private CjhCartDao cartDao;
	
	//	장바구니 추가하기
	@Transactional
	@Override
	public void insertCart(String u_id, int[] countArr, String[] sizeArr, LshBoardVo boardVo) throws Exception {
		for (int i=0; i<countArr.length; i++) {
			int count = cartDao.checkCart(u_id, sizeArr[i], boardVo.getP_num());
			if (count > 0 ) {
				cartDao.updateDupCart(u_id, countArr[i], sizeArr[i], boardVo.getP_num());
			} else {
				cartDao.insertCart(u_id, countArr[i], sizeArr[i], boardVo);
			}
		}
	}

	//	장바구니 불러오기
	@Override
	public List<CjhCartVo> getCart(String u_id) throws Exception {
		List<CjhCartVo> list = cartDao.getCart(u_id);
		return list;
	}

	//	장바구니 삭제
	@Override
	public void deleteCart(String u_id, int c_num) throws Exception {
		cartDao.deleteCart(u_id, c_num);
	}
	
	//	선택된 장바구니 삭제
	@Override
	public void deleteCheckedCart(String u_id, String c_num) throws Exception {
		String[] c_nums = c_num.toString().split(",");
		for (int i=0; i<c_nums.length; i++) {
//			System.out.println("c_nums[i] : " + c_nums[i]);
		    cartDao.deleteCart(u_id, Integer.parseInt(c_nums[i]));
		}
	}

	//	장바구니 갱신
	@Override
	public void updateCart(String u_id, int p_count, int c_num) throws Exception {
		cartDao.updateCart(u_id, p_count, c_num);
	}

	//	주문하기 후 주문목록으로 변경
	@Override
	public void orderCartUpdate(String u_id) throws Exception {
		cartDao.orderCartUpdate(u_id);
	}
	
	//	상품 수량 감소
	@Override
	public void minusCount(int[] p_num, String[] p_size, int[] p_count) throws Exception {
		for (int i=0; i<p_num.length; i++) {
			cartDao.minusCount(p_num[i], p_size[i], p_count[i]);
			
			System.out.println(p_num[i]);
			System.out.println(p_size[i]);
			System.out.println(p_count[i]);
		}
	}

	//	주문목록 불러오기
	@Override
	public List<CjhCartVo> getOrder(String u_id, int p_status, CjhPagingDto pagingDto) throws Exception {
		return cartDao.getOrder(u_id, p_status, pagingDto);
	}

	//	장바구니 갯수 불러오기
	@Override
	public int getCountCart(String u_id) throws Exception {
		return cartDao.getCountCart(u_id);
	}

	//	주문목록 개수 구하기
	@Override
	public int getCountOrder(String u_id, int p_status) throws Exception {
		return cartDao.getCountOrder(u_id, p_status);
	}

	//	구매확정 버튼
	@Override
	public void comfirmOrder(int c_num) throws Exception {
		cartDao.comfirmOrder(c_num);
	}

	@Override
	public int getUserOrder(String u_id) throws Exception {
		return cartDao.getUserOrder(u_id);
	}

	@Override
	public int getPCount(int p_num, String p_size) throws Exception {
		return cartDao.getPCount(p_num, p_size);
	}

}
