<?php
	date_default_timezone_set('America/New_York');
	$conn = new mysqli("classroom.cs.unc.edu","comp426f16","password123","aaronzdb");

	class Student{
		private $sid;
		private $fn;
		private $ln;
		private $courseTaken;

		private function __construct($sid, $fn, $ln, $ln, $courseTaken){
			$this->id = $sid;
    	$this->fn = $fn;
    	$this->ln = $ln;
    	$this->coureTaken = $courseTaken;
		}
		public function getId() {
    	return $this->sid;
  	}
 		public function getFirstName() {
    	return $this->fn;
  	}
  
  	public function getLastName() {
    	return $this->ln;
  	}
  	public getCourseTaken(){
  		return $this->courseTaken;
  	}
  	public function getStuOBJ() {
    	return json_encode(array(
        'firstname' => $this->getFirstName(),
        'lastname' => $this->getLastName(),
        'semesters' => $this->getCourseTaken()
      ));
  }
		public function findStudentBySID($SID){

			$conn = SQL::connect();

			$student_obj = $conn ->query("SELECT FN, LN FROM STUDENT WHERE sid = ". $sid);

			if($student_obj==null || $student_obj->num_rows ==0){
				//student not found
				return null;
			}else{$courseTaken = array()
				$hold = $student_obj->fetch_array()
				$sfn = $hold['FN'];
				$sln = $hold['LN'];
			}
			$courses_obj = $conn->query("SELECT c.Name, c.Semester, p.FN, p.LN FROM COURSESTAKEN ct, COURSE c, Professor p 
				WHERE p.profid = c.profid 
				AND c.cid = ct.cid AND ct.SID =".$sid);

			foreach($sturow as $courses_res->fetch_array()){
				$courseIndex = $sturow['SEMESTER']." ".$sturow["YEAR"];
				$courseTaken = new CoursesTaken($row['SEMESTER'], $row['YEAR']);

				$courseTaken ->addCourse(new Course($row['Name'], $row['fn'],$row['LN']))
				}
		
			return new Student($sod, $sfn, $sln, $courseTaken);	
			}

		}
		class Course{
			private $course_name;
			private $professor;
			public function __construct($course_name, $pfn, $pln){
				$this->course_name = $course_name;
				$this->professor = $pfn+" , "+$pln;
			}
			public function getCourseName(){
				return $this->course_name;
			}
			public function getProf(){
				return $this->professor;
			}
		}
		class CoursesTaken{
			$term;
			$year;
			$courses;

			public function __construct($semeste, $year){
				if($semester=='F'){$this->term ='Fall';}else{$this->term="Spring"}
				$this->year = intval("20"+$year);
				$this->courses = array();
			}
			public function getSemester(){
				return $this->term;
			}
			public function getYear(){
				return $this->year;
			}
			public function getCourses(){
				return $this->courses;
			}
			public function getCourseArr(){
				return array(
					'term'=> $this->getTerm(), 'year'=>$this->getYear(), 'courses'=>$this->courses);
			}
		}
?>
