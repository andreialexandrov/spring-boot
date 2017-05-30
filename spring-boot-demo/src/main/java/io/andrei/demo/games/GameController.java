package io.andrei.demo.games;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiPathParam;
import org.jsondoc.core.pojo.ApiVerb;

@Api(name = "Game Services", description = "Provides simple games")
@RestController
public class GameController {
	@Autowired
	private MegaBallGameService megaBallGameService;
	
	@Autowired
	private PowerBallGameService powerBallGameService;
	
	@Autowired
	private KnightGameService knightGameService;
	
	@ApiMethod(path = "/games", verb = ApiVerb.GET, description = "Default method, returns empty list")	
	@RequestMapping("/games")
	public List<GameDraw> tryGame() {
		return new ArrayList<GameDraw>();
	}

	@ApiMethod(path = "/games/megaball", verb = ApiVerb.GET, description = "Returns megaball draw simulation")	
	@RequestMapping("/games/megaball")
	public List<GameDraw> playMegaBallGame() {	
		return megaBallGameService.play();
	}
	
	@ApiMethod(path = "/games/megaball/{draws}", verb = ApiVerb.GET, 
	   description = "Returns megaball draw simulations for number of draws")	
	@RequestMapping("/games/megaball/{draws}")
	public List<GameDraw> playMegaBallGame(@ApiPathParam(name = "draws", description = "Number of draws") @PathVariable Integer draws) {	
		return megaBallGameService.play(draws);
	}
	
	@ApiMethod(path = "/games/powerball", verb = ApiVerb.GET, 
	   description = "Returns powerball draw simulation")	
	@RequestMapping("/games/powerball")
	public List<GameDraw> playPowerBallGame() {	
		return powerBallGameService.play();
	}
	
	@ApiMethod(path = "/games/powerball/{draws}", verb = ApiVerb.GET, 
	   description = "Returns powerball draw simulations for number of draws")	
	@RequestMapping("/games/powerball/{draws}")
	public List<GameDraw> playPowerBallGame(@ApiPathParam(name = "draws", description = "Number of draws") @PathVariable Integer draws) {	
		return powerBallGameService.play(draws);
	}
	
	@ApiMethod(path = "/games/knight", verb = ApiVerb.GET, 
	   description = "Returns Knight Tour Pazzle result for 8X8 board with top-left start position")	
	@RequestMapping("/games/knight")
	public List<GameDraw> playKniteGame() {	
		return knightGameService.play();
	}
	
	@ApiMethod(path = "/games/knight", verb = ApiVerb.GET, 
	   description = "Returns Knight Tour Pazzle result for board and start position given by params")	
	@RequestMapping("/games/knight/{params}")
	public List<GameDraw> playKnightGame(@ApiPathParam(name = "params", 
	   description = "Parameter of board like: 8,8,0,0 - for board 8X8 with 0X0 start position") @PathVariable String params) {	
		return knightGameService.play(params);
	}
}
