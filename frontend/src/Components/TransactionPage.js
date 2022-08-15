import axios from "axios";
//import { Link } from 'react-router-dom'
import DateSet from "./DateSet";
import { useState, useEffect } from "react";
import StatusPage from "./StatusPage";
import {useParams,useLocation} from 'react-router-dom'
import { Navigate, useNavigate } from "react-router-dom";


function TransactionPage() {


  //---------Employee State Validation------------
   
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




  //----------------------------------------------

  
  const fee = 0.0025;
  const [trFee, setTrFee] = useState(0);
  const [senderId, setSenderId] = useState("");
  const [senderName, setSenderName] = useState("");
  const [senderBalance, setSenderBalance] = useState(0);
  const [senderStatus, setSenderStatus] = useState("");
  const [currencyCode, setCurrencyCode] = useState("INR");
  const [conversionrate, setConversionRate] = useState(0);
  //const [reciverBIC,setRecieverBIC]=useState("")
  const [bankStatus, setBankStatus] = useState("");
  const [bankId, setBankId] = useState("");
  const [bankName, setBankName] = useState("");
  const [recName, setRecName] = useState("");
  const [recNumber, setRecNumber] = useState("");
  const [trType, setTrType] = useState("");
  const [msgCode, setMsgCode] = useState("");
  const [amount, setAmount] = useState();
  const [clrBalance, setClrBalance] = useState();
  const [overDraft,setOverdraft]=useState()
  const navigate=useNavigate()


  
  //-------Transaction Object--------

const [transaction,setTransaction]=useState({currency:{} ,senderbank:{},recieverbank:{}, accountholdernumber:"",recieveraccountholdername:"",transferType:{},message:{},currencyamount:0,transferfees:0,inramount:0,transferdate:"",customer:{}})
transaction.senderbank={
  bic:"DBSHYDINDXX",
 bankname:"DBS BANK LTD, HYD BRANCH"
}

//-----------bUTTTON sTYLE--------------------------------
const buttonStyle= {
  backgroundcolor: "#04AA6E",border: "none",padding: "10px 10px 10px 10px",textAlign: "center",color:"red",textdecoration: "none",display: "inline-block",fontsize: "16px",borderRadius: "20px",fontFamily:" Poppins sans-serif",margin: "4px 2px"
}

//======================================================



function Details(){
 
  const senderBankId="DBSHYDINDXX"
  console.log("---Details---")
    console.log(senderId)
    console.log(senderName)
    console.log(senderBalance)
    console.log(currencyCode+ " "+conversionrate)
    console.log(bankId+ " "+bankName)
    console.log(recName)
    console.log(recNumber)
    console.log(trType)
    console.log(msgCode)
    console.log(amount)
    console.log(trFee)
    console.log(clrBalance)

    const trStatus=makeTransaction();
   // console.log(trStatus)
    async function makeTransaction(){


console.log("senderId:"+senderId)
console.log("currency Code:"+currencyCode)
console.log("senderBankId:"+senderBankId)
console.log("bankId:"+bankId)
console.log("msgCode:"+msgCode)
console.log("trType:"+trType)
console.log("amount:"+amount)
console.log("trFee:"+trFee)
console.log("clrBalance:"+clrBalance)
console.log("senderName:"+senderName)
console.log("senderName:"+recName)
console.log("overdraft:"+overDraft)
var result="";
if(senderId===""||currencyCode===""||bankId==""||amount===""){console.log("Enter Details Properly")}
else{

    if(clrBalance<=senderBalance){
     result=await axios.post(`http://localhost:8041/api/transaction/proceed/${senderId}/${currencyCode}/${senderBankId}/${bankId}/${msgCode}/${trType}/${amount}/${trFee}/${clrBalance}/${senderName}/${recName}`)
    }
    else 
    {
      if(overDraft==1){
      result=await axios.post(`http://localhost:8041/api/transaction/proceed/${senderId}/${currencyCode}/${senderBankId}/${bankId}/${msgCode}/${trType}/${amount}/${trFee}/${clrBalance}/${senderName}/${recName}`)

      }
      else{
        console.log("Customer Balance is low to send money!")
      }
    }
    // const result=await axios.post(`http://localhost:8041/api/transaction/${hello}/${world}/${hello}/${world}/${hello}/${world}/${hello}/${world}/${hello}/${world}/${hello}/${world}`)
    console.log(result.data)  
    if(result.data==="Transaction Successfull")
    navigate("/TrStatusPage")
    else
    console.log("Error Occured")
    return result;
    }
    }

}


  useEffect(() => {
    if (senderId.length === 14) {
      console.log("inside the function");
      axiosTest();
      setSenderStatus("Customer Not Found");

      async function axiosTest() {
        var response = 1;
        const res=await axios
          .get(`http://localhost:8041/fetchbyid/${senderId}`)
         
          if (res.data.customerid == null)
             { setSenderStatus("Customer Not Found"); }
            else{ 
            setSenderStatus("");
            console.log(res.data)
            setOverdraft(res.data.overdraftflag)
            console.log(overDraft)
            setTransaction({customer:res.data})
            setSenderBalance(res.data.clearbalance);
            setSenderName(res.data.accountholdername);}
           

        return response;
      }
    } else {
      setSenderBalance(0);
      setSenderName("");
      setBankId("");
      setBankName("");
    }
    return () => {};
  }, [senderId]);

  function currencyHandler(value) {
    console.log(value);
    currencyCall();
    async function currencyCall() {
      await axios
        .get(`http://localhost:8041/api/currency/findbyid/${value}`)
        .then((res) => {
          console.log("Conversion rate: " + res.data.conversionrate);
          setTransaction({currency:res.data})

          console.log("conversion rate set");
          setCurrencyCode(res.data.currencycode);
          setConversionRate(res.data.conversionrate);
        });
    }
  }

  function transferTypeHandler(value) {
    transferTypeCall();
    async function transferTypeCall() {
      await axios
        .get(`http://localhost:8041/transfertype/findbyid/${value}`)
        .then((res) => {
          setTransaction({transferType:res.data})
          setTrType(res.data.transfertype);
          console.log(res.data.transfertype);
          console.log(res.data.transfertypedescription);
        });
    }
  }

  function messageCodeHandler(value) {
    messageCode();
    async function messageCode() {
      await axios
        .get(`http://localhost:8041/message/findbyid/${value}`)
        .then((res) => {
          setTransaction({message:res.data})
          setMsgCode(res.data.messagecode);
          console.log(res.data.messagecode);
          console.log(res.data.instruction);
        });
    }
  }

  //
  
  useEffect(() => {
    
    setAmount(parseFloat(amount));
    setTrFee(parseFloat(amount)*fee)
   
  }, [amount]);

  useEffect(() => {
    setTrFee(parseFloat(amount)*fee)
    console.log(trFee);
    setClrBalance(trFee+parseFloat(amount))
    
  
  }, [trFee])
  useEffect(() => {
    setClrBalance(trFee+parseFloat(amount))
    console.log(clrBalance);
   
  }, [clrBalance])
  
  

  function ValiditeCustomerState() {
    if (senderName === "") return true;
    else return false;
  }

  useEffect(() => {
    //console.log("inside the BANK function");
    if (bankId.length === 11) {
      console.log("inside the IF function");
      axiosTest();
      setBankStatus("Bank Not Found");

      async function axiosTest() {
        var response = 1;
        await axios
          .get(`http://localhost:8041/bank/fetchbyid/${bankId}`)
          .then((res) => {
            console.log("Bank Details:" + res.data);
            if (res.data.bic == null) setBankStatus("Bank Not Found");
            else {
              setTransaction({recieverbank:res.data})
              setSenderStatus("");
              console.log(res.data.bic);
              console.log(res.data.bankname);
              setBankStatus("");
              setBankId(res.data.bic);
              setBankName(res.data.bankname);
            }
          })
          .catch((err) => {
            console.log(err);
          });
        return response;
      }
    } else {
      setBankName("");
    }

    return () => {};
  }, [bankId]);

  if(employeeStatus==true){

  return (
    <div className="App"  style={{
      backgroundColor: '#C7D7D7',
      padding: '10px 7px'
    }} >
      <div id="name">
        <DateSet/>
      </div>
      

      <div class="senderDetails" style={{borderStyle:"inset"}}>

{/* 
      <h5 align="center" ><strong>-----Sender Details------ </strong></h5>
      <br /> */}
      <br />
      <label htmlFor="lcid" style={{fontFamily: "Times New Roman, Times, serif",fontSize:"20px",fontWeight:"bold",paddingLeft:"20px"}}>Customer Id </label>&nbsp;&nbsp;&nbsp;&nbsp;
      <input
        type="text"
        maxLength="14"
        required
        id="sid"
        name="sid"
        value={senderId}
        onChange={(e) => setSenderId(e.target.value)}
      />
     
      
      <label htmlFor="lname" style={{fontFamily: "Times New Roman, Times, serif",fontSize:"20px",fontWeight:"bold",paddingLeft:"20px"}}>Account Holder Name</label> &nbsp;&nbsp;&nbsp;
      <input
        type="text"
        id="sname"
        name="sname"
        value={senderName}
        required
        readOnly
      />
     
      <label htmlFor="lbal"  style={{fontFamily: "Times New Roman, Times, serif",fontSize:"20px",fontWeight:"bold",paddingLeft:"20px"}}>Clear Balance </label>&nbsp;&nbsp;&nbsp;{" "}
      <input
        type="text"
        id="sbal"
        name="sbal"
        readOnly
        required
        value={senderBalance}
      />
       
      <br />
      {senderStatus}
   
     
      <br />
      <label htmlFor="Currency" style={{fontFamily: "Times New Roman, Times, serif",fontSize:"20px",fontWeight:"bold",paddingLeft:"500px"}}>Currency&nbsp;&nbsp;&nbsp;&nbsp;</label>
      <select
        onChange={(e) => currencyHandler(e.target.value)}
        value={currencyCode}
      >
        <option value="--" name="--">
          ---
        </option>
        <option value="USD" name="USD">
          USD
        </option>
        <option value="GBP" name="GBP">
          GBP
        </option>
        <option value="JPY" name="JPY">
          JPY
        </option>
        <option value="EUR" name="EUR">
          EUR
        </option>
      </select>
      </div>
      <br />
      <br />
     <div className="RecieverDetails" style={{borderStyle:"inset",textAlign:"center"}}>
      {/* <h5 align="center"><b> ------Reciever Details------</b></h5>
   
      <br /> */}
      <br />
      <label htmlFor="RecieverBIC" style={{fontFamily: "Times New Roman, Times, serif",fontSize:"20px",fontWeight:"bold",paddingLeft:"20px"}}>Reciever BIC</label>&nbsp;&nbsp;&nbsp;&nbsp;
      <input
        type="text"
        maxLength="11"
        required
        disabled={ValiditeCustomerState()}
        value={bankId}
        onChange={(e) => {
          setBankId(e.target.value);
        }}
      />
      {bankStatus} 
      <label htmlFor="RecieverBankname" style={{fontFamily: "Times New Roman, Times, serif",fontSize:"20px",fontWeight:"bold",paddingLeft:"20px"}}>Bank Name</label>
      &nbsp;&nbsp;&nbsp;&nbsp;
      <input
        type="text"
        value={bankName}
        readOnly
        name="recieverbankname"
        id="recieverbankname"
      />
      <br />
      <br />
      <label htmlFor="raccountname" style={{fontFamily: "Times New Roman, Times, serif",fontSize:"20px",fontWeight:"bold",paddingLeft:"20px"}}>
        Reciever Name&nbsp;&nbsp;&nbsp;&nbsp;
      </label>
      <input
        type="text"
        required
        value={recName}
        disabled={ValiditeCustomerState()}
        onChange={(e) => {
          setRecName(e.target.value);
        }}
      />
      
      <label htmlFor="raccountnumber" style={{fontFamily: "Times New Roman, Times, serif",fontSize:"20px",fontWeight:"bold",paddingLeft:"20px"}}>
        Reciever Account Number&nbsp;&nbsp;&nbsp;&nbsp;
      </label>
      <input
        type="text"
        required
        value={recNumber}
        maxLength="14"
        disabled={ValiditeCustomerState()}
        onChange={(e) => {
          setRecNumber(e.target.value);
        }}
      />{" "}

</div>
      <br />
      <div className="paymentDetails" style={{borderStyle:"grrove",textAlign:"center"}}>
      {/* <b>------Payment Details------ </b> <br />
      <br /> */}
      <br />
      <label htmlFor="trType" style={{fontFamily: "Times New Roman, Times, serif",fontSize:"20px",fontWeight:"bold",paddingLeft:"20px"}}> Transfer type&nbsp;&nbsp;&nbsp;&nbsp;</label>
      <select
        onChange={(e) => {
          setTrType(e.target.value);
          transferTypeHandler(e.target.value);
          
        }}
        value={trType}
        disabled={ValiditeCustomerState()}
        
      >
        <option value="------------" name="---------">
          ---------------------
        </option>
        <option value="Customer Transfer" name="Customer Transfer">
        Customer Transfer
        </option>
        <option value="Bank Transfer" name="Bank Transfer">
          Bank Transfer
        </option>
        <option
          value="Bank Transfer for Own Account"
          name="Bank Transfer for Own Account"
        >
          Bank Transfer for Own Account
        </option>
      </select>
     
      <label htmlFor="msgCode" style={{fontFamily: "Times New Roman, Times, serif",fontSize:"20px",fontWeight:"bold",paddingLeft:"20px"}}>Message Code</label>&nbsp;&nbsp;&nbsp;&nbsp;
      <select
        onChange={(e) => {
          setMsgCode(e.target.value);
          messageCodeHandler(e.target.value);
        }}
        value={msgCode}
        disabled={ValiditeCustomerState()}
      >
         <option value="----" name="----">
          ----
        </option>
        <option value="CHQB" name="CHQB">
          CHQB
        </option>
        <option value="CORT" name="CORT">
          CORT
        </option>
        <option value="HOLD" name="HOLD">
          HOLD
        </option>
        <option value="INTC" name="INTC">
          INTC
        </option>
        <option value="PHOB" name="PHOB">
          PHOB
        </option>
        <option value="PHOI" name="PHOI">
          PHOI
        </option>
        <option value="PHON" name="PHON">
          PHON
        </option>
        <option value="REPA" name="REPA">
          REPA
        </option>
        <option value="SDVA" name="SDVA">
          SDVA
        </option>
      </select>
      <br /><br />
      
      <label htmlFor="amount" style={{fontFamily: "Times New Roman, Times, serif",fontSize:"20px",fontWeight:"bold",paddingLeft:"20px"}}>Amount</label>&nbsp;&nbsp;&nbsp;&nbsp;
      <input
        type="number"
        required
        value={amount}
        onChange={(e) => {
          setAmount(e.target.value)
          //console.log(parseInt(amount));
        }}
        disabled={ValiditeCustomerState()}
      />
      
      <label htmlFor="trFee" style={{fontFamily: "Times New Roman, Times, serif",fontSize:"20px",fontWeight:"bold",paddingLeft:"20px"}}>Transfer Fee</label>&nbsp;&nbsp;&nbsp;&nbsp;
      <input type="number" value={trFee} disabled={true} />
      
      <label htmlFor="totalMoney" style={{fontFamily: "Times New Roman, Times, serif",fontSize:"20px",fontWeight:"bold",paddingLeft:"20px"}}>Total Money</label>&nbsp;&nbsp;&nbsp;&nbsp;
      <input
        type="number"
        value={parseFloat(amount)+trFee}
        disabled={true}
        name="total"
        id="total"
      />
      </div>
 
         <br />
      <br />
      {/* <Link to="/home"> */}
      <div className="buttonProceed" align="center">
     <button type="button" style={buttonStyle} align="center"onClick={Details}>
          PROCEED &rarr;
     </button>
     </div>
 {/* </Link><br /> */}
      <br />
    
     {/* <p>{Result}</p>  */}
    { false?<StatusPage />:null}
    </div>
  );
  }
  else{
    return;
  }
}


export default TransactionPage;
