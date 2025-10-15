package accesdades.ra2.ac1.accesdades_ra2_ac1.model.repository;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import accesdades.ra2.ac1.accesdades_ra2_ac1.model.Student;

@Repository
public class StudentRepository {

    @Autowired 
    JdbcTemplate jdbcTemplate;

    
    private static final class StudentRowMapper implements RowMapper<Student>{
        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            Student student = new Student();
            student.setId(rs.getLong("id"));
            student.setName(rs.getString("name"));
            student.setAge(rs.getInt("age"));
            return student;
        }
    }


    public List<Student> findAll() {
        String sql = "SELECT * FROM Students";
        return jdbcTemplate.query(sql, new StudentRowMapper());
    }

    public int save() {
        String sql = "INSERT INTO Students (name, age) VALUES (?, ?)";
        int numReg = jdbcTemplate.update(sql, "Khalid", 27);
        return numReg;     
    }

}
