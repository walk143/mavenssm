package com.sloera.springmvc.dao;

import com.sloera.mng.core.ibatis.MapperBaseDao;
import com.sloera.springmvc.bean.LoginBean;
import org.springframework.stereotype.Repository;

/**
 * Created by myzha on 2019/10/10.
 */
@Repository("loginDao")
public class LoginDao extends MapperBaseDao<LoginBean> {
}
