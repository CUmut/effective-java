package Chapter2.Item2.builder;

public class JavaBeansNutritionFacts {

	/*
	 * A second alternative when you’re faced with many optional parameters in a
	 * constructor is the JavaBeans pattern, in which you call a parameterless
	 * constructor to create the object and then call setter methods to set each
	 * required parameter and each optional parameter of interest:
	 */

	// Parameters initialized to default values (if any)
	private int servingSize = -1; // Required; no default value
	private int servings = 0;
	private int calories = 0;
	private int fat = 0;
	private int sodium = 0;
	private int carbohydrate = 0;

	public void setServingSize(int servingSize) {
		this.servingSize = servingSize;
	}

	public void setServings(int servings) {
		this.servings = servings;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public void setFat(int fat) {
		this.fat = fat;
	}

	public void setSodium(int sodium) {
		this.sodium = sodium;
	}

	public void setCarbohydrate(int carbohydrate) {
		this.carbohydrate = carbohydrate;
	}

	/*
	 * Unfortunately, the JavaBeans pattern has serious disadvantages of its own.
	 * Because construction is split across multiple calls, a JavaBean may be in an
	 * inconsistent state partway through its construction. The class does not have
	 * the option of enforcing consistency merely by checking the validity of the
	 * constructor parameters. Attempting to use an object when it’s in an
	 * inconsistent state may cause failures that are far removed from the code
	 * containing the bug and hence difficult to debug. A related disadvantage is
	 * that the JavaBeans pattern precludes the possibility of making a class
	 * immutable and requires added effort on the part of the programmer to ensure
	 * thread safety.
	 */

	public static void main(String[] args) {
		JavaBeansNutritionFacts cocaCola = new JavaBeansNutritionFacts();
		cocaCola.setServingSize(240);
		cocaCola.setServings(8);
		cocaCola.setCalories(100);
		cocaCola.setSodium(35);
		cocaCola.setCarbohydrate(27);
	}

}
