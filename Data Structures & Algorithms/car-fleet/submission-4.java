class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if(n == 1)
            return 1;
        
        List<List<Integer>> posSpeeds = new ArrayList<>();
        for(int i=0;i<n;i++) {
            List<Integer> posSpeed = new ArrayList<>(
                List.of(position[i], speed[i]));
            
            posSpeeds.add(posSpeed);
        }

        posSpeeds.sort((a, b) -> Integer.compare(a.get(0), b.get(0)));
        Deque<Double> fleets = new ArrayDeque<>();

        for(int i=n-1;i>=0;i--) {
            double time = 
                (target-posSpeeds.get(i).get(0))/(double)(posSpeeds.get(i).get(1));
            // System.out.println("time: " + "(" + i + "): " + time);
            
            if(fleets.isEmpty()) {
                fleets.push(time);
                continue;
            }

            if(fleets.peek() >= time)   continue;

            fleets.push(time);
        }

        return fleets.size();
    }
}
