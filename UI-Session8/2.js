//Removes Consecutive repeated string

function removeConsecutives(){
    var str= document.getElementById("string").value;
    var i;
    var j;
    for(j=0;j<str.length;j++){
      for(i=0 ; i<str.length ; i++){
        if(str.charAt(i) == str.charAt(i+1)){
          var rem = str.substring(i,i+2);
          str = str.replace(rem,"");
        }
      }
    }

    alert(str);
}