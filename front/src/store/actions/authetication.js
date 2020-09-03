import { API_AUTH } from "../../config/API"


export const login = (user, history) => {
    console.log('DADOS', user)
    return (dispatch) => {
        API_AUTH.post('/login', user)
            .then(response => {
                console.log('LOGIN', response);
            })
            .catch(error => {
                console.error('Error', error);
            })
    }
}

const setAccessToKen = (token) => {

}