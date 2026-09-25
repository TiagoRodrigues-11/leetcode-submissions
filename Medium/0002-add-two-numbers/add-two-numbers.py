# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: ListNode | None, l2: ListNode | None) -> ListNode | None:
        if l1 is None and l2 is None:
            return None

        return self.addTwoNumbersHelper(l1, l2, False)

    def addTwoNumbersHelper(self, l1: ListNode | None, l2: ListNode | None, carry: bool) -> ListNode | None:
        if l1 is None and l2 is None:
            return ListNode(1, None) if carry else None

        sum = (l1.val if l1 is not None else 0) + (l2.val if l2 is not None else 0) + (1 if carry else 0)
        if l1 is None:
            return ListNode(
                sum % 10,
                self.addTwoNumbersHelper(None, l2.next, sum >= 10)
            )

        if l2 is None:
            return ListNode(
                sum % 10,
                self.addTwoNumbersHelper(l1.next, None, sum >= 10)
            )

        return ListNode(
            sum % 10,
            self.addTwoNumbersHelper(l1.next, l2.next, sum >= 10)
        )
