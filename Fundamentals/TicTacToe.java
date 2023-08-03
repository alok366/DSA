import java.util.*;
class TicTacToe
{
    final int X=1;
    final int O=-1;
    final int EMPTY=0;
    int board[][]=new int[3][3];
    int player;
    TicTacToe()
    {
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            board[i][j]=EMPTY;
        }
        player=X;
    }
    void putMark(int i,int j)throws IllegalArgumentException
    {
        if(i>2||j>2||i<0||j<0)throw new IllegalArgumentException("invalid position");
        else if(board[i][j]!=EMPTY) throw new IllegalArgumentException("board is full");
        else
        {
            board[i][j]=player;
            player=-player;
        }
    }
    boolean isWin(int mark)
    {
        return ((board[0][0]+board[1][0]+board[2][0]==mark*3)
        ||(board[1][0]+board[1][1]+board[1][2]==mark*3)
        ||(board[2][0]+board[2][1]+board[2][2]==mark*3)
        ||(board[0][1]+board[0][1]+board[0][2]==mark*3)
        ||(board[0][0]+board[1][0]+board[2][0]==mark*3)
        ||(board[0][1]+board[1][1]+board[2][1]==mark*3)
        ||(board[0][2]+board[1][2]+board[2][2]==mark*3)
        ||(board[0][0]+board[1][1]+board[2][2]==mark*3)
        ||(board[2][0]+board[1][1]+board[0][2]==mark*3));
    }
    int winner()
    {
        if(isWin(X))
        return X;
        else if(isWin(O))
        return O;
        else
        return EMPTY;
    }
    public String toString()
    {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                switch(board[i][j])
                {
                    case X:sb.append("X");
                    break;
                    case O:sb.append("O");
                    break;
                    case EMPTY:sb.append(" ");
                }
                if(j<2)sb.append("|");
            }
            if(i<2)sb.append("\n------\n");
        }
        return sb.toString();
    }
    boolean isFull()
    {
        boolean flag=true;
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(board[i][j]==0)
                {
                    flag=false;
                    break;
                }
            }
        }
        return flag;
    }
    public static void main(String args[])
    {
        TicTacToe game=new TicTacToe();
        Scanner in=new Scanner(System.in);
        while(!game.isFull())
        {
            if(game.player==1)
            {
                System.out.println("Player X enter your position");
            }
            else if(game.player==-1)
            System.out.println("Player Y enter your position");
            int x=in.nextInt();
            int y=in.nextInt();
            game.putMark(x,y);
            System.out.println(game);
            if(game.winner()!=0)
            break;
        }
        int winner=game.winner();
        String[] outcome={"O wins","Tie","X wins"};
        System.out.println(outcome[winner+1]);
    }
}