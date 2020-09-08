import {applyMiddleware, combineReducers, createStore, compose} from "redux";
import thunkMiddleware from "redux-thunk";
import authenticationReducer from "../store/reducers/authentication-reducer";
import cepReducer from "../store/reducers/cep-reducer";
import clientReducer from "../store/reducers/cliente-reducer";

const composeEnhancers = window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose;
const rootReducer = combineReducers({
    authentication: authenticationReducer,
    cep: cepReducer,
    client: clientReducer
});

const initialize = () => createStore(rootReducer, composeEnhancers(applyMiddleware(thunkMiddleware)));

export default initialize;