class FoodItem {

  private String name;                                             // string variable called name 
  private double fat;                                              // double variable called fat 
  private double carbs;                                            // double variable called carbs 
  private double protein;                                          // double variable called protein  
  private static final double CALORIES_PER_GRAM_FAT = 9.0;        // helps make sure there are no magic numbers in the program and is used for the calculations. 
  private static final double CALORIES_PER_GRAM_CARBS = 4.0;
  private static final double CALORIES_PER_GRAM_PROTEIN = 4.0;


// 4 arg constructor that sets name, fat, carbs, and protein to the values passed in.
  public FoodItem(String name, double fat, double carbs, double protein) {
    this.name = name;
    this.fat = fat;
    this.carbs = carbs;
    this.protein = protein;  
  }



  // getter that returns the calculation for the total amount of calories 
  public double getCalories(double numServings) {
    return (this.fat * CALORIES_PER_GRAM_FAT + this.carbs * CALORIES_PER_GRAM_CARBS + this.protein * CALORIES_PER_GRAM_PROTEIN) * numServings;
  }

  // method that prints the information of the food item entered into the program
  public void printInfo() {
    System.out.println("Nutritional information per serving of " + this.name);
    System.out.printf("\tFat: %.2f g\n", this.fat );
    System.out.printf("\tCarbs: %.2f g\n", this.carbs);
    System.out.printf("\tProtein: %.2f g\n", this.protein);  
  }

  // method that calculates and then prints the dominant macronutrient depnding on the calculation
  public String getDominantMacronutrient() {
    double totalFat = this.fat * CALORIES_PER_GRAM_FAT;
    double totalCarbs = this.carbs * CALORIES_PER_GRAM_CARBS;
    double totalProtein = this.protein * CALORIES_PER_GRAM_PROTEIN;

    if (totalFat >= totalCarbs && totalFat >= totalProtein)
      return "Fat";
    else if (totalCarbs >= totalProtein && totalCarbs >= totalFat)
      return "Carbs";
    else 
      return "Protein";  
  }
}