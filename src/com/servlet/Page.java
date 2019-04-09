package com.servlet;

import com.pojo.PageInfo;
import com.service.PeopleService;
import com.service.impl.PeopleServiceImpl;
import sun.dc.pr.PRError;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintStream;

@WebServlet(name = "Page",urlPatterns = "/page")
public class Page extends HttpServlet {
    //获取业务层对象
    private PeopleService peopleService=new PeopleServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置初始值
        int pageSize=2;
        int pageNumber=1;
        //获取请求信息
        String pageSizestr=req.getParameter("pageSize");
        String pageNumberstr=req.getParameter("pageNumber");
        //处理请求信息
        if (pageNumberstr!=null&&!pageNumberstr.equals("")){
            pageNumber= Integer.parseInt(pageNumberstr);
        }

        if (pageSizestr!=null&&!pageSizestr.equals("")){
            pageSize= Integer.parseInt(pageSizestr);
        }
        //响应处理结果
        PageInfo pageInfo = peopleService.show(pageSize,pageNumber);
        req.setAttribute("pageInfo",pageInfo);
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
        return;
    }


}
