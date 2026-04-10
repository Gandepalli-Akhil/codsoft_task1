import java.util.Scanner;
import java.util.Random;
public class NumberGame{
	public static void main(String[] args){
	Random rand=new Random();
	int start=1,Max_Attempts=0,best=0;
	System.out.println("-!-!-!-!-!----WELCOME----!-!-!-!");
	System.out.println();
	Scanner sc=new Scanner(System.in);
	System.out.println("SET THE RANGE VALUE 1 To ?");
	int range=sc.nextInt();
	int round=0,score=0;
	
	for(int i=1;i<=5;i++)
	{
	round++;
	System.out.printf("------ROUND %d------\n",round);
	System.out.println();
	System.out.println("SET THE DIFFICULTY");
	System.out.println("1 ---> EASY ");
	System.out.println("2 ---> MEDIUM ");
	System.out.println("3---> HARD\n");
	
	int Difficulty_Level=sc.nextInt();
	System.out.println();
	
	if(Difficulty_Level==1){
	System.out.println("EASY MODE");
	Max_Attempts=10;
	System.out.printf("\nYOU HAVE TOTAL %d ATTEMPTS\n",Max_Attempts);
	}
	
	else if(Difficulty_Level==2)
	{
	System.out.println("MEDIUM MODE");
	Max_Attempts=5;
	System.out.printf("YOU HAVE TOTAL %d ATTEMPTS",Max_Attempts);
	}
	
	else if(Difficulty_Level==3)
	{
	System.out.println("HARD MODE");
	Max_Attempts=3;
	System.out.printf("YOU HAVE TOTAL %d ATTEMPTS",Max_Attempts);
	}
	
	else
	{
	System.out.println("INVALID DIFFICULTY LEVEL");
	return;
	}
	
	int Attempts=0;
	System.out.println("Letsss Goooooo >>>>>>>>>");
	int Random_Number=rand.nextInt(range)+1;
	boolean found=false;

	do
	{
	System.out.printf("GUESS THE NUMBER WITHIN  GIVEN RANGE : %d TO %d\n",start,range);
	Attempts++;

	int User_Number=sc.nextInt();

	if(User_Number>range || User_Number<=0){
	System.out.printf("pls enter in range %d TO %d",start,range);
	continue;
	}
		
	else if(Random_Number == User_Number )
	{
	// ✅ SCORE ADDED (only addition, nothing else changed)
	int points=0;
	if(Attempts==1) points=10;
	else if(Attempts<=3) points=7;
	else if(Attempts<=5) points=5;
	else points=2;
	score+=points;
	System.out.printf("You earned %d points\n",points);

	score++;
	if(Attempts>best)
	best=Attempts;
	System.out.println("#Congratulations! You guessed it right!");
	System.out.println("----------------------------------------");
	System.out.printf("YOU HAVE WON IN YOUR %d ATTEMPT\n",Attempts);
	System.out.print("----------------------------------------\n");
	found=true;
	}
	
	else if((Random_Number ==  User_Number+1) || (Random_Number ==  User_Number-1) )
	{
	System.out.println(">> Near miss! Try again.");
	}

	else if(User_Number<Random_Number)
	{
	System.out.println("TOO LOW");}
	
	else if(User_Number>Random_Number)
	{
	System.out.println("TOO HIGH");
	}
	
	if (Attempts>Max_Attempts-1 )
	{
	System.out.println("\nOut of attempts! Better luck next time.");
	break;
	}
}
	while(!found);
}
	System.out.printf("\nYOU HAVE DONE YOUR BEST IN YOUR %d th Attempt\n",best);
	System.out.printf("SCORE:-- %d / %d",score,round);
}
}