import axios from 'axios';
import { store } from '../index';

const BASE_URL = 'http://localhost:8080/api';

export const API = axios.create({
 baseURL: BASE_URL
});

export const API_AUTH = axios.create({
    baseURL: 'http://localhost:8080'
});

//TODO Configurar integração com SCA posteriormente
API.interceptors.request.use(function (config) {
    config.headers['Content-Type'] = 'application/json';
    config.headers['Control-Allow-Origin'] = '*';
    config.headers['Control-Allow-Headers'] = '*';

    const stateObj = store.getState();
    const token = stateObj.authentication.auth;
    config.headers.Authorization = token;
    return config;
});