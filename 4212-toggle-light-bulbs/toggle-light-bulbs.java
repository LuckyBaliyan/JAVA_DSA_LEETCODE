class Solution {
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        ArrayList<Integer> on = new ArrayList<>();

        for(int bulb:bulbs){
            if(on.contains(bulb))on.remove(Integer.valueOf(bulb));
            else on.add(bulb);
        }

        Collections.sort(on);
        return on;
    }
}