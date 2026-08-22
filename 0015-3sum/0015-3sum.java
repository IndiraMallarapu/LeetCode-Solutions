class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        int n = nums.length;
        List<List<Integer>> ll = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < n - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int l = i + 1;
            int r = n - 1;

            while (l < r) {

                int x = nums[i] + nums[l] + nums[r];

                if (x == 0) {

                    ll.add(Arrays.asList(nums[i], nums[l], nums[r]));

                    while (l < r && nums[l] == nums[l + 1])
                        l++;

                    while (l < r && nums[r] == nums[r - 1])
                        r--;

                    l++;
                    r--;

                } else if (x < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }

        return ll;
    }
}