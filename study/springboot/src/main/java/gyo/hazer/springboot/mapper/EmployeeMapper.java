package gyo.hazer.springboot.mapper;

import gyo.hazer.springboot.entity.Employee;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * @ClassName: EmployeeMapper
 * @Author: Hazer
 * @Description:
 * @Date: 2020/1/2 10:45
 * @Version: 1.0
 */
@Repository
@Mapper
public interface EmployeeMapper {
    @Select("SELECT * FROM employee WHERE id = #{id}")
    Employee getEmpById(Integer id);

    @Insert("INSERT INTO employee (lastName,email,gender,d_id) VALUES (#{lastName},#{email},#{gender},#{dId})")
    void insertEmp(Employee employee);

    @Update("UPDATE employee SET lastName=#{lastName},email=#{email},gender=#{gender},d_id=#{dId} WHERE id=#{id}")
    void updateEmp(Employee employee);

    @Delete("DELETE from employee WHERE id=#{id}")
    void deleteEmp(Integer id);
}
