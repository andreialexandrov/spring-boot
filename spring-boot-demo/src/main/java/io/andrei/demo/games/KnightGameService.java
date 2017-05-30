package io.andrei.demo.games;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.springframework.stereotype.Service;

@Service
public class KnightGameService implements GameService<GameDraw,String>{
	private int width;
	private int high;
	private int knightX;
	private int knightY;
	private String name = "KnightGame";
	// Default board 8X8 with knite in top left position
	private int[] defaultBoard = new int[]{8,8,0,0};

	@Override
	public List<GameDraw> play(String params) {
		try{
			int[] val = parseParam(params);
			setBoard(val);
		} catch (NumberFormatException e) {
			// write to log 
		}
		return playGame();
	}
	
	@Override
	public List<GameDraw> play() {
		setBoard(defaultBoard);
		return playGame();
	}
	
	private List<GameDraw> playGame() {
		int rowcnt = 1;
		String draw = name + " Fails - Board line ";
		List<GameDraw> result = new ArrayList<>();
        Board board = new Board(high,width);
        Knight knight = new Knight(board,new Point(knightX,knightY));
        knight.play();
        if(knight.isCompleted())
        	draw = name + " - Board line ";
        		
		for (int[] row : board.getBoard()) {
			List<Integer> line = IntStream.of(row).boxed().collect(Collectors.toList());
			result.add(new GameDraw(draw + rowcnt++,line));
		}
		return result;
	}
	
	private int[] parseParam(String params) throws NumberFormatException {
		// Game dosn't optimized for board size > 8
		int maxSize = 8;
		int[] val = new int[4];
		String[] values = params.split(",");
		if(values.length != 4)
			return defaultBoard;	
		for(int i = 0;i<4;i++) {
			val[i] = Integer.parseInt(values[i]);
		}
		if(val[0] > maxSize || val[1] > maxSize || val[2] >= val[0] || val[3] >= val[1])
			return defaultBoard;
		return val;	
	}
	
	private void setBoard(int[] val){
		this.width = val[0];
		this.high = val[1];
		this.knightY = val[2];
		this.knightX = val[3];	
	}

    private class Board {
        private final int[][] board;
        private final int size;
        private int step;

        Board(int m, int n) {
            this.board = new int[m][n];
            this.step = 0;
            this.size = m*n;
        }

        boolean isAvailable(Point p) {
            return !(p.x < 0 || p.y < 0 || p.x >= board.length || p.y >= board[0].length) && board[p.x][p.y] == 0;
        }

        void set(Point p) {
            if(isAvailable(p)) {
                board[p.x][p.y] = ++step;
            }
        }

        void back(Point p) {
            board[p.x][p.y] = 0;
            step--;
        }

        int size() {
            return this.size;
        }

        int step() {
            return this.step;
        }

        int[][] getBoard() {
            return this.board;
        }
    }

    private class Knight {
        private final Board board;
        private final int[][] moves = new int[][]{{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1},{-2,1},{-1,2}};
        private final Point start;
        long count = 0;
        private boolean status = false;

        Knight(Board board,Point p) {
            this.board = board;
            this.board.set(p);
            this.start = p;
        }

        void play() {
            play(this.start);
        }

        void play(Point p) {
            for (int[] move : moves) {
                if (board.isAvailable(p.move(move))) {
                    board.set(p.move(move));
                    count++;
                    play(p.move(move));
                }
                if(count > 2000000000) {
                	return;
                }
            }
            if (board.step == board.size()) {
            	status = true;
                return;
            }
            board.back(p);
        }
        
        boolean isCompleted() {
        	return status;
        }
    }

    private class Point {
        final int x;
        final int y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        Point move(int[] v) {
            return new Point(this.x + v[0], this.y + v[1]);
        }
    }

}
