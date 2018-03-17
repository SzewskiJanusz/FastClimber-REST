package com.fastclimber.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fastclimber.dao.ScoreDao;
import com.fastclimber.model.Score;



@Service
public class ScoreServiceImp implements ScoreService 
{

   @Autowired
   private ScoreDao scoreDao;

   public void addScore(Score score) 
   {
      scoreDao.addScore(score);
   }

   public Score getScore(long id) {
    //  return scoreDao.getScore(id);
	   return null;
   }

   public Collection<Score> getScores() 
   {
       return scoreDao.getScores();
   }

   public void updateScore(Score score) {
	//   scoreDao.updateScore(score);
   }

   public void deleteScore(long id) 
   {
     //  scoreDao.deleteScore(id);
   }

}

