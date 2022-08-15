import React from 'react'
import { useState } from 'react'
import { Link } from 'react-router-dom'
//import Login from './Login'
import logo from '../Images/dbsLogo.jpg'
//import Home from './Home'
import { Navigate,useNavigate } from 'react-router-dom'

const Landing = (props) => {

//======Styling button=====
const buttonStyle= {
  backgroundcolor: "#04AA6E",
  border: "none",
  padding: "10px 10px 10px 10px",
  textAlign: "center",
  color:"red",
  textdecoration: "none",
  display: "inline-block",
  fontsize: "16px",
  borderRadius: "20px",
  fontFamily:" Poppins sans-serif",
  margin: "4px 2px"
}


//========================
const navigate = useNavigate()
function checkLogout(){
  window.localStorage.removeItem("isLoggedIn")
  window.localStorage.setItem("isLoggedIn",false)
  console.log("Logged out ")
  
 // navigate("/")


}





//======================

  console.log("isLoggedIn"+window.localStorage.getItem("isLoggedIn"))
  const [employeeStatus,setEmployeeStatus]=useState(props.state)
  if(employeeStatus==true && window.localStorage.getItem("isLoggedIn")){
    console.log("Inside if  landing page:"+window.localStorage.getItem("isLoggedIn"))
  return (
    <div style={{
      backgroundColor: '#C7D7D7',
      padding: '10px 7px'
    }}>
      <div name="navbar" style={{
    //  backgroundColor: '#023d5d',
    backgroundColor: '#36454F',
      padding: '10px 10px',width:"1100px",height:"65px",margin:"auto",borderRadius: "40px" }}>
         <div>
          <img src={logo} alt="Image Here" style={{height:"40px",width:"80px",paddingLeft:"20px"}}/>
        
        <Link to="/home" state={{ empState: employeeStatus }} style={{textDecoration: 'none',paddingLeft:"100px"}}>  <button style={buttonStyle}><b> Home</b></button> </Link>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  
        <Link to="/transaction" state={{ empState: employeeStatus }} style={{textDecoration: 'none'}}><button style={buttonStyle}><b> Make Transaction</b></button> </Link>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <Link to="/customer" state={{ empState: employeeStatus }}style={{textDecoration: 'none'}}><button style={buttonStyle}><b> Customers</b></button> </Link> 
       <label htmlFor="Logout" style={{textDecoration: 'none',paddingLeft:"300px"}}>  <button style={buttonStyle} onClick={checkLogout} >Logout</button></label>
        </div>    
</div>
       
    </div>
  )
  }
  else{
   // alert("Please login")
    <div>Please Login</div>
  }
}

export default Landing