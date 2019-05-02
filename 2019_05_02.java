class Solution {
  public String solution(int n) {
      String answer = "";
      
      int remainder = 0;

      while(true){
	    if(n%3 == 1){
	        remainder = 1;	
	    }else if(n%3 == 2){
	        remainder = 2;	
	    }else if(n%3 == 0){
	        remainder = 4;	
	    }
	    answer = remainder + answer;
	    if(n/3 == 0){
	    	break;	
	    }
	
      if(n%3 == 0){
	    	n = n/3-1;
	   }else{
	    	n = n/3;	
    	}
          if(n==0){
              break;
          }
      }
      
      return answer;
  }
}
