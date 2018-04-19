package com.ikentop.biz.provider.dao;

import com.ikentop.biz.model.entity.Area;
import com.ikentop.biz.provider.constant.AreaLevel;
import com.ikentop.biz.provider.mapper.AreaMapper;
import com.ikentop.biz.provider.model.dto.Area4ListInfo;
import com.ikentop.biz.provider.model.dto.AreaDetailInfo;
import com.ikentop.biz.provider.model.dto.SearchForAreaDto;
import com.ikentop.framework.dao.GenericDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author : Huqiao
 * @since : 2017/10/20
 */
@Repository
public class AreaDao extends GenericDaoSupport<Area, String> {
    private AreaMapper mapper;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    public AreaDao(AreaMapper mapper) {
        super(mapper, Area.class);
        this.mapper = mapper;
    }

    public List<Area> list4tree() {
        Example example = new Example(Area.class);
        example.or().andEqualTo("areaLevel", AreaLevel.LEVEL_ONE.val);
        example.or().andEqualTo("areaLevel", AreaLevel.LEVEL_TWO.val);
        example.or().andEqualTo("areaLevel", AreaLevel.LEVEL_THREE.val);
        return this.selectByExample(example);
    }

    public List<Area4ListInfo> listChildrenAreaByCondition(SearchForAreaDto searchForAreaDto) {
        return mapper.listChildrenAreaByCondition(searchForAreaDto);
    }

    public AreaDetailInfo getDetail(String id) {
        return mapper.getDetail(id);
    }

    public List<Area> listCityByInitials(List<String> initials) {
        return mapper.listCityByInitials(initials);
    }
}
