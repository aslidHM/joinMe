

var show = document.getElementById("nav-links");
function showMenu() {
        show.style.right = "0";
}
function closeMenu() {
        show.style.right = "-200px";
}
function togglePopup2() {
        document.getElementById("popup-2").classList.toggle("active");
}

function togglePopup(index) {
        document.getElementById(index).classList.toggle("active");
}
function isOwner() {
  var x = document.getElementsByClassName("notMyActivity");
  for(var i = 0; i<x.length; i++) {
      x[i].style.display = "none";
  }
}
function showAll() {
  var x = document.getElementsByClassName("notMyActivity");
  for(var i = 0; i<x.length; i++) {
    if (x[i].style.display == "none") {
        x[i].style.display = "block";
    }
  }
}

function addValue(block, addMe) {
        var v = document.getElementById("hidden-field").value;
        var len = block.length;

        var vv = block[len-1].text;

        if(v === vv){
            block[len-1] = null
            addMe.setAttribute('value', 'Add Me +');
        }
        else{
        var AddOpt = new Option(v, v);
            block[len] = AddOpt;
            addMe.setAttribute('value', 'Remove Me -');
        }
        return true;
}


function myCategory() {
  var category = document.getElementById("select-box").value;
  var lunch = document.getElementsByClassName("lunch");
  var exercise = document.getElementsByClassName("exercise");
  var fika = document.getElementsByClassName("fika");
  var run = document.getElementsByClassName("run");
  var meet = document.getElementsByClassName("meet");
  var allCategories = "allCategories"

  if(category == "lunch"){

      for(var i = 0; i<lunch.length; i++) {
          if (lunch[i].style.display === "none") {
                  lunch[i].style.display = "block";
          }
      }
      for(var i = 0; i<exercise.length; i++) {
          exercise[i].style.display = "none";
      }
      for(var i = 0; i<fika.length; i++) {
                fika[i].style.display = "none";
      }
      for(var i = 0; i<run.length; i++) {
                run[i].style.display = "none";
      }
      for(var i = 0; i<meet.length; i++) {
                meet[i].style.display = "none";
      }
  }
  if(category == "exercise"){
        for(var i = 0; i<exercise.length; i++) {
            if (exercise[i].style.display === "none") {
                    exercise[i].style.display = "block";
            }
        }
        for(var i = 0; i<lunch.length; i++) {
            lunch[i].style.display = "none";
        }
        for(var i = 0; i<fika.length; i++) {
                  fika[i].style.display = "none";
        }
        for(var i = 0; i<run.length; i++) {
                  run[i].style.display = "none";
        }
        for(var i = 0; i<meet.length; i++) {
                  meet[i].style.display = "none";
        }
  }
  if(category == "fika"){
          for(var i = 0; i<fika.length; i++) {
              if (fika[i].style.display === "none") {
                      fika[i].style.display = "block";
              }
          }
          for(var i = 0; i<lunch.length; i++) {
              lunch[i].style.display = "none";
          }
          for(var i = 0; i<exercise.length; i++) {
                    exercise[i].style.display = "none";
          }
          for(var i = 0; i<run.length; i++) {
                    run[i].style.display = "none";
          }
          for(var i = 0; i<meet.length; i++) {
                    meet[i].style.display = "none";
          }
  }
  if(category == "run"){
            for(var i = 0; i<run.length; i++) {
                if (run[i].style.display === "none") {
                        run[i].style.display = "block";
                }
            }
            for(var i = 0; i<lunch.length; i++) {
                lunch[i].style.display = "none";
            }
            for(var i = 0; i<exercise.length; i++) {
                      exercise[i].style.display = "none";
            }
            for(var i = 0; i<fika.length; i++) {
                      fika[i].style.display = "none";
            }
            for(var i = 0; i<meet.length; i++) {
                      meet[i].style.display = "none";
            }
  }
  if(category == "meet"){
              for(var i = 0; i<meet.length; i++) {
                  if (meet[i].style.display === "none") {
                          meet[i].style.display = "block";
                  }
              }
              for(var i = 0; i<lunch.length; i++) {
                  lunch[i].style.display = "none";
              }
              for(var i = 0; i<exercise.length; i++) {
                        exercise[i].style.display = "none";
              }
              for(var i = 0; i<fika.length; i++) {
                        fika[i].style.display = "none";
              }
              for(var i = 0; i<run.length; i++) {
                        run[i].style.display = "none";
              }
  }
  if(category == "allCategories"){
                for(var i = 0; i<meet.length; i++) {
                    meet[i].style.display = "block";
                }
                for(var i = 0; i<lunch.length; i++) {
                    lunch[i].style.display = "block";
                }
                for(var i = 0; i<exercise.length; i++) {
                    exercise[i].style.display = "block";
                }
                for(var i = 0; i<fika.length; i++) {
                    fika[i].style.display = "block";
                }
                for(var i = 0; i<run.length; i++) {
                     run[i].style.display = "block";
                }
    }
}




