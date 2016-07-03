package com.springapp.mvc.dao;

import com.springapp.mvc.db.DbConnection;
import com.springapp.mvc.db.entities.UserInfoEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by zyw on 2016/7/2.
 */
public class UserInfoDao {

    private Session session = null;
    private Transaction transaction = null;

    /**
     * 注册添加用户信息
     * @param userInfoEntity
     */
    public void addUserInfo(UserInfoEntity userInfoEntity){
        try {
            session = DbConnection.getSession();
            transaction = session.beginTransaction();
            session.save(userInfoEntity);
            transaction.commit();
        }catch (Exception e){
            System.out.println("add failure!");
            transaction.rollback();
        }finally {
            session.close();
        }
    }

    /**
     * 查用户名是否重复
     * @param username
     * @return
     */
    public boolean queryUserInfo(String username){
        try {
            session = DbConnection.getSession();
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(UserInfoEntity.class);
            List<UserInfoEntity> list = criteria.list();
            for (int i = 0;i<list.size();i++){
                if (list.get(i).getUsername().equals(username)){
                    return true;
                }
            }
        }catch (Exception e){
            System.out.println("query failure!");
            transaction.rollback();
        }finally {
            session.close();
        }
        return false;
    }

    /**
     * 登陆查找用户名密码
     * @param username
     * @param pwd
     * @return
     */
    public boolean queryUserInfo(String username,String pwd){
        try {
            session = DbConnection.getSession();
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(UserInfoEntity.class);
            List<UserInfoEntity> list = criteria.list();
            for (int i = 0;i<list.size();i++){
                if (list.get(i).getUsername().equals(username)&&list.get(i).getPwd().equals(pwd)){
                    return true;
                }
            }
        }catch (Exception e){
            System.out.println("query failure!");
            transaction.rollback();
        }finally {
            session.close();
        }
        return false;
    }
}
