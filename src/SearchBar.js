import React, { useContext } from 'react';
 import { FlightContext } from './FlightContext';

 function SearchBar() {
   const { setSearchTerm } = useContext(FlightContext);

   const handleSearchChange = (event) => {
     setSearchTerm(event.target.value);
   };

   return (
     <div>
       <input type="text" placeholder="Search flights..." onChange={handleSearchChange} />
     </div>
   );
 }

 export default SearchBar;
