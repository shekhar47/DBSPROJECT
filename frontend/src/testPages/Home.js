import React, { useState } from 'react'
import {useParams,useLocation} from 'react-router-dom'
import Login from './Login';

const Home = (props) => {
  
var employeeStatus=false
  const paramState=useLocation();
  if(paramState.state==null){
    console.log("param is null")
    employeeStatus=false}
  else{
  const {empState}=paramState.state;
  if(empState===true){
    employeeStatus=empState
  }
  }
 console.log(""+window.localStorage.getItem("isLoggedIn"))
 console.log(paramState)
 //console.log(empState)
  
  if(employeeStatus==true){
  return (
    <div>
      
    <div clas="logo" align="center">
    
        <img className="logo"  style={{height:500, width:"100%", paddingLeft:10 ,paddingRight:1, paddingTop:5}}
     src="https://media-exp1.licdn.com/dms/image/C5622AQG1JPUwhxCuUw/feedshare-shrink_2048_1536/0/1660356001647?e=1663200000&v=beta&t=JPxOUiV50ifWSZl1Dzk2zgiITkKIeRJi-eMITbbh5m4" alt="DBS Achievements" />
      </div>




    </div>
  )
  }
  else{
   // alert("Please Login!")
    return ;
  }
}

export default Home