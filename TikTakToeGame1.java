// Game Tik Tak Toe
import java.util.*;
import java.io.*;

class TikTakToeGame1
{
	static HashSet<Integer> user_set = new HashSet<Integer>();
	static HashSet<Integer> compt_set = new HashSet<Integer>();
	
	public static void main(String Args[])
	{
		String [][] game_board = 
		{
 			{"   ","|","   ","|","   "},
			{"---","|","---","|","---"},
			{"   ","|","   ","|","   "},
			{"---","|","---","|","---"},
			{"   ","|","   ","|","   "}
		};
		print_board(game_board);
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Do you want to play with computer? press Y \nand other button to play with friend :");
		char user_in = input.next().charAt(0);
		
		while(true)
		{
			System.out.print("Enter the values from 1-9:");
			int user_pos = input.nextInt();
			while(user_set.contains(user_pos) || compt_set.contains(user_pos))
			{
				System.out.println();
				System.out.print("Retry, Enter the values from 1-9:");
				user_pos = input.nextInt();
			}
			p_holder(game_board,user_pos,"you");
			
			String result = check_winner();
			if(result.length()>0)
			{
				System.out.println(result);
				break;
			}
			int compt_pos=0;
			if(user_in == 'Y' || user_in == 'y' )
			{
				compt_pos = gen_random();
				while(user_set.contains(compt_pos) || compt_set.contains(compt_pos))
				{
					compt_pos = gen_random();
				}
			}
			else
			{
				System.out.print("Enter the values from 1-9:");
				compt_pos = input.nextInt();
				while(user_set.contains(compt_pos) || compt_set.contains(compt_pos))
				{
					compt_pos = input.nextInt();
				}
				
			
			}
			
			p_holder(game_board,compt_pos,"Computer");
			
			result = check_winner();
			
			if(result.length()>0)
			{
				if(result.equals("YOU LOST") && !(user_in == 'Y' || user_in == 'y' ))
				{
					System.out.println("Player 2 won");
				}
				else if(result.equals("YOU WON") && (user_in == 'Y' || user_in == 'y' ))
				{
					System.out.println("Player 1 won");
				}
				else
					System.out.println(result);
				break;
			}
		}
		
		
		
	}
		static String check_winner()
		{
			HashSet<Integer> r1 = new HashSet<Integer>();
			r1.add(1);r1.add(2);r1.add(3);
			HashSet<Integer> r2 = new HashSet<Integer>();
			r2.add(4);r2.add(5);r2.add(6);
			HashSet<Integer> r3 = new HashSet<Integer>();
			r3.add(7);r3.add(8);r3.add(9);
			HashSet<Integer> r4 = new HashSet<Integer>();
			r4.add(1);r4.add(4);r4.add(7);
			HashSet<Integer> r5 = new HashSet<Integer>();
			r5.add(2);r5.add(5);r5.add(8);
			HashSet<Integer> r6 = new HashSet<Integer>();
			r6.add(3);r6.add(6);r6.add(9);
			HashSet<Integer> r7 = new HashSet<Integer>();
			r7.add(1);r7.add(5);r7.add(9);
			HashSet<Integer> r8 = new HashSet<Integer>();
			r8.add(3);r8.add(5);r8.add(7);
			
			HashSet<HashSet> set = new HashSet<HashSet>();
			set.add(r1);set.add(r2);set.add(r3);
			set.add(r4);set.add(r5);set.add(r6);
			set.add(r7);set.add(r8);

			for(HashSet c:set)
			{
				if(user_set.containsAll(c))
					return "YOU WON";
				else if(compt_set.containsAll(c))
					return "YOU LOST";	
			}
			if(user_set.size()+compt_set.size()==9)
				return "DRAW";
			
				return "";
		}
	
		static int gen_random()
		{
			int max = 9;
			int min = 1;
			
			int range = max-min+1;
			int result = (int) (Math.random()*range) + min;
			System.out.println("Computer selected no is "+ result);
			return result;
			
		}
	
	static void print_board(String [][]game_board)
	{
		for(int i=0; i<game_board.length; i++)
		{
			for(int j=0; j<game_board[1].length; j++)
			{
				System.out.print(game_board[i][j]);
			}
			System.out.println();
		}
	}
	
	static void p_holder(String game_board[][],int pos, String user)
	{
		String symb = " X ";
		if(user.equals("you"))	//if u want to check containt of string we use .equals method	// and == (double equal) sign check for the reference
		{
			symb = " X ";
			user_set.add(pos);
			
		}
		else if(user.equals("Computer"))
		{
			symb = " O ";
			compt_set.add(pos);
		}
		
		switch(pos)
		{
			case 1:
			game_board[0][0]=symb;
			break;
			case 2:
			game_board[0][2]=symb;
			break;
			case 3:
			game_board[0][4]=symb;
			break;
			case 4:
			game_board[2][0]=symb;
			break;
			case 5:
			game_board[2][2]=symb;
			break;
			case 6:
			game_board[2][4]=symb;
			break;
			case 7:
			game_board[4][0]=symb;
			break;
			case 8:
			game_board[4][2]=symb;
			break;
			case 9:
			game_board[4][4]=symb;
			break;
			
			default:
			System.out.println("Invalid Input");

		}
		
		print_board(game_board);
		System.out.println("__________________________________________________");
	}
}