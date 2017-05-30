package io.andrei.demo.games;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class LotteryGame{
	private String name;
	private int minValue;
	private int maxValue;
	private int maxMegaValue;
	private int ballDrows;
	private int megaBallDrows;
	
	public LotteryGame(String name, int ballDrows, int maxValue, int maxMegaValue) {
		this.minValue = 1;
		this.megaBallDrows = 1;
		this.name = name;
		this.ballDrows = ballDrows;
		this.maxValue = maxValue;
		this.maxMegaValue = maxMegaValue;
	}
	
	public List<Integer> getRandomList(Integer min, Integer max, Integer size) {		
		Set<Integer> result = new HashSet<>();
		Random rnd = new Random();
		while(result.size() < size) {
			result.add(rnd.nextInt(max - min) + min);
		}
		List<Integer> list =  new ArrayList<Integer>(result);
		Collections.sort(list);
		return list;
	}
	
	public List<GameDraw> playLottery(Integer draws) {
		List<GameDraw> result = new ArrayList<>();
		for(int i=0;i<draws;i++) {
			List<Integer> game = getRandomList(minValue,maxValue,ballDrows);
			game.addAll(getRandomList(minValue,maxMegaValue,megaBallDrows));
			String draw = name + " - Draw " + (i+1);
			result.add(new GameDraw(draw,game));
		}
		return result;
	}
}
