// ================================================================
//  LeetCode #643 — Maximum Average Subarray I
//  Pattern  : Fixed Sliding Window
//  Link     : https://leetcode.com/problems/maximum-average-subarray-i/
//  Time     : O(n)
//  Space    : O(1)
// ================================================================

// ----------------------------------------------------------------
// PROBLEM STATEMENT
// ----------------------------------------------------------------
// You are given an integer array nums consisting of n elements,
// and an integer k.
//
// Find a contiguous subarray whose length is exactly k that has
// the maximum average value, and return this maximum average.
//
// Answers within 10^-5 of the actual answer will be accepted.
//
// ----------------------------------------------------------------
// WHY "FIXED" SLIDING WINDOW?
// ----------------------------------------------------------------
// The window size is always exactly k — it never grows or shrinks.
// It just slides one step to the right each time.
// This is different from a Dynamic Sliding Window where the size
// changes based on a condition.
//
//   Window size = k = FIXED at every point in time
//
// ----------------------------------------------------------------
// EXAMPLES
// ----------------------------------------------------------------
//
// Example 1:
//   Input : nums = [1, 12, -5, -6, 50, 3],  k = 4
//   Output: 12.75
//
//   All windows of size 4:
//   [1,  12,  -5,  -6]  → sum =  2  → avg =  0.50
//   [12,  -5,  -6,  50]  → sum = 51  → avg = 12.75  ✅ MAX
//   [-5,  -6,  50,   3]  → sum = 42  → avg = 10.50
//
//   Answer: 12.75
//
// ----------------------------------------------------------------
//
// Example 2:
//   Input : nums = [5],  k = 1
//   Output: 5.0
//
//   Only one window: [5] → sum = 5 → avg = 5.0
//
// ----------------------------------------------------------------
//
// Example 3:
//   Input : nums = [0, 1, 1, 3, 3],  k = 4
//   Output: 2.0
//
//   All windows of size 4:
//   [0, 1, 1, 3]  → sum = 5 → avg = 1.25
//   [1, 1, 3, 3]  → sum = 8 → avg = 2.00  ✅ MAX
//
//   Answer: 2.0
//
// ----------------------------------------------------------------
// CONSTRAINTS
// ----------------------------------------------------------------
//   n == nums.length
//   1 <= k <= n <= 10^5
//   -10^4 <= nums[i] <= 10^4
//
// ----------------------------------------------------------------
// APPROACH — Sliding Window
// ----------------------------------------------------------------
// Instead of recalculating sum from scratch for every window
// (that would be O(n*k)), reuse the previous sum:
//
//   new_sum = old_sum - element_leaving_left + element_entering_right
//
// This reduces time complexity to O(n).
//
// ----------------------------------------------------------------
// SOLUTION
// ----------------------------------------------------------------

public class FixedSlidingWindow {

    public static double findMaxAverage(int[] nums, int k) {
        int n = nums.length;

        // STEP 1: Compute sum of the first window
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int maxSum     = sum;
        int startIndex = 0;  // tracks where the best window begins

        // STEP 2: Slide the window across the rest of the array
        for (int i = k; i < n; i++) {
            sum = sum - nums[i - k]  // remove element leaving on the left
                      + nums[i];     // add  element entering on the right

            if (sum > maxSum) {
                maxSum     = sum;
                startIndex = i - k + 1;  // update start of the best window
            }
        }

        // STEP 3: Print the best subarray
        System.out.print("Best subarray: [");
        for (int i = startIndex; i < startIndex + k; i++) {
            System.out.print(nums[i]);
            if (i < startIndex + k - 1) System.out.print(", ");
        }
        System.out.println("]");

        // STEP 4: Return the maximum average
        return (double) maxSum / k;
    }

    public static void main(String[] args) {
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;

        double result = findMaxAverage(nums, k);
        System.out.println("Max Average: " + result);
    }
}

// ----------------------------------------------------------------
// EXPECTED OUTPUT
// ----------------------------------------------------------------
// Best subarray: [12, -5, -6, 50]
// Max Average: 12.75
