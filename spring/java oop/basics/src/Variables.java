public class Variables {

    public void pupAge() {
        int age = 0;
        age = age + 7;
        System.out.println("Puppy age is : " + age);
     }

    // Instance variables are declared in a class, but outside a method, constructor or any block.

    // When a space is allocated for an object in the heap, a slot for each instance variable value is created.
    
        // this instance variable is visible for any child class.
        public String name;



// Class variables also known as static variables are declared with the static keyword in a class, but outside a method, constructor or a block.

// There would only be one copy of each class variable per class, regardless of how many objects are created from it.
        // salary  variable is a private static variable
        private static double salary;

        // DEPARTMENT is a constant
        public static final String DEPARTMENT = "Development ";

   public static void main(String args[]) {
      salary = 1000;
      System.out.println(DEPARTMENT + "average salary:" + salary);
   }
}
