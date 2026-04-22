class Solution {
    // static class Car implements Comparable<Car>{
    //     private int destination;
    //     private int position;
    //     private int speed;
    //     private double  timeToReach;
    //     public Car(int position,int speed,int destination){
    //         this.position=position;
    //         this.speed=speed;
    //         this.destination=destination;
    //     }
    //     double getTimeToReach(){
    //         return this.timeToReach;
    //     } 
    //     void timeToReach(){
    //         this.timeToReach=this.calcuateTime();
    //     }
    //     double calcuateTime(){
    //         return (double) getDistanceRemaining() / speed;
    //     }
    //     int getDistanceRemaining(){
    //         return destination - position;
    //     }
    //     public int compareTo(Car c) {
    //     // Sort movies in ascending order of year
    //     return c.position - this.position; 
    // }
    // }
    // public int carFleet(int target, int[] position, int[] speed) {
    //     int n=position.length;
    //     Car[] cars=new Car[n]; // extra space for calculating the timetoreach and storing  
    //     for(int i=0;i<n;i++){
    //         cars[i]=new Car(position[i],speed[i],target); //o(n) to store 
    //     }
    //     Arrays.sort(cars); //o(nlog n). sorting 
    //     int fleet=0;
    //     double time=0;
    //     for(int i=0;i<n;i++){  // again o(n)
    //         Car car = cars[i];
    //         car.timeToReach();
    //         if(time < 0 || car.getTimeToReach() > time ){
    //              fleet+=1;
    //              time=car.getTimeToReach();
    //         }       
    //     }
    //     return fleet;
    // }

    //tell me its right ot not = o(n) , o(nlogn) , o(n) => worest case so o(nlog n) is time complexity
                 //     space is cars so o(n) for space 

    public int carFleet(int target, int[] position, int[] speed) {
    // Create buckets for every possible position up to the target
    double[] timeAtPosition = new double[target]; 
    
    for (int i = 0; i < position.length; i++) {
        // Store the time it takes for a car at this position to reach the target
        timeAtPosition[position[i]] = (double) (target - position[i]) / speed[i];
    }

    int fleets = 0;
    double maxTime = 0;

    // Iterate backwards from the target to the start (closest to target first)
    for (int i = target - 1; i >= 0; i--) {
        if (timeAtPosition[i] > maxTime) {
            fleets++;
            maxTime = timeAtPosition[i];
        }
    }
    return fleets;
}
}
