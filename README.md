# hw-8
ATTENTION
DO NOT USE JAVA COLLECTIONS FOR HOMEWORK

Task 1 - ArrayList#
Write your own MyArrayList class as an analogue of the ArrayList class.
You can use 1 array to store data.

Methods

add(Object value) adds an element to the end
remove(int index) removes the element at index
clear() clears the collection
size() returns the size of the collection
get(int index) returns the element at the index


Task 2 - LinkedList#
Write your own MyLinkedList class as an analogue of the LinkedList class.
You cannot use an array. Each element must be a separate intermediary object (Node - node) 
that stores a link to the previous and next element of the collection (doubly linked list).

Methods

add(Object value) adds an element to the end
remove(int index) removes the element at index
clear() clears the collection
size() returns the size of the collection
get(int index) returns the element at the index


Task 3 - Queue#

Write your own MyQueue class as an analogue of the Queue class, which will work on the FIFO (first-in-first-out) principle.

You can do it either with Node or with an array.

Methods

add(Object value) adds an element to the end
remove(int index) removes the element at index
clear() clears the collection
size() returns the size of the collection
peek() returns the first element in the queue (FIFO)
poll() returns the first element in the queue and removes it from the collection


Task 4 - Stack#


Write your own MyStack class as an analogue of the Stack class, which works on the LIFO (last-in-first-out) principle.

You can do it either with Node or with an array.

Methods

push(Object value) adds an element to the end
remove(int index) removes the element at index
clear() clears the collection
size() returns the size of the collection
peek() returns the first element on the stack (LIFO)
pop() returns the first element on the stack and removes it from the collection


Task 5 - HashMap#
Write your own MyHashMap class as an analogue of the HashMap class.
You need to do it with a single-linked Node.
Cannot store two nodes with the same keys at the same time.

Methods

put(Object key, Object value) adds a key + value pair
remove(Object key) removes a pair by key
clear() clears the collection
size() returns the size of the collection
get(Object key) returns value(Object value) by key
