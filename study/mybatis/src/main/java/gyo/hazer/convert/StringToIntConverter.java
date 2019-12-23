package gyo.hazer.convert;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ProjectName: javacode
 * @Package: gyo.hazer.convert
 * @ClassName: StringToIntConverter
 * @Author: Hazer
 * @Description:
 * @Date: 2019/12/11 21:15
 * @Version: 1.0
 */
public class StringToIntConverter extends BaseTypeHandler<String> {

    // java - db
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, String s, JdbcType jdbcType) throws SQLException {
        if (s.equals("男")) {
            preparedStatement.setInt(i, 0);
        } else if (s.equals("女")) {
            preparedStatement.setInt(i, 1);
        }
    }

    @Override
    public String getNullableResult(ResultSet resultSet, String s) throws SQLException {
        int sex = resultSet.getInt(s);
        return sex == 0 ? "男" : "女";
    }

    @Override
    public String getNullableResult(ResultSet resultSet, int i) throws SQLException {
        int sex = resultSet.getInt(i);
        return sex == 0 ? "男" : "女";
    }

    @Override
    public String getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        int sex = callableStatement.getInt(i);
        return sex == 0 ? "男" : "女";
    }
}
