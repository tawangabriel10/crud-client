import { API_AUTH } from "../../config/API"
import { AUTHETICATION_SET_AUTH_TOKEN } from "./action-types"


export const login = (user, history) => {
    console.log('DADOS', user)
    return (dispatch) => {
        API_AUTH.post('/login', user)
            .then(response => {
                console.log('LOGIN', response);

                const auth = response.headers.authorization
                dispatch(setAccessToKen(auth));
                history.push('/home');
            })
            .catch(error => {
                console.error('Error', error);
            })
    }
}

const setAccessToKen = (token) => {
    return {
        type: AUTHETICATION_SET_AUTH_TOKEN,
        payload: token
    }
}