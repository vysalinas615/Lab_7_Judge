import java.util.*;

public class Judge
{
	//notes before starting 
	//The number of people in the town is always between 1 and 1000.
	//N-1 people believe the judge (remember the judge trusts no one.)

	private boolean [][] adjacencyMatrix;
	private int numberOfVerticies;

	public void printArray(int[][] input)
	{
		System.out.println();
		System.out.print("Input: {");
		for (int row=0;row<input.length;row++)
		{
			for (int col=0;col<input[row].length;col++)
			{

				if (col==0)
				{
					System.out.print("{"+input[row][col]+",");
				}

				else
				{

					if (col==input[row].length-1)
					{
						System.out.print(input[row][col]+"}");
					}

					else
					{
						System.out.print(input[row][col]+"}, ");
					}
				}
			}
		}
		System.out.print("} \n");
		System.out.println();
	}

	public int findJudge(int N, int[][] trust)
	{
		adjacencyMatrix = new boolean[numberOfVerticies][numberOfVerticies];

		int[] count = new int[N];

		for (int[] t: trust)
		{
			count[t[0]-1]--; 
			//this represents the verticies going out
			count[t[1]-1]++;
			//this represents the verticies going in
		}

		for (int i=0; i<N; i++)
		{
			if (count[i]==N-1)
			{
				return i+1;
			}
		}
		
		//************************************************************************************************************

		/*boolean[][] visited = new boolean[N][N]; 

		if (N==1)
		{
			//if there's only one person they must be the judge since numbers can't be repeated/ the judge trusts no one 
			return N;
		}

		if (N<1 || N>1000)
		{
			System.out.println("Incorrect number of N people entered. Please enter a number between 1 and 1000. ");
		}

		//see if a is == to b and print error message since we can't have duplicates of the same number

		for (int h=0; h!=trust.length; h++)
		{
			visited[trust[h][0]-1][trust[h][1]-1] = true;
		}

		for (int i=0; i!=trust[0].length; i++)
		{
			int count = 0;
			for (int j=0; j<visited.length; j++)
			{
				count = visited[j][i] ? count+1 : count;*/
				/*count = visited[j][i];
				//count is an int and visited[][] is a boolean
				if(visited[j][i] == true)
				{
					count ++;
				}

				else 
				{
					System.out.println();
				}*/
			/*}
			if (count == N-1)
			{
				boolean get = true;

				for (int k=0; k!=visited.length; k++)
				{
					if (visited[i][k])
					{
						get = false;
						break;
					}
				}
				if (get)
				{
					return i+1;
				}
			}
			
		}*/
		//maybe make a tree with the judge as the parent or use an adjacency matrix or something
		
		return -1;
		//if no judge has been found return -1
		//***********************************************************************************************
	}

	public static void main(String[] args)
	{
		Judge theJudge = new Judge();

		Scanner scan1 = new Scanner(System.in);
		System.out.println("Please enter the number of verticies. ");
		int uinput = scan1.nextInt();

		//Please delete the numbers I used and paste yours after array int[][] theArray = 
		int[][] theArray = {{1,3},{1,4},{2,3},{2,4},{4,3}};

		theJudge.printArray(theArray);

		/*Graph myGraph = new Graph(uinput);
		myGraph.addEdge(1,3);
		myGraph.addEdge(1,4);
		myGraph.addEdge(2,3);
		myGraph.addEdge(2,4);
		myGraph.addEdge(4,3);



		String result;
		result = myGraph.printMatrix();
		System.out.println(result);*/

		int resultJudge;

		resultJudge = theJudge.findJudge(uinput, theArray);
		System.out.println("Output: "+resultJudge);
	}
}