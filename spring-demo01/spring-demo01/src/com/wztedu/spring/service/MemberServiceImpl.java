package com.wztedu.spring.service;


import com.wztedu.spring.dao.MemberDAOImpl;

/**
 * @author 小涛
 * @version 1.0
 * Service类
 */
public class MemberServiceImpl {

    private MemberDAOImpl memberDAO;

    public MemberServiceImpl() {

    }

    public MemberDAOImpl getMemberDAO() {
        return memberDAO;
    }

    public void setMemberDAO(MemberDAOImpl memberDAO) {
        this.memberDAO = memberDAO;
    }

    public void add() {
        System.out.println("MemberServiceImpl add() 被调用...");
        memberDAO.add();
    }
}
