package com.kh.team.kys.service;

import java.util.List;

import javax.inject.Inject;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.kh.team.domain.CjhCartVo;
import com.kh.team.domain.KysVisitCountVo;
import com.kh.team.kys.dao.VisitCountDao;

@Service
public class VisitCountServiceImpl implements VisitCountService {
	
	@Inject
	private VisitCountDao dao;
	
	@Override
	public void insertVisitor(KysVisitCountVo vo) throws Exception {
		dao.insertVisitor(vo);
		

	}
	@Override
	public int visitNow() throws Exception {
		return dao.visitNow();
		
	}
	@Override
	public int visitAll() throws Exception {
		return dao.visitAll();
		
	}
	@Override
	public JSONObject rodChart() throws Exception {
		List<KysVisitCountVo> items =dao.rodChart();
		//리턴할 json 객체
		JSONObject data = new JSONObject();
		//json 컬럼 객체
		JSONObject col1 = new JSONObject();
		JSONObject col2 = new JSONObject();
		
		//json 배열 객체 , 배열에 저장할대는 JSONArray(); 를 사용
		JSONArray title = new JSONArray();
		col1.put("label", "날짜");
		col1.put("type", "string");
		col2.put("label", "방문객");
		col2.put("type", "number");
		
		//테이블행에 컬럼 추가
		title.add(col1);
		title.add(col2);
		
		data.put("cols", title);
		JSONArray body = new JSONArray();
		for(KysVisitCountVo vo : items) {
			JSONObject time = new JSONObject();
			time.put("v", vo.getVisit_time());
			
			JSONObject todaycon = new JSONObject();
			todaycon.put("v", vo.getTodayCon());
			
			JSONArray row = new JSONArray();
			row.add(time);
			row.add(todaycon);
			
			JSONObject cell = new JSONObject();
			cell.put("c", row);
			body.add(cell);
		}
		data.put("rows", body);
		return data;
	}
	@Override
	public JSONObject salesList() throws Exception {
		List<KysVisitCountVo> items = dao.salesList();
		//리턴 객체
		JSONObject data = new JSONObject();
		//컬럼 객체
		JSONObject col1 = new JSONObject();
		JSONObject col2 = new JSONObject();
		
		
		JSONArray title  = new JSONArray();
		col1.put("label", "일 매출");
		col1.put("type", "string");
		
		col2.put("label", "판매금액");
		col2.put("type", "number");
		
		//테이블행에 컬럼 추가
		title.add(col1);
		title.add(col2);
		
		
		data.put("cols", title);
		JSONArray body = new JSONArray();
		for(KysVisitCountVo vo : items) {
			JSONObject m_price = new JSONObject();
			m_price.put("v", vo.getP_price());
			
			JSONObject m_date = new JSONObject();
			m_date.put("v", vo.getP_date());
			
			JSONObject color = new JSONObject();
			color.put("color", "#e5e4e2");
			
			JSONArray row = new JSONArray();
			
			row.add(m_date);
			row.add(m_price);
			row.add(color);
			JSONObject cell = new JSONObject();
			cell.put("c", row);
			body.add(cell);
		}
		data.put("rows", body);
		return data;
		
		
	}
	@Override
	public List<KysVisitCountVo> orderList() throws Exception {
		
		return dao.orderList();
	}
	@Override
	public void updateStatus(int p_status,int p_num,String u_id) throws Exception {

		dao.updateStatus(p_status,p_num,u_id);
		
	}

}
