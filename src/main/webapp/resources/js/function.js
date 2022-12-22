function deleteStudents(){
    var checkedCheckboxs = document.querySelectorAll('input[name=idStudent]:checked')
    if(checkedCheckboxs.length == 0){
        alert("Выберите хотя бы одного студента!")
        return;
    }
    // "1 2 5 7" - string
    var ids = ""
    for(var i = 0; i < checkedCheckboxs.length; i++){
        ids = ids + checkedCheckboxs[i].value + ",";
    }
    ids = ids.substring(0, ids.length - 1);


    document.getElementById("deleteStudentHidden").value = ids;
    document.getElementById('deleteStudentForm').submit();
}

function deleteDisciplin(){
    var checkedCheckboxs = document.querySelectorAll('input[name=idDisciplin]:checked')
    if(checkedCheckboxs.length == 0){
        alert("Выберите хотя бы одну дисциплину!")
        return;
    }
    // "1 2 5 7" - string
    var ids = ""
    for(var i = 0; i < checkedCheckboxs.length; i++){
        ids = ids + checkedCheckboxs[i].value + ",";
    }
    ids = ids.substring(0, ids.length - 1);
    document.getElementById("deleteDisciplinHidden").value = ids;
    document.getElementById('deleteDisciplinForm').submit();
}

function progressStudent(){
    var checkedCheckboxs = document.querySelectorAll('input[name=idStudent]:checked')
    if(checkedCheckboxs.length != 1 ){
        alert("Выберите только одного студента!")
        return;
    }
    // "1 2 5 7" - string
    var id = checkedCheckboxs[0].value;

    document.getElementById("progressStudentHidden").value = id;
    document.getElementById('progressStudentForm').submit();
}

function deleteNews(){
    var checkedCheckboxs = document.querySelectorAll('input[name=idNews]:checked')
    if(checkedCheckboxs.length == 0){
        alert("Выберите хотя бы одну новость!")
        return;
    }
    // "1 2 5 7" - string
    var ids = ""
    for(var i = 0; i < checkedCheckboxs.length; i++){
        ids = ids + checkedCheckboxs[i].value + ",";
    }
    ids = ids.substring(0, ids.length - 1);


    document.getElementById("deleteNewsHidden").value = ids;
    document.getElementById('deleteNewsForm').submit();
}