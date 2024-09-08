// To RUN this code execute below command to generate the binary: 
// g++ -std=c++11 reverseLL.cpp -o reverseLL

// Reverse a Linked list

// TC: O(n)
// SC: O(1)

#include <iostream>
using namespace std;

class Node
{
public:
    int data;
    Node *next;

    Node(int d)
    {
        data = d;
        next = nullptr;
    }
};

void printLL(Node *head)
{
    Node *curr = head;
    while (curr != nullptr)
    {
        cout << curr->data << " ";
        curr = curr->next;
    }
    cout << endl;
}

Node *reverseLL(Node *head, Node *prev)
{
    if (head == nullptr)
        return prev;

    Node *temp = head->next;
    head->next = prev;
    prev = head;
    head = temp;
    return reverseLL(head, prev);
}

int main()
{
    cout << "Mock interview 1 Topic LL" << endl;

    Node *head1 = new Node(2);
    head1->next = new Node(4);
    head1->next->next = new Node(6);
    head1->next->next->next = new Node(7);
    head1->next->next->next->next = new Node(8);
    Node *prev = nullptr;

    printLL(head1);
    Node *reversedHead = reverseLL(head1, prev);
    printLL(reversedHead);

    return 0;
}
