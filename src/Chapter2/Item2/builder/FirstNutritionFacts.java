package Chapter2.Item2.builder;

public class FirstNutritionFacts {

	//First alternative;
	//Parametre sayısının arttıkça hızla kontrolden çıkması.
	//Tüm değerlerin ne anlama geldiğinin anlaşılmasının zor olması.
	//İstemeseniz de değer atamak zorunda olmanız.
	//Kodun yazılması ve okunmasının zorlaşması.

	private final int servingSize;
	private final int servings; 
	private final int fat;
	private final int calories;
	private final int sodium;
	private final int carbohydrate;

	public FirstNutritionFacts(int servingSize, int servings) {
		this(servingSize, servings, 0);
	}

	public FirstNutritionFacts(int servingSize, int servings, int calories) {
		this(servingSize, servings, calories, 0);
	}

	public FirstNutritionFacts(int servingSize, int servings, int calories, int fat) {
		this(servingSize, servings, calories, fat, 0);
	}

	public FirstNutritionFacts(int servingSize, int servings, int calories, int fat, int sodium) {
		this(servingSize, servings, calories, fat, sodium, 0);
	}

	public FirstNutritionFacts(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrate) {
		this.servingSize = servingSize;
		this.servings = servings;
		this.calories = calories;
		this.fat = fat;
		this.sodium = sodium;
		this.carbohydrate = carbohydrate;

	}

	/*
	 * Typically this constructor invocation will require many parameters that you
	 * don’t want to set, but you’re forced to pass a value for them anyway. In this
	 * case, we passed a value of 0 for fat. With “only” six parameters this may not
	 * seem so bad, but it quickly gets out of hand as the number of parameters
	 * increases. In short, the telescoping constructor pattern works, but it is
	 * hard to write client code when there are many parameters, and harder still to
	 * read it. The reader is left wondering what all those values mean and must
	 * carefully count = servings; = calories; = fat; = sodium; parameters to find
	 * out
	 */

	/*
	 * Long sequences of identical type parameters can cause subtle bugs. If the
	 * client accidentally reverses two such parameters, the compiler won’t
	 * complain, but the program will misbehave at runtime
	 */

	public static void main(String[] args) {

		FirstNutritionFacts facts = new FirstNutritionFacts(240, 8, 100, 0, 35, 27);
	}

}
