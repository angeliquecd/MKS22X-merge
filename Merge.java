import java.util.Random;
public class Merge{
  public static void mergesort(int[] data){
    mergehelper(data,data);}
    public static void mergehelper(int[] data, int[] stored){
    int hi =data.length;
    int lo = 0;//kind of unnecessary
    if (hi<=1) return ;
    int leftlength = hi/2;
    int rightlength=leftlength;
    if (hi%2 ==1) rightlength+=1;
    int [] leftside= new int[leftlength];
    int [] rightside = new int[rightlength];
  //  System.out.println("length of left side: "+leftside.length+"length of right side: "+rightside.length);
    for (int h=0;h<data.length;h++){
    //  System.out.println(h);
      if (h<leftlength) leftside[h]=data[h];
      else rightside[h-leftlength]=data[h];//fills up correct arrays and splits in half
    }
    mergehelper(rightside,stored);
    mergehelper(leftside,stored);//changed wrapper function because i was having trouble with return values
    data=merge(leftside,rightside, data);
  }
    public static int[] merge (int[] rightside, int[] leftside, int[] empty){
    //merge part
    int total = rightside.length + leftside.length;//total length
  //  int[] empty=new int[total];
    int i =0;//for left
    int j=0;//for right
    int inc =0;
    //    System.out.println("left side: ");
      //  printarray(leftside);
    //    System.out.println("right side: ");
      //  printarray(rightside);
    while (inc<total){
    if(i<leftside.length && j<rightside.length){
      if (leftside[i]<rightside[j]){//compares stuff
      empty[inc]=leftside[i];
      i++;}//increments within the right list
      else{
        empty[inc]=rightside[j];
        j++;}
      inc++;//moves forward in new array
    //System.out.println("final: ");
  //  printarray(data);
    System.out.println("left side: ");
  printarray(leftside);
    System.out.println("right side: ");
    printarray(rightside);
}
else {
  if (i>=leftside.length){
    while (j<rightside.length){
      empty[inc]=rightside[j];//fills in for if values are not perfectly alternating
      j++;
    inc++;}
  }
  if (j>=rightside.length){
    while(i<leftside.length){
      empty[inc]=leftside[i];//same as above but for other side
      i++;
      inc++;
    }
  }
}
}
    System.out.println("total array: ");
printarray(empty);
return empty;
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
  //  int[] nums = {1, 5,6,3,4};
    printarray(nums);
    mergesort(nums);
     printarray(nums);
  }
}
