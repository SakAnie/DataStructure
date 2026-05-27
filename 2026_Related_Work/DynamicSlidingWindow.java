// ================================================================
//  LeetCode #3 — Longest Substring Without Repeating Characters
//  Pattern  : Dynamic Sliding Window
//  Link     : https://leetcode.com/problems/longest-substring-without-repeating-characters/
//  Time     : O(n)
//  Space    : O(n)
// ================================================================

// ----------------------------------------------------------------
// PROBLEM STATEMENT
// ----------------------------------------------------------------
// Given a string, find the length of the longest substring
// that does not contain any repeating characters.
//
// Unlike Fixed Sliding Window, the window size here is NOT fixed —
// it expands and shrinks dynamically based on whether a duplicate
// character is found. That is why this is a Dynamic Sliding Window.
//
// ----------------------------------------------------------------
// WHY "DYNAMIC" SLIDING WINDOW?
// ----------------------------------------------------------------
//
//   Fixed Window   → size k is constant, just slides right
//   Dynamic Window → size grows when valid, shrinks when invalid
//
//   In this problem:
//     EXPAND  → move right pointer, add character to window
//     SHRINK  → duplicate found? move left pointer until it's gone
//
// ----------------------------------------------------------------
// EXAMPLES
// ----------------------------------------------------------------
//
//  Example 1:
//    Input : str = "Sakshisinha"
//    Output: 6
//
//    Walking through the string:
//    right=0  → 'S'  window=[S]            len=1
//    right=1  → 'a'  window=[S,a]          len=2
//    right=2  → 'k'  window=[S,a,k]        len=3
//    right=3  → 's'  window=[S,a,k,s]      len=4
//    right=4  → 'h'  window=[S,a,k,s,h]    len=5
//    right=5  → 'i'  window=[S,a,k,s,h,i]  len=6  ✅ MAX so far
//    right=6  → 's'  DUPLICATE! shrink left until 's' removed
//               window=[a,k,s,h,i] → remove 's' → window=[a,k,h,i,s] wait...
//               shrink: remove S → remove a → remove k → remove s → now add new s
//               window=[h,i,s]  len=3  (but max stays 6)
//    ...continues
//    Final max_len = 6
//
//  Example 2:
//    Input : str = "abcabcbb"
//    Output: 3   → "abc"
//
//  Example 3:
//    Input : str = "bbbbb"
//    Output: 1   → "b"
//
//  Example 4:
//    Input : str = "pwwkew"
//    Output: 3   → "wke"
//
// ----------------------------------------------------------------
// CONSTRAINTS
// ----------------------------------------------------------------
//   0 <= s.length <= 5 * 10^4
//   s consists of English letters, digits, symbols and spaces
//
// ----------------------------------------------------------------
// KEY DATA STRUCTURE — HashSet
// ----------------------------------------------------------------
//   HashSet<Character> is used to track characters in the current
//   window. It gives O(1) average time for:
//     seenChars.contains(ch)  → check if duplicate exists
//     seenChars.add(ch)       → add new character to window
//     seenChars.remove(ch)    → remove character as window shrinks
//
// ----------------------------------------------------------------
// SOLUTION
// ----------------------------------------------------------------

import java.util.HashSet;

class Main {
    public static void main(String[] args) {
        System.out.println("Start small. Ship something.");

        String str = "Sakshisinha";
        char[] c = str.toCharArray();

        HashSet<Character> seenChars = new HashSet<>();
        int max_len = 0;
        int left = 0;                          // left pointer of the window

        // Expand the window by moving 'right' pointer
        for (int right = 0; right < c.length; right++) {

            // Duplicate found → shrink from left until duplicate is removed
            while (seenChars.contains(c[right])) {
                seenChars.remove(c[left]);     // remove leftmost char from window
                left++;                        // shrink window from the left
            }

            // No duplicate → safely expand window by adding current char
            seenChars.add(c[right]);

            // Update max length with current window size
            max_len = Math.max(max_len, right - left + 1);
        }

        // Output
        System.out.println("Unique chars in best window : " + seenChars);
        System.out.println("Max Length                  : " + max_len);
    }
}

// ----------------------------------------------------------------
// EXPECTED OUTPUT
// ----------------------------------------------------------------
//  Start small. Ship something.
//  Unique chars in best window : [a, k, s, i, n, h]
//  Max Length                  : 6
//
// ----------------------------------------------------------------
// COMMON MISTAKES TO AVOID
// ----------------------------------------------------------------
//  ❌  Using c.charAt(right) on a char[] — arrays use c[right]
//  ❌  Doing left++ without seenChars.remove(c[left]) → infinite loop
//  ❌  Using str.length() inside the for loop — use c.length for char[]
