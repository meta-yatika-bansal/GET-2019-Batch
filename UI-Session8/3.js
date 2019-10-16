class queue{
    constructor(){
        this.items=[];
   }
}

queue.prototype.enqueue = function(data){
   this.items.push(data);
   alert("Data Enqueued");
}

queue.prototype.dequeue = function(){
  if(this.items.length != 0){
      this.items.shift();
      alert("Data Dequeued!");
  }else{
      alert("Cannot Perform this operation!");
  }
}

var list = new queue();

function insertData(){
    var data=document.getElementById("data").value;
    list.enqueue(data);
}

function deleteData(){
  list.dequeue();
}

function show(){
    alert(list.items);
}