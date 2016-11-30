package com.youxia.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("baseDao")
public class BaseDao {
	
	@Resource(name="sqlSession")
	private SqlSessionTemplate sqlSession;
	
	public boolean addObjectB(String statement, Object param){
		if(addObject(statement, param) > 0) 	return true;
		else 								return false;
	}
	
	public int addObject(String statement, Object param){
		return this.sqlSession.insert(statement, param);
	}
	
	public boolean updateB(String statement, Object param){
		if(update(statement, param) > 0) return true;
		else								 return false;
	}
	
	public int update(String statement, Object param){
		return this.sqlSession.update(statement, param);
	}
	
	public Object queryObject(String statement){
		return this.sqlSession.selectOne(statement);
	}
	
	public Object queryObject(String statement, Object param){
		return this.sqlSession.selectOne(statement, param);
	}
	
	public List<Object> queryList(String statement){
		return this.sqlSession.selectList(statement);
	}
	
	public List<Object> queryList(String statement, Object param){
		return this.sqlSession.selectList(statement, param);
	}
}
