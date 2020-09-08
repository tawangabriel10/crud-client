const { CLIENT_FIND_ALL } = require("../actions/action-types");
const { bindActionCreators } = require("redux");

const initialState = {
    clients: []
};

const clientReducer = (state = initialState, actions) => {
    switch(actions.type) {
        case CLIENT_FIND_ALL:
            return {
                ...state,
                clients: bindActionCreators.payload
            };
        default:
            return state;
    }
}

export default clientReducer;