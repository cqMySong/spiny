package com.gioov.spiny.system.entity;

import java.io.Serializable;

/**
 * @author godcheese
 * @date 2018-02-22
 */
public class DepartmentEntity implements Serializable {

    private static final long serialVersionUID = -3783473775571278807L;

    /**
     * id
     */
    private Long id;

    /**
     * 部门名称
     */
    private String name;

    /**
     * 父部门 id
     */
    private Long parentId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

}
