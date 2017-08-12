<?php
	require_once("studentorm.php");

	$path = $_SERVER['REQUEST_URI'];
	$path_components = explode('/', $path);

	if($_SERVER['REQUEST_METHOD']=="GET"){
		if(sizeof($path_components>=2) && (path_components[1]!="")){
			//transcript.php/<id>, should return specific student
			$sid = intval($path_components[1]);
			$student = Student::findStudentBySID($sid);

			if($student==null){
				header("HTTP/1.0 404 Not Found");
        print("Student ID: " . $sid . " not found.");
        exit();
			}
		}else if(sizeof($path_components>=1)&&path_components[0]!=""){
			//return index of all students
			$student = Student::getStudentOBJ();
		}
		print($student);
		exit();
	}else if()
?>
