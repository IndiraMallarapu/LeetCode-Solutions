class MyLinkedList {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    Node head=null;
    int cur_size=0;
    public MyLinkedList() { }
    
    public int get(int index) {
        if(index<0||index>=cur_size) return -1;
        Node temp=head;
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        return temp.data;
    }
    
    public void addAtHead(int val) {
        Node node=new Node(val);
        if(head==null)
            head=node;
        else{
            node.next=head;
            head=node;
        }
        cur_size++;
    }
    
    public void addAtTail(int val) {
        Node node = new Node(val);
        if(head==null){
            head=node;
            cur_size++;
            return;
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=node;
        cur_size++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index<0||index>cur_size) return;
        if(index == cur_size) {
            addAtTail(val);
            return;
        }
        if(index == 0) {
            addAtHead(val);
            return;
        }
        Node node =new Node(val);
        Node temp=head;
        for(int i=0;i<index-1;i++){
            temp=temp.next;
        }
        if(index==cur_size){
            while(temp.next!=null){
                temp=temp.next;
            }
        }
        node.next=temp.next;
        temp.next=node;
        cur_size++;
    }
    
    public void deleteAtIndex(int index) {
        Node temp=head;
        if(index<0||index>=cur_size) return;
        if(index==0){
            head=head.next;
            cur_size--;
            return;
        }
        for(int i=0;i<index-1;i++) temp=temp.next;
        temp.next=temp.next.next;
        cur_size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */