//1 10 11 100 101 110 111 110
public class Test {
	public static void main(String[] args) {
		System.out.println((int)' ');
	}
	
	public static void sortBuddle(int[] arr){
		
		for(int i = 0; i < arr.length; i++){
			boolean tag = false;
			for(int j = 0; j < arr.length - i - 1; j++){
				if(arr[j] > arr[j+1]){
					arr[j] = arr[j] ^ arr[j+1];
					arr[j+1] = arr[j] ^ arr[j+1];
					arr[j] = arr[j] ^ arr[j+1];
					tag = true;
				}
			}
			if(!tag)
				break;
		}
	}
}

	

