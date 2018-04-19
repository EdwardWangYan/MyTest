package com.ikentop.biz.provider.service.dev;

import com.ikentop.biz.model.entity.Department;
import com.ikentop.biz.provider.dao.DepartmentDao;
import com.ikentop.biz.provider.exception.RepeatedDepartmentCodeException;
import com.ikentop.biz.provider.model.dto.DepartmentCreateDto;
import com.ikentop.biz.provider.service.DepartmentService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * @author tac
 * @since 2017/9/11
 */
@Profile("ut")
@Service
public class DepartmentService4UT extends DepartmentService {
    public DepartmentService4UT(DepartmentDao departmentDao) {
        super(departmentDao);
    }

    @Override
    public String create(DepartmentCreateDto dto) {
        if(existCode(dto.getCode())){
            throw new RepeatedDepartmentCodeException();
        }

        Department o = assemble(dto, Department.class);
        getDao().insert(o);
        return o.getPk();
    }
}
