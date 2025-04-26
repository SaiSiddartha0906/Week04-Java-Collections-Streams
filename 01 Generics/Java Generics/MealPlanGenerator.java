
interface MealPlan {
    void displayMeal();
    boolean isValid();
}


class VegetarianMeal implements MealPlan {
    private String dish;

    public VegetarianMeal(String dish) {
        this.dish = dish;
    }

    @Override
    public void displayMeal() {
        System.out.println("Vegetarian Meal: " + dish);
    }

    @Override
    public boolean isValid() {
        return dish != null && !dish.isEmpty();
    }
}

class VeganMeal implements MealPlan {
    private String item;

    public VeganMeal(String item) {
        this.item = item;
    }

    @Override
    public void displayMeal() {
        System.out.println("Vegan Meal: " + item);
    }

    @Override
    public boolean isValid() {
        return item.toLowerCase().contains("vegan");
    }
}

class KetoMeal implements MealPlan {
    private int proteinGrams;

    public KetoMeal(int proteinGrams) {
        this.proteinGrams = proteinGrams;
    }

    @Override
    public void displayMeal() {
        System.out.println("Keto Meal - Protein: " + proteinGrams + "g");
    }

    @Override
    public boolean isValid() {
        return proteinGrams >= 20;
    }
}

class HighProteinMeal implements MealPlan {
    private String name;
    private int protein;

    public HighProteinMeal(String name, int protein) {
        this.name = name;
        this.protein = protein;
    }

    @Override
    public void displayMeal() {
        System.out.println("High Protein Meal: " + name + " - " + protein + "g protein");
    }

    @Override
    public boolean isValid() {
        return protein >= 25;
    }
}


class Meal<T extends MealPlan> {
    private T meal;

    public Meal(T meal) {
        this.meal = meal;
    }

    public T getMeal() {
        return meal;
    }

    public void showMeal() {
        meal.displayMeal();
    }
}


class MealGenerator {
    public static <T extends MealPlan> void generateMealPlan(Meal<T> meal) {
        System.out.println("---- Generating Meal Plan ----");
        if (meal.getMeal().isValid()) {
            meal.showMeal();
            System.out.println("✅ Meal is valid and added to your plan!");
        } else {
            System.out.println("❌ Invalid Meal. Please choose another.");
        }
    }
}


public class MealPlanGenerator {
    public static void main(String[] args) {
        Meal<VegetarianMeal> vegMeal = new Meal<>(new VegetarianMeal("Paneer Curry"));
        Meal<VeganMeal> veganMeal = new Meal<>(new VeganMeal("Vegan Smoothie"));
        Meal<KetoMeal> ketoMeal = new Meal<>(new KetoMeal(30));
        Meal<HighProteinMeal> highProtein = new Meal<>(new HighProteinMeal("Grilled Chicken", 40));


        MealGenerator.generateMealPlan(vegMeal);
        MealGenerator.generateMealPlan(veganMeal);
        MealGenerator.generateMealPlan(ketoMeal);
        MealGenerator.generateMealPlan(highProtein);


        Meal<KetoMeal> invalidKeto = new Meal<>(new KetoMeal(10));
        MealGenerator.generateMealPlan(invalidKeto);
    }
}
