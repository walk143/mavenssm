package com.sloera.mng.core.ibatis;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Map;

public class BaseReadDao<E> {
    static final Object[] object = new Object[0];
    @Autowired
    @Qualifier("slaveSqlSessionTemplate")
    public SqlSessionTemplate slaveSqlSessionTemplate;

    public BaseReadDao(){};

    private SqlSession getSession(SqlSessionTemplate var1, boolean var2) {
        return (SqlSession) (var1 == null ? this.slaveSqlSessionTemplate : var1.getSqlSessionFactory().openSession(ExecutorType.BATCH, var2));
//        return (SqlSession) (var1.getSqlSessionFactory().openSession(ExecutorType.BATCH, var2));
    }
    //未传入数据库链接
    public <E>List<E> selectList(String var1, Object var2){
        SqlSession var3 = this.getSession((SqlSessionTemplate)null, false);
        return var3.selectList(var1, var2);
    }
    public <E>List<E> selectList(SqlSessionTemplate var1, String var2, Object var3){
        SqlSession var4 = this.getSession((SqlSessionTemplate)var1, false);
        return var4.selectList(var2, var3);
    }
    public <E> List<E> selectList(String var1) {
        SqlSession var2 = this.getSession((SqlSessionTemplate)null, false);
        return var2.selectList(var1);
    }
    //只传入一个sql
    public <E> List<E> selectList(SqlSessionTemplate var1, String var2) {
        SqlSession var3 = this.getSession((SqlSessionTemplate)null, false);
        return var3.selectList(var2);
    }

    public <E> E selectOne(String var1) {
        SqlSession var2 = this.getSession((SqlSessionTemplate)null, false);
        return var2.selectOne(var1);
    }

    public <E> E selectOne(String var1, Object var2) {
        SqlSession var3 = this.getSession((SqlSessionTemplate)null, false);
        return var3.selectOne(var1, var2);
    }

    public <E> E selectOne(SqlSessionTemplate var1, String var2, Object var3) {
        SqlSession var4 = this.getSession(var1, false);
        return var4.selectOne(var2, var3);
    }

    public <E> E selectOne(SqlSessionTemplate var1, String var2) {
        SqlSession var3 = this.getSession(var1, false);
        return var3.selectOne(var2);
    }

    public Map<?, ?> selectMap(String var1, String var2) {
        SqlSession var3 = this.getSession((SqlSessionTemplate)null, false);
        return var3.selectMap(var1, var2);
    }

    public Map<?, ?> selectMap(SqlSessionTemplate var1, String var2, String var3) {
        SqlSession var4 = this.getSession((SqlSessionTemplate)null, false);
        return var4.selectMap(var2, var3);
    }

    public Map<?, ?> selectMap(String var1, Object var2, String var3) {
        SqlSession var4 = this.getSession((SqlSessionTemplate)null, false);
        return var4.selectMap(var1, var2, var3);
    }

    public Map<?, ?> selectMap(SqlSessionTemplate var1, String var2, Object var3, String var4) {
        SqlSession var5 = this.getSession(var1, false);
        return var5.selectMap(var2, var3, var4);
    }
    
}
