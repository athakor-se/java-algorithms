package leetcode;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AddTwoNumbersListNode {

    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        var list = Arrays.asList(1,5,29,8,9,51,6,2,7,5);
        Map<Integer, Long> collect = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);
        System.out.println(list.stream().filter(f -> list.stream().filter(f1 -> f != f1).count() > 1).collect(Collectors.toSet()));
        list.stream().reduce((i, j) -> i + j).ifPresent(System.out::println);
        return new ListNode();
    }

    public static void main(String[] args) {
        AddTwoNumbersListNode.addTwoNumbers(null, null);
    }
}

class ListNode {
      int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}