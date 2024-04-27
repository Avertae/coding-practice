class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        return Arrays.stream(restaurants)
                .filter(a -> a[3] <= maxPrice && a[4] <= maxDistance)
                .filter(a -> veganFriendly == 1 ? a[2] == veganFriendly : true)
                .sorted((a1, a2) -> Integer.compare(a2[0], a1[0]))
                .sorted((a1, a2) -> Integer.compare(a2[1], a1[1]))
                .map(a -> a[0])
                .collect(Collectors.toList());           
    }
}