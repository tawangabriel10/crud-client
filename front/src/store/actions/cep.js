import { VIACEP_FIND_BY_CEP } from "../actions/action-types";

const { API } = require("../../config/API");

export const findByCep = (cep) => {
    return(dispatch) => {
        API.get('/cep?cep=' + cep)
            .then((response) => {
                console.log('CEP', response.data);
                dispatch(setDataAddress(response.data));
            })
            .catch((error) => {
                console.log('Error: ', error);
            });

    }
}

const setDataAddress = (response) => {
    return {
        type: VIACEP_FIND_BY_CEP,
        payload: response
    }
}