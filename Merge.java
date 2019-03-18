import java.util.Random;
public class Merge{
  public static void mergesort(int[] data){
    int[] temp = new int[data.length];
    mergehelper(data, temp,0,data.length-1);
  }
  public static void mergehelper(int[] data, int[] temp, int lo, int hi){
    if (lo>=hi) return;
    mergehelper(data,temp,lo, (lo+hi)/2);
    mergehelper(data,temp,(lo+hi)/2+1,hi);
    int [] leftside= new int[(lo+hi)/2];
    int [] rightside = new int[(lo+hi)/2];
    for (int h=0;h<(hi-lo);h++){
      if (h<=(lo+hi)/2){
        leftside[h]=data[lo];}
      else{
        rightside[h-(lo+hi)/2]=data[lo];}
    }
    int i =0;
    int j=0;
    int inc =0;
    while(i<leftside.length && j<rightside.length){
      if (leftside[i]>rightside[j]){
      temp[inc]=rightside[j];
      j++;}
      else{
        temp[inc]=leftside[i];
        i++;}
      inc++;
    }
    System.out.println("left side: ");
    printarray(leftside);
    System.out.println("right side: ");
    printarray(rightside);
  }
  public static void printarray(int [] data){
    for (int a: data){
      System.out.print(a+" ");
    }
    System.out.println();
  }
  public static void main (String[] args){
    Random rng = new Random();
    int [] nums = new int[6];
    for (int i=0;i<6;i++){
      nums[i]=Math.abs(rng.nextInt()%20);
    }
    printarray(nums);
    mergesort(nums);
      printarray(nums);
  }
}
