package com.ikentop.biz.provider.dao;

import com.ikentop.biz.model.entity.ImageRecord;
import com.ikentop.biz.provider.mapper.ImageRecordMapper;
import com.ikentop.framework.core.util.IDUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author tac
 * @since 15/11/2017
 */
@Repository
public class ImageRecordDao {
    private ImageRecordMapper mapper;

    @Autowired
    public ImageRecordDao(ImageRecordMapper mapper) {
        this.mapper = mapper;
    }

    public int insert(ImageRecord entity) {
        if(StringUtils.isBlank(entity.getId())){
            entity.setId(IDUtils.UUID());
        }
        return mapper.insert(entity);
    }


    public ImageRecord selectByPrimaryKey(String id) {
        return mapper.selectByPrimaryKey(id);
    }
}
