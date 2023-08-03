class ValidExpression
{
    static boolean isMatched(String expression)
    {
        String opening="({[";
        String closing=")}]";//there's reason why order is same
        LinkedStack2<Character> buffer=new LinkedStack2<>();
        for(char c:expression.toCharArray())
        {
            if(opening.indexOf(c)!=-1)
            buffer.push(c);
            else if(closing.indexOf(c)!=-1)
            {
                if(buffer.isEmpty())
                return false;
                else if(closing.indexOf(c)!=opening.indexOf(buffer.pop()))
                return false;
            }
        }
        return buffer.isEmpty();
    }
    public static void main(String args[])
    {
        String expression="[5*(23)]";
        System.out.println("Expression"+expression+" is valid: "+isMatched(expression));
        expression="{122313[}()";
        System.out.println("Expression"+expression+" is valid: "+isMatched(expression));
    }
}