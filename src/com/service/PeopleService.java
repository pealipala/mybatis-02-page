package com.service;

import com.pojo.PageInfo;

import java.io.IOException;

public interface PeopleService {
    //返回分页数据
    PageInfo show(int pageSize,int pageNumber) throws IOException;
}
