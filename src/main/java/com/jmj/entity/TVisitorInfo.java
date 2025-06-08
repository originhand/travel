package com.jmj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 *
 * @TableName t_visitor_info
 */
@TableName(value ="t_visitor_info")
@Data
public class TVisitorInfo {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 访客姓名
     */
    private String visitorName;

    /**
     * 访客电话
     */
    private String visitorTelNumber;

    /**
     * 来访公司
     */
    private String company;

    /**
     * 到访人数 默认1人
     */
    private Integer nums;

    /**
     * 到访时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date visitorTime;

    /**
     * 被访人ID
     */
    private Integer empId;
    @TableField(exist = false)
    private String empTelNumber;

    /**
     *
     */
    private Integer reason;

    /**
     *
     */
    private Date createTime;

    /**
     *
     */
    private String createBy;

    /**
     *
     */
    private Date updateTime;

    /**
     *
     */
    private Integer updateBy;

    /**
     * 审核状态 3 待审核  1 通过  2拒绝
     */
    private Integer status;

    /**
     *
     */
    private String remark;

    /**
     *
     */
    private Integer deleted;
}