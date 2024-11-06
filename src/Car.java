public class Car extends Vehicle{



//Vehicle vehicle = new Vehicle(getMake(), getModel(), getType());
int wheels;
int year;
public Car(String cmake, String cmodel, String ctype, int year){
    super(cmake, cmodel, ctype);
    this.wheels = 4;
    this.year = year;
}
public int getYear(){
    return year;
}

public void display(){
    System.out.print("\n");
    System.out.println("Make : " + make);
    System.out.println("Model: " + model);
    System.out.println("Type: " + type);
    System.out.println("Year: " + year);

}




}
