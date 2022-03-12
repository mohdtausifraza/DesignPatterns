package StructuralDesignPatterns;

// Abstract Pizza class (All classes extend from this)
abstract class Pizza{
    String description = "Unknown Pizza";
    public String getDescription(){
        return description;
    }
    public abstract int getCost();
}
// The decorator class :  It extends Pizza to be
// interchangeable with it toppings decorator can
// also be implemented as an interface
abstract class ToppingsDecorator extends Pizza{
    @Override
    public abstract String getDescription();
}

// Concrete Pizza Classes
class PeppyPaneer extends Pizza{
    public PeppyPaneer(){
        description="PeppyPaneer";
    }
    @Override
    public int getCost() {
        return 100;
    }
}
class FarmHouse extends Pizza{
    public FarmHouse(){
        description="FarmHouse";
    }
    @Override
    public int getCost() {
        return 150;
    }
}
class Margherita extends Pizza{
    public Margherita(){
        description="Margherita";
    }
    @Override
    public int getCost() {
        return 200;
    }
}
class ChickenFiesta extends Pizza{
    public ChickenFiesta(){
        description="ChickenFiesta";
    }
    @Override
    public int getCost() {
        return 250;
    }
}

// Concrete Topping Classes
class FreshTomato extends ToppingsDecorator{

    Pizza pizza;
    public FreshTomato(Pizza pizza){
        this.pizza=pizza;
    }
    @Override
    public int getCost() {
        return 10+this.pizza.getCost();
    }
    @Override
    public String getDescription() {
        return pizza.getDescription()+" , Fresh Tomato ";
    }
}
class Paneer extends ToppingsDecorator{

    Pizza pizza;
    public Paneer(Pizza pizza){
        this.pizza=pizza;
    }
    @Override
    public int getCost() {
        return 20+this.pizza.getCost();
    }
    @Override
    public String getDescription() {
        return pizza.getDescription()+" , Paneer ";
    }
}
class Jalapeno extends ToppingsDecorator{

    Pizza pizza;
    public Jalapeno(Pizza pizza){
        this.pizza=pizza;
    }
    @Override
    public int getCost() {
        return 30+this.pizza.getCost();
    }
    @Override
    public String getDescription() {
        return pizza.getDescription()+" , Jalapeno ";
    }
}
class Barbeque extends ToppingsDecorator{

    Pizza pizza;
    public Barbeque(Pizza pizza){
        this.pizza=pizza;
    }
    @Override
    public int getCost() {
        return 40+this.pizza.getCost();
    }
    @Override
    public String getDescription() {
        return pizza.getDescription()+" , Barbeque ";
    }
}

// Other toppings can be coded in a similar way
// Driver class and method
public class DecoratorPattern {
    public static void main(String[] args) {
        Pizza pizza1 = new Margherita();
        System.out.println(pizza1.getDescription()+ "Cost :" +pizza1.getCost());

        Pizza pizza2 = new FarmHouse();
        pizza2=new FreshTomato(pizza2);
        pizza2=new Paneer(pizza2);
        System.out.println(pizza2.getDescription()+ "Cost :" +pizza2.getCost());

        Pizza pizza3=new Barbeque(null);
        System.out.println(pizza3.getDescription()+ "Cost :" +pizza3.getCost());
    }
}
