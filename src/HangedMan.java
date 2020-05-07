/*
 * The HangMan() Class object could implement an interface, if you want. 
 * It will need String variables to set up the display. 
 * (Ex. The man hanging, the blanks for the answer _ _ _ _, etc.)
 * 
 * 1. Getters and setters
 * 2. A list with possible words
 * 3. A method that fills that list based on a text file as soon as the Class Object is created
 * 4. A method to select a random word, stores it as variable inside class
 * 5. String with blanks _ _ _ _, the number of blanks depending on the “word”
 * 6. Method that replaces a blank with appropriate letter if there’s a match
 * 7. ….continued
 */

public class HangedMan implements HangManInterface {
	private String myLeftArm;
	private String myRightArm;
	private String myLeftLeg;
	private String myRightLeg;
	private String myHead;
	private String myBody;
	
	public void setLeftArm(String myLeftArm) {
		this.myLeftArm = myLeftArm;
	}
	
	public void setRightArm(String myRightArm) {
		this.myRightArm = myRightArm;
	}
	
	public void setLeftLeg(String myLeftLeg) {
		this.myLeftLeg = myLeftLeg;
	}
	
	public void setRightLeg(String myRightLeg) {
		this.myRightLeg = myRightLeg;
	}
	
	public void setHead(String myHead) {
		this.myHead = myHead;
	}
	
	public void setBody(String myBody) {
		this.myBody = myBody;
	}
	
	public String getLeftArm () {
		return myLeftArm;
	}
	
	public String getRightArm () {
		return myRightArm;
	}
	
	public String getLeftLeg () {
		return myLeftLeg;
	}
	
	public String getRightLeg() {
		return myRightLeg;
	}
	
	public String getHead() {
		return myHead;
	}
	
	public String getBody() {
		return myBody;
	}
			
	@Override
	public String toString() {
		return "";
	}

	@Override
	public String myLeftArm() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String myRightArm() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String myHead() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String myLeftLeg() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String myRightLeg() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String myBody() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
