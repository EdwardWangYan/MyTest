package com.ikentop.biz.provider.mapper;

import com.ikentop.biz.model.entity.Department;
import com.ikentop.biz.provider.model.dto.DepartmentDetailInfo;
import com.ikentop.biz.provider.model.dto.DepartmentInfo;
import com.ikentop.biz.provider.model.dto.DepartmentListDto;
import com.ikentop.framework.dao.GenericMapperSupport;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Huqiao
 * @author tac
 * @since 2017/9/4
 */
@Mapper
public interface DepartmentMapper extends GenericMapperSupport<Department> {
    //todo:: test
    List<DepartmentInfo> list4Admin(DepartmentListDto dto);

    DepartmentDetailInfo getDetail(String id,String orgId);
}
