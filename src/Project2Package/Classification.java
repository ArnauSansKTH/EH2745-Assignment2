package Project2Package;
import java.util.Arrays;
import java.util.Comparator;

public class Classification {	
	
/////////////////////////////////////////////////////////////////////////////////////////////
///// Distance between each point to classify and each point of each Cluster/////////////////
/////////////////////////////////////////////////////////////////////////////////////////////
	
	
	// Distance and points for each cluster points with 1 point to classify
	double[][] distance1 = new double[2][200];
	double[][] distance2 = new double[2][200];
	double[][] distance3 = new double[2][200];
	double[][] distance4 = new double[2][200];
	
	public void distanceCalc(double[][] C1, double[][] C2, double[][] C3, double[][] C4, 
			                 int coun1, int coun2, int coun3, int coun4, double[][] NORManalog, int iter){
		
		
		//Create a row with cluster numbers
		for(int i=0; i<coun1; i++){
			distance1[1][i]=1;
		}
		for(int i=0; i<coun2; i++){
			distance2[1][i]=2;
		}
		for(int i=0; i<coun3; i++){
			distance3[1][i]=3;
		}
		for(int i=0; i<coun4; i++){
			distance4[1][i]=4;
		}
				
	////// Calculate Euclidean Distance for Cluster 1 ////////
				for(int i=0; i<coun1; i++){
					double distance=0;
					double sum=0;
						for(int k=0; k<18; k++){
					        sum = sum + Math.pow((C1[i][k] - NORManalog[iter][k]),2); 
						}
						distance = Math.sqrt(sum);
						distance1[0][i]=distance;
				}
	////// Calculate Euclidean Distance for Cluster 2 ////////
				for(int i=0; i<coun2; i++){
					double distance=0;
					double sum=0;
						for(int k=0; k<18; k++){
							      sum = sum + Math.pow((C2[i][k] - NORManalog[iter][k]),2); 
						}
						distance = Math.sqrt(sum);
						distance2[0][i]=distance;
						}
	////// Calculate Euclidean Distance for Cluster 3 ////////
				for(int i=0; i<coun3; i++){
					double distance=0;
					double sum=0;
						for(int k=0; k<18; k++){
							      sum = sum + Math.pow((C3[i][k] - NORManalog[iter][k]),2); 
						}
						distance = Math.sqrt(sum);
						distance3[0][i]=distance;
						}
	////// Calculate Euclidean Distance for Cluster 4 ////////
				for(int i=0; i<coun4; i++){
					double distance=0;
					double sum=0;
						for(int k=0; k<18; k++){
							      sum = sum + Math.pow((C4[i][k] - NORManalog[iter][k]),2); 
						}
						distance = Math.sqrt(sum);
						distance4[0][i]=distance;

						}								
	}// End distanceCalc Method
	
	public double[][] getDistance1(){
		return distance1;
	}
	public double[][] getDistance2(){
		return distance2;
	}
	public double[][] getDistance3(){
		return distance3;
	}
	public double[][] getDistance4(){
		return distance4;
	}
	
	/////////////////////////////////////////////////////////////
	///// Mergin the distances from 4 clusters in an Array///////
	/////////////////////////////////////////////////////////////
	
	double[][] DistArray = new double[200][2]; //200 distances and cluster number
	
	public double[][] mergeArray(double[][] distance1, double[][] distance2, double[][] distance3, double[][] distance4,
			                     int coun1, int coun2, int coun3, int coun4){
	
		//Distances cluster 1
		for(int i=0; i<coun1; i++){
				for(int k=0; k<2; k++){
					DistArray[i][k]=distance1[k][i];
				}
		}
		
		//Distances cluster 2
		for(int i=coun1; i<coun1+coun2; i++){
				for(int k=0; k<2; k++){
					DistArray[i][k]=distance2[k][i-coun1];
				}
		}
		
		//Distances cluster 3
		for(int i=coun1+coun2; i<coun1+coun2+coun3; i++){
			for(int k=0; k<2; k++){
				DistArray[i][k]=distance3[k][i-coun1-coun2];
			}
	    }
		
		//Distances cluster 4
		for(int i=coun1+coun2+coun3; i<200; i++){
			for(int k=0; k<2; k++){
				DistArray[i][k]=distance4[k][i-coun1-coun2-coun3];
			}
	    }		
		return DistArray;	
	}	
	
	
	/////////////////////////////////////////////////////////////
	////////////////// Sorting the array ////////////////////////
	/////////////////////////////////////////////////////////////
	
	public double[][] Sort(double[][] theArray){   
	    Arrays.sort(theArray, new Comparator<double[]>(){
	        @Override
	        public int compare(double[] int1, double[] int2){
	            Double numOfKeys1 = int1[0];
	            Double numOfKeys2 = int2[0];
	            return numOfKeys1.compareTo(numOfKeys2);
	        }
	    });
		return theArray;  //Return the Array sorted  
	}
	
	
	
	
}// End Clasification class

		
