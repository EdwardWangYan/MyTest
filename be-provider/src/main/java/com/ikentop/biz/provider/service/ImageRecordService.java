package com.ikentop.biz.provider.service;

import com.ikentop.biz.constant.OSSType;
import com.ikentop.biz.model.dto.ImageRecordInfo;
import com.ikentop.biz.model.entity.ImageRecord;
import com.ikentop.biz.provider.assembler.QiniuCallbackDto2ImageRecordAssembler;
import com.ikentop.biz.provider.dao.ImageRecordDao;
import com.ikentop.biz.provider.domain.oss.pojo.UploadResult;
import com.ikentop.biz.provider.model.dto.QiniuCallbackDto;
import com.ikentop.biz.provider.util.OSSUtils;
import com.ikentop.framework.core.util.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author tac
 * @since 15/11/2017
 */
@Service
public class ImageRecordService {
    @Autowired
    private ImageRecordDao dao;

    public ImageRecordDao getDao() {
        return dao;
    }

    @Autowired
    private QiniuCallbackDto2ImageRecordAssembler qiniuCallbackDto2ImageRecordAssembler;

    public UploadResult handlerQiniuCallback(QiniuCallbackDto body) {
        ImageRecord record = qiniuCallbackDto2ImageRecordAssembler.assemble(body);
        dao.insert(record);
        return assembleUploadResult(record, body);
    }

    private UploadResult assembleUploadResult(ImageRecord record, QiniuCallbackDto body) {
        UploadResult result = new UploadResult();
        result.setId(record.getId());
        result.setBucket(body.getBucket());
        result.setKey(body.getKey());
        result.setName(body.getName());
        result.setHash(body.getHash());
        result.setUrl(OSSUtils.buildUrl(record));
        result.setExt(record.getExtJson());
        result.setOssType(OSSType.QINIU.getCode());
        return result;
    }

    public ImageRecordInfo getImageRecordInfo(String orgLogoId) {
        ImageRecord imageRecord = getDao().selectByPrimaryKey(orgLogoId);
        return assembled(imageRecord, orgLogoId);
    }

    private ImageRecordInfo assembled(ImageRecord imageRecord, String orgLogoId) {
        ImageRecordInfo info = new ImageRecordInfo();
        if (null != imageRecord) {
            BeanUtils.copyProperties(imageRecord, info);
            info.setImageId(imageRecord.getId());
        }
        return info;
    }
}
