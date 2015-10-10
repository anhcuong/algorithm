class Palindrome{
	public static void main(String[]args){

		System.out.println(isPalindrome(12321));
		System.out.println(isPalindrome(1232));
		System.out.println(isPalindrome(1234321));
		System.out.println(isPalindrome(12344321));
	}

	static boolean isPalindrome(int num){		
		String number = Integer.toString(num);

		int n = number.length();
		int i =0, j=n-1;
		while (i<n/2){

			if (number.charAt(i) == number.charAt(j)){
				i++;
				j--;
			}else{
				return false;
			}
		}
		return true;
	}
}