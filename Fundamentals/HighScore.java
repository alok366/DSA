import java.util.*;
class GameEntry
{
    int score;
    String name;
    GameEntry(int score,String name)
    {
        this.score=score;
        this.name=name;
    }
    int getScore()
    {
        return score;
    }
    String getName()
    {
        return name;
    }
    public String toString()
    {
        return "[Score: "+score+"\tName: "+name+"]";
    }
}
class ScoreBoard
{
    GameEntry[] board;
    int numEntries=0;
    ScoreBoard(int size)
    {
        board=new GameEntry[size];
    }
    void add(GameEntry e)
    {
        int newScore=e.getScore();
        if(numEntries<board.length||newScore>board[numEntries-1].getScore())
        {
            if(numEntries<board.length)
            numEntries++;
            int j=numEntries-1;
            while(j>0 && newScore>board[j-1].getScore())
            {
                board[j]=board[j-1];
                j--;
            }
            board[j]=e;
        }
    }
    GameEntry remove(int i)throws IndexOutOfBoundsException
    {
        if(i<0||i>=numEntries)throw new IndexOutOfBoundsException("Invalid Index: "+i);
        GameEntry temp=board[i];
        for(int j=i;j<numEntries-1;j++)
        {
            board[j]=board[j+1];
        }
        board[numEntries-1]=null;
        numEntries--;
        return temp;
    }
    void display()
    {
        for(int i=0;i<numEntries;i++)
        System.out.println(board[i].toString());
    }
}
class HighScore
{
    public static void main(String args[])
    {
        ScoreBoard sb=new ScoreBoard(5);
        String ans;
        do
        {
            Scanner in=new Scanner(System.in);
            int choice;
            System.out.println("Press 1 to enter score\nPress 2 to remove score\nPress 3 to display");
            choice=in.nextInt();
            if(choice==1)
            {
                System.out.println("Enter high score");
                int score=in.nextInt();
                in.nextLine();
                System.out.println("Enter your name");
                String name=in.nextLine();
                GameEntry entry=new GameEntry(score,name);
                sb.add(entry);
            }
            else if(choice==2)
            {
                int index;
                System.out.println("Enter index of entry to remove");
                index=in.nextInt();
                in.nextLine();
                GameEntry ob=sb.remove(index);
                System.out.println(ob.toString()+" Removed");
            }
            else if(choice==3)
            {
                sb.display();
                in.nextLine();
            }
            System.out.println("to continue type yes");
            ans=in.nextLine();
        }
        while(ans.equals("yes"));
    }
}