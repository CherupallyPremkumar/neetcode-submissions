class Solution {

  

    static class Car implements Comparable<Car>{
        private int destination;
        private int position;
        private int speed;
        private double  timeToReach;
        public Car(int position,int speed,int destination){
            this.position=position;
            this.speed=speed;
            this.destination=destination;
        }
        double getTimeToReach(){
            return this.timeToReach;
        }
        void timeToReach(){
            this.timeToReach=this.calcuateTime();
        }
        double calcuateTime(){
            return (double) getDistanceRemaining() / speed;
        }
        int getDistanceRemaining(){
            return destination - position;
        }
        public int compareTo(Car c) {
        // Sort movies in ascending order of year
        return c.position - this.position; 
    }
    }
    public int carFleet(int target, int[] position, int[] speed) {


        
        int n=position.length;
        Car[] cars=new Car[n];
        for(int i=0;i<n;i++){
            cars[i]=new Car(position[i],speed[i],target);
        }
  

        // we have a sorted position but respective speed
        Arrays.sort(cars);

        //we need to find the fleet of each car 
        // Deque<Car> stack=new ArrayDeque<>();
        int fleet=0;
        double time=0;
        for(int i=0;i<n;i++){
            //first car is always a fleet so what ever comes later can pass firts reaching car so we need calcuate 
            //time of arrival of all car if it creater we wont consitor
            //7,4,1,0

            // so we have 7  3/1   3 hours 
                            //    6/2 3 
                            //  9/2   4.5 so its greate so sepearate fleet 
                            //     10/1 10 
            Car car = cars[i];
            car.timeToReach();
            if(time < 0 || car.getTimeToReach() > time ){
                 fleet+=1;
                 time=car.getTimeToReach();
            }       
        }
        return fleet;
    }
}
