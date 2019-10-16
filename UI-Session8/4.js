class stack{

    constructor(){
        this.items=[];
   }
}

stack.prototype.push = function(data){
   this.items.push(data);
   alert("Data Pushed");
}

stack.prototype.pop = function(){
  if(this.items.length != 0){
      this.items.pop();
      alert("Data Popped!");
  }else{
      alert("Cannot Perform this operation!");
  }
}

var list = new stack();

function pushData(){
    var data=document.getElementById("data").value;
    list.push(data);
}

function popData(){
  list.pop();
}

function show(){
    alert(list.items);
}