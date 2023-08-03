class ValidHtml
{
    static boolean isHTML(String html)
    {
        int j=html.indexOf("<");
        LinkedStack2<String> buffer=new LinkedStack2<>();
        while(j!=-1)
        {
            int k=html.indexOf('>',j+1);
            if(k==-1)
            return false;
            String tag=html.substring(j+1,k);
            if(!tag.startsWith("/"))
            buffer.push(tag);
            else
            {
                if(buffer.isEmpty())
                return false;
                else if(!tag.substring(1).equals(buffer.pop()))
                return false;
            }
            j=html.indexOf('<',k+1);
        }
        return buffer.isEmpty();
    }
    public static void main(String args[])
    {
        String html="<body>Hello</body>";
        System.out.println("Html "+html+" is valid: "+isHTML(html));
        html="<h1><b></h1>";
        System.out.println("Html "+html+" is valid: "+isHTML(html));
    }
}