/*
Hi, here's your problem today. This problem was recently asked by Microsoft:
  You are given two linked-lists representing two non-negative integers.
  The digits are stored in reverse order and each of their nodes contain a single digit.
  Add the two numbers and return it as a linked list.


Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
# Definition for singly-linked list.
# class ListNode(object):
#   def __init__(self, x):
#     self.val = x
#     self.next = None

class Solution(object):
  def addTwoNumbers(self, l1, l2):
    # Fill this in.
 */

public class July_21_2019 {
    private class Node {
        int val;
        Node next;

        Node(){}
        Node(int newVal) {val = newVal;}
    }

    public static void main(String[] args) {
        // Test addTwoNumbers() here.
    }

    private Node addTwoNumbers(Node l1, Node l2) {
        Node output, iterator;

        int firstVal = l1.val + l2.val;
        int carry = firstVal / 10;
        firstVal -= (carry * 10);
        output = new Node(firstVal);
        iterator = output;

        while (l1.next != null || l2.next != null || carry != 0) {
            int current = 0;
            if (l1.next != null) {
                l1 = l1.next;
                current += l1.val;
            }
            if (l2.next != null) {
                l2 = l2.next;
                current += l2.val;
            }
            current += carry;
            carry = 0;

            if (current >= 10) {
                carry = current / 10;
                current -= (carry * 10);
            }

            iterator.next = new Node(current);
            iterator = iterator.next;
        }

        return output;
    }
}
