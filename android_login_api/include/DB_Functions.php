<?php
 
class DB_Functions {
 
    private $conn;
 
    // constructor
    function __construct() {
        require_once 'DB_Connect.php';
        // connecting to database
        $db= new Db_Connect();
        $this->conn = $db->connect();
    }
 
    // destructor
    function __destruct() {
         
    }
 
    /**
     * Storing new user
     * returns user details
     */
    public function storeUser($name, $email, $password) {
        
        $uuid = uniqid('', true);
        $hash = $this->hashSSHA($password);
        $encrypted_password = $hash["encrypted"]; // encrypted password
        $salt = $hash["salt"]; // salt
 
      // $sql = "INSERT INTO users(unique_id, name, email, encrypted_password, salt, created_at) VALUES($uuid, '$name', '$email', '$encrypted_password', '$salt', NOW())";
        
        $stmt = $this->conn->prepare("update users set name='$name', email='$email', encrypted_password='$encrypted_password', salt='$salt', created_at=NOW() where unique_id=3");
        //$stmt->bind_param("sssss", $uuid, $name, $email, $encrypted_password, $salt);
     //$stmt->execute();
    //    $result=$stmt->fetch();
    //   $stmt->close();
        
        
        // check for successful store
        if ($stmt->execute()) {
            $stmt->close();
            $stmt1= $this->conn->prepare("SELECT * FROM users WHERE email = ?");
            $stmt1->bind_param("s", $email);
            $stmt1->execute();
            $user = $stmt1->get_result()->fetch_assoc();
            $stmt1->close();
            return $user;
        } else {
            return false;
        }
    }
 
    /**
     * Get user by email and password
     */
    public function getUserByEmailAndPassword($email, $password) {
 
        $stmt = $this->conn->prepare("SELECT * FROM users WHERE email = ?");
 
        $stmt->bind_param("s", $email);
 
        if ($stmt->execute()) {
            $user = $stmt->get_result()->fetch_assoc();
            $stmt->close();
            return $user;
        } else {
            return NULL;
        }
    }
 
    /**
     * Check user is existed or not
     */
    public function isUserExisted($email) {
        $stmt = $this->conn->prepare("SELECT email from users WHERE email = ?");
 
        $stmt->bind_param("s", $email);
 
        $stmt->execute();
 
        $stmt->store_result();
 
        if ($stmt->num_rows > 0) {
            // user existed 
            $stmt->close();
            return true;
        } else {
            // user not existed
            $stmt->close();
            return false;
        }
    }
 
    /**
     * Encrypting password
     * @param password
     * returns salt and encrypted password
     */
    public function hashSSHA($password) {
 
        $salt = sha1(rand());
        $salt = substr($salt, 0, 10);
        $encrypted = base64_encode(sha1($password . $salt, true) . $salt);
        $hash = array("salt" => $salt, "encrypted" => $encrypted);
        return $hash;
    }
 
    /**
     * Decrypting password
     * @param salt, password
     * returns hash string
     */
    public function checkhashSSHA($salt, $password) {
 
        $hash = base64_encode(sha1($password . $salt, true) . $salt);
 
        return $hash;
    }
    
    public function getpoints($email){
        $stmt = $this->conn->prepare("SELECT water, energy, transport, waste from pins WHERE email = ?");
 
        $stmt->bind_param("s", $email);
 
        $stmt->execute();
        $points = $stmt->get_result()->fetch_assoc();
        return $points;
        //$stmt->store_result();    
    }
    
    public function setpoints($email,$value,$category){
        $pwater=0;
        $penergy=0;
        $pwaste=0;
        $ptransport=0;
        
        if(strcmp('Water',$category)==0)
        {
            $pwater=$value;
        }
        if(strcmp('Energy',$category)==0){
            $penergy=$value;
        }
        if(strcmp('Transport',$category)==0){
            $ptransport=$value;
        }
        if(strcmp('Waste',$category)==0){
            $pwaste=$value;
        }
        
        $sql="update pins set water = $pwater + water, energy = energy + $penergy, waste = waste + $pwaste, transport = transport + $ptransport where email = '$email'";
        $stmt = $this->conn->prepare($sql);
 
        //$stmt->bind_param("s", $email);
 
        if($stmt->execute())
            return true;
        else
        //$points = $stmt->get_result()->fetch_assoc();
            return false;
        //$stmt->store_result();    
    }
    

}
 
?>