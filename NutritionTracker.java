import java.util.Scanner;   

class NutritionTracker {

  // private method that takes inputvalue from user and returns it
  private static double getInputValue(String prompt) {
    Scanner input = new Scanner(System.in);   // creates scanner object
    double food = -1.0;                       // initializes food to -1.0
    // while loop to ensures that the user enters a valid input
    while (food < 0) {
      System.out.print(prompt);
      food = input.nextDouble();  
      input.nextLine();
    }
    return food;
    } 
 
  
  public static void main(String[] args) {
   Scanner input = new Scanner(System.in);  // creates scanner object
   double total = 0;                        // initializes total to 0 later used to get the toal amount

    int numItems = -1;        
    String nameItem;                        // variable that allows me to get the name of food item

    
    // while loop that ask for amount of food items and ensures that it is a valid input
    while (numItems < 0) {
      System.out.print("How many food items would you like to input?: ");
      numItems = input.nextInt();
      input.nextLine();
    }
    // for loop that asks for the name of the food item and stores them in variables and prints them out
    for (int i = 0; i < numItems; i++) {
      System.out.print("Enter the name of the food item: ");
      nameItem = input.nextLine();
      
      double fat = getInputValue("Enter the amount of fat in " + nameItem + " (grams): "); 
      double carbs = getInputValue("Enter the amount of carbs in " + nameItem + " (grams): ");
      double protein = getInputValue("Enter the amount of protein in " + nameItem + " (grams): ");
      double servings =  getInputValue("Enter the number of servings: ");
      
      FoodItem foodItem = new FoodItem(nameItem, fat, carbs, protein);

      total += foodItem.getCalories(servings);      // gets toatl amount of calories 

      foodItem.printInfo();                         // prints all the info of the food

      System.out.println("Total Calories for " + servings + " servings of " + nameItem +": " + foodItem.getCalories(servings));      // prints the total calories and the rest of the information for the food item

      System.out.println("Dominant Macronutrient: " + foodItem.getDominantMacronutrient());      // prints the dominant macronutrient (carbs/ fat/ protein)
      
    }

    System.out.println("Total combined calories for all food items: " + total);   // prints the total calories for all food items

    System.out.println("Thank you for using the Nutrition Information System!");  // thanks the user for using the program
  }
}