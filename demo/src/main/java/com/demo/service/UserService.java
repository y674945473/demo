package com.demo.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.UserDao;
import com.demo.entity.AuditVO;

@Service
public class UserService {
	private static Logger Logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserDao userDao;
	public String getScore(String date,int c,String id){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	Date parse = new Date();;
		try {
			parse = sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         Calendar cal = Calendar.getInstance();  
         cal.setTime(parse);
         String dateBegin = "";
         String dateEnd = "";
         if(c==0){
        	 int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
	         int count = dayWeek - 2;
	         if (count==-1) {
	        	 cal.set(Calendar.DAY_OF_MONTH,cal.get(Calendar.DAY_OF_MONTH)-6);
	        	 dateBegin = sdf.format(cal.getTime());
	        	 Logger.info("周开始："+sdf.format(cal.getTime()));
	        	 cal.set(Calendar.DAY_OF_MONTH,cal.get(Calendar.DAY_OF_MONTH)+6);
	        	 dateEnd = sdf.format(cal.getTime());
	        	 Logger.info("周结束："+sdf.format(cal.getTime()));
	         }else{
	        	 cal.set(Calendar.DAY_OF_MONTH,cal.get(Calendar.DAY_OF_MONTH)-count);
	        	 dateBegin = sdf.format(cal.getTime());
	        	 Logger.info("周开始："+sdf.format(cal.getTime()));
	        	 cal.set(Calendar.DAY_OF_MONTH,cal.get(Calendar.DAY_OF_MONTH)+6);
	        	 dateEnd = sdf.format(cal.getTime());
	        	 Logger.info("周结束："+sdf.format(cal.getTime()));
	         }
         }else{
        	 c = c * 7;
        	 int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
	         int count = dayWeek - 2;
        	 cal.set(Calendar.DAY_OF_MONTH,cal.get(Calendar.DAY_OF_MONTH)-count);
        	 cal.set(Calendar.DAY_OF_MONTH,cal.get(Calendar.DAY_OF_MONTH)+c);
        	 dateBegin = sdf.format(cal.getTime());
        	 Logger.info("周开始："+sdf.format(cal.getTime()));
        	 cal.set(Calendar.DAY_OF_MONTH,cal.get(Calendar.DAY_OF_MONTH)+6);
        	 dateEnd = sdf.format(cal.getTime());
        	 Logger.info("周结束："+sdf.format(cal.getTime()));
         }
         String score = userDao.getScore(dateBegin, dateEnd, id);
         return score;
	}
	
	public String getUserScore(String date,String id){
		String userScore = userDao.getUserScore(date, id);
		return userScore;
	}
	
	public String getUser(String code){
		String user = userDao.getUser(code);
		return user;
	}
	
	public void insert(AuditVO auditVo){
		userDao.insert(auditVo);
	}
	
	public void updateSelf(AuditVO auditVo){
		userDao.updateSelf(auditVo);
	}
	
	public void updateAudit(AuditVO auditVo){
		userDao.updateAudit(auditVo);
	}
}
