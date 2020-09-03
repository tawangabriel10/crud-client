import React from 'react';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import './App.css';
import LoginScreen from './modules/client/LoginScreen';

function App() {
  return (
    <BrowserRouter>
      <div className="App">
          <h2>
            CRUD Client
        </h2>

        <Switch>
          <Route path="/" exact component={LoginScreen} />
        </Switch>
      </div>
    </BrowserRouter>
  );
}

export default App;
