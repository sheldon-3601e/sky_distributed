package com.sky.mapper;

import com.github.pagehelper.Page;
//import com.sky.annotation.AutoFill;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface EmployeeMapper {

    /**
     * 根据用户名查询员工
     * @param username
     * @return
     */
    @Select("select * from sky_take_out.employee where username = #{username}")
    Employee getByUsername(String username);

    @Insert("insert into sky_take_out.employee" +
            "(name, username, password, phone, sex, id_number, status, create_time, update_time, create_user, update_user)" +
            "values " +
            "(#{name}, #{username}, #{password}, #{phone}, #{sex}, #{idNumber}, #{status}, #{createTime}, #{updateTime}, #{createUser}, #{updateUser})")
    // TODO @AutoFill(value = OperationType.INSERT)
    void insert(Employee employee);

    /**
     * 分页查询
     * @param pageQueryDTO
     * @return
     */
    Page<Employee> pageQuery(EmployeePageQueryDTO pageQueryDTO);


    /**
     * 根据主键动态修改员工信息
     * @param employee
     */
    // TODO @AutoFill(value = OperationType.UPDATE)
    void update(Employee employee);

    @Select("select * from sky_take_out.employee where id = #{id}")
    Employee selectEmployeeById(Long id);
}
