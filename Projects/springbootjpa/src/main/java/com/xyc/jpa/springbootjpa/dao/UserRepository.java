package com.xyc.jpa.springbootjpa.dao;

import com.xyc.jpa.springbootjpa.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    // 根据名字查询，且按照名字升序
    List<User> findByNameOrderById(String name);

    // 根据名字查询，且使用翻页查询
    List<User> findByName(String name, Pageable pageable);

    // 查询满足条件的前10个用户
    List<User> findFirst10ByName(String name, Sort sort);

    // 使用 And 联合查询
    List<User> findByNameAndDepartmentId(String name, Integer departmentId);

    // 使用 or 查询
    List<User> findDistinctByNameOrDepartmentId(String name, Integer departmentId);

    // 使用 like 查询
    List<User> findByNameLike(String name);

    @Query("select u from User u where u.name=?1 and u.department.id=?2")
    public User findUserByDepartment(String name,Integer departmentId);

    @Query(value="select * from user where name=?1 and department_id=?2",nativeQuery=true)
    public User nativeQuery(String name,Integer departmentId);

    @Query(value="select * from user where name=:name and department_id=:departmentId",nativeQuery=true)
    public User nativeQuery2(@Param("name")  String name, @Param("departmentId")  Integer departmentId);

    @Query(value="select department_id,count(1) total from user group by department_id",nativeQuery=true)
    public List<Object[]> queryUserCount();

    @Query(value="select id from user where department_id=?1",nativeQuery=true)
    public List<Integer> queryUserIds(Integer departmentId);

    @Query(value="select u from User u where u.department.id=?1")
    public Page<User> queryUsers(Integer departmentId, Pageable page);

}
