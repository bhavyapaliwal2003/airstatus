// In FlightList.js
import React, { useContext } from 'react';
import { FlightContext } from './FlightContext';
import FlightDetails from './FlightDetails'; // Import FlightDetails

function FlightList() {
  const { flights, selectedFlight, setSelectedFlight, searchTerm } = useContext(FlightContext);

  const handleClick = (flight) => {
    setSelectedFlight(flight);
  };

  const filteredFlights = flights.filter(flight => {
    const search = searchTerm.toLowerCase();
    return (
      flight.flightNumber.toLowerCase().includes(search) ||
      flight.status.toLowerCase().includes(search) // Assuming you have a status property
    );
  });

  return (
    <div>
      <h2>Flight List</h2>
      <ul>
        {filteredFlights.map(flight => (
          <li key={flight.id} onClick={() => handleClick(flight)}>
            {flight.flightNumber} - {flight.status}
          </li>
        ))}
      </ul>
      {selectedFlight && <FlightDetails flight={selectedFlight} />}
    </div>
  );
}

export default FlightList;
