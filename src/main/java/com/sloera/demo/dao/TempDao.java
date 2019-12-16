package com.sloera.demo.dao;

import com.sloera.demo.po.TempBean;
import com.sloera.mng.core.ibatis.MapperBaseDao;
import org.springframework.stereotype.Repository;

@Repository("tempDao")
public class TempDao extends MapperBaseDao<TempBean> {
}
