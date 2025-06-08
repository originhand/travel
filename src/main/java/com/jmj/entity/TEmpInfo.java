package com.jmj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 员工表
 * @TableName t_emp_info
 */
@TableName(value ="t_emp_info")
@Data
public class TEmpInfo implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 员工姓名
     */
    private String empName;

    /**
     * 员工工号
     */
    private String empNo;

    /**
     * 手机号
     */
    private String telNumber;

    /**
     * 性别 1男 0 女
     */
    private Integer gender;

    /**
     * 
     */
    private Date inductionTime;

    /**
     * 部门ID
     */
    private Integer deptId;

    /**
     * 岗位ID
     */
    private Integer jobId;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private Integer createBy;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 
     */
    private Integer updateBy;

    /**
     * 员工状态 1 正常  0 离职 2 待岗
     */
    private Integer status;

    /**
     * 删除标记  1已删除 0未删除
     */
    private Integer deleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TEmpInfo other = (TEmpInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getEmpName() == null ? other.getEmpName() == null : this.getEmpName().equals(other.getEmpName()))
            && (this.getEmpNo() == null ? other.getEmpNo() == null : this.getEmpNo().equals(other.getEmpNo()))
            && (this.getTelNumber() == null ? other.getTelNumber() == null : this.getTelNumber().equals(other.getTelNumber()))
            && (this.getGender() == null ? other.getGender() == null : this.getGender().equals(other.getGender()))
            && (this.getInductionTime() == null ? other.getInductionTime() == null : this.getInductionTime().equals(other.getInductionTime()))
            && (this.getDeptId() == null ? other.getDeptId() == null : this.getDeptId().equals(other.getDeptId()))
            && (this.getJobId() == null ? other.getJobId() == null : this.getJobId().equals(other.getJobId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getUpdateBy() == null ? other.getUpdateBy() == null : this.getUpdateBy().equals(other.getUpdateBy()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getDeleted() == null ? other.getDeleted() == null : this.getDeleted().equals(other.getDeleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getEmpName() == null) ? 0 : getEmpName().hashCode());
        result = prime * result + ((getEmpNo() == null) ? 0 : getEmpNo().hashCode());
        result = prime * result + ((getTelNumber() == null) ? 0 : getTelNumber().hashCode());
        result = prime * result + ((getGender() == null) ? 0 : getGender().hashCode());
        result = prime * result + ((getInductionTime() == null) ? 0 : getInductionTime().hashCode());
        result = prime * result + ((getDeptId() == null) ? 0 : getDeptId().hashCode());
        result = prime * result + ((getJobId() == null) ? 0 : getJobId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getUpdateBy() == null) ? 0 : getUpdateBy().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getDeleted() == null) ? 0 : getDeleted().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", empName=").append(empName);
        sb.append(", empNo=").append(empNo);
        sb.append(", telNumber=").append(telNumber);
        sb.append(", gender=").append(gender);
        sb.append(", inductionTime=").append(inductionTime);
        sb.append(", deptId=").append(deptId);
        sb.append(", jobId=").append(jobId);
        sb.append(", createTime=").append(createTime);
        sb.append(", createBy=").append(createBy);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", status=").append(status);
        sb.append(", deleted=").append(deleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}