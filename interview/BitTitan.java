import java.util.*;

public class BitTitan{
	
	public static void main (String[]args){
		BitTitan question = new BitTitan();
		int[] coins = {1,2,3};
		System.out.println("Number ways to change: " + question.three(4, coins));
		int[] coins2 = {2,3};
		System.out.println("Number ways to change: " + question.three(4, coins2));
	}

	/*
	Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = {
	S1, S2, .. , Sm} valued coins, how many ways can we make the change? The order of coins doesn’t
	matter.
	For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So
	output should be 4.
	*/
	public int three(int N, int[] coins){				
		// for a given coins, return whether it is changable by using the set of coins we have
		// value from 1->N
		boolean [] is_changable = new boolean[N+1];
		int[] number_ways_to_change = new int[N+1];
		// setup the default value
		for (int i=0; i<N+1; i++){
			is_changable[i] = false;
			number_ways_to_change[i] = 0;
		}
		// with 0 money, it is always changable 
		is_changable[0] = true;
		number_ways_to_change[0] = 1;
		//compute the result for coin value from 1->N
		for (int i=1; i<N+1; i++){						
			for (int coin: coins){
				//cannot exchange if the given value is smaller than the coin
				if (coin > i) continue;				
				// try to exchange, the result depends on previous result
				boolean try_success = is_changable[i-coin];
				if (try_success){
					number_ways_to_change[i] = number_ways_to_change[i] + number_ways_to_change[i-coin];
				}
				// update change boolean
				is_changable[i] = is_changable[i] || try_success;
			}
		}

		System.out.println(Arrays.toString(is_changable));
		return number_ways_to_change[N];
	}

}