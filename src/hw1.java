import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class hw1 {

    public static Scanner scanner;  // Note: Do not change this line.

    public static void theStudentsGame() {
        int m = scanner.nextInt();
        char x = scanner.next().charAt(0);
        int n = scanner.nextInt();
        int [][] mat=new int[m][n];
        for (int i=0;i<m;i++)
        {
            for(int j=0; j<n;j++)
            {
                mat[i][j]=0;
            }
        }
        scanner.nextLine();
        String str= scanner.nextLine();
        int j=0,left=0,num1=0,num2=0;
        while( (j< str.length()))
        {
            if (str.charAt(j)=='Y')
            {
                break;
            }
            while(str.charAt(j)!=',')
            {
                j++;
            }
            try {
                num1=Integer.parseInt(str.substring(left,j));
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }
            j=j+2;
            if (str.charAt(j)=='Y')
            {
                break;
            }
            left=j;
            while (str.charAt(j)!=' ')
            {
                j++;

            }
            try {
                num2=Integer.parseInt(str.substring(left,j));
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }
            if ((num1>m)||(num2>n)||(num1<0)||(num2<0))
            {
                continue;
            }
            if(mat[num1][num2]==0)
            {
                mat[num1][num2]=1;
                num1=0;
                num2=0;

            }
            else
            {
                mat[num1][num2]=0 ;
                num1=0;
                num2=0;
            }


            j++;

        }
        changeBorad(mat,n,m);





    }
    public static void changeBorad(int [][]mat,int n , int m)
    {
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if ((i==0)&&(j==0))
                {
                    if((mat[i][j]==0)&&(mat[i][j+1]==1)&&(mat[i+1][j+1]==1)&&(mat[i+1][j]==1))
                    {
                        mat[i][j]=1;
                    }
                   // if((mat[i][j]==1)&&((checkFriends1())||checkFriends2())

                }
            }
        }
    }
    public static int checkFriends1(int [][]mat, int i, int j,int n, int m)
    {
        int counter=0;
        if (mat[i][j]==1)
        {
            if((i>0)&&(mat[i-1][j]==1))
            {
                counter++;
                if((j<n-1)&&(mat[i-1][j+1]==1))
                {
                    counter++;
                }

            }
            if((j>0)&&(mat[i][j-1]==1))
            {
                counter++;
            }
            if((i<n)&&(mat[i+1][j]==1))
            {
                counter++;
            }
            if((j<n)&&(mat[i][j+1]==1))
            {
                counter++;
            }
            if((j>0)&&(i>0)&&(mat[i-1][j-1]==1))
            {
                counter++;
            }
            if((j<n)&&(i<m)&&mat[i+1][j+1]==1)
            {
                counter++;
            }





        }
         return counter;


    }

    public static void main(String[] args) throws IOException {
         String path = args[0];
        scanner = new Scanner(new File(path));
        int numberOfGames = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= numberOfGames; i++) {
            System.out.println("Game number " + i + " starts.");
            theStudentsGame();
            System.out.println("Game number " + i + " ended.");
            System.out.println("-----------------------------------------------");
        }
        System.out.println("All games are ended.");
    }
}














