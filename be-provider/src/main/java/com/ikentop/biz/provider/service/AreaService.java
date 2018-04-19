package com.ikentop.biz.provider.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ikentop.biz.model.entity.Area;
import com.ikentop.biz.provider.dao.AreaDao;
import com.ikentop.biz.provider.exception.AreaIsNotExistException;
import com.ikentop.biz.provider.model.dto.*;
import com.ikentop.framework.core.pojo.DataTableResponse;
import com.ikentop.framework.service.GenericServiceSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author : Huqiao
 * @since : 2017/10/20
 */
@Service
@Transactional
public class AreaService extends GenericServiceSupport<AreaDao> {
    @Autowired
    public AreaService(AreaDao areaDao) {
        super(areaDao);
    }

    /**
     * 为左边的树形查询三级信息
     */
    public List<Area4TreeInfo> list4tree() {
        List<Area> areas = getDao().list4tree();
        return assemble(areas, Area4TreeInfo.class);
    }

    /**
     * 根据条件查询地区信息
     */
    public DataTableResponse<Area4ListInfo> listChildrenAreaByCondition(SearchForAreaDto searchForAreaDto) {
        PageHelper.startPage(searchForAreaDto.getIndex(), searchForAreaDto.getSize());
        List<Area4ListInfo> list = getDao().listChildrenAreaByCondition(searchForAreaDto);
        return DataTableResponse.fromPageInfo(new PageInfo<>(list));
    }

    public AreaDetailInfo getDetail(String id) {
        return getDao().getDetail(id);
    }

    public Integer update(AreaUpdateDto dto) {
        verifyAreaId(dto.getId());
        Area area = assemble(dto, Area.class);
        return getDao().updateByPrimaryKeySelective(area);
    }

    private void verifyAreaId(String id) {
        Area area = new Area();
        area.setPk(id);
        if (getDao().selectCount(area) == 0)
            throw new AreaIsNotExistException();
    }
}
