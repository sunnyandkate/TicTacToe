package tictactoe;

import java.util.Scanner;

public class Game2 {

	// row for the number of rows and col for the number of columns
	int row = 3;
	int col = 3;
	//Scanner for user input in the console
	Scanner scanner = new Scanner(System.in);
	//An Array for the rows and columns to display 
	String[][] boxes = new String[row][col];
	//total of all rows and columns are saved in a variable boxesSize
	int boxesSize = row * col;
	//save the choosen row and columns in variables
	int choosenRow, choosenCol;
	//the symbols for the fields
	String symbole = "*";
	
	//set the player's turn to true/false
	boolean playerX = true;
	boolean playerO = false;
	
	//the currentplayer
	String currentPlayer = "X";
	
	String playerTurn = "X";
	
	int counter;
	
	//Constructor
	public Game2(){
		//call the startGame() method
		startGame();
		
		
	}
	public void startGame() {
		
		//loop through the array and print out the rows and columns	
		for(int i = 0; i < boxes.length;i++) {
			for(int j = 0; j < boxes[i].length;j++) {
				boxes[i][j] = symbole;
				System.out.print(boxes[i][j]);
			}
			System.out.println();
		}
		
		//call the method choosenField()
		chooseField();
		
		
	}
	public void chooseField() {
		//ask the player to choose a row and column
		System.out.println("choose a row from 1 to " + row);
		choosenRow = scanner.nextInt();
	
		System.out.println("choose a col from 1 to " + col);
		choosenCol = scanner.nextInt();
		
		
		//who's turn is it
		playerTurn();
	
		//loop through the array 
		for(int i = 0; i < boxes.length;i++) {
			for(int j = 0; j < boxes[i].length;j++) {
			
				//if the box is not taken insert X or O
				if(boxes[choosenRow-1][choosenCol-1].equals("*")) {
					boxes[choosenRow-1][choosenCol-1] = playerTurn;
					//increase counter every time a symbol is set
					counter++;
					
				}
								
				System.out.print(boxes[i][j]);
								
			}
			System.out.println();
						
		}
		//call the winner() method
		winner();

	}
	public void playerTurn() {
		//if it is playerX's turn put an X in the box
		//set currentPlayer to X
		if(playerX == true) {
			playerTurn = "X";
			currentPlayer = "X";
			playerX = false;
			playerO = true;
			
			
		}
			
		//if it is playerO's turn then put an O in the box
		//set currentPlayer to O
		else if(playerO == true) {
			playerTurn = "O";
			currentPlayer = "O";
			playerO = false;
			playerX = true;
			
		}
		
	}
	public void checkPlayersTurn() {
		
		System.out.println("Winner is: " + currentPlayer);
	}
	public void winner() {
		
		
		
			for(int i = 0; i < boxes.length;i++) {
				
				
				
				for(int j = 1; j < boxes[i].length-1;j++) {
					
					//if all boxes in one row or col or diagonal are the same and not equal to *
					//then show the winner
					
					if(!(boxes[i][j].equals("*"))) {
						if((boxes[i][j].equals(boxes[0][j])) && boxes[i][j].equals(boxes[1][j]) && boxes[i][j].equals(boxes[2][j]) || 
								(boxes[i][j].equals(boxes[i][0]) && boxes[i][j].equals(boxes[i][1]) && boxes[i][j].equals(boxes[i][2])) || 
								(boxes[i][j].equals(boxes[0][0]) && boxes[i][j].equals(boxes[1][1]) && boxes[i][j].equals(boxes[2][2])) || 
								(boxes[i][j].equals(boxes[0][2]) && boxes[i][j].equals(boxes[1][1]) && boxes[i][j].equals(boxes[2][0]))) {
					
					
							
						//which players turn is it
						//set this player to winner
							checkPlayersTurn();			
						
					}
						
					}
					
					
				}
			}
		
	
		//if counter equals the size of the board
		// all boxes are filled the game finishes
		if(counter == boxesSize) {
			endGame();
		}
		chooseField();
		
	}
	public void endGame() {
		
		System.out.println("End of the game");
	}
	
}
