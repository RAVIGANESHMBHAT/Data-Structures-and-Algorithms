class Node {
    String data;
    Node prev;
    Node next;
   
    Node(String data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DLL {
    Node head = null;
    int size = 0;
   
    void addAtFirst(String data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            size++;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        size++;
    }
   
    void add(String data) {
        Node newNode = new Node(data);
        Node currentHead = head;
        if (head == null) {
            head = newNode;
            size++;
            return;
        }
       
        while (currentHead.next != null) {
            currentHead = currentHead.next;
        }
        currentHead.next = newNode;
        newNode.prev = currentHead;
        size++;
    }
   
    void addAtIndex(int index, String data) {
        if(head == null && index != 0) {
            System.out.println("DLL is empty. Cannot add new node at index " + index + "\n");
            return;
        } else if(index == 0) {
            addAtFirst(data);
            return;
        }
       
        Node newNode = new Node(data);
        Node currentHead = head;
        int currentIndex = 0;
       
        while(currentHead.next != null && currentIndex < index - 1) {
            currentIndex++;
            currentHead = currentHead.next;
        }
       
        if(currentIndex < index - 1) {
            System.out.println("DLL is shorter than the provided index value " + index + "\n");
            return;
        } else if(currentHead.next == null && currentIndex == index - 1) {
            add(data);
            return;
        }
        newNode.next = currentHead.next;
        currentHead.next = newNode;
        size++;
    }
   
    void pop() {
        if(head == null) {
            System.out.println("DLL is empty. Cannot pop.\n");
            return;
        } else if(head.next == null) {
            head = null;
            return;
        }
       
        Node currentHead = head;
        while(currentHead.next != null) {
            currentHead = currentHead.next;
        }
        currentHead.prev.next = null;
        size--;
    }
   
    void deleteFirst() {
        if(head == null) {
            System.out.println("DLL is empty. Cannot pop.\n");
            return;
        } else if(head.next == null) {
            head = null;
            size--;
            return;
        }
        head = head.next;
        size--;
    }
   
    void deleteAtIndex(int index) {
        if(head == null) {
            System.out.println("DLL is empty. Cannot delete.\n");
            return;
        } else if(head.next == null && index == 0) {
            head = null;
            size--;
            return;
        }
       
        int currentIndex = 0;
        Node currentHead = head;
        while(currentHead.next != null && currentIndex < index) {
            currentHead = currentHead.next;
            currentIndex++;
        }
         if(currentIndex < index) {
             System.out.println("DLL is shorter than the provided index value " + index + ". Cannot delete.\n");
            return;
         }
         currentHead.prev.next = currentHead.next;
         currentHead.next.prev = currentHead.prev;
    }
   
    void display() {
        Node currentHead = head;
        if (head == null) {
            System.out.println("DLL is empty. Nothing to display.\n");
            return;
        }
       
        while (currentHead.next != null) {
            System.out.print(currentHead.data + ", ");
            currentHead = currentHead.next;
        }
        System.out.println(currentHead.data + "\n");
    }
   
    int getSize() {
        return size;
    }
   
    public static void main(String[] args) {
        DLL dll = new DLL();
        dll.display();
       
        dll.add("A");
        dll.display();
       
        dll.add("B");
        dll.display();
       
        dll.add("C");
        dll.display();
       
        dll.addAtFirst("1");
        dll.display();
       
        dll.addAtIndex(4, "0");
        dll.display();
       
        int idx = 2;
        dll.deleteAtIndex(idx);
        System.out.print("After deleting at index " + idx + " = ");
        dll.display();
       
        dll.deleteFirst();
        dll.display();
       
        dll.pop();
        dll.display();
       
        dll.pop();
        dll.display();
       
        dll.pop();
        dll.display();
       
        dll.deleteFirst();
        dll.display();
       
        dll.pop();
        dll.display();
       
        dll.pop();
        dll.display();
       
        dll.pop();
        dll.display();
       
        System.out.println("Size= " + dll.getSize());
    }
}
