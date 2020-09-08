import { AUTHETICATION_SET_AUTH_TOKEN } from "../actions/action-types";


const initialState = {
    login: null,
    auth: '',
    isLogged: false
};

const authenticationReducer = (state = initialState, actions) => {
    switch(actions.type) {
        case AUTHETICATION_SET_AUTH_TOKEN:
            return {
                ...state,
                auth: actions.payload,
                isLogged: true
            };
        default:
            return state;
    }
}

export default authenticationReducer;