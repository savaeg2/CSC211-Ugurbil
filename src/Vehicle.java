public class Vehicle implements Default{
     
private int wheels = 2;
String make;
String model;
String type;

//Constructor
public Vehicle(String make, String model, String type){
    this.make = make;
    this. model = model;
    this.type = type;
}
//Getters 
public String getMake() {
    return make;
}
public String getModel() {
    return model;
}
public String getType() {
    return type;
}

//Setters

public void display(){
System.out.print("\n");
System.out.println("Wheels: " + wheels);
System.out.println("Make: " + make);
System.out.println("Model: " + model);
System.out.println("Type: " + type);
}
}