//프로그래머스 - 프린터

import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        ArrayList<Integer> prioritiesList = new ArrayList<>();
        ArrayList<Integer> prioritiesListOrder = new ArrayList<>();
        for(int prior : priorities){
          prioritiesList.add(prior);
        }
        for(int i=0;i<priorities.length;i++){
            prioritiesListOrder.add(i);
        }
        
        
        while(true){
           int max = 0;
           for (int index = 1; index < prioritiesList.size(); index++) {
               if(prioritiesList.get(max) < prioritiesList.get(index)){
                    max = index; 
                }  
            }
          
          if(max != 0){
              answer++;
              if(prioritiesListOrder.get(max) == location){
                  break;
              }
              // 중요도 높은 문서 출력
              prioritiesList.remove(max);
              prioritiesListOrder.remove(max);
              for(int i=0; i<max; i++){
                  // 마지막으로 보내기
                  int add = prioritiesList.get(0);
                  int add_order = prioritiesListOrder.get(0);
                  prioritiesList.remove(0);
                  prioritiesList.add(add);  
                  prioritiesListOrder.remove(0);
                  prioritiesListOrder.add(add_order);
              }    
          }else{
              // 첫 문서가 가장 큰 값일 때
              if(prioritiesListOrder.get(0) == location && prioritiesList.size()==priorities.length){
                answer++;   
                  break;
              }else if(prioritiesListOrder.get(0) == location){
                    answer++;                
                  break;
              }else{
                  prioritiesList.remove(0);
                  prioritiesListOrder.remove(0);
                  answer++;
              }
          }

        }
        
        
        
        return answer;
    }
}
