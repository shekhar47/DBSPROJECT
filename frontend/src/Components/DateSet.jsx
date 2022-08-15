import React, { useEffect, useState } from 'react'
import DatePicker from "react-datepicker"

import "react-datepicker/dist/react-datepicker.css";



const DateSet = () => {
    const [date, setDate] = useState(null);
    const [dateStatus,setDateStatus]=useState("")
    

  return (
    <div>
<label htmlFor="date">Date</label> 
<DatePicker
 dateFormat="dd-MM-yyyy"
 //filterDate={date=>date.getDay()!=6 && date.getDay()!=0}
 selected={date}
 onChange={date=>setDate(date)}
 minDate={new Date()}
 maxDate={new Date()}
 //readOnly
 //disabled={true}
/>

    </div>
   
  
  )
}

export default DateSet