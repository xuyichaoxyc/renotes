package com.xyc.jpa.springbootjpa.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * spring data jpa 实体类必须使用 @Entity 来进行注解
 */
@Entity
public class User implements Serializable {
    /**
     * @Id：声明了一个属性将映射到数据库主键字段，主键生成策略由注解 @GeneratedValue 来指定
     * @GeneratedValue：指定主键生成策略，
     * GenerationType.IDENTITY 自增主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    /**
     * @Column：表明属性对应到数据库的一个字段，且列名为 name 指定的名称
     */
    @Column
    private String name ;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "department_id")
    private Integer departmentId;

    public User() {
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
