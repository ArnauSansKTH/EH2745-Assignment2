package Project2Package;

public class KNN {

	// Where the points to classify will be classified depending on the cluster
	static double[][] cluster1= new double[20][18];
	static double[][] cluster2= new double[20][18];
	static double[][] cluster3= new double[20][18];
	static double[][] cluster4= new double[20][18];
	
	static Double[][] dObj1 = new Double [20][18];
	static Double[][] dObj2 = new Double [20][18];
	static Double[][] dObj3 = new Double [20][18];
	static Double[][] dObj4 = new Double [20][18];
	

	public static void run(String USERN, String PASSW) {
		
		int k=5; // Number of the nearest neighbors
		
		//Run the Kmeans
		Kmeans objKMean = new Kmeans();
		objKMean.KMeansMethod(USERN, PASSW);
		double[][] initial1= objKMean.getCluster1();
		double[][] initial2= objKMean.getCluster2();
		double[][] initial3= objKMean.getCluster3();
		double[][] initial4= objKMean.getCluster4();
		objKMean.printingClusters(initial1, initial2, initial3, initial4);
		double[][] C1= objKMean.getFinalC1();
		double[][] C2= objKMean.getFinalC2();
		double[][] C3= objKMean.getFinalC3();
		double[][] C4= objKMean.getFinalC4();
		int coun1= objKMean.getCounter1();
		int coun2= objKMean.getCounter2();
		int coun3= objKMean.getCounter3();
		int coun4= objKMean.getCounter4();
		
		//Extract the point to classify from the Database
		PointbyPoint obj2= new PointbyPoint(USERN, PASSW);
		double[][] analog= obj2.pointOfAnalog();
		double[][] NORManalog= obj2.NormAnalogValues(analog);
		
		//Get the points in each cluster and the number of points
		objKMean.DeNorm(C1, C2, C3, C4, coun1, coun2, coun3, coun4,USERN, PASSW);;
		double[] meanVoltAng1 = objKMean.getMeanVoltAng1();
		double[] meanVoltAng2 = objKMean.getMeanVoltAng2();
		double[] meanVoltAng3 = objKMean.getMeanVoltAng3();
		double[] meanVoltAng4 = objKMean.getMeanVoltAng4();
		objKMean.labelClusters(meanVoltAng1, meanVoltAng2, meanVoltAng3, meanVoltAng4);
		
		
		//Iterate for the 20 points to classify
		for(int iter=0; iter<20; iter++){
			Classification obj3 = new Classification();
			//Calculate distance from this point to all the 200 points
			obj3.distanceCalc(C1, C2, C3, C4, coun1, coun2, coun3, coun4, NORManalog, iter);
			double[][] distance1= obj3.getDistance1(); 
			double[][] distance2= obj3.getDistance2();
			double[][] distance3= obj3.getDistance3();
			double[][] distance4= obj3.getDistance4();	
			
			//Merge all the distances in a 2D Double
			double[][] theArray= obj3.mergeArray(distance1, distance2, distance3, distance4, coun1, coun2, coun3, coun4);
			
			//Sort all the distances
			double[][] SortedArray= obj3.Sort(theArray);
			
			int[] count= new int[4];
			for (int i=0; i<k; i++){
				for(int j=1; j<k; j++){
					if(SortedArray[i][1]==j){
						count[j-1]++;					
					}
				}
			}
			
			
           ////////////Filling each cluster with related points ///////////
			if(count[0]>count[1]&&count[0]>count[2]&&count[0]>count[3]){
				for(int j=0; j<18; j++){
					cluster1[iter][j]= NORManalog[iter][j];
					dObj1[iter][j] = cluster1[iter][j];
				}
			}else if(count[1]>count[0]&&count[1]>count[2]&&count[1]>count[3]){
					for(int j=0; j<18; j++){
						cluster2[iter][j]= NORManalog[iter][j];
						dObj2[iter][j] = cluster2[iter][j];
					}
				}else if(count[2]>count[0]&&count[2]>count[1]&&count[2]>count[3]){
						for(int j=0; j<18; j++){
							cluster3[iter][j]= NORManalog[iter][j];
							dObj3[iter][j] = cluster3[iter][j];
						}
					}else{
							for(int j=0; j<18; j++){
								cluster4[iter][j]= NORManalog[iter][j];
								dObj4[iter][j] = cluster4[iter][j];
							}
						}

			
			}// End 20 iteration 
		

		
               ////////Final Cluster 1 //////////
		        System.out.print("\n");
		        System.out.println("\n *** KNN Classification 1 *** ");
		        System.out.print("\n");
				for(int i=0; i<20; i++){
					double sum=0;
					for(int j=0; j<18; j++){
						sum=sum+cluster1[i][j];
					}
					if(sum!=0){
						for(int j=0; j<18; j++){
							System.out.print(cluster1[i][j]+"\t");
						}
						System.out.println("\n");
					}
				}
		        ////////Final Cluster 2 //////////
		        System.out.println("\n *** KNN Classification 2 *** ");
		        System.out.print("\n");
				for(int i=0; i<20; i++){
					double sum=0;
					for(int j=0; j<18; j++){
						sum=sum+cluster2[i][j];
					}
					if(sum!=0){
						for(int j=0; j<18; j++){
							System.out.print(cluster2[i][j]+"\t");
						}
						System.out.println("\n");
					}
				}
		        ////////Final Cluster 3 //////////
		        System.out.println("\n *** KNN Classification 3 *** ");
		        System.out.print("\n");
				for(int i=0; i<20; i++){
					double sum=0;
					for(int j=0; j<18; j++){
						sum=sum+cluster3[i][j];
					}
					if(sum!=0){
						for(int j=0; j<18; j++){
							System.out.print(cluster3[i][j]+"\t");
						}
						System.out.println("\n");
					}
				}
		        ////////Final Cluster 4 //////////
		        System.out.println("\n *** KNN Classification 4 *** ");
		        System.out.print("\n");
				for(int i=0; i<20; i++){
					double sum=0;
					for(int j=0; j<18; j++){
						sum=sum+cluster4[i][j];
					}
					if(sum!=0){
						for(int j=0; j<18; j++){
							System.out.print(cluster4[i][j]+"\t");
						}
						System.out.println("\n");
					}
				}
				

	}// End main method
	
	public static Double[][] getClusterFinal1(){
		return dObj1;
	}
	
	public static Double[][] getClusterFinal2(){
		return dObj2;
	}
	
	public static Double[][] getClusterFinal3(){
		return dObj3;
	}
	
	public static Double[][] getClusterFinal4(){
		return dObj4;
	}

}// End Class
