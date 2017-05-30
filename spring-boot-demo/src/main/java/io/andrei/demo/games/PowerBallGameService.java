package io.andrei.demo.games;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PowerBallGameService extends LotteryGame implements GameService<GameDraw,Integer>{	
	private static String name = "PowerBall";
	private static int maxValue = 69;
	private static int maxMegaValue = 26;
	private static int ballDrows = 5;
	
	public PowerBallGameService() {
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
