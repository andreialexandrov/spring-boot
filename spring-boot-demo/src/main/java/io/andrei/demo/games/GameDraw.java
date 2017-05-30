package io.andrei.demo.games;

import java.util.List;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

@ApiObject
public class GameDraw{
	@ApiObjectField(description = "Game Name")
	private String name;
	
	@ApiObjectField(description = "Game Result")
	private List<Integer> result;
	
	public GameDraw(){}
	
	public GameDraw(String name, List<Integer> result) {
		this.name = name;
		this.result = result;
	}
	
	public List<Integer> getResult() {
		return result;
	}
	public void setResult(List<Integer> result) {
		this.result = result;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
