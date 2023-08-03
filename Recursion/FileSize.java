import java.io.File;
class FileSize
{
    static long diskUsage(File root)
    {
        long total=root.length();
        if(root.isDirectory())
        {
            for(String childname:root.list())
            {
                File child=new File(root,childname);
                //File child=new File(childname);this doesn't work bcoz this version requires full pathname so it treats them as file
                total+=diskUsage(child);
            }
        }
        System.out.println(root+": "+total+" bytes");
        return total;
    }
    public static void main(String args[])
    {
        File root=new File("D:\\java");
        diskUsage(root);
    }
}