<?php
require_once 'include/DB_Functions.php';
$db = new DB_Functions();
 
// json response array
$response = array("error" => FALSE);
 $result=$db->gettotal();
    //echo $result;
    echo json_encode($result);
?>