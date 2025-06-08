package com.jmj.mapper;

import com.jmj.entity.TVisitorInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jmj.entity.vo.VisitorInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author 73848
* @description 针对表【t_visitor_info】的数据库操作Mapper
* @createDate 2025-03-13 17:53:09
* @Entity com.jmj.domain.TVisitorInfo
*/
@Mapper
public interface TVisitorInfoMapper extends BaseMapper<TVisitorInfo> {

    List<VisitorInfoVO> getListForEmpId(@Param("empId") Integer empId);
    
    /**
     * 获取指定员工的访客记录总数
     * @param empId 员工ID
     * @return 记录总数
     */
    int getCountForEmpId(@Param("empId") Integer empId);
    
    /**
     * 分页获取指定员工的访客记录
     * @param empId 员工ID
     * @param offset 偏移量
     * @param pageSize 每页大小
     * @return 访客记录列表
     */
    List<VisitorInfoVO> getListForEmpIdWithPage(
        @Param("empId") Integer empId, 
        @Param("offset") int offset, 
        @Param("pageSize") int pageSize
    );
}




