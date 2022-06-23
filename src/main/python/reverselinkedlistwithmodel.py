from models.listnode import ListNode

class Solution(object):

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
    head = ListNode(1)
    head.next = ListNode(2)
    head.next.next = ListNode(3)
    head.next.next.next = ListNode(4)
    head.next.next.next.next = ListNode(5)
    head.next.next.next.next.next = ListNode(6)
    head.next.next.next.next.next.next = ListNode(7)

    print(s.reverse_linked_list(head))
    print(s.reverse_linked_list(None))
    print(s.reverse_linked_list(ListNode(1)))
