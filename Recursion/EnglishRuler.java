class EnglishRuler
{
    static void drawRuler(int inches,int majorLength)
    {
        drawLine(majorLength,0);
        for(int i=1;i<=inches;i++)
        {
            drawInterval(majorLength-1);
            drawLine(majorLength,i);
        }
    }
    static void drawInterval(int centralLength)//when there's standard or recursive call execution starts here
    {
        if(centralLength>=1)
        {
            drawInterval(centralLength-1);//when a call returns it will start executing from next line so even,
            drawLine(centralLength);//if length is 0 it will call drawLine and drawInterval
            drawInterval(centralLength-1);
        }
    }
    static void drawLine(int tickLength,int label)
    {
        for(int i=0;i<tickLength;i++)
        System.out.print("-");
        if(label>=0)
        System.out.print(label);
        System.out.println();
    }
    static void drawLine(int tickLength)
    {
        drawLine(tickLength,-1);
    }
    public static void main(String args[])
    {
        drawRuler(1,5);
    }
}