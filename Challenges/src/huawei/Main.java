package huawei;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i=0;i<n;i++){
            int peopleNum = in.nextInt();
            int num  = in.nextInt();
            LinkedList list = new LinkedList();
            int tempIndex = 0;
            for(int j=0;j<peopleNum;j++){
                list.add(j+1);
            }
            while(list.size()>0){
                System.out.print(list.get((tempIndex+num)%list.size())+" ");
                tempIndex = (tempIndex+num)%list.size();
                list.remove(tempIndex);
            }
            System.out.println();
        }
    }
}