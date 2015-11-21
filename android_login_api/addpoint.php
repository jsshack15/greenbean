<?php
require_once 'include/DB_Functions.php';
$db = new DB_Functions();
 
// json response array
$response = array("error" => FALSE);
 
if (isset($_POST['email']) && isset($_POST['category']) && isset($_POST['value'])) {
 
    // receiving the post params
    $email = $_POST['email'];
    $category=$_POST['category'];
    $value=$_POST['value'];
    
    $result = $db->setpoints($email,(int)$value,$category);
    if($result){
        $response['error']=FALSE;
        $response['message']="Successfully added points";
        echo json_encode($response);
    }
}
else{
    $response["error"] = TRUE;
        $response["error_msg"] = "point not add error!";
        echo json_encode($response);
}




?>
    
