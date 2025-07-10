package newmvcproject.blood.model;

/*
 * Since the model is a code in which business logic is implemented, it is subject to reuse.
 * The developer's effort is the most.
 */
public class BloodManager {
	public String getAdvice(String item) {
	
		String msg = "";
		if (item == null)
			item = "";

		if (item.equals("A")) {
			msg = "신중하고 꼼꼼하다";
		} else if (item.equals("B")) {
			msg = "자유롭고 개성 강함";
		} else if (item.equals("O")) {
			msg = "외향적이고 리더십이 있다.";
		} else if (item.equals("AB")) {
			msg = "이성적이고 독특하다";
		}

		return msg;
	}
}