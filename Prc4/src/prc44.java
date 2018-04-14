
public class prc44 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] numbers = new int[3];
		numbers[0] = 3;
		numbers[1] = 4;
		numbers[2] = 9;
		
		System.out.println("１桁の数字を入力してください。");
		int input = new java.util.Scanner(System.in).nextInt();
		
		for(int i = 0;i < numbers.length;i++){
			if(input==numbers[i])
				System.out.println("アタリ！");
		}

	}

}