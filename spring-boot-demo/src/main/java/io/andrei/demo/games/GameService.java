package io.andrei.demo.games;

import java.util.List;

public interface GameService<T,U> {
	List<T> play();
	List<T> play(U param);	
}