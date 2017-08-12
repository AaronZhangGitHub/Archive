<?php

require_once("sql.php");

class Course {
  
  private $course_name;
  private $professor;
  
  public function __construct($course_name, $pfirst, $plast) {
    $this->course_name = $course_name;
    $this->professor = $plast . ", " . $pfirst;
  }
  
  public function getCourseName() {
    return $this->course_name;
  }
  
  public function getProfessor() {
    return $this->professor;
  }
  
  public function asMap() {
    return array(
      'course_name' => $this->getCourseName(),
      'professor' => $this->getProfessor()
    );
  }
}

class Semester {
  
  private $term;
  private $year;
  private $courses;
  
  public function __construct($semester, $year) {
    if ($semester == "F") $this->term = "Fall";
    else if ($semester == "S") $this->term = "Spring";
    
    $this->year = intval("20" . $year);
    $this->courses = array();
  }
  
  public function getTerm() {
    return $this->term;
  }
  
  public function getYear() {
    return $this->year;
  }
  
  public function getCourses() {
    return $this->courses;
  }
  
  public function addCourse($course) {
    $this->courses[] = $course;
  }
  
  public function getCoursesAsMap() {
    $c2j = function($course) { return $course->asMap(); };    
    return array_map($c2j, $this->getCourses());
  }
  
  public function asMap() {
    return array(
        'term' => $this->getTerm(),
        'year' => $this->getYear(),
        'courses' => $this->getCoursesAsMap()
      );
  }
  
}

class Student {
  
  public static function getAllIds($first_name = "", $last_name = "") {
    $conn = SQL::connect();
    
    $result = $conn->query(
      sprintf("SELECT sid FROM Student WHERE FirstName LIKE '%s%%' AND LastName LIKE '%s%%'", $first_name, $last_name)
    );
    
    $id_array = array();
    if ($result) {
      while ($next_row = $result->fetch_array()) {
        $id_array[] = intval($next_row['sid']);
      }      
    }
    
    return $id_array;
  }
  
  public static function findById($sid) {
    $conn = SQL::connect();
    
    $student_res = $conn->query("SELECT FirstName, LastName FROM Student WHERE sid = " . $sid);
    if ($student_res) {
      if ($student_res->num_rows == 0) {
        return null;
      }
      $student_info = $student_res->fetch_array();

      $semesters = array();
      $courses_res = $conn->query(
        sprintf("SELECT c.CourseName, c.Semester, c.Year, p.FirstName, p.LastName FROM CourseTaken t, Course c, Professor p WHERE t.sid = %s AND c.cid = t.cid AND p.profid = c.profid", $sid)
      );
      while ($row = $courses_res->fetch_array()) {
        $key = $row["Semester"] . " " . $row["Year"];
        if (array_key_exists($key, $semesters)) {
          $semester = $semesters[$key];
        } else {
          $semester = new Semester($row["Semester"], $row["Year"]);
          $semesters[$key] = $semester;
        }
        
        $semester->addCourse(new Course($row["CourseName"], $row["FirstName"], $row["LastName"]));
      }
      
      return new Student($sid, $student_info['FirstName'], $student_info['LastName'], $semesters);
    }
    
    return null;
  }
  
  private $id;
  private $first_name;
  private $last_name;
  private $semesters;
  
  private function __construct($id, $first_name, $last_name, $semesters) {
    $this->id = $id;
    $this->first_name = $first_name;
    $this->last_name = $last_name;
    $this->semesters = $semesters;
  }
  
  public function getId() {
    return $this->id;
  }
  
  public function getFirstName() {
    return $this->first_name;
  }
  
  public function getLastName() {
    return $this->last_name;
  }
  
  public function getSemesters() {
    return $this->semesters;
  }
  
  public function getSemestersAsMap() {
    $s2j = function($semester) { return $semester->asMap(); };    
    return array_map($s2j, array_values($this->getSemesters()));
  }
  
  public function getJSON() {
    return json_encode(array(
        'firstname' => $this->getFirstName(),
        'lastname' => $this->getLastName(),
        'semesters' => $this->getSemestersAsMap()
      ));
  }
}

?>