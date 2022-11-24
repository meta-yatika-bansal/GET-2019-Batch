var linkedList ;

class node{
    constructor(data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class list{

    constructor(){
    this.head= null;
    this.tail = null;
    this.size = 0;
    }

    add(data){
        var current;
        var newNode = new node(data);
        if(this.head == null){
            this.head = newNode;
            this.tail = newNode;
        }else{
            current = this.tail;
            current.next= newNode;
        }
        this.size++;
    }

    show(){
        var current = this.head;
        var outputList = " ";
        while(current){
            outputList += current.data + " ";
            current = current.next;
        }  
        alert("Linked List :" + outputList);
    }
}

function addData(){
    var ele = document.getElementById("data").value;
    linkedList.add(ele);
    alert("Element added!");
}

function showData(){
    linkedList.show();
}

function create(){
 linkedList = new list();
}