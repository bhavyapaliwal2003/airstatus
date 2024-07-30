import { createContext, useState, useEffect } from 'react';
import axios from 'axios';

const FlightContext = createContext();

const FlightProvider = ({ children }) => {
  const [flights, setFlights] = useState([]);
  const [selectedFlight, setSelectedFlight] = useState(null);
  const [notifications, setNotifications] = useState([]);// Add notifications
  const [searchTerm, setSearchTerm] = useState(''); 

  useEffect(() => {
    const fetchFlights = async () => {
      try {
        const response = await axios.get('/api/flights');
        setFlights(response.data);
      } catch (error) {
        console.error('Error fetching flights:', error);
      }
    };

    fetchFlights();
  }, []);

  return (
    <FlightContext.Provider value={{ 
        flights, selectedFlight, setSelectedFlight, notifications, setNotifications,
        searchTerm, setSearchTerm // Add searchTerm and setSearchTerm
      }}>
      {children}
    </FlightContext.Provider>
  );
};

export { FlightContext, FlightProvider };
