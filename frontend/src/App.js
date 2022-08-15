import { useState } from "react";

import { BrowserRouter, Route, Routes } from "react-router-dom";
import StatusPage from "./Components/StatusPage";
import TransactionPage from "./Components/TransactionPage";
import CustomerData from "./testPages/CustomerData";
import Home from "./testPages/Home";
//import Landing from "./testPages/Landing";
import Login from "./testPages/Login";
//import ".\CSS\Login.css"


function App() {

  const [employeeStatus,setEmployeeStatus]=useState(false)

  return (
    <div className="App">
     
     { <Login/>}
      <Routes>
       
        <Route path="/transaction" element={<TransactionPage />} />
        <Route path="/home" element={<Home />} />
        <Route path="/login" element={<Login />} />
          <Route path="/customer" element={<CustomerData />}/>
          <Route path="/TrstatusPage" element={<StatusPage />}/>
      </Routes>
     
    </div>
  );
}

export default App;
