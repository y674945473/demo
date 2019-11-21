package com.demo.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.demo.entity.AuditVO;
import com.demo.entity.User;

@Component
public class UserDao {

	private static Logger Logger = LoggerFactory.getLogger(UserDao.class);
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public String getUser(String code){
		Map<String,Object> map = new HashMap<String, Object>();
		String sqlUser = "select u.name as name,u.position as position,a.auth as auth from USER u,permissions a where u.auth = a.id and code = ?";
		List<Map<String,Object>> UserML = jdbcTemplate.queryForList(sqlUser,code);
		String auth = UserML.get(0).get("auth").toString();
		
		User user = new User();
		user.setName(UserML.get(0).get("name").toString());
		user.setPosition(UserML.get(0).get("position").toString());
		map.put("user", user);
		Logger.info("登录人员：" + user.toString());
		
		String sql = "select u.id,u.name,u.position from USER u,permissions a where u.auth = a.id and a.auth <= ?";
		List<Map<String,Object>> queryForList = jdbcTemplate.queryForList(sql,auth);
		map.put("person", queryForList);
		String json = JSON.toJSONString(map);
		return json;
	}
	
	
	public String getScore(String dateBegin,String dateEnd,String id){
		String sql = "select * from Audit where userId = ? and authDate >= ? and authDate <= ?";
		List<Map<String,Object>> queryForList = jdbcTemplate.queryForList(sql,id,dateBegin,dateEnd);
		List<Map<String,String>> scoreList = new ArrayList<Map<String,String>>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for (int i = 0; i < queryForList.size(); i++) {
			Map<String,String> map = new HashMap<>();
			String score = "";
			String date = "";
			try {
				score = queryForList.get(i).get("score").toString();
				date = sdf.format((Date)queryForList.get(i).get("authDate"));
			} catch (Exception e) {
				// TODO: handle exception
			}
			map.put(date, score);
			scoreList.add(map);
		}
		Map<String,String> map = new HashMap<>();
		map.put(dateBegin, dateBegin);
		map.put(dateEnd, dateEnd);
		scoreList.add(map);
		String json = JSON.toJSONString(scoreList);
		return json;
	}
	
	public String getUserScore(String date,String id){
		String sql = "select score,selfScore,note from Audit where userId = ? and authDate = ?";
		List<Map<String,Object>> queryForList = jdbcTemplate.queryForList(sql);
		if (queryForList.size() > 0) {
			String json = JSON.toJSONString(queryForList);
			return json;
		}else{
			return "{}";
		}
	}
	
	
	public void insert(AuditVO auditVo){
		String sql = "select * from Audit where authDate = ? and userId = ?";
		List<Map<String,Object>> queryForList = jdbcTemplate.queryForList(sql,auditVo.getAuthDate(),auditVo.getId());
		if (queryForList.size()==0) {
			String sqlIN = "insert into Audit(id,userId,selfScore,auditId,score,authDate,note,addDate) values(?,?,?,?,?,?,?,?)";
			jdbcTemplate.update(sqlIN,UUID.randomUUID(),auditVo.getUserId(),auditVo.getSelfScore(),auditVo.getAuditId(),
					auditVo.getScore(),auditVo.getAuthDate(),auditVo.getNote(),new Date());
		}
	}
	
	public void updateSelf(AuditVO auditVo){
		String sql = "select * from Audit where authDate = ? and userId = ?";
		List<Map<String,Object>> queryForList = jdbcTemplate.queryForList(sql,auditVo.getAuthDate(),auditVo.getId());
		String id = queryForList.get(0).get("id").toString();
		String sqlUp = "update Audit set selfScore = ? where id = ?";
		jdbcTemplate.update(sqlUp,auditVo.getSelfScore(),id);
	}
	
	public void updateAudit(AuditVO auditVo){
		String sql = "select * from Audit where authDate = ? and userId = ?";
		List<Map<String,Object>> queryForList = jdbcTemplate.queryForList(sql,auditVo.getAuthDate(),auditVo.getId());
		String id = queryForList.get(0).get("id").toString();
		String sqlUp = "update Audit set score = ?,note = ?,auditId = ? where id = ?";
		jdbcTemplate.update(sqlUp,auditVo.getScore(),auditVo.getNote(),auditVo.getAuditId(),id);
	}
	
	
}
