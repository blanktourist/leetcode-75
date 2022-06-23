class Solution(object):
    
    class ListNode(object):
        def __init__(self, x):
            self.val = x
            self.next = None
        def __str__(self):
            return str(self.val) + "->" + str(self.next)

    def reverse_linked_list(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head is None:
            return None
        if head.next is None:
            return head
        prev = None
        curr = head
        while curr is not None:
            next = curr.next
            curr.next = prev
            prev = curr
            curr = next
        return prev

if __name__ == '__main__':
    s = Solution()
    head = s.ListNode(1)
    head.next = s.ListNode(2)
    head.next.next = s.ListNode(3)
    head.next.next.next = s.ListNode(4)
    head.next.next.next.next = s.ListNode(5)
    head.next.next.next.next.next = s.ListNode(6)
    head.next.next.next.next.next.next = s.ListNode(7)

    print(s.reverse_linked_list(head))
    print(s.reverse_linked_list(None))
    print(s.reverse_linked_list(s.ListNode(1)))


