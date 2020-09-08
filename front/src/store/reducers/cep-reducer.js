const { VIACEP_FIND_BY_CEP } = require("../actions/action-types");


const initialState = {
    dataAddress: null
};

const cepReducer = (state = initialState, actions) => {
    switch(actions.type) {
        case VIACEP_FIND_BY_CEP:
            return {
                ...state,
                dataAddress: actions.payload
            };
        default:
            return state; 
    }
}

export default cepReducer;