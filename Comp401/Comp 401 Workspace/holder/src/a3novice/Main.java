package a3novice;

public class Main {
	public static void main (String[] args) {
		BisonJerky Bj = new BisonJerky(5);
		Burrito B = new Burrito(0);
		ButtonUp Bu = new ButtonUp(0);
		Coffee C = new Coffee(0);
		Fleece F = new Fleece(4);
		Ramen R = new Ramen(0);
		RedBison Rb = new RedBison(3);
		Sushi S = new Sushi(0);
		TShirt T = new TShirt(0);
		
		System.out.println("Testing correct specifications -");
		
		System.out.println("expected: 1 1 1 1000 ramen noodles");
		System.out.print("actual : ");
		System.out.print(R.getPoundsPerItem()+ " ");
		System.out.print(R.getPricePerItem()+ " ");
		System.out.print(R.getFill()+ " ");
		System.out.print(R.getDaysTillExpiration()+ " ");
		System.out.println(R.getName());
		System.out.println();
		
		System.out.println("expected: 5 7 10 5 burrito");
		System.out.print("actual : ");
		System.out.print(B.getPoundsPerItem()+ " ");
		System.out.print(B.getPricePerItem()+ " ");
		System.out.print(B.getFill()+ " ");
		System.out.print(B.getDaysTillExpiration()+ " ");
		System.out.println(B.getName());
		System.out.println();
		
		System.out.println("expected: 3 15 15 2 sushi");
		System.out.print("actual : ");
		System.out.print(S.getPoundsPerItem()+ " ");
		System.out.print(S.getPricePerItem()+ " ");
		System.out.print(S.getFill()+ " ");
		System.out.print(S.getDaysTillExpiration()+ " ");
		System.out.println(S.getName());
		System.out.println();
		
		System.out.println("expected: 5 10 6 40 bison jerky");
		System.out.print("actual : ");
		System.out.print(Bj.getPoundsPerItem() + " ");
		System.out.print(Bj.getPricePerItem() + " ");
		System.out.print(Bj.getFill()+ " ");
		System.out.print(Bj.getDaysTillExpiration()+ " ");
		System.out.println(Bj.getName());
		System.out.println();
		
		System.out.println("expected: 1 5 0 100 1 coffee");
		System.out.print("actual : ");
		System.out.print(C.getPoundsPerItem()+ " ");
		System.out.print(C.getPricePerItem()+ " ");
		System.out.print(C.getFill()+ " ");
		System.out.print(C.getDaysTillExpiration()+ " ");
		System.out.print(C.getDuration() + " ");
		System.out.println(C.getName());
		System.out.println();
		
		System.out.println("expected: 2 7 -10 100 5 Red Bison");
		System.out.print("actual : ");
		System.out.print(Rb.getPoundsPerItem()+ " ");
		System.out.print(Rb.getPricePerItem()+ " ");
		System.out.print(Rb.getFill()+ " ");
		System.out.print(Rb.getDaysTillExpiration()+ " ");
		System.out.print(Rb.getDuration() + " ");
		System.out.println(Rb.getName());
		System.out.println();
		
		System.out.println("expected: 1 20 1 t-shirt");
		System.out.print("actual : ");
		System.out.print(T.getPoundsPerItem() + " ");
		System.out.print(T.getPricePerItem() + " ");
		System.out.print(T.getWarmth() + " ");
		System.out.println(T.getName());
		System.out.println();
		
		System.out.println("expected: 5 50 2 button-up");
		System.out.print("actual : ");
		System.out.print(Bu.getPoundsPerItem() + " ");
		System.out.print(Bu.getPricePerItem() + " ");
		System.out.print(Bu.getWarmth() + " ");
		System.out.println(Bu.getName());
		System.out.println();
		
		System.out.println("expected: 10 100 3 fleece");
		System.out.print("actual : ");
		System.out.print(F.getPoundsPerItem() + " ");
		System.out.print(F.getPricePerItem() + " ");
		System.out.print(F.getWarmth() + " ");
		System.out.println(F.getName());
		
		System.out.println();
		System.out.println("Testing total weight method -");
		System.out.println("expected: 25, actual: " + Bj.getTotalWeight());
		
		System.out.println();
		System.out.println("Testing setter and getter for amount -");
		F.setAmount(4);
		System.out.println("expected: 4, actual: " + F.getAmount());
		
		System.out.println();
		System.out.println("Testing consume method -");
		
		System.out.println("expected: 5, " + "actual: " + Bj.getAmount());
		for (int i = 4; i >= -1; i--) {
			if (i == -1) {
				System.out.print("expected: you are out of food, ");
			}
			try{
				Bj.consume();
			}
			catch(NoFoodException e){
				System.out.println("actual: you are out of food");
				break;
			}
			System.out.println("expected: " + i + ", " + "actual: " + Bj.getAmount());
			
		}
		
		System.out.println();
		System.out.println("Testing age method -");

		System.out.println("expected: 5, " + "actual: " + B.getDaysTillExpiration());
		for (int i = 4; i >= -1; i--) {
			if (i == -1) {
				System.out.print("expected: your food has expired, ");
			}
			try{
				B.age();
			}
			catch(FoodExpiredException e){
				System.out.println("actual: your food has expired");
				break;
			}
			System.out.println("expected: " + i + ", " + "actual: " + B.getDaysTillExpiration());
		}
		
		
	}
}
