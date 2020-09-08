import { API } from "../../config/API"
import { CLIENT_FIND_ALL } from "./action-types";


export const findAll = () => {
    return (dispatch) => {
        API.get('/client')
            .then((response) => {
                dispatch(setListClients(response.data));
            })
            .catch((error) => {
                console.log('Error: ', error);
            });
    }
}

export const save = (client, history) => {
    return (dispatch) => {
        API.post('/client', client)
            .then((response) => {
                history.push('/home');
            }).catch((error) => {
                console.log('Error: ', error);
            });
    }
}

const setListClients = (clients) => {
    return {
        type: CLIENT_FIND_ALL,
        payload: clients
    }
};



