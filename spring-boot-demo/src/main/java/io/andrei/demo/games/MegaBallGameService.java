package io.andrei.demo.games;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MegaBallGameService extends LotteryGame implements GameService<GameDraw,Integer>{
	private static String name = "MegaBall";
	private static int maxValue = 75;
	private static int maxMegaValue = 15;
	private static int ballDrows = 5;
	
	public MegaBallGameService() {
		super(name,ballDrows,maxValue,maxMegaValue);
	}

	@Override
	public List<GameDraw> play(Integer draws) {
		return playLottery(draws);
	}
	
	@Override
	public List<GameDraw> play() {
		return playLottery(1);
	}
}

