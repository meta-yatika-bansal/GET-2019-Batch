function repeatify(){
    var input = document.getElementById("string").value;
    var num = document.getElementById("number").value;
    var i ;
    var output = input;
    for(i = 1 ; i < num ; i++){
        output += input;
    }

    alert("Repeated String is " + output);
}