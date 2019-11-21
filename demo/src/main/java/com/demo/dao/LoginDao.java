package com.demo.dao;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.demo.entity.Message;


@Component
public class LoginDao {

	private static Logger Logger = LoggerFactory.getLogger(LoginDao.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public String login(String code){
		String sqlS = "select * from USER where code = ?";
		List<Map<String,Object>> queryForList = jdbcTemplate.queryForList(sqlS,code);
		Message mes = new Message();
		if (queryForList.size() > 0 ) {
			mes.setStatus("successful");
			mes.setAuth(queryForList.get(0).get("auth").toString());
			String json = JSON.toJSONString(mes);
			Logger.info("登录成功！");
			return json;
		}else{
			mes.setStatus("failure");
			String json = JSON.toJSONString(mes);
			return json;
		}
	}
	
	
	public String getUser(String code,String invitationCode){
		String sql = "select * from USER where invitationCode = ?";
		List<Map<String,Object>> queryForList = jdbcTemplate.queryForList(sql,invitationCode);
		Message mes = new Message();
		if (queryForList.size()==0) {
			mes.setStatus("failure");
			String json = JSON.toJSONString(mes);
			return json;
		}else{
			String sqlU = "update USER set code = ? where invitationCode = ?";
			try {
				jdbcTemplate.update(sqlU,code,invitationCode);
			} catch (Exception e) {
				e.printStackTrace();
				Logger.info("首次登录失败");
				mes.setStatus("failure");
				String json = JSON.toJSONString(mes);
				return json;
			}
			mes.setStatus("successful");
			mes.setAuth(queryForList.get(0).get("auth").toString());
			String json = JSON.toJSONString(mes);
			return json;
		}
	}
}
