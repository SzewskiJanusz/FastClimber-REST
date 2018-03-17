package com.fastclimber.service;

import java.util.Collection;
import com.fastclimber.model.Score;

public interface ScoreService 
{
   void addScore(Score score);
   Score getScore(long id);
   Collection<Score> getScores();
   void updateScore(Score score);
   void deleteScore(long id);
}