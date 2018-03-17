package com.fastclimber.dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Repository;

import java.sql.*;
import com.fastclimber.model.Score;


@Repository
public class ScoreDao
{
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/fastclimberdb";
    

	public void addScore(Score s)
	{
		Connection conn = null;
	    Statement stmt = null;
	   try{
	      Class.forName("com.mysql.jdbc.Driver");

	      conn = DriverManager.getConnection(DB_URL, "root", "");

	      stmt = conn.createStatement();
	      
	      String sql = "INSERT INTO Score (score,name) " +
	                   "VALUES ("+s.getScore()+", '"+s.getName()+"')";
	      
	      stmt.executeUpdate(sql);
	   }catch(SQLException se){
	      se.printStackTrace();
	   }catch(Exception e){
	      e.printStackTrace();
	   }finally{
	      try{
	         if(stmt!=null)
	            conn.close();
	      }catch(SQLException se){
	      }
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }
	   }
	}

//	public Score getScore(long id)
//	{
//		Session session= null;
//		Score score = null;
//		try 
//		{
//			session = sessionFactory.openSession();
//			session.beginTransaction();
//			
//			score = session.get(Score.class, id);
//			
//			session.getTransaction().commit();
//		} 
//		catch (Exception e) 
//		{
//			e.printStackTrace();
//		}
//		return score;
//	}

	public Collection<Score> getScores()
	{
	   	Connection conn = null;
	    Statement stmt = null;
	    List<Score> scores = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");

		    conn = DriverManager.getConnection(DB_URL, "root", "");

		    stmt = conn.createStatement();

		    String sql = "SELECT id, score, name FROM Score s ORDER BY s.score DESC LIMIT 100;";
		    ResultSet rs = stmt.executeQuery(sql);
		      
		    scores = new ArrayList<Score>();
		    while(rs.next())
		    {
		    	Score s = new Score();
		    	s.setId(rs.getLong("id"));
		    	s.setName(rs.getString("name"));
		    	s.setScore(rs.getLong("score"));
		    	scores.add(s);
		    }
		    rs.close();
		    conn.close();
		}
		catch(SQLException se)
		{
		    se.printStackTrace();
		}
		catch(Exception e)
		{
		    e.printStackTrace();
		}
	    return scores;
	}

//	public void updateScore(Score s)
//	{
//		Session session= null;
//		Score score = new Score();
//		try 
//		{
//			session = sessionFactory.openSession();
//			session.beginTransaction();
//			score.setId(s.getId());
//			score.setName(s.getName());
//			score.setScore(s.getScore());
//			session.update(score);
//			session.getTransaction().commit();
//		} 
//		catch (Exception e) 
//		{
//			e.printStackTrace();
//		}
//	}

//	public void deleteScore(long id)
//	{
//		Session session= null;
//		Score toDelete = new Score();
//		try 
//		{
//			session = sessionFactory.openSession();
//			session.beginTransaction();
//			toDelete = (Score)session.load(Score.class,id);
//		    session.delete(toDelete);
//			session.getTransaction().commit();
//		} 
//		catch (Exception e) 
//		{
//			e.printStackTrace();
//		}
//	}
}
