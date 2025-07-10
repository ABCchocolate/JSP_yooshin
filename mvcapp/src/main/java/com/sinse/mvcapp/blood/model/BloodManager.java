package com.sinse.mvcapp.blood.model;

public class BloodManager {
	public String getAdvice(String bloodType) {
		 String msg ="";
			if(bloodType == null) bloodType = "";
			
		    if(bloodType.equals("A")){
		        msg = "신중하고 꼼꼼하다";
		    }
		    else if(bloodType.equals("B")){
		        msg = "자유롭고 개성 강함";
		    }
		    else if(bloodType.equals("O")){
		        msg = "외향적이고 리더십이 있다.";
		    }
		    else if(bloodType.equals("AB")){
		        msg = "이성적이고 독특하다";
		    }
		    return msg;
	}
}
