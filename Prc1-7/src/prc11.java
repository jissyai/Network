
public class prc11 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=100;i++){
			sb.append(i+",");
		}
		String s=sb.toString();
		System.out.println(s);
		
		String[] a=s.split("[,]");
		for(String w : a){
			System.out.print(w+"->");
		}
	}

}
