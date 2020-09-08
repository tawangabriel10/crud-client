import React from 'react';
import {BrowserRouter, Route, Redirect, Switch} from 'react-router-dom';
import './Custom.scss';
import './App.scss';
import LoginScreen from './modules/login/LoginScreen';
import { connect } from 'react-redux';
import HomeScreen from './modules/home/HomeScreen';
import RegisterScreen from './modules/client/RegisterScreen';

function App(props) {
  return (
    <BrowserRouter>
      <div className="App">
          <h2>
            CRUD Client
        </h2>

        <Switch>
          <Route path="/" exact component={LoginScreen} />

          <PrivateRoute authed={props.isLogged} path="/home" exact component={HomeScreen}/>
          <PrivateRoute authed={props.isLogged} path="/register" exact component={RegisterScreen}/>
        </Switch>
      </div>
    </BrowserRouter>
  );
}

function PrivateRoute({component: Component, authed, ...rest}) {
  return (
    <Route
      {...rest}
      render={(props) => authed
        ? <Component {...props} />
        : <Redirect to={{ pathname: "/", state: { from: props.location }}} />}
    />
  )
}

const mapStateToProps = (state) => {
  return {
    isLogged: state.authentication.isLogged
  }
}

export default connect(mapStateToProps, null)(App);
