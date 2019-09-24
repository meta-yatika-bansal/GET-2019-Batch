function hello(formId){
    if("block" == document.getElementById(formId).style.display){
        return document.getElementById(formId).style.display = "none";
    }else{
        return document.getElementById(formId).style.display = "block";
    }
}