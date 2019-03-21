import java.util.Random;
public class Merge{
  public static void mergesort(int[] data){
    data=mergehelper(data, 0,data.length,data.length);
  }
  public static int[] mergehelper(int[] data,int lo, int hi,int total){
    if (hi-lo<=1) return data;
    int leftlength = hi/2;
    int rightlength=leftlength;
    if (hi%2 ==1) rightlength+=1;
    int [] leftside= new int[leftlength];
    int [] rightside = new int[rightlength];
  //  System.out.println("length of left side: "+leftside.length+"length of right side: "+rightside.length);
    for (int h=0;h<data.length;h++){
    //  System.out.println(h);
      if (h<leftlength) leftside[h]=data[h];
      else rightside[h-leftlength]=data[h];//fills up correct arrays
    }
  //  printarray(leftside);
    //printarray(rightside);
    mergehelper(rightside, 0, rightlength,total);
    mergehelper(leftside,0, leftlength,total);
    int[] empty = new int[total];
  merge(rightside,leftside,empty);
  printarray(empty);
return empty;}
    public static void merge (int[] rightside, int[] leftside,int[] data){
    //merge part
    int i =0;
    int j=0;
    int inc =0;
    //    System.out.println("left side: ");
      //  printarray(leftside);
    //    System.out.println("right side: ");
      //  printarray(rightside);
    while(i<leftside.length && j<rightside.length){
      if (leftside[i]>rightside[j]){//compares stuff
      data[inc]=rightside[j];
      j++;}//increments within the right list
      else{
        data[inc]=leftside[i];
        i++;}
      inc++;
    }
    System.out.println("final: ");
    printarray(data);
//    System.out.println("left side: ");
  //  printarray(leftside);
//    System.out.println("right side: ");
  //  printarray(rightside);
  }
  public static void printarray(int [] data){
    for (int a: data){
      System.out.print(a+" ");
    }
    System.out.println();
  }
  public static void main (String[] args){
    Random rng = new Random();
  /*  int [] nums = new int[6];
    for (int i=0;i<6;i++){
      nums[i]=Math.abs(rng.nextInt()%20);
    }*/
    int[] nums = {1, 5,6,3,4};
    printarray(nums);
    mergesort(nums);
      printarray(nums);
  }
}
