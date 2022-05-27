package com.example.dieuhuyphuc.controller;

import com.example.dieuhuyphuc.dao.UserDao;
import com.example.dieuhuyphuc.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeServlet", urlPatterns = "/Home")
public class HomeServlet extends HttpServlet {
    UserDao dao = new UserDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
    }
    protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
//        String msg = updateUser();
//        String msg = deleteUser();
        String msg = insertUser();
        request.setAttribute("users", getListUser());
        request.setAttribute("message",msg);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
    protected List<User> getListUser(){
        List<User>list=dao.getListUser(4);
        return list;
    }
    protected String updateUser(){
        User u = new User();
        u.setId(3);
        u.setName("NguyenQuangHuy");
        return dao.updateUser(u);
    }
    protected String insertUser() {
        User u = new User();
        u.setName("NguyenQuangHuy");
        u.setEmail("huy@gmail.com");
        u.setAddress("Ha Noi");
        u.setPhone(0123456);
        return dao.insertUser(u);
    }
    protected String deleteUser() {
        return dao.deleteUser(14);
    }
}