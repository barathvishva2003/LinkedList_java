import java.util.Scanner;
class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
class LinkedList{
    Node head = null;
    
    void insertBegining(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    void insertLast(int data){
        if(head==null){
            insertBegining(data);
            return;
        }
       Node temp = head;
       while(temp.next!=null){
        temp=temp.next;
       } 
       Node newNode = new Node(data);
       temp.next=newNode;
       newNode.next=null;
    }

    void insertMiddle(int data, int index){
        if(index<0){
            System.out.print("invalid INDEX");
            return;
        }
         if(index == 0){
            insertBegining(data);
            return;
        }
        if(head.next == null){
            insertLast(data);
            return;
        }
        Node temp = head;
        for(int i=0;i<index-1;i++){
            if (temp == null) {
                System.out.println("Invalid INDEX value");
                return;
            }
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Invalid INDEX value");
            return;
        }
        Node newNode = new Node(data);
        newNode.next=temp.next;
        temp.next=newNode;
    }

    void deleteFront(){
        if(head == null){
            System.out.print("head is null");
            System.out.println();
            return;
        }
        Node prv = head.next;
        head = head.next;
        prv = null;
    }

    void deleteEnd(){
        if(head == null){
            System.out.print("head is null");
            System.out.println();
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node temp = head;
        while(temp.next.next!=null){
            temp = temp.next;
        }
        temp.next=null;
    }

    void deleteMiddle(int index){
        if (index < 0) {
            System.out.println("Invalid INDEX");
            return;
        }
        if(head == null){
            System.out.print("head is null");
            System.out.println();
            return;
        }
         if (index == 0) {
            deleteFront();
            return;
        }
        Node temp = head;
        for(int i=0;i<index-1;i++){
            temp = temp.next;
            if(temp.next==null || temp==null){
                System.out.print("Invalid INDEX value");
                System.out.println();
                return;
            }
        }
         if (temp.next == null) {
            System.out.println("Invalid INDEX value");
            return;
        }
        temp.next=temp.next.next;
    }

    void set(int index, int element){
          Node temp = head;
          if(index < 0){
              System.out.print("Invalid INDEX");
          }
          for(int i=0; i<index;i++){
            temp = temp.next;
            if(temp.next==null){
                System.out.print("Invalid INDEX value");
                System.out.println();
                return;
            }
          }
          temp.data = element;
    }

    int get(int index){
         if (index < 0 || head == null) {
            System.out.print("Invalid INDEX value : ");
            return -9999;
        }
        Node temp = head;
        for(int i=0;i<index;i++){

            temp = temp.next;

            if(temp == null){
                System.out.print("Invalid INDEX value : ");
                return -9999;
            }
        }
        return temp.data;
    }

     void display(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
    }

public static void main(String []args){
    LinkedList list = new LinkedList();
    Scanner scan = new Scanner(System.in);
     
    String choice = "yes";
    while(choice.equalsIgnoreCase("yes")){

        System.out.print("Enter the FUNCTION value : ");
        
        int function = scan.nextInt();

        switch(function){
            case 1:
                System.out.println("Enter the insertBegining DATA : ");
                int data = scan.nextInt();
                list.insertBegining(data);
                break;
            case 2:
                System.out.println("Enter the insertMiddle DATA : ");
                data = scan.nextInt();
                System.out.print("Enter the INDEX value : ");
                int index = scan.nextInt();
                list.insertMiddle(data,index);
                break;

            case 3:
                System.out.println("Enter the insertLast DATA : ");
                data = scan.nextInt();
                list.insertLast(data);
                break;
            
            case 4:
                list.deleteFront();
                break;

            case 5:
                System.out.print("Enter the INDEX value : ");
                index = scan.nextInt();
                list.deleteMiddle(index);
                break;

            case 6:
                list.deleteEnd();
                break;
                
            case 7:
                System.out.print("Enter the INDEX value : ");
                index = scan.nextInt();
                System.out.print("Enter the ELEMENT : ");
                data = scan.nextInt();
                list.set(index,data);
                break;
            
            case 8:
                System.out.print("Enter the INDEX value : ");
                index = scan.nextInt();
                System.out.print(list.get(index));
                System.out.println();
                break;

            case 9:
                list.display();
        }
        System.out.print("Do you want to Countinue : ");
        choice = scan.next();
    }
}
}