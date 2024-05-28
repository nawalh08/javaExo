var startTime; // Temps de début
var stopwatchInterval; // Intervale
var elapsedPausedTime = 0; 
let temps = 0;
let chrono = [];
let displayTime

function startStopwatch() {
  if (!stopwatchInterval) {
    startTime = new Date().getTime() - elapsedPausedTime; 
    stopwatchInterval = setInterval(updateStopwatch, 1000); 
    console.log(chrono);
  }
}

function stopStopwatch() {
  clearInterval(stopwatchInterval); 
  elapsedPausedTime = new Date().getTime() - startTime; 
  stopwatchInterval = null; 
  console.log(elapsedPausedTime);
  chrono.push(displayTime)
}

function resetStopwatch() {
  stopStopwatch();
  elapsedPausedTime = 0; 
  document.getElementById("stopwatch").innerHTML = "00:00:00"; 
}

function updateStopwatch() {
  var currentTime = new Date().getTime();
  var elapsedTime = currentTime - startTime; 
  var seconds = Math.floor(elapsedTime / 1000) % 60; 
  var minutes = Math.floor(elapsedTime / 1000 / 60) % 60; 
  var hours = Math.floor(elapsedTime / 1000 / 60 / 60); 
  displayTime = pad(hours) + ":" + pad(minutes) + ":" + pad(seconds); 
  document.getElementById("stopwatch").innerHTML = displayTime; 
  if(displayTime === temps){
    play("./assets/ring.mp3",5000)
    
  }
}

function pad(number) {
  
  return (number < 10 ? "0" : "") + number;
}

function getTimes(){
    temps = document.getElementById('tps').value;
    console.log(temps);
}

function play( audio_path, time_in_milisec){
  let beep = new Audio( audio_path);
  beep.loop = true;
  beep.play();
  setTimeout(() => { beep.pause(); }, time_in_milisec);
  }