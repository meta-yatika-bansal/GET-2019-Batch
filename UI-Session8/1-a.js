var linkedList ;

class node{
    constructor(data){
        this.data = data;
        this.next = null;
    }
}

class list{

    constructor(){
    this.head= null;
    this.size = 0;
    }

    add(data){
        var current;
        var newNode = new node(data);
        if(this.head == null){
            this.head = newNode;
        }else{
            current = this.head;
            while(current.next){
                current = current.next;
            }
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