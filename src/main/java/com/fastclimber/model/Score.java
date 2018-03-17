package com.fastclimber.model;

public class Score
{

	private Long id;
	private Long score;
	private String name;
	
	public Long getScore()
	{
		return score;
	}
	
	public void setScore(Long score)
	{
		this.score = score;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}
}
