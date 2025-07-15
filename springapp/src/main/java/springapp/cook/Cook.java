package springapp.cook;

public class Cook {
	
	//FriPan이나 Induction을 사용할 경우 결합도가 높아진다. 객체간 결합도가 너무 높다.
	//따라서 결합도를 낮추기 위해서 부품이 되는 객체는 느슨하게 보유해야한다.
	Pan pan;
	
	public Cook(Pan pan) {
	 this.pan = pan;
	}
	
	public void makeFood() {
		pan.boil();
	}
}
