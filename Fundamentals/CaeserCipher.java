import java.util.Arrays;
class CaeserCipher
{
    char encoder[]=new char[26];
    char decoder[]=new char[26];
    CaeserCipher(int rotation)
    {
        for(int i=0;i<26;i++)
        {
            encoder[i]=(char)('A'+(i+rotation)%26);
            decoder[i]=(char)('A'+(i-rotation+26)%26);//26 is added to avoid -ve 
        }
    }
    String encrypt(String message)
    {
        return transform(message,encoder);
    }
    String decrypt(String secret)
    {
        return transform(secret,decoder);
    }
    String transform(String Original,char[] code)
    {
        char[] org=Original.toCharArray();
        for(int i=0;i<org.length;i++)
        {
            if(Character.isUpperCase(org[i]))
            {
                int j=org[i]-'A';
                org[i]=code[j];
            }
        }
        return new String(org);
    }
    public static void main(String args[])
    {
        CaeserCipher cipher=new CaeserCipher(3);
        System.out.println("Encryption code: "+new String(cipher.encoder));
        System.out.println("Decryption code: "+new String(cipher.decoder));
        String msg="ALOK PANWAR";
        String coded=cipher.encrypt(msg);
        System.out.println("Encrypted message: "+coded);
        String decoded=cipher.decrypt(msg);
        System.out.println("Decrypted message: "+decoded);
    }
}