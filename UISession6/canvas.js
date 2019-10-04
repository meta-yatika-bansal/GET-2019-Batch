
  function  f1() {
      var canvas = document.getElementById("partly-cloudy-day");
      var ctx = canvas.getContext("2d");
      var img = new Image();   // Create new img element
      img.addEventListener('load', function() {
          ctx.drawImage(img, 0, 0);
      }, false);
      img.src = 'Session6Images/cloud.png';
  };
  
  function f2() {
      var canvas = document.getElementById("rain");
      var ctx = canvas.getContext("2d");
      var img = new Image();   // Create new img element
      img.addEventListener('load', function() {
          ctx.drawImage(img, 0, 0);
      }, false);
      img.src = 'Session6Images/rain.png';
  };
  
  function f3() {
      var canvas = document.getElementById("wind");
      var ctx = canvas.getContext("2d");
      var img = new Image();   // Create new img element
      img.addEventListener('load', function() {
          ctx.drawImage(img, 0, 0);
      }, false);
      img.src = 'Session6Images/wind.png';
  };
  
  function start() {
      f1();
      f2();
      f3();
  }
  
  window.onload = start;