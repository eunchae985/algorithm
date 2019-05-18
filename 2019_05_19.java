import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int max_plays = 0;
        int answer_i = 0;
        ArrayList<Integer> answerList = new ArrayList<>();
        ArrayList<Integer> playList = new ArrayList<>();
        ArrayList<String> genresList = new ArrayList<>();
        for (int i = 0; i < plays.length; i++) {
            playList.add(plays[i]);
        }
        for (int i = 0; i < genres.length; i++) {
            genresList.add(genres[i]);
        }
        
        // 장르별 재생수 합친거 구하기
        HashMap<String, Integer> playListMap = new HashMap();
        for (int i = 0; i < plays.length; i++) {
            if(playListMap.containsKey(genres[i])){
                playListMap.put(genres[i], playListMap.get(genres[i]) + plays[i]);
            }else{
                playListMap.put(genres[i], plays[i]);
            }        
        }
        
        ValueComparator bvc =  new ValueComparator(playListMap);
        TreeMap<String,Integer> sorted_map = new TreeMap<String,Integer>(bvc);
 
        sorted_map.putAll(playListMap);
         String present_genres = "";
        int same = -1;
        for (Map.Entry<String,Integer> entry : sorted_map.entrySet()) {
            int put = 0;
            present_genres = entry.getKey();
            
           while(true){
               if(put==2){
                   break;
               }
            if(put == 1){
               // 재생목록에 장르가 1개 있을 때
                if(genresList.contains(present_genres)==false){
                    break;
                }
                for (int i = 0; i < genresList.size(); i++) {
                    if(genresList.get(i).equals(present_genres)){
                        max_plays = i;
                        break;
                    }
                }
               
                if(! (max_plays+1 > playList.size()) ){
                 for (int i = max_plays+1; i < playList.size(); i++) {
                   if(genresList.get(i).equals(present_genres)){
                        if(playList.get(max_plays) < playList.get(i)){
                           max_plays = i;
                        }
                   }
                 }
                }
                // 원래 있던 번호 찾기
                int answer_idx = 0;
                for(int i=0; i<plays.length; i++){
                    if(playList.get(max_plays) == plays[i] && same!=i){
                        answer_idx = i;
                        break;
                    }
                }
                   answerList.add(answer_idx);
                   playList.remove(max_plays);
                   genresList.remove(max_plays);
                    
                  //같은 장르에 곡 모두 삭제 
                  for (int i = 0; i < playList.size(); i++) {
                   if(genresList.get(i).equals(present_genres)){
                        playList.remove(i);
                        genresList.remove(i);
                       i--;
                   }
                  }
                   put = 2;
                
            }else{
                for(int i=0; i<genresList.size(); i++){
                    if(genresList.get(i).equals(present_genres)){
                        max_plays = i;
                    }
                }
                // 재생수가 가장 많은 횟수
                for (int i = 0; i < playList.size(); i++) {
                   if(genresList.get(i).equals(present_genres)){
                        if(playList.get(max_plays) < playList.get(i)){
                           max_plays = i;
                       }
                	}
                }
                // 원래 있던 번호 찾기
                int answer_idx = 0;
                for(int i=0; i<plays.length; i++){
                    if(playList.get(max_plays) == plays[i]){
                        answer_idx = i;
                        break;
                    }
                }
                same = answer_idx;
                answerList.add(answer_idx);
                present_genres = genresList.get(max_plays); //현재 선택된 장르
                playList.remove(max_plays);
                genresList.remove(max_plays);
                put = 1;
            }
           }
           
        }


        int[] answer = new int[answerList.size()];
        for (int i=0; i < answer.length; i++)
        {
            answer[i] = answerList.get(i).intValue();
            System.out.println(answer[i]);
        }
         
        return answer;
    }
}

class ValueComparator implements Comparator<String> {
 
    Map<String, Integer> base;
     
    public ValueComparator(Map<String, Integer> base) {
        this.base = base;
    }
     
    public int compare(String a, String b) {
        if (base.get(a) >= base.get(b)) { 
            return -1;
        } else {
            return 1;
        } 
    }
}
