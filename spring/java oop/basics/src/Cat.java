public class Cat extends Animal {
    
    
    @Override
    public void sound(){
        System.out.println("Cat meaow");
    }

    @Override
    void eat() {
        System.out.println("Cat eats");
    }
}
