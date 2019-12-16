package com.sloera.demo.service;

import com.sloera.demo.bean.Demo;
import com.sloera.demo.bean.Form;
import com.sloera.demo.dao.DemoDao;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by myzha on 2019/7/3.
 */
@Service("demoService")
@Transactional( rollbackFor = {Exception.class, RuntimeException.class})
public class DemoService {
    private static Logger logger = Logger.getLogger(DemoService.class);
    //@Autowired
    //private DemoMapper demoMapper;
    //
    //public List<Form> getAll(){
    //    return demoMapper.getAll();
    //}
    //public Form getByNumber(String number){
    //    return  demoMapper.getByNumber(number);
    //}
    //public int add(Form form){
    //    System.out.println("This is /add/DemoService/add");
    //    return demoMapper.add(form);
    //}
    //public int delete(Form form){
    //    return demoMapper.delete(form);
    //}
    //public int delete2(String number){
    //    return demoMapper.delete2(number);
    //}
    //public int update(Form form){
    //    return demoMapper.update(form);
    //}
    @Autowired
    private DemoDao demoDao;

    public void save(Demo demo)  throws Exception{
        this.demoDao.save("com.inspur.person.insertTest", demo);//保存
    }
    public void update(Demo demo)throws Exception {
        this.demoDao.update("com.inspur.person.updatePerson", demo);//编辑
    }
    //public PersonBean findById(String seqId) {
    //    List<PersonBean> list=personDao.selectList("com.inspur.person.getPerson",seqId);
    //    if(null!=list && list.size()>0){
    //        return list.get(0);
    //    }
    //    return new PersonBean();
    //}
    //public List<PersonBean> isExit(String identityType,String idcardNo) {
    //    Map<String, Object> paramMap=new HashMap<String, Object>();
    //    paramMap.put("identityType", identityType);
    //    paramMap.put("idcardNo", idcardNo);
    //    paramMap.put("isUse", ApprovalConstant.APPROVAL_USEED);
    //    return this.personDao.selectList("com.inspur.person.isExit", paramMap);
    //}
}
