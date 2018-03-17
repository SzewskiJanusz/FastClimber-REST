package com.fastclimber.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.fastclimber.model.Score;
import com.fastclimber.service.ScoreService;

@RestController
@RequestMapping("/highscores")
public class ScoreController
{
	@Autowired
	private ScoreService scoreService;
	
	@RequestMapping(method = RequestMethod.GET)
	public Collection<Score> getAllStudentsToGame()
	{
        return scoreService.getScores();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Score getScoreById(@PathVariable("id") int id)
	{
		return scoreService.getScore(id);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void removeStudentById(@PathVariable("id") int id)
	{
		scoreService.deleteScore(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addScore(@RequestBody Score s)
	{
		scoreService.addScore(s);
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateScore(@RequestBody Score s)
	{
		scoreService.updateScore(s);
	}
}
