import axios from "axios";
import React, { useEffect } from "react";
import { useState } from "react";
import "./CSS/CustomerData.css";
import {useParams,useLocation} from 'react-router-dom'

const CustomerData = () => {

  
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
  
  const [customerId, setCustomerId] = useState("");
  const [customer_id, setCustomer_id] = useState("");
  const [customer, setCustomer] = useState([]);
  const [overdraftValue, setOverdraftValue] = useState("");
  const [error_id,setError_id] = useState("");


  async function loadCustomer(e) {
    e.preventDefault();
    console.log(customer_id);
    // setCustomerId(e.target.value);
    if(customer_id.length<14){ 
      setError_id("Account ID not Found. Please enter valid ID");
      setCustomer([]);
      setOverdraftValue("");
    }
    else {
      const details=await axios
      .get(`http://localhost:8041/fetchbyid/${customer_id}`)
      console.log(details)
      setCustomer(details.data)
   
    }
      
  }
  if(employeeStatus==true){

  return (
    <div style={{fontSize:"18px",backgroundColor: '#C7D7D7'}} >
      <h2 style={{fontSize:"25px"}}>Customer Details</h2>
      <center>
        <form>
          <div className="formss">
            <input
              type="text"
              name="customer_id"
              placeholder="Enter employee id"
              value={customer_id}
              onChange={(e) => setCustomer_id(e.target.value)}
            ></input>
            <button
              type="button"
              className="btn btn-primary btn-lg"
              onClick={loadCustomer}
            >
              search
            </button><br></br>
            <div>{error_id}</div>
          </div>
        </form>
      </center>
      <br />
      <br />

      <table className="table table-borderless" style={{fontSize:"18px"}}>
        <tbody>
          <tr>
            <td>Customer ID</td>
            <td>{customer.customerid}</td>
          </tr>
          <tr>
            <td>Customer Name</td>
            <td>{customer.accountholdername}</td>
          </tr>
          <tr>
            <td>Overdraft Status</td>
            <td>{customer.overdraftflag}</td>
          </tr>
          <tr>
            <td>Clear Balance</td>
            <td>{customer.clearbalance}</td>
          </tr>
          <tr>
            <td>Customer City</td>
            <td>{customer.customercity}</td>
          </tr>
          <tr>
            <td>Customer Address</td>
            <td>{customer.customeraddress}</td>
          </tr>
        </tbody>
      </table>
    </div>
  );}
  else {
  return }
};

export default CustomerData;