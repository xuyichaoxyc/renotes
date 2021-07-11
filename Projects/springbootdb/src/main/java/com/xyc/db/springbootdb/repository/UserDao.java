package com.xyc.db.springbootdb.repository;

import com.xyc.db.springbootdb.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
public class UserDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    static class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setDepartmentId(resultSet.getInt("department_id"));

            return user;
        }
    }


    public int getUserCount() {
        return this.jdbcTemplate.queryForObject("select count(*) from user", Integer.class);
    }

    public int getUserCount2() {
        return this.jdbcTemplate.queryForObject("select count(*) from user where department_id = ?", Integer.class, 1);
    }

    public int getUserCount3(Long userId) {
        return this.jdbcTemplate.queryForObject("select count(*) from user where department_id = ?", Integer.class, userId);
    }


    public User getUser(Long userId) {
        String sql = "select * from user where id = ?";
        User user = jdbcTemplate.queryForObject(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setDepartmentId(resultSet.getInt("department_id"));

                return user;
            }
        }, userId);

        return user;
    }

    public List<User> getUserByDepartmentId(Long departmentId) {
        String sql = "select * from user w where department_id = ?";
        List<User> user = jdbcTemplate.query(sql, new UserRowMapper(), departmentId);

        return user;
    }

    public Map findUserById2(Integer userId) {
        String sql = "select * from user where id=?";
        Map map = jdbcTemplate.queryForMap(sql, userId);
        return map;
    }


    public void updateInfo(User user) {
        String sql = "update user set name=?, department_id=? where id=?";
        jdbcTemplate.update(sql, user.getName(), user.getDepartmentId(), user.getId());
    }

    public void updateInfoByNamedJdbc(User user) {
        String sql = "update user set name=:name, department_id=:departmentId where id = :id";
        SqlParameterSource source = new BeanPropertySqlParameterSource(user);
        namedParameterJdbcTemplate.update(sql, source);

    }

    public Integer insertUser(final User user) {
        final String sql = "insert into user (name, department_id ) values (?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, new String[] { "id" });
                ps.setString(1, user.getName());
                ps.setInt(2, user.getDepartmentId());
                return ps;
            }
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }

    public void insertUser2(final User user) {
        final String sql = "insert into user (name, department_id) values (?,?);";
        jdbcTemplate.update(sql, user.getName(), user.getDepartmentId());
        return;
    }

}
