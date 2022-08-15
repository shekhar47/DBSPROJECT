import React, { useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import { Link } from "react-router-dom";
import Landing from "./Landing";
import "./CSS/Login.css"

function Login() {

  const [employeeStatus,setEmployeeStatus]=useState(false)
  const [empId,setEmpId]=useState("")
  const [empPwd,setEmpPwd]=useState("")

  const [statusMessage,setStatusMessage]=useState("")
function check(){
  
  console.log(employeeStatus);
  console.log(empId+" "+empPwd);
  if(empId==="513776"&&empPwd==="Shekhar@47"){
    setStatusMessage("")
    window.localStorage.setItem("isLoggedIn",true)
    alert("Login Successfull")
  setEmployeeStatus(true);
  }
  else{
    alert("Invalid Credentials");
    setStatusMessage("Incorrect Deatials")
    window.localStorage.setItem("isLoggedIn",false)

    setEmployeeStatus(false);
  }
}

  if(employeeStatus===false){
  
  return (
    <div name="Login" backgroundcolor="cyan">

      <div className="login_form">
        <form className="login">

          <input type="text" required placeholder="Username" name="userId" value={empId} onChange={(e)=>setEmpId(e.target.value)} /><br />
          <input type="password" required placeholder="User Password" name="userPwd" value={empPwd} onChange={(e)=>setEmpPwd(e.target.value)}/><br />
          <button onClick={check}>Login</button>
          <br />
          {statusMessage}
        </form>


      </div>
      </div>
     

   
  );
  }
  
  else{

  return(<Landing state={employeeStatus}/>)}

}
export default Login;