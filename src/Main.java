import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);   
        
        System.out.print("What kind of vehicle do you have?" + 
                        "\n(1): Car\n(2): Bicycle\n");
        int vehicle = scnr.nextInt();
        
if (vehicle == 1){
        System.out.print("What is the make of your bicycle? ");
        String make = scnr.nextLine();
        
        System.out.print("What is the model? ");
        String model = scnr.nextLine();
        
        System.out.print("What type of bicycle do you have? ");
        String type = scnr.nextLine();

        Vehicle v = new Vehicle(make, model, type);
        v.display();
}
if (vehicle == 2){  
    
    System.out.print("What is the make of your Car? ");
    String make = scnr.nextLine();
    
    System.out.print("What is the model? ");
    String model = scnr.nextLine();
    
    System.out.print("What type of Car do you have? ");
    String type = scnr.nextLine();

    System.out.print("What year is your car from? ");
    int year = scnr.nextInt();

        Car c = new Car(make, model, type, year);        
        c.display();
}
scnr.close();
}
}

