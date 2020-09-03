import {applyMiddleware, combineReducers, createStore, compose} from "redux";
import thunkMiddleware from "redux-thunk";

const composeEnhancers = window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose;
const rootReducer = combineReducers({

});

const initialize = () => createStore(rootReducer, composeEnhancers(applyMiddleware(thunkMiddleware)));

export default initialize;