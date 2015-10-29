import java.applet.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.lang.*;

public class PreemptivePriorityLow {

	static int totalBert[];
	static int priority[];
	static int i = 0;
	int n;
	static int n1;
	

	public static void main(String[] args) throws FileNotFoundException {

		Scanner readfile1 = new Scanner(new File("/Users/kennykadilov/Documents/workspace/OS2/src/input3.data"));
		PrintWriter writefile1 = new PrintWriter("/Users/kennykadilov/Documents/workspace/OS2/src/output3.data");

		int n = readfile1.nextInt();
		System.out.println("Number of processes is " + n);

		int rr = readfile1.nextInt();
		int preamtive = readfile1.nextInt();
		if (rr > 0 || preamtive > 0) {
			System.out.println("Preemptive");
		}

		else {
			System.out.println("not RR nor preemptive");
		}
		totalBert = new int[100];
		priority = new int[100];
		int parray[][] = new int[n][4];
		int a[] = new int[n];	
		int b[] = new int[n];
		int count = 0; 
		int	total = 0;
		int vr1 = 0; 
		int vr2 = 0; 
		int sp = 0; 
		int	sp1 = 0; 
		int	x = 0;
		int snum; 

		
		
		
//		pro[0][0]=0;
//		pro[0][2]=readfile1.nextInt();
//		System.out.println(pro[0][2]);
//		pro[0][3]=readfile1.nextInt();
//		System.out.println(pro[0][3]);
//		pro[0][1]=readfile1.nextInt();
//		System.out.println(pro[0][1]);
//
//		
//		pro[1][0]=0;
//		pro[1][2]=readfile1.nextInt();
//		System.out.println(pro[1][2]);
//		pro[1][3]=readfile1.nextInt();
//		System.out.println(pro[1][3]);
//		pro[1][1]=readfile1.nextInt();
//		System.out.println(pro[1][1]);
//
//		
//		pro[0][0]=0;
//		pro[0][2]=1;
//		pro[0][3]=2;
//		pro[0][1]=3;
//		
//		pro[0][0]=0;
//		pro[0][2]=1;
//		pro[0][3]=2;
//		pro[0][1]=3;
						
	System.out.println("Table");
	System.out.println("Process\tArrival\tBurst\tPriority");

		
			for (int i = 0; i < n; i++) {
				parray[i][0] = i;
				System.out.print("P"+(i+1)+"\t ");
				parray[i][2] = readfile1.nextInt();
				System.out.print(parray[i][2]+" \t");
				parray[i][3] = readfile1.nextInt();
				total += parray[i][3];
				System.out.print(parray[i][3]+" \t");
				parray[i][1] = readfile1.nextInt();
				System.out.println(parray[i][1]+" ");


			}



			for (int i = 1; i <= total; i++) {
				snum=100;
				for (int j = vr2; j < n; j++)
					if (vr1 >= parray[j][2])
						vr2++;
				for (int j = 0; j < vr2; j++) {
					if (snum > parray[j][1] && parray[j][3] != 0) {
						snum = parray[j][1];
						sp = parray[j][0];
						sp1 = j;
					}
				}
				if (priority[x] == sp) {
					totalBert[x + 1]++;

				} else {
					x++;
					priority[x] = sp;
					totalBert[x + 1] = totalBert[x];
				    //System.out.println(totalBert);
					totalBert[x + 1]++;
					count++;
				}

				parray[sp1][3] -= 1;
				if (parray[sp1][3] == 0)
					b[sp1] = i;

				for (int j = 0; j < n; j++) {
					if (parray[j][3] != 0 && j != sp)
						a[j] += 1;
				}
				vr1++;
			}
			for (int i = 0; i < n; i++)
				for (int j = i + 1; j < n; j++)
					if (parray[i][0] > parray[j][0]) {
						int temp[] = parray[i];
						parray[i] = parray[j];
						parray[j] = temp;
						int tem = a[i], tem1 = b[i];
						a[i] = a[j];
						a[j] = tem;
						b[i] = b[j];
						b[j] = tem1;

					}


			for (int m = 0; m <= count; m++)
				priority[m] += 1;

		//	double awt = 0.0, att = 0.0;

			System.out.println();
		
			
	
			n1 = count + 1;
			System.out.println("Output\n");
			for (int j = 1; j <= n1; j++) {
				
				System.out.print(totalBert[j - 1]+" ");
				writefile1.print(totalBert[j - 1]+" ");
				System.out.print(totalBert[j]+ " ");
				writefile1.print(totalBert[j]+ " ");
				System.out.print(priority[j - 1]+" \n ");
				writefile1.print(priority[j - 1]+" \n ");


			}
			
			writefile1.close();


		}

		}
	
//Number of processes is 4
//Preemptive
//Table
//Process	Arrival	Burst	Priority
//P1		 0 		7 		5 
//P2		 1 		4 		1 
//P3		 2 		9 		4 
//P4		 3 		5 		3 
//
//Output
//
// 0 1 1 
// 1 5 2 
// 5 10 4 
// 10 19 3 
// 19 25 1 
// 

//Output for input2.data

//Number of processes is 4
//Preemptive
//Table
//Process	Arrival	Burst	Priority
//P1	 0 	5 	8 
//P2	 1 	4 	1 
//P3	 2 	5 	3 
//P4	 3 	9 	4 
//
//Output
//
// 0 1 1 
// 1 5 2 
// 5 10 3 
// 10 19 4 
// 19 23 1 
// 

//Output for input3.data


//Number of processes is 4
//Preemptive
//Table
//Process	Arrival	Burst	Priority
//P1		0 		5 		5	 
//P2	 	1 		4 		3 
//P3	 	2 		5 		1 
//P4	 	3 		9 		4 
//
//Output
//
// 0 1 1 
// 1 2 2 
// 2 7 3 
// 7 10 2 
// 10 19 4 
// 19 23 1 
// 