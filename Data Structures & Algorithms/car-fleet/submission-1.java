class Solution {

  static int destination;

    static class Car implements Comparable<Car>{
        private int position;
        private int speed;
        private double  timeToReach;
        public Car(int position,int speed){
            this.position=position;
            this.speed=speed;
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
        this.destination=target;

        List<Car> cars=new ArrayList<>();
        int n=position.length;

        for(int i=0;i<n;i++){
            cars.add(new Car(position[i],speed[i]));
        }
  

        // we have a sorted position but respective speed
        Collections.sort(cars);

        //we need to find the fleet of each car 
        Stack<Car> stack=new Stack<>();
        
        for(int i=0;i<cars.size();i++){
            //first car is always a fleet so what ever comes later can pass firts reaching car so we need calcuate 
            //time of arrival of all car if it creater we wont consitor
            //7,4,1,0

            // so we have 7  3/1   3 hours 
                            //    6/2 3 
                            //  9/2   4.5 so its greate so sepearate fleet 
                            //     10/1 10 
            Car car = cars.get(i);
            car.timeToReach();
            if(stack.isEmpty() || car.getTimeToReach() > stack.peek().getTimeToReach()){
                    stack.push(car);
                }       
        }
        return stack.size();
    }
}
