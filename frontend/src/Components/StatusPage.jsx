import React from 'react'
import { Link, Navigate, useNavigate } from 'react-router-dom'

const StatusPage = () => {
  const navigate=useNavigate();
  console.log(window.localStorage.getItem("isLoggedIn")+"  ")
  if(window.localStorage.getItem("isLoggedIn")){
  return (
    
    <div> Transaction Successfull{window.localStorage.getItem("isLoggedIn")}

<Link to="/transaction"><button>Make Another Transaction</button></Link>

    </div>
   
  )
  }
  else{
    return (
      <div>Please login</div>
    )
  }
}

export default StatusPage