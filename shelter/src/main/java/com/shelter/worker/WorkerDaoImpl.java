package com.shelter.worker;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class WorkerDaoImpl implements WorkerDao {
	
	
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate  namedJdbcTemplate;
	
	public WorkerDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		namedJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public List<Worker> getWorkers() {
		String query = "SELECT * FROM Workers";
		 return jdbcTemplate.query(query, new RowMapper<Worker>() {

			@Override
			public Worker mapRow(ResultSet rs, int row) throws SQLException {
				Worker w = new Worker();
				w.setId(rs.getInt(1));
				w.setName(rs.getString(2));
				w.setLastName(rs.getString(3));
				w.setEmail(rs.getString(4));
				//w.setPassword(rs.getString(5));
				return w;
			}
			
		});
	}

	@Override
	public void addWorker(Worker worker) {
		MapSqlParameterSource msps = new MapSqlParameterSource();
		msps.addValue("firstName", worker.getName());
		msps.addValue("lastName", worker.getLastName());
		msps.addValue("email", worker.getEmail());
		msps.addValue("password", worker.getPassword());
		
		String sql = "INSERT INTO Shelter.Workers(firstName, lastName, email, password)"
				+ "VALUES (:firstName, :lastName, :email, :password)";
		
		namedJdbcTemplate.update(sql, msps);
		
		
	}

	@Override
	public List<String> getAllEmails() {
		String sql ="SELECT email FROM Workers";
		return jdbcTemplate.query(sql, new RowMapper<String>() {

			@Override
			public String mapRow(ResultSet rs, int row) throws SQLException {
				
				return rs.getString(1);
			}
			
		});
		 
	}

}
