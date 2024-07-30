import React from 'react';

 function FlightDetails({ flight }) {
   if (!flight) { 
     return null; 
   }

   return (
     <div>
       <h3>Flight Details</h3>
       <p>Flight Number: {flight.flightNumber}</p>
       <p>Status: {flight.status}</p>
       {/* Display other flight details */}
     </div>
   );
 }

 export default FlightDetails;
