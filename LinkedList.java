public class LinkedList {
    class Node{
        int val; 
        Node next; 
        Node prev;

        Node( int x){
            this.val = x;
            this.next = null; 
        }

        Node(int x, Node n){
            this.val = x; 
            this.next = n; 
        }

        Node(int x, Node n, Node p){
            this.val = x; 
            this.next = n; 
            this.next = p;
        }
    }

    int size; 
    Node head; 

    public LinkedList(){
        this.size = 0; 
        this.head = null;
    }

    public int get(int index){
        if(head == null || index >= size){
            return -1;
        }else{
            Node curr = head; 
            for(int i = 0; i < index; i++){
                curr = curr.next;
            }

            return curr.val;
        }
    }

    public void addAtHead(int val){
        Node newNode = new Node(val);
        if(head == null){
            head = newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }

        size++;
    }

    public void addAtTail(int val){
        Node newNode = new Node(val);
        if(head == null){
            head = newNode;
        }else{
            Node curr = head;

            while(curr.next != null){
                curr = curr.next;
            }

            curr.next = newNode;
        }

        size++;
    }

    public void addAtIndex(int index, int val){

        if(index < 0 || index > size){
            return;
        }else if( index == 0){
            addAtHead(val);
        }else if (index == size){
            addAtTail(val);
        }else{
            Node newNode = new Node(val);
            Node curr = head;

            for(int i = 0; i < index -1 ; i++){
                curr = curr.next;
            }

            newNode.next = curr.next; 
            curr.next = newNode;
            size++;
        }

    }

    public void deleteAtIndex(int index, int val){
        if (index < 0 || index >= size || head == null){
            return;
        }else if( index== 0){
            head = head.next;
        }else if( index == size -1){
            Node curr = head; 
            while(curr.next.next != null){
                curr = curr.next;
            }

            curr.next = null;
        }else{
            Node curr = head; 

            for(int i = 0; i < index -1; i++){
                curr = curr.next;
            }
            curr.next = curr.next.next;
        }

        size--;
    }

    public void deleteNode(Node node){
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public void removeNthFromEnd(Node head, int index){
        // this does not remove the head or tail

        Node dummy = new Node(0, head);
        Node fast = dummy; 
        Node slow = dummy; 

        for(int i = 0; i < index -1; i++){
            fast = fast.next;
        }

        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next; 
        size--;
    }

    public Node reverse(Node head){
        Node prev = null; 

        while( head != null){
            Node next = head.next; 
            head.next = prev; 
            prev = head; 
            head = next;
        }

        return prev;
    }

    public Node mergeTwoLists(Node list1, Node list2) {
        
        Node merged = new Node(0); 
        Node curr = merged;
        
        while(list1 != null && list2 != null){
            
            if(list1.val < list2.val){
                curr.next = list1; 
                list1 = list1.next;
            }else{
                curr.next = list2;
                list2= list2.next;
            }
            
            curr = curr.next;
        }
        
        if( list1 != null){
            curr.next = list1;
            list1.next = list1.next;
        }
        
        if(list2 != null){
            curr.next = list2;
            list2 = list2.next;
        }
        
        return merged.next;
    }

    public boolean hasCycle(Node head) {
        
        
        if(head == null){
            return false; 
            
        }
        
        Node fast = head.next; 
        Node slow = head; 
        
        while(slow != fast){
            
            if(fast == null || fast.next == null){
                return false; 
            }
            slow = slow.next; 
            fast = fast.next.next; 
        }
        
        return true; 
        
    }




}
