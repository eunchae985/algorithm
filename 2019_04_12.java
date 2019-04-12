// 영어 끝말잇기


2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28
29
30
31
32
33
34
35
36
37
38
39
40
41
42
43
44
45
46
47
48
49
50
51
52
53
54
55
//n :  참여수, words : 입력단어
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int i=0;
        int turn=1; //말한 사람 번호

        String current; //현재 말한 단어
        String prev; //바로 전에 말한 단어

        int break_exist = 0;

        while(true){
            if(i!=0){
                //앞에 말한거 있을 때
                for(int j=0; j<i; j++){
                    if(words[j].equals(words[i])){
                        answer[0] = turn;
                        answer[1] = i/n+1;
                        break_exist = 1;
                        break;
                    }
                }
                if(break_exist == 1){
                    break;
                }

                // 앞단어와 뒷단어 글자가 다를때
                current=words[i].substring(0, 1);
                prev=words[i-1].substring(words[i-1].length()-1, words[i-1].length());         
                if(!prev.equals(current)){
                    answer[0] = turn;
                    answer[1] = i/n+1;
                    break;
                }
            }            

            //모두 맞음
            if(words.length-1==i){
                answer[0] = 0;
                answer[1] = 0;
                break;
            }
            i++;
            if(turn==n){
                turn=1;
            }else{
                turn++;
            }
        }

        return answer;
    }
}
