class Node {
    String data;
    Node next;
    
    Node(String data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;
    int size = 0;
    
    void add(String data) {
        Node currentHead = head;
        Node newNode = new Node(data);
        
        size++;
        if(currentHead == null) {
            head = newNode;
            return;
        }
        
        while(currentHead.next != null) {
            currentHead = currentHead.next;
        }
        currentHead.next = newNode;
    }
    
    void addFirst(String data) {
        Node newNode = new Node(data);
        
        size++;
        if(head == null) {
            head = newNode;
            return;
        }
        
        newNode.next = head;
        head = newNode;
    }
    
    void display() {
        Node currentHead = head;
        
        if(currentHead == null) {
            System.out.println("Linked List is empty.\n");
            return;
        }
        
        while(currentHead.next != null) {
            System.out.print(currentHead.data + ", ");
            currentHead = currentHead.next;
        }
        System.out.println(currentHead.data);
    }
    
    void removeFirst() {
        if(head == null) {
            System.out.println("Linked List is empty.\n");
            return;
        }
        size--;
        head = head.next;
    }
    
    void pop() {
        Node secondLastNode = head;
        
        if(secondLastNode == null) {
            System.out.println("LinkedList is empty.\n");
            return;
        } else if(secondLastNode.next == null) {
            size--;
            head = null;
            return;
        }
        
        while(secondLastNode.next.next != null) {
            secondLastNode = secondLastNode.next;
        }
        secondLastNode.next = null;
        size--;
    }
    
    int size() {
        return size;
    }
    
    void findDataAt(int index) {
        int currentIndex = 0;
        Node currentHead = head;
        
        if(currentHead == null) {
            System.out.println("LinkedList is empty.\n");
            return;
        }
        
        while(currentHead.next != null && currentIndex != index) {
            currentHead = currentHead.next;
            currentIndex++;
        }
        if(currentIndex < index) {
            System.out.println("The length of LinkedList is lesser than provided index, "+ index);
        } else if(currentIndex == index) {
            System.out.println("The data at the index " + index + " is " + currentHead.data);
        }
    }
    
    // wrong logic. need to fix
    void removeAt(int index) {
        int currentIndex = 0;
        Node currentHead = head;
        
        if(currentHead == null) {
            System.out.println("LinkedList is empty.\n");
            return;
        } else if(index == 0 && currentHead.next == null) {
            head = null;
            size--;
            return;
        }
        
        while(currentHead.next != null && currentIndex != index) {
            currentHead = currentHead.next;
            currentIndex++;
        }
        
        if(currentIndex < index) {
            System.out.println("Failed to remove data at the index, " + index + ". The length of LinkedList is lesser than specified index.");
        } else if(currentIndex == index) {
            currentHead.next = currentHead.next.next;
            size--;
            return;
        }
    }
    
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.add("A");
        ll.add("B");
        ll.add("C");
        ll.addFirst("1");
        ll.display();
        ll.pop();
        ll.display();
        ll.add("D");
        ll.display();
        ll.removeFirst();
        ll.pop();
        ll.display();
        ll.add("C");
        ll.display();
        ll.removeAt(1);
        System.out.println("Below Data is after deleting the node at index, "+ 1);
        ll.display();
        ll.addFirst("1");
        ll.display();
        ll.findDataAt(1);
        
        System.out.println("Size = " + ll.size());
    }
}
