
public class prc42 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] moneyList = new int[3];
		moneyList[0] = 121902;
		moneyList[1] = 8302;
		moneyList[2] = 55100;
		
		for(int i = 0;i < moneyList.length;i++){
			System.out.println(moneyList[i]);
		}
		for(int value : moneyList){
			System.out.println(value);
		}

	}

}