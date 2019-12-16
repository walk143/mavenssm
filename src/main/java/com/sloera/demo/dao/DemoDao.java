package com.sloera.demo.dao;

import com.sloera.demo.bean.Demo;
import com.sloera.mng.core.ibatis.MapperBaseDao;
import org.springframework.stereotype.Repository;

@Repository("demoDao")
public class DemoDao extends MapperBaseDao<Demo> {
}
