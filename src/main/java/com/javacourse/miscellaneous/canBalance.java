package com.javacourse.miscellaneous;

public class canBalance {
	public static boolean canBalance(int[] nums) {
		  boolean balanced = false;
		  int index = 0;
		  while(!balanced){
		    int sumLeft = 0;
		    int sumRight = 0;
		    for(int i = 0; i<nums.length; i++){
		      if(i<=index)sumLeft+=nums[i];
		      if(i>index)sumRight+=nums[i];
		    }
		    if(index==nums.length-1) break;
		    if(sumLeft==sumRight)balanced = true;
		    index++;
		  }
		  return balanced;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(canBalance(new int[] {1,1,1,2,1}));
	}

}
