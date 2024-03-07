import java.io.File;

public class DirectoryTest {
    public static void main(String args[]) {
      String dirname = "javadirectory";
      File directory = new File(dirname);

      // Create directory now.
      directory.mkdirs();

      // create new file object
      File file = new File("javadirectory");

      System.out.println(file.exists());  
      
      read(dirname);
      delete(dirname);
   }


   public static void read(String dirname) {
    File file = null;
    String[] paths;

    try {      
       // create new file object
       file = new File(dirname);

       // array of files and directory
       paths = file.list();

       // for each name in the path array
       for(String path:paths) {
          // prints filename and directory name
          System.out.println(path);
       }
    } catch (Exception e) {
       // if any error occurs
       e.printStackTrace();
    }
 }
 public static void delete(String dirname) {
    File file = new File(dirname);
    if(file.exists()) {
       boolean success = file.delete();

       if (success) {
          System.out.println("The directory has been successfully deleted."); 
       }else {
          System.out.println("The directory deletion failed.");
       }        
    }else {
       System.out.println("The directory is not present."); 
    }
 }
}
