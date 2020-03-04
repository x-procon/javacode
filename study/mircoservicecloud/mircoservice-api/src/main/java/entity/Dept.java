package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @ClassName Dept
 * @Description TODO
 * @Author Hazer
 * @Date 2020/1/13 11:56
 **/
@SuppressWarnings(value = "serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Dept implements Serializable {
    private Long deptNo;
    private String dname;
    private String dbSource;

}
