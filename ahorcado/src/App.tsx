import React from 'react';
import logo from './logo.svg';
import './App.css';
import Imagen from './Imagen'
import Teclado from './Teclado'


function App() {
  return (
    <div className="App">
      <header className="App-header">
        <Imagen/>
        <Teclado/>
      </header>
    </div>
  );
}

export default App;
