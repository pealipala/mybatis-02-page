package com.service.impl;

import com.pojo.PageInfo;
import com.pojo.People;
import com.service.PeopleService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PeopleServiceImpl implements PeopleService {
    @Override
    public PageInfo show(int pageSize, int pageNumber) throws IOException {
        //获取mybatis配置文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        //使用工厂设计模式
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //生产 SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建PageInfo对象
        PageInfo pageInfo=new PageInfo();
        //创建map
        Map<String,Object>  map=new HashMap<>();
        map.put("pageStart",pageSize*(pageNumber-1));
        map.put("pageSize",pageSize);
        //返回查询结果
        long count= sqlSession.selectOne("com.mapper.PeopleMapper.selCount");
        //给对象pageInfo传值
        pageInfo.setPageSize(pageSize);
        pageInfo.setPageNumber(pageNumber);
        pageInfo.setList(sqlSession.selectList("com.mapper.PeopleMapper.selAll", map));
        pageInfo.setTotal(count%pageSize==0?count/pageSize:count/pageSize+1);
        //返回pageInfo
        return pageInfo;
    }
}
