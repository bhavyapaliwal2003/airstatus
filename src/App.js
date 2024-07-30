import React from 'react';
import { FlightProvider } from './FlightContext';
import FlightList from './FlightList';
import SearchBar from './SearchBar';

function App() {
  return (
    <FlightProvider>
      <div>
        <h1>Flight Status App</h1>
        <SearchBar /> <FlightList />
      </div>
    </FlightProvider>
  );
}

export default App;
