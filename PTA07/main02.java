package PTA07;

public class main02 {
   public static void main(String args[ ]) {
      try{  
        throw new DefaultException("Default Exception");
      }catch(Exception e){
            System.out.println(e);     
      }
    }
}

class DefaultException extends Exception{
    public DefaultException(String message){
        super(message);
    }
}