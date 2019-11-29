package string;

public class StringCompression {
	
	public static void main(String[] args) {
		new StringCompression().compress(new char[] {'a','b','b','b','b','b','b','b','b','b','b','b','b'});
		new StringCompression().compress(new char[] {'a'});
		new StringCompression().compress(new char[] {'a','a',
				'b','b','c','c','c'});
//		new StringCompression().compress(new char[] {'a','a','a','a','a','a',
//				'a','a','a','a','a','a',
//				'b','b','c','c','c'});
	}
	
	public int compress(char[] chars) {
		int i = 0;
		int index = -1;
		if(chars.length == 1) {
			chars = new char[] {chars[0]};
			return 1;
		}
		while(i < chars.length) {
			int j = i + 1;
			while(j < chars.length && chars[i] == chars[j]) {
				j++;
			}
			int count = j-i;
			index++;
			chars[index] = chars[i];
			char[] countArray = ("" + count).toCharArray();
			for(int k = 0 ; k < countArray.length ; k++) {
				index++;
				chars[index] = countArray[k];
			}
			i += count;
		}		
		return index+1; 		
	}
	
	public int compress2(char[] chars) {
		int k = 0;
		StringBuilder result = new StringBuilder();
		for(int i = 0 ; i < chars.length ; i+=k) {
			int j = i+1;
			int count = 1;
			while(j < chars.length && chars[i] == chars[j]) {
				j++;
				count++;
			}
			result.append(chars[i]).append(count);
			k = count;
		}
		return 0;
	}
}
