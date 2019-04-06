package com.service;

import com.pojo.PageInfo;

import java.io.IOException;

public interface PeopleService {
    //查询用户
    PageInfo show(int pageSize,int pageNumber) throws IOException;
}
