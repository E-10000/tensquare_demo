package com.tensquare.spit.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @description：每一个回复的楼层
 */
@Data
public class SpitPojo implements Serializable {
    private String _id;
    private String content;
    private Date publishtime;
    private String userid;
    private String nickname;
    private Integer visits;
    private Integer thumbup;
    private Integer share;
    private Integer comment;
    private String state;
    private String parentid;
    private List<SpitPojo> list;
}
