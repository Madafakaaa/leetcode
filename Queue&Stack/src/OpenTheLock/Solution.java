package OpenTheLock;

class Solution {

    public int openLock(String[] deadends, String target) {
        int[] array = new int[10000];
        for(int i=0;i<array.length;i++) array[i] = -1;
        for(String s : deadends) array[Integer.parseInt(s)] = -2;
        if(array[0]==-2) return -1;
        array[Integer.parseInt(target)] = 0;
        int step = 0;
        int count;
        int[] newNumbers = new int[8];
        int fig1, fig2, fig3, fig4;
        while(true){
            count = 0;
            for(int i=0;i<array.length;i++){
                if(array[i]==step){
                    fig1 = i/1000%10;
                    fig2 = i/100%10;
                    fig3 = i/10%10;
                    fig4 = i/1%10;
                    newNumbers[0] = 1000*fig1+100*fig2+10*fig3+1*((fig4+1)%10);
                    newNumbers[1] = 1000*fig1+100*fig2+10*fig3+1*((fig4+9)%10);
                    newNumbers[2] = 1000*fig1+100*fig2+10*((fig3+1)%10)+1*fig4;
                    newNumbers[3] = 1000*fig1+100*fig2+10*((fig3+9)%10)+1*fig4;
                    newNumbers[4] = 1000*fig1+100*((fig2+1)%10)+10*fig3+1*fig4;
                    newNumbers[5] = 1000*fig1+100*((fig2+9)%10)+10*fig3+1*fig4;
                    newNumbers[6] = 1000*((fig1+1)%10)+100*fig2+10*fig3+1*fig4;
                    newNumbers[7] = 1000*((fig1+9)%10)+100*fig2+10*fig3+1*fig4;
                    for(int n : newNumbers){
                        if(array[n]==-1){
                            array[n] = step+1;
                            count++;
                        }
                    }
                }
            }
            if(array[0]!=-1||count==0) break;
            step++;
        }
        return array[0];
    }

}
