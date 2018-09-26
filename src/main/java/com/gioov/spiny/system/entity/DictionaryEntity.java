package com.gioov.spiny.system.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author godcheese
 * @date 2018-02-22
 */
public class DictionaryEntity implements Serializable {

    private static final long serialVersionUID = -4000696333938261490L;

    /**
     * id
     */
    private Long id;

    /**
     * 字典键
     */
    private String key;

    /**
     * 字典键名
     */
    private String keyName;

    /**
     * 字典值名
     */
    private String valueName;

    /**
     * 字典值别名
     */
    private String valueSlug;

    /**
     * 字典值
     */
    private String value;

    /**
     * 是否可编辑
     */
    private Integer editable;

    /**
     * 字典分类 id
     */
    private Long dictionaryCategoryId;

    /**
     * 排序
     */
    private Long sort;

    /**
     * 备注
     */
    private String remark;

    /**
     * 更新时间
     */
    private Date gmtModified;

    /**
     * 创建时间
     */
    private Date gmtCreated;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName;
    }

    public String getValueSlug() {
        return valueSlug;
    }

    public void setValueSlug(String valueSlug) {
        this.valueSlug = valueSlug;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getEditable() {
        return editable;
    }

    public void setEditable(Integer editable) {
        this.editable = editable;
    }

    public Long getDictionaryCategoryId() {
        return dictionaryCategoryId;
    }

    public void setDictionaryCategoryId(Long dictionaryCategoryId) {
        this.dictionaryCategoryId = dictionaryCategoryId;
    }

    public Long getSort() {
        return sort;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

}
