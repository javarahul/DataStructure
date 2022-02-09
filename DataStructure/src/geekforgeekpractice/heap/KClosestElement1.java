import java.io.*;
import java.util.*;

class KClosestElement1{

public static void printKClosest(int arr[], int n, int k, int x)
{
    boolean[] visited=new boolean[n];
    
    for(int i=0;i<k;i++){
        
        int min_diff=Integer.MAX_VALUE;
        int min_diff_idx=0;
        
        for(int j=0;j<n;j++){
            if(visited[j]==false && Math.abs(arr[j]-x)<=min_diff){
                min_diff=Math.abs(arr[j]-x);
                min_diff_idx=j;
            }
        }
        System.out.print(arr[min_diff_idx]+" ");
        visited[min_diff_idx]=true;
    }
}

public static void main (String[] args)
{
	int arr[] = { 10,30,5,40,38,80,70 };

	int size = arr.length;

	int x=35; int k = 3;

	printKClosest(arr,size,k,x);
}
}
