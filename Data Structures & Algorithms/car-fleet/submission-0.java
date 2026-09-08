class Solution {
    static class Car {
        int position;
        int speed;

        Car(int position, int speed) {
            this.position = position;
            this.speed = speed;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        /*
          As we know that -
          TIME = DISTANCE / SPEED;
        ==> distance = target - position
        ==> Hence -> time = (target - position) / speed
        Example -
        target = 12
        Car A:
        position = 10
        speed = 2
        -> time = 2 / 2 = 1 hour

CORE LOGIC
Cars
 ↓
Position DESC sort
 ↓
Closest → Farthest
 ↓
time = (target - position) / speed
 ↓
time > previousTime ?
       ↓
      YES → New Fleet
       ↓
      NO → Join Existing Fleet



        */

        // Create cars so position + speed stay together
        Car[] cars = new Car[position.length];

        for (int i = 0; i < position.length; i++) {
            cars[i] = new Car(position[i], speed[i]);
        }

        // Sort by position DESC
        Arrays.sort(cars, (a, b) -> Integer.compare(b.position, a.position));

        int fleets = 0;
        double previousTime = 0;

        // Closest car to target → farthest car
        for (Car car : cars) {
            double time = (double) (target - car.position) / car.speed;

            // New fleet
            if (time > previousTime) {
                fleets++;
                previousTime = time;
            }

            // time <= previousTime means
            // this car catches the fleet ahead
        }

        return fleets;
    }
}
