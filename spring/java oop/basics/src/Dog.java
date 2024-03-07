public class Dog extends Animal {
    
    @Override
    public void sound(){
        System.out.println("Dog barks");
    }

    @Override
    void eat() {
        System.out.println("Dog eats");
    }
}
