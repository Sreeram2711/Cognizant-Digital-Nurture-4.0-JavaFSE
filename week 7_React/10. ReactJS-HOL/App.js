import React from 'react';
import './index.css';


function App() {
  const heading = "Office Space";

  const officeSpaces = [
    { Name: "DBS", Rent: 50000, Address: "Chennai" },
    { Name: "WeWork", Rent: 65000, Address: "Bangalore" },
    { Name: "Regus", Rent: 55000, Address: "Hyderabad" }
  ];

  return (
    <div className="container">
      <h1>{heading} , at Affordable Range</h1>
      <img src="office.jpg" width="25%" height="25%" alt="Office Space" />

      {officeSpaces.map((item, index) => {
        let rentClass = item.Rent <= 60000 ? 'textRed' : 'textGreen';
        return (
          <div key={index} className="card">
            <h2>Name: {item.Name}</h2>
            <h3 className={rentClass}>Rent: Rs. {item.Rent}</h3>
            <h3>Address: {item.Address}</h3>
          </div>
        );
      })}
    </div>
  );
}

export default App;
