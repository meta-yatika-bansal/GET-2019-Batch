var vehicleType;
var password;

function next(){
    var n = document.getElementById("in").value;
    document.getElementById("lbl").innerHTML="Hi "+ n + "!" +" Enter Your Email ";
    document.getElementById("in").type = "email";
    document.getElementById("in").value="";
    document.getElementById("a").onclick = next1;
}

function next1(){
    var email = document.getElementById("in").value;
    var regexp = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if(regexp.test(email)){
       document.getElementById("lbl").innerHTML="Enter Your Password !";
       document.getElementById("in").type = "password";
       document.getElementById("in").value="";
       document.getElementById("a").onclick = next2;
    }else{
        alert("Email should be in Proper Format!");
    }
}

function next2(){
    password = document.getElementById("in").value;
    document.getElementById("lbl").innerHTML="Please Confirm Your Password !";
    document.getElementById("in").type = "password";
    document.getElementById("in").value="";
    document.getElementById("a").onclick = next3;
}

function next3(){
  var repass = document.getElementById("in").value;
  if(password != repass){
     alert("Passwords Don't Match!");
  }else{
     document.getElementById("lbl").innerHTML="Enter Your Contact Number!";
     document.getElementById("in").type = "tel";
     document.getElementById("in").value="";
     document.getElementById("a").onclick = next4;
  }
 }

 function next4(){
    document.body.style.background = "gray";
     document.getElementById("lbl").innerHTML="Enter your vehicle number!";
     document.getElementById("in").type = "number";
     document.getElementById("in").value="";
     document.getElementById("a").onclick = next5;
 }

 function next5(){
     document.getElementById("lbl").innerHTML="What's Your Vehicle Type [Cycle/MotorCycle/FourWheeler] ?";
     document.getElementById("in").type = "text";
     document.getElementById("in").value="";
     document.getElementById("a").onclick = next6;
 }

 function next6(){
     vehicleType = document.getElementById("in").value;
     document.getElementById("lbl").innerHTML = "Enter Your Employee Id!";
     document.getElementById("in").type = "id";
     document.getElementById("in").value="";
     document.getElementById("a").onclick = next7;
 }

 function next7(){
     document.body.style.background = "DarkSeaGreen";
     if("Cycle" == vehicleType){
        document.getElementById("lbl").innerHTML="Choose Your Pass[5 Daily/100 Monthly/500 Yearly]!";
     }else if("MotorCycle" == vehicleType){
        document.getElementById("lbl").innerHTML="Choose Your Pass[10 Daily/200 Monthly/1000 Yearly]!";
     }else{
        document.getElementById("lbl").innerHTML="Choose Your Pass[20 Daily/500 Monthly/3500 Yearly]!";
     }

     document.getElementById("in").type = "text";
     document.getElementById("in").value="";
     document.getElementById("a").onclick = next8;
 }

 function next8(){
     var pass = document.getElementById("in").value;
     document.getElementById("field").innerHTML=" Your pass price is " + pass +"  !!!!!";
     document.getElementById("field").style.animation = "end 4s";
     document.body.style.background = "RosyBrown";
 }