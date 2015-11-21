<?php
require_once 'include/DB_Functions.php';
$db = new DB_Functions();
 
// json response array
$response = array("error" => FALSE);
 
if (isset($_POST['email'])) {
 
    // receiving the post params
    $email = $_POST['email'];
    $result = $db->getpoints($email);
    if($result){
        $response['water']=$result['water'];
        $response['waste']=$result['waste'];
        $response['transport']=$result['transport'];
        $response['energy']=$result['energy'];
        echo json_encode($response);
    }
}
else{
    $response["error"] = TRUE;
        $response["error_msg"] = "Login email error!";
        echo json_encode($response);
}




?>
    
