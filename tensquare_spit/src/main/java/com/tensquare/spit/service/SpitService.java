package com.tensquare.spit.service;

import com.tensquare.spit.dao.SpitDao;
import com.tensquare.spit.pojo.Spit;
<<<<<<< HEAD
=======
import com.tensquare.spit.pojo.SpitPojo;
>>>>>>> ed90e21... v1.0.0
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.repository.query.ParameterOutOfBoundsException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import util.IdWorker;

<<<<<<< HEAD
=======
import java.util.ArrayList;
>>>>>>> ed90e21... v1.0.0
import java.util.Date;
import java.util.List;

@Service
public class SpitService {
    @Autowired
    private SpitDao spitDao;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Spit> findAll(){
        return spitDao.findAll();
    }

    public Spit findById(String id){
        return spitDao.findById(id).get();
    }

    public void add(Spit spit){
        spit.set_id(idWorker.nextId()+"");
        spit.setPublishtime(new Date());//发布时间
        spit.setVisits(0);//浏览量
        spit.setShare(0);//分享数量
        spit.setThumbup(0);//点赞数
        spit.setComment(0);//回复数
        spit.setState("1");//状态码
        //如果有父节点
        if (spit.getParentid()!=null&&"".equals(spit.getParentid())){
            //db.spit.update({"_id":xxx},{$inc:{comment:NumberInt(1)}})
            Query query = new Query();
            query.addCriteria(Criteria.where("_id").is(spit.getParentid()));
            Update update = new Update();
            update.inc("comment",1);
            mongoTemplate.updateFirst(query,update,"spit");
        }
        spitDao.save(spit);
    }

    public void update(Spit spit){
        spitDao.save(spit);
    }

    public void deleteById(String id){
        spitDao.deleteById(id);
    }

    public Page<Spit> findByParentid(String parentid,int page,int size){
        Pageable pageable = PageRequest.of(page, size);
        return spitDao.findByParentid(parentid,pageable);
    }

    public void updateThumbup(String id){
        //方式1,效率低
//        Spit spit = spitDao.findById(id).get();
//        spit.setThumbup(spit.getThumbup()+1);
//        spitDao.save(spit);
        //方式2，效率高
        //db.spit.update({"_id":xxx},{$inc:{thumbup:NumberInt(1)}})
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));//{"_id":"1"}
        Update update = new Update();
        update.inc("thumbup",1);//{$inc:{thumbup:NumberInt(1)}}
        mongoTemplate.updateFirst(query,update,"spit");//db.spit.update({"_id":"1"},{$inc:{thumbup:NumberInt(1)}})
    }

<<<<<<< HEAD
=======

    /**
     * 给一个吐槽的父节点，查看其子类
     * @param id 查询该ID下的评论
	 * @param spitPojoList 相当于全局变量
     * @return java.util.List<com.tensquare.spit.pojo.SpitPojo>
     */

    public List<SpitPojo> findChildren(String id ,List<SpitPojo> spitPojoList){
        //where parentid = id
        List<Spit> spitList = spitDao.findByParentid(id);
        //如果不是空的话，做准备工作就递归
        if (spitList!=null){
            //转化为给前端的json（spitpojo），并且给全局spitPojoList添加值
            for (int i = 0 ; i < spitList.size();i++){
                Spit tempSpit = spitList.get(i);
                SpitPojo tempSpitPojo = new SpitPojo();
                transformToPojo(tempSpit,tempSpitPojo);
                spitPojoList.add(tempSpitPojo);
            }
            //到这里，数据库不为空，深度遍历
            for (int j = 0; j < spitList.size();j++){
                //递归，id = 数据库中查询到的每一列的id，spitPojo也向下深入一层，如果没有就返回了，如果有，就会继续深入挖掘
                findChildren(spitList.get(j).get_id(),spitPojoList.get(j).getList());
            }
        }
        return spitPojoList;
    }

    //转换函数
    public void transformToPojo(Spit tempSpit,SpitPojo tempSpitPojo){
        //开始转换
        tempSpitPojo.set_id(tempSpit.get_id());
        tempSpitPojo.setContent(tempSpit.getContent());
        tempSpitPojo.setPublishtime(tempSpit.getPublishtime());
        tempSpitPojo.setUserid(tempSpit.getUserid());
        tempSpitPojo.setNickname(tempSpit.getNickname());
        tempSpitPojo.setVisits(tempSpit.getVisits());
        tempSpitPojo.setThumbup(tempSpit.getThumbup());
        tempSpitPojo.setShare(tempSpit.getShare());
        tempSpitPojo.setComment(tempSpit.getComment());
        tempSpitPojo.setState(tempSpit.getState());
        tempSpitPojo.setParentid(tempSpit.getParentid());
        tempSpitPojo.setList(new ArrayList<>());

    }


>>>>>>> ed90e21... v1.0.0
}
