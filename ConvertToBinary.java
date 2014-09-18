package algorithms;

/*
 * Description: this function used to convert an Integer to Binary String
 */
 
 public class ConvertToBinary {
 
    public static void main(String[] args) {
        
        System.out.println(getBinary(1000));
    }
    
    public static String getBinary(int n) {
    
        if (n == 0)
            return "0";
        
        StringBuilder sb = new StringBuilder();
        
        while (n > 0) {
            
            if (n % 2 == 1)
                sb.insert(0, 1);
            
            if (n % 2 == 0)
                sb.insert(0, 0);
                
            n = n >> 1;
        }
        
        return sb.toString();
    }
 }
